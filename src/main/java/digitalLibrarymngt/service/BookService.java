package digitalLibrarymngt.service;

import digitalLibrarymngt.entites.Book;
import digitalLibrarymngt.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        validateBookForCreation(book);
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> searchBooks(String term) {
        if (!StringUtils.hasText(term)) {
            return Collections.emptyList();
        }

        // Search by ID first
        Optional<Book> bookById = bookRepository.findById(term);
        if (bookById.isPresent()) {
            return Collections.singletonList(bookById.get());
        }

        // If no ID match, search by title
        return bookRepository.findByTitleContainingIgnoreCase(term);
    }

    public Book updateBook(String id, Book updatedBook) {
        validateBookForUpdate(updatedBook);

        return bookRepository.findById(id)
                .map(existingBook -> {
                    updateExistingBook(existingBook, updatedBook);
                    return bookRepository.save(existingBook);
                })
                .orElseThrow(() -> new IllegalArgumentException("Book not found with ID: " + id));
    }

    public void deleteBook(String id) {
        if (!bookRepository.existsById(id)) {
            throw new IllegalArgumentException("Book not found with ID: " + id);
        }
        bookRepository.deleteById(id);
    }

    private void validateBookForCreation(Book book) {
        if (book.getId() == null || book.getId().isEmpty()) {
            throw new IllegalArgumentException("Book ID is required");
        }

        if (bookRepository.existsById(book.getId())) {
            throw new IllegalArgumentException("Book ID must be unique");
        }

        validateCommonBookFields(book);
    }

    private void validateCommonBookFields(Book book) {
        if (!StringUtils.hasText(book.getTitle())) {
            throw new IllegalArgumentException("Title is required");
        }

        if (!StringUtils.hasText(book.getAuthor())) {
            throw new IllegalArgumentException("Author is required");
        }

        if (book.getAvailability() == null) {
            throw new IllegalArgumentException("Availability status is required");
        }
    }

    private void validateBookForUpdate(Book book) {
        validateCommonBookFields(book);
    }

    private void updateExistingBook(Book existing, Book updated) {
        existing.setTitle(updated.getTitle());
        existing.setAuthor(updated.getAuthor());
        existing.setGenre(updated.getGenre());
        existing.setAvailability(updated.getAvailability());
    }
}
