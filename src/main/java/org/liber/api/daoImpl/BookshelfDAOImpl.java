/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.liber.api.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.liber.api.dao.BookshelfDAO;
import org.liber.api.model.BookEntity;
import org.liber.api.model.TransactionEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author prashant
 */
public class BookshelfDAOImpl implements BookshelfDAO{

    private JdbcTemplate jdbcTemplate;
 
    public BookshelfDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public List<BookEntity> getAllBooks() {
        String sql="SELECT * FROM bookshelf where b_delete='N'";
        
        List<BookEntity> books = jdbcTemplate.query(sql, new RowMapper<BookEntity>() {
            @Override
            public BookEntity mapRow(ResultSet rs, int i) throws SQLException {
                BookEntity b = new BookEntity();
                b.setTitle(rs.getString("b_title"));
                b.setAuthor(rs.getString("b_author"));
                b.setCoverImgUrl(rs.getString("b_cover"));
                b.setDescription(rs.getString("b_desc"));
                b.setGenre(rs.getString("b_genre"));
                b.setRating(rs.getString("b_rating"));
		b.setUser(rs.getString("u_id"));
		b.setAvailable(rs.getString("b_available"));
                b.setReader(rs.getString("b_reader"));
		b.setDor(rs.getString("b_dor"));
		b.setDelete(rs.getString("b_delete"));
                return b;
            }
        });
                  
        return books;
    }

    @Override
    public void insertBook(BookEntity b, String u_id) {
        String sql =  "INSERT INTO bookshelf (b_title, b_author, b_cover, b_desc,b_genre,b_rating,u_id,b_available, b_reader,b_delete)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

        jdbcTemplate.update(sql, b.getTitle(),b.getAuthor(),b.getCoverImgUrl(),b.getDescription(),b.getGenre(),b.getRating(), u_id,b.getAvailable(),b.getReader(),b.getDelete());
    }   

    @Override
    public void updateBookshelfAvailability(String isAvailable, TransactionEntity t) {
             int count = jdbcTemplate.update("UPDATE bookshelf set b_available = ? ,b_reader = ?, b_dor = ?  where b_title = ? AND u_id = ?", new Object[] {isAvailable,t.getTxUser(),t.getTxReturnDate() ,t.getTxBook(), t.getTxBookOwner()});             
    }

    @Override
    public void updateBookshelfToDeleteBook(BookEntity b) {
             int count = jdbcTemplate.update("UPDATE bookshelf set b_available = ? ,b_delete = ?  where b_title = ? AND u_id = ?", new Object[] {"N",b.getDelete(),b.getTitle(),b.getUser()});             
    }
}
