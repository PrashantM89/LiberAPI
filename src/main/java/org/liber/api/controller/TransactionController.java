/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.liber.api.controller;

import java.util.List;
import org.liber.api.dao.BookshelfDAO;
import org.liber.api.dao.TransactionDAO;
import org.liber.api.model.TransactionEntity;
import org.liber.api.util.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author prashant
 */
@RestController
@RequestMapping("/txn")
public class TransactionController {
    private static final String SUCCESS_STATUS = "success";

    private static final String ERROR_STATUS = "error";

    private static final int CODE_SUCCESS = 100;

    private static final int AUTH_FAILURE = 102;

    private SendEmail email;
    
    @Autowired
    private TransactionDAO txnDAO;
    @Autowired
    private BookshelfDAO bookshelfDAO;
    
    @RequestMapping(value="/transactions", method = RequestMethod.GET)     
    public List<TransactionEntity> getTransactions(@RequestParam String txMob){
        
        List<TransactionEntity> txns = txnDAO.getAllTx(txMob);                    
        return txns;            
    }

  @PostMapping(value="/createUsrTxn")
  public void insertUserTxn(@RequestBody TransactionEntity r){

	 TransactionEntity tx = new TransactionEntity();
                        tx.setTxDate(r.getTxDate());
                        tx.setTxDelete(r.getTxDelete());
                        tx.setTxDeliveryDate(r.getTxDeliveryDate());
                        tx.setTxDeliverySts(r.getTxDeliverySts());
                        tx.setTxId(r.getTxId());               
                        tx.setTxPaymentMode(r.getTxPaymentMode());
                        tx.setTxType(r.getTxType());                  
                        tx.setTxUser(r.getTxUser());
                        tx.setTxMob(r.getTxMob());
                        tx.setTxAmount(r.getTxAmount());
                        tx.setTxReturnDate(r.getTxReturnDate());
			tx.setTxBook(r.getTxBook());
			tx.setTxBookOwner(r.getTxBookOwner());
	txnDAO.insertUserTxn(tx);
        updateBookAvailability("N",tx);
        email = new SendEmail("prashantm61289@gmail.com","sandwista@gmail.com","Liber- Order placed","Your order for book has been placed.");
        email.sendMail();
        
  }

    private void updateBookAvailability(String isAvailable,TransactionEntity t) {
            bookshelfDAO.updateBookshelfAvailability(isAvailable, t);
    }
}
