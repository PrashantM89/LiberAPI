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
import org.liber.api.model.ReviewEntity;
import org.liber.api.model.UserEntity;
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
@RequestMapping("/user")
public class UserController {
      private static final String SUCCESS_STATUS = "success";

    private static final String ERROR_STATUS = "error";

    private static final int CODE_SUCCESS = 100;

    private static final int AUTH_FAILURE = 102;
 
    @Autowired
    private UserDAO userDAO;
    
    @RequestMapping(value="/user/{u_mob}", method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public ResponseEntity<UserEntity> getUser(@PathVariable("u_mob") String u_mob, HttpServletRequest request, HttpServletResponse response){
        
        UserEntity user = userDAO.getUser(u_mob);
        if(user == null){
            return new ResponseEntity<UserEntity>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<UserEntity>(user,HttpStatus.OK);
        //return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
    }
    
    
 
    @PostMapping(value="/createUser")
    public void createUser(@RequestBody UserEntity u){
        
       UserEntity b = new UserEntity();    
                b.setUname(u.getUname());
                b.setUemail(u.getUemail());
                b.setUmob(u.getUmob());
                b.setUpin(u.getUpin());
                b.setUaddress(u.getUaddress());               
                b.setUsignup_date(u.getUsignup_date());
                b.setUlast_update(u.getUlast_update());                  
                b.setUdelete(u.getUdelete());
                                         
        userDAO.insertUser(b);        
    }
    
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserEntity u){
        UserEntity b = new UserEntity();    
                b.setUname(u.getUname());
                b.setUemail(u.getUemail());
                b.setUmob(u.getUmob());
                b.setUpin(u.getUpin());
                b.setUaddress(u.getUaddress());               
                b.setUsignup_date(u.getUsignup_date());
                b.setUlast_update(u.getUlast_update());                  
                b.setUdelete(u.getUdelete());
                
       int result = userDAO.updateUser(b);
        
    }
    
    @RequestMapping(value="/users", method = RequestMethod.GET,produces = "application/json")     
    public ResponseEntity<List<UserEntity>> getUsers(){
        
        List<UserEntity> users = userDAO.getUsers();
               
        if(users.size()<1 || users == null){
            return new ResponseEntity<List<UserEntity>>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<UserEntity>>(users,HttpStatus.OK);
            //return users;      
    }
}
