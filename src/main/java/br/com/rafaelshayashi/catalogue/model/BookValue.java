package br.com.rafaelshayashi.catalogue.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class BookValue {

    private String currency;
    private Integer amount;
    @Enumerated(EnumType.STRING)
    private UnitTypeEnum unitType;

    public BookValue() {
    }

    public BookValue(String currency, Integer amount, UnitTypeEnum unitType) {
        this.currency = currency;
        this.amount = amount;
        this.unitType = unitType;
    }

    public static BookValueBuilder builder() {
        return new BookValueBuilder();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer value) {
        this.amount = value;
    }

    public UnitTypeEnum getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitTypeEnum unit) {
        this.unitType = unit;
    }

    public static final class BookValueBuilder {
        private String currency;
        private Integer amount;
        private UnitTypeEnum unit;

        public BookValueBuilder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public BookValueBuilder amount(Integer amount) {
            this.amount = amount;
            return this;
        }

        public BookValueBuilder unit(String unit) {
            this.unit = UnitTypeEnum.fromValue(unit);
            return this;
        }

        public BookValueBuilder unit(UnitTypeEnum unit) {
            this.unit = unit;
            return this;
        }

        public BookValue build() {
            return new BookValue(currency, amount, unit);
        }
    }
}
