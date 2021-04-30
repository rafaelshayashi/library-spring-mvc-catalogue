package br.com.rafaelshayashi.catalogue.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private UUID uuid;
    @NotEmpty
    private String title;
    private String subTitle;
    @Embedded
    private BookValue value;
    private String description;
    @NotEmpty
    private String isbn;
    @NotEmpty
    private String userId;

    public Book() {
    }

    public Book(String title, String subTitle, BookValue value, String description, String isbn, String userId) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.subTitle = subTitle;
        this.value = value;
        this.description = description;
        this.isbn = isbn;
        this.userId = userId;
    }

    public static BookBuilder builder() {
        return new BookBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public BookValue getValue() {
        return value;
    }

    public void setValue(BookValue value) {
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

    public void setUserId(String user) {
        this.userId = user;
    }

    public static final class BookBuilder {
        private String title;
        private String subTitle;
        private BookValue value;
        private String description;
        private String isbn;
        private String userId;

        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder subTitle(String subTitle) {
            this.subTitle = subTitle;
            return this;
        }

        public BookBuilder value(BookValue value) {
            this.value = value;
            return this;
        }

        public BookBuilder description(String description) {
            this.description = description;
            return this;
        }

        public BookBuilder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public BookBuilder userId(String userId){
            this.userId = userId;
            return this;
        }

        public Book build() {
            return new Book(title, subTitle, value, description, isbn, userId);
        }
    }
}
