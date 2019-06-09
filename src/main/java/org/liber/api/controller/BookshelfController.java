/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.liber.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.liber.api.dao.BookshelfDAO;
import org.liber.api.model.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author prashant
 */
@RestController
@RequestMapping("/bookshelf")
public class BookshelfController {
    
    private static final String SUCCESS_STATUS = "success";

    private static final String ERROR_STATUS = "error";

    private static final int CODE_SUCCESS = 100;

    private static final int AUTH_FAILURE = 102;
 
    @Autowired
    private BookshelfDAO bookshelfDAO;
    
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public List<BookEntity> bookshelfBooks(){
        
        List<BookEntity> books = bookshelfDAO.getAllBooks();        
        return books;
    }
 
    @PostMapping(value="/upload")
    public void uploadBook(@RequestBody BookEntity book,@RequestParam String u_id){

        BookEntity b = new BookEntity();    
        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
        b.setCoverImgUrl(book.getCoverImgUrl());
        b.setDescription(book.getDescription());
	b.setGenre(book.getGenre());
        b.setRating(book.getRating());
        b.setAvailable(book.getAvailable());
	b.setReader(book.getReader());
	b.setDor(book.getDor());
	b.setDelete(book.getDelete());
        bookshelfDAO.insertBook(b,u_id);
        
    }


    @PostMapping(value="/deleteBook")
    public void deleteBook(@RequestBody BookEntity book){
 	bookshelfDAO.updateBookshelfToDeleteBook(book);        
    }
	
  @RequestMapping(value="/userBooks", method = RequestMethod.GET)
    public List<BookEntity> bookshelfBooks(@RequestParam String u_id){
        List<BookEntity> userBooks = new ArrayList<BookEntity>();
        List<BookEntity> books = bookshelfDAO.getAllBooks(); 
        
        userBooks.clear();
        for(BookEntity bk : books){
            if(u_id.equalsIgnoreCase(bk.getUser()) || u_id.equalsIgnoreCase(bk.getReader())){
                userBooks.add(bk);
            }
        }       
        return userBooks;
    }

}
