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
import org.liber.api.dao.TransactionDAO;
import org.liber.api.model.TransactionEntity;
import org.liber.api.model.UserEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author prashant
 */
public class TransactionDAOImpl implements TransactionDAO{

    private JdbcTemplate jdbcTemplate;

    public TransactionDAOImpl(DataSource dataSource) {
         jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    
    
    @Override
    public List<TransactionEntity> getAllTx(String txMob) {
        List<TransactionEntity> txn = null;
        String sql="SELECT * FROM txn where tx_mob = "+txMob;
        try{
            txn = jdbcTemplate.query(sql, new RowMapper<TransactionEntity>() {
                @Override
                public TransactionEntity mapRow(ResultSet u, int i) throws SQLException {
                      TransactionEntity tx = new TransactionEntity();
                        tx.setTxDate(u.getString("tx_date"));
                        tx.setTxDelete(u.getString("tx_delete"));
                        tx.setTxDeliveryDate(u.getString("tx_delivery_date"));
                        tx.setTxDeliverySts(u.getString("tx_delivery_sts"));
                        tx.setTxId(u.getString("tx_id"));               
                        tx.setTxPaymentMode(u.getString("tx_payment_mode"));
                        tx.setTxType(u.getString("tx_type"));                  
                        tx.setTxUser(u.getString("tx_user"));
                        tx.setTxMob(u.getString("tx_mob"));
                        tx.setTxAmount(u.getString("tx_amount"));
			tx.setTxReturnDate(u.getString("tx_return_date"));
			tx.setTxBook(u.getString("tx_book"));
			tx.setTxBookOwner(u.getString("tx_book_owner"));
                      return tx;
                }
            });   
        }catch(DataAccessException e){
            e.printStackTrace();            
        }
        
            return txn;                                  
    }
 

    @Override
    public void insertUserTxn(TransactionEntity r) {
        String sql =  "INSERT INTO txn(tx_id, tx_mob, tx_date, tx_delivery_sts,tx_payment_mode, tx_user,tx_delete,tx_delivery_date,tx_type,tx_amount, tx_return_date, tx_book, tx_book_owner)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        jdbcTemplate.update(sql, r.getTxId(),r.getTxMob(),r.getTxDate(),r.getTxDeliverySts(),r.getTxPaymentMode(),r.getTxUser(),r.getTxDelete(),r.getTxDeliveryDate(),r.getTxType(),r.getTxAmount(),r.getTxReturnDate(),r.getTxBook(),r.getTxBookOwner());
    }

}
