package org.example.web.controllers;


import org.apache.log4j.Logger;
import org.example.app.services.BookService;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "books")
public class BookShelfController {

    private Logger logger = Logger.getLogger(BookShelfController.class);
    private BookService bookService;

    @Autowired
    public BookShelfController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/shelf")
    public String books(Model model) {
        logger.info("got book shelf");
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.getAllBooks());
        return "book_shelf";
    }

    @PostMapping("/save")
    public String saveBook(Book book){
        bookService.saveBook(book);
        logger.info("current repository size: "+bookService.getAllBooks().size());
        return "redirect:/books/shelf";
    }

    @PostMapping("/remove")
    public String removeBookById(@RequestParam(value = "bookIdToRemove", required = false) Integer bookIdToRemove,
                                 @RequestParam(value = "bookAuthorToRemove", required = false) String bookAuthorToRemove,
                                 @RequestParam(value = "bookTitleToRemove", required = false) String bookTitleToRemove,
                                 @RequestParam(value = "bookSizeToRemove", required = false) String bookSizeToRemove){
        bookService.removeBook(bookIdToRemove, bookAuthorToRemove, bookTitleToRemove, bookSizeToRemove);
        return "redirect:/books/shelf";
    }

}
