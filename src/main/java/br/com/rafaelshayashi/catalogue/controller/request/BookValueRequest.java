package br.com.rafaelshayashi.catalogue.controller.request;

import br.com.rafaelshayashi.catalogue.model.BookValue;

public class BookValueRequest {

    private String currency;
    private Integer amount;
    private String unit;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BookValue toModel() {
        return BookValue.builder()
                .currency(currency)
                .amount(amount)
                .unit(unit)
                .build();
    }
}
