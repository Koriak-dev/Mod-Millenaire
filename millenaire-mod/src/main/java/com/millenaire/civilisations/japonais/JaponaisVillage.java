package com.millenaire.civilisations.japonais;

import com.millenaire.civilisations.AbstractCivilisation;

public class JaponaisVillage {
    private final JaponaisCivilisation civilisation;
    private final String name;

    public JaponaisVillage(JaponaisCivilisation civilisation, String name) {
        this.civilisation = civilisation;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public JaponaisCivilisation getCivilisation() {
        return civilisation;
    }
}
