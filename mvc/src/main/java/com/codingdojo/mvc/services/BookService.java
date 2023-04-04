package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book 
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
//    Books API practice assignment tasks below:
    
    // updates a book
    
//    updateBook method needed to be created taking id, title desc,lang, and numOfPages
    
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {

//    	first need to find the book being referenced by id
    	
    	Optional<Book> optionalBook = bookRepository.findById(id);
    	if(optionalBook.isPresent()) {
    		
//    		assigning to a more descriptive variable name
    		
    		Book foundBook = optionalBook.get();
    		
//    		using setter methods from domain model Book.java
    		
    		foundBook.setTitle(title);
    		foundBook.setDescription(desc);
    		foundBook.setLanguage(lang);
    		foundBook.setNumberOfPages(numOfPages);
    		
//    		calling save method from BookRepository passing in the entity we just updated
    		
    		return bookRepository.save(optionalBook.get());
    	}
    	else {
    		
//    		returning null in case no book with that id exists
    		
    		return null;
    	}
    }
    
    // deletes a book
    
    public Book deleteBook(Long id) {
    	
//    	using the deleteById method from the CrudRepository
    	
    	bookRepository.deleteById(id);
    	return null;
    }
}
