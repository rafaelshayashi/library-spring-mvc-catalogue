package br.com.rafaelshayashi.catalogue.repository;

import br.com.rafaelshayashi.catalogue.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);

    Optional<Book> findByUuid(UUID bookUuid);
}
