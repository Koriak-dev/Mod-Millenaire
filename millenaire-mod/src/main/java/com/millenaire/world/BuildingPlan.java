package com.millenaire.world;

import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;

public class BuildingPlan {
    private final List<String> layers = new ArrayList<>();
    private int width;
    private int length;
    private int height;

    public BuildingPlan(Path filePath) throws IOException {
        parseBuildingFile(filePath);
    }

    private void parseBuildingFile(Path filePath) throws IOException {
        Files.lines(filePath)
            .filter(line -> !line.trim().isEmpty())
            .forEach(line -> {
                if (line.startsWith("width:")) {
                    width = Integer.parseInt(line.split(":")[1].trim());
                } else if (line.startsWith("length:")) {
                    length = Integer.parseInt(line.split(":")[1].trim());
                } else if (line.startsWith("height:")) {
                    height = Integer.parseInt(line.split(":")[1].trim());
                } else {
                    layers.add(line);
                }
            });
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public List<String> getLayers() {
        return layers;
    }
}
