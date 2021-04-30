package br.com.rafaelshayashi.catalogue.controller.response;

import br.com.rafaelshayashi.catalogue.model.Book;

public class BookResponse {

    private final String uuid;
    private final String title;
    private final String subTitle;
    private final BookValueResponse value;
    private final String description;
    private final String isbn;

    public BookResponse(Book book) {
        this.uuid = book.getUuid().toString();
        this.title = book.getTitle();
        this.subTitle = book.getSubTitle();
        this.value = BookValueResponse.of(book.getValue());
        this.description = book.getDescription();
        this.isbn = book.getIsbn();
    }

    public static BookResponse of(Book book) {
        return new BookResponse(book);
    }

    public String getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public BookValueResponse getValue() {
        return value;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDescription() {
        return description;
    }
}
