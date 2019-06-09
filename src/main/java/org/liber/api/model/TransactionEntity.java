/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.liber.api.model;


/**
 *
 * @author prashant
 */
public class TransactionEntity{
  private String TxId;
  private String TxDate;
  private String TxDeliverySts;
  private String TxPaymentMode;
  private String TxUser;
  private String TxDelete;
  private String TxDeliveryDate;
  private String TxType;
  private String TxMob;
  private String TxAmount;
  private String TxReturnDate;
  private String TxBook;
  private String TxBookOwner;

    public String getTxBookOwner() {
        return TxBookOwner;
    }

    public void setTxBookOwner(String TxBookOwner) {
        this.TxBookOwner = TxBookOwner;
    }

    public String getTxBook() {
        return TxBook;
    }

    public void setTxBook(String TxBook) {
        this.TxBook = TxBook;
    }

    public String getTxReturnDate() {
        return TxReturnDate;
    }

    public void setTxReturnDate(String TxReturnDate) {
        this.TxReturnDate = TxReturnDate;
    }


    public String getTxMob() {
        return TxMob;
    }

    public void setTxMob(String TxMob) {
        this.TxMob = TxMob;
    }

    public String getTxAmount() {
        return TxAmount;
    }

    public void setTxAmount(String TxAmount) {
        this.TxAmount = TxAmount;
    }
 
    public String getTxId() {
        return TxId;
    }

    public void setTxId(String TxId) {
        this.TxId = TxId;
    }

    public String getTxDate() {
        return TxDate;
    }

    public void setTxDate(String TxDate) {
        this.TxDate = TxDate;
    }

    public String getTxDeliverySts() {
        return TxDeliverySts;
    }

    public void setTxDeliverySts(String TxDeliverySts) {
        this.TxDeliverySts = TxDeliverySts;
    }

    public String getTxPaymentMode() {
        return TxPaymentMode;
    }

    public void setTxPaymentMode(String TxPaymentMode) {
        this.TxPaymentMode = TxPaymentMode;
    }

    public String getTxUser() {
        return TxUser;
    }

    public void setTxUser(String TxUser) {
        this.TxUser = TxUser;
    }

    public String getTxDelete() {
        return TxDelete;
    }

    public void setTxDelete(String TxDelete) {
        this.TxDelete = TxDelete;
    }

    public String getTxDeliveryDate() {
        return TxDeliveryDate;
    }

    public void setTxDeliveryDate(String TxDeliveryDate) {
        this.TxDeliveryDate = TxDeliveryDate;
    }

    public String getTxType() {
        return TxType;
    }

    public void setTxType(String TxType) {
        this.TxType = TxType;
    }
  
  
}
