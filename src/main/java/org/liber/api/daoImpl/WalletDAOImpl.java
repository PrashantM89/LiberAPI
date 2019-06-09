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
import org.liber.api.dao.WalletDAO;
import org.liber.api.model.BookEntity;
import org.liber.api.model.ReviewEntity;
import org.liber.api.model.WalletEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author prashant
 */
public class WalletDAOImpl implements WalletDAO{

  private JdbcTemplate jdbcTemplate;
    
    
    public WalletDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<WalletEntity> getUserWalletData(String mob) {
        String sql="SELECT * FROM wallet where w_delete='N' AND w_mob="+mob;
        
        List<WalletEntity> walletData = jdbcTemplate.query(sql, new RowMapper<WalletEntity>() {
            @Override
            public WalletEntity mapRow(ResultSet rs, int i) throws SQLException {
                WalletEntity w = new WalletEntity();
                w.setWUid(rs.getString("w_uid"));
                w.setWMob(rs.getString("w_mob"));
                w.setWAmntAdded(rs.getString("w_amnt_added"));
                w.setWBookName(rs.getString("w_book_name"));
                w.setWBookDate(rs.getString("w_book_date"));
                w.setWDelete(rs.getString("w_delete"));                
                return w;
            }
        });
                  
        return walletData;
    }

    @Override
    public void addMonetInToWallet(WalletEntity w) {
	       String sql =  "INSERT INTO wallet(w_uid, w_mob, w_amnt_added, w_book_date,w_book_name, w_delete)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        
        jdbcTemplate.update(sql, w.getWUid(),w.getWMob(),w.getWAmntAdded(),w.getWBookDate(),w.getWBookName(),w.getWDelete());
    }
    
    
}
