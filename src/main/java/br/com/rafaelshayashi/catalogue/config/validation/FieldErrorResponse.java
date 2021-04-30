package br.com.rafaelshayashi.catalogue.config.validation;

public class FieldErrorResponse {

    private final String field;
    private final String error;

    public FieldErrorResponse(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}
