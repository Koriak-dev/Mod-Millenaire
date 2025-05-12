package com.millenaire.civilisations.azteques;

import com.millenaire.civilisations.AbstractCivilisation;

public class AztequeVillage {
    private final AztequeCivilisation civilisation;
    private final String name;

    public AztequeVillage(AztequeCivilisation civilisation, String name) {
        this.civilisation = civilisation;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public AztequeCivilisation getCivilisation() {
        return civilisation;
    }
}
