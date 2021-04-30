package br.com.rafaelshayashi.catalogue.model;

import java.util.Arrays;

public enum UnitTypeEnum {
    FRACTIONAL("fractional"), FULL("full");

    private final String value;

    UnitTypeEnum(String value) {
        this.value = value;
    }

    public static UnitTypeEnum fromValue(String value) {
        return Arrays.stream(values())
                .filter(unitTypeEnum -> unitTypeEnum.value.equalsIgnoreCase(value))
                .findFirst()
                .orElse(UnitTypeEnum.FRACTIONAL);
    }
}
