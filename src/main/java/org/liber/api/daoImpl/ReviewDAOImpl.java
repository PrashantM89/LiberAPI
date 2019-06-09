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
import org.liber.api.dao.ReviewDAO;
import org.liber.api.model.BookEntity;
import org.liber.api.model.ReviewEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author prashant
 */
public class ReviewDAOImpl implements ReviewDAO{

    private JdbcTemplate jdbcTemplate;
    
    
    public ReviewDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public List<ReviewEntity> getAllReviews() {
        String sql="SELECT * FROM review";
        
        List<ReviewEntity> review = jdbcTemplate.query(sql, new RowMapper<ReviewEntity>() {
            @Override
            public ReviewEntity mapRow(ResultSet rs, int i) throws SQLException {
                ReviewEntity b = new ReviewEntity();
                b.setUId(rs.getString("u_id"));
                b.setUReview(rs.getString("u_review"));
                b.setUStar(rs.getString("u_star"));
                b.setUDate(rs.getString("u_date"));
                b.setUBook(rs.getString("u_book"));               
                return b;
            }
        });
                  
        return review;
    }

    @Override
    public void insertUserReview(ReviewEntity r) {
        String sql =  "INSERT INTO review (u_id, u_review, u_star, u_date,u_book)"
                + " VALUES (?, ?, ?, ?, ?)";
        
        jdbcTemplate.update(sql, r.getUId(),r.getUReview(),r.getUStar(),r.getUDate(),r.getUBook());
    }
        
}
