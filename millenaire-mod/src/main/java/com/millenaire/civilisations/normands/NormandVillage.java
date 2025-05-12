package com.millenaire.civilisations.normands;

import com.millenaire.civilisations.AbstractCivilisation;

public class NormandVillage {
    private final NormandCivilisation civilisation;
    private final String name;

    public NormandVillage(NormandCivilisation civilisation, String name) {
        this.civilisation = civilisation;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public NormandCivilisation getCivilisation() {
        return civilisation;
    }
}
