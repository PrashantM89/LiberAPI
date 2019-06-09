/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.liber.api.dao;

import java.util.List;
import org.liber.api.model.TransactionEntity;

/**
 *
 * @author prashant
 */
public interface TransactionDAO {
    
   public List<TransactionEntity> getAllTx(String txMob);
    
   public void insertUserTxn(TransactionEntity r);

}
