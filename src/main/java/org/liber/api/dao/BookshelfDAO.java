/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.liber.api.dao;

import java.util.List;
import org.liber.api.model.BookEntity;
import org.liber.api.model.TransactionEntity;

/**
 *
 * @author prashant
 */
public interface BookshelfDAO {
    public List<BookEntity> getAllBooks();    
    public void insertBook(BookEntity b, String u_id);
    public void updateBookshelfAvailability(String isAvailable, TransactionEntity t);
    public void updateBookshelfToDeleteBook(BookEntity b);
}
