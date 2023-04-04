// Rendering Books practice assignment tasks below

// 	create a second controller called BookContoller

package com.codingdojo.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

// have the @Controller annotation

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;

//	Add a route in your controller for "/books/3", where the number is a variable for the ID of the book.
	
	@GetMapping("/books/{bookId}")
	public String index(Model model, @PathVariable("bookId") Long bookId) {
		
		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		System.out.println(book);
		
		model.addAttribute("book", book);
		
//		Render the JSP with the book information. To test, manually enter the ID of the book in the url. You can use Workbench to see what IDs exist.
		
		return "show.jsp";
	}
}
