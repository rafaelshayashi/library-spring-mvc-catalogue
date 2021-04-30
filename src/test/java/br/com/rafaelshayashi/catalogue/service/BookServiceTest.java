package br.com.rafaelshayashi.catalogue.service;

import br.com.rafaelshayashi.catalogue.controller.request.BookRequest;
import br.com.rafaelshayashi.catalogue.controller.request.BookValueRequest;
import br.com.rafaelshayashi.catalogue.model.Book;
import br.com.rafaelshayashi.catalogue.model.BookValue;
import br.com.rafaelshayashi.catalogue.repository.BookRepository;
import br.com.rafaelshayashi.catalogue.util.exception.ResourceAlreadyExistsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = BookServiceImpl.class)
class BookServiceTest {

    @MockBean
    private BookRepository repository;

    @Autowired
    private BookService service;

    @Test
    @DisplayName("Service - Should create a book")
    void should_create_a_book() {

        doReturn(Optional.empty()).when(repository).findByIsbn(any(String.class));
        doReturn(getBookMock()).when(repository).save(any(Book.class));

        Book book = service.create(getBookRequest());

        Assertions.assertEquals("Effective Java", book.getTitle());
        Assertions.assertEquals("978-0134685991", book.getIsbn());
    }

    @Test
    @DisplayName("Service - try to create a already existing book")
    void try_to_create_a_already_existing_book() {

        doReturn(Optional.of(getBookMock())).when(repository).findByIsbn(any(String.class));
        BookRequest bookRequest = getBookRequest();
        Assertions.assertThrows(ResourceAlreadyExistsException.class, () -> service.create(bookRequest));
    }

    @Test
    @DisplayName("Service - Should get a list of books")
    void should_get_a_list_of_books() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(getBookMock());
        PageImpl<Book> bookPage = new PageImpl<>(books);
        doReturn(bookPage).when(repository).findAll(any(Pageable.class));

        Pageable pageable = PageRequest.of(1, 1);
        Page<Book> booksPage = service.list(pageable);
        Assertions.assertEquals(1, booksPage.getTotalElements());
    }

    private Book getBookMock() {
        BookValue bookValue = BookValue.builder().currency("BRL").amount(6200).build();
        return Book.builder().title("Effective Java").isbn("978-0134685991").value(bookValue).build();
    }

    private BookRequest getBookRequest() {
        BookValueRequest bookValueRequest = new BookValueRequest();
        bookValueRequest.setCurrency("BRL");
        bookValueRequest.setAmount(6200);
        BookRequest request = new BookRequest();
        request.setTitle("Effective Java");
        request.setIsbn("978-0134685991");
        request.setValue(bookValueRequest);
        request.setUserId(UUID.randomUUID().toString());
        return request;
    }
}
