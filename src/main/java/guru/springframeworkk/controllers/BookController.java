package guru.springframeworkk.controllers;

import guru.springframeworkk.domain.Book;
import guru.springframeworkk.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by A707937 on 03-08-2020.
 */
@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books/list";
    }

    @RequestMapping("/newBook")
    public  String newBook(Model model) {
        model.addAttribute("bookToBeAdded", new Book());
        return "books/addingBook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  String newBook(@ModelAttribute("bookToBeAdded") Book book) {
        bookRepository.save(book);
        return "books/list";
    }
}
