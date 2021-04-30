package br.com.rafaelshayashi.catalogue.controller.request;

import br.com.rafaelshayashi.catalogue.model.Book;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.util.Assert;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BookRequest {

    @NotEmpty
    private String title;
    private String subTitle;
    @NotNull
    private BookValueRequest value;
    private String description;
    @NotEmpty
    private String isbn;
    @JsonIgnore
    private String userId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public BookValueRequest getValue() {
        return value;
    }

    public void setValue(BookValueRequest value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Book toModel() {
        Assert.notNull(title, "title is required");
        Assert.notNull(value, "value is required");
        Assert.notNull(isbn, "isbn is required");
        Assert.notNull(userId, "user id is required");

        return Book.builder()
                .title(title)
                .subTitle(subTitle)
                .value(value.toModel())
                .description(description)
                .isbn(isbn)
                .userId(userId)
                .build();
    }
}
