/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.liber.api.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.liber.api.dao.ReviewDAO;
import org.liber.api.dao.UserDAO;
import org.liber.api.dao.WalletDAO;
import org.liber.api.model.BookEntity;
import org.liber.api.model.ReviewEntity;
import org.liber.api.model.UserEntity;
import org.liber.api.model.WalletEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author prashant
 */

@RestController
@RequestMapping("/wallet")
public class WalletController {
    private static final String SUCCESS_STATUS = "success";

    private static final String ERROR_STATUS = "error";

    private static final int CODE_SUCCESS = 100;

    private static final int AUTH_FAILURE = 102;
 
    @Autowired
    private WalletDAO walletDAO;
    
    @RequestMapping(value="/userWaller", method = RequestMethod.GET)
    public List<WalletEntity> userWalletData(@RequestParam String wmob){
        
        List<WalletEntity> uWallet = walletDAO.getUserWalletData(wmob);  
        return uWallet;
    }

    
    @PostMapping(value="/addMoney")
    public void uploadBook(@RequestBody WalletEntity wallet){

        WalletEntity w = new WalletEntity();    
                w.setWUid(wallet.getWUid());
                w.setWMob(wallet.getWMob());
                w.setWAmntAdded(wallet.getWAmntAdded());
                w.setWBookName(wallet.getWBookName());
                w.setWBookDate(wallet.getWBookDate());
                w.setWDelete(wallet.getWDelete());                

        walletDAO.addMonetInToWallet(w);
        
    }
}
