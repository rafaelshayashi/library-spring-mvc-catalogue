package br.com.rafaelshayashi.catalogue.controller.response;

import br.com.rafaelshayashi.catalogue.model.BookValue;

public class BookValueResponse {

    private final String currency;
    private final Integer amount;
    private final String unit;

    public BookValueResponse() {
        this.currency = null;
        this.amount = null;
        this.unit = null;
    }

    public BookValueResponse(String currency, Integer amount, String unit) {
        this.currency = currency;
        this.amount = amount;
        this.unit = unit;
    }

    public static BookValueResponse of(BookValue value) {
        if(value == null){
            return new BookValueResponse();
        }
        return new BookValueResponse(value.getCurrency(), value.getAmount(), value.getUnitType().toString());
    }

    public String getCurrency() {
        return currency;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }
}
