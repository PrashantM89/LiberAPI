/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.liber.api.controller;

import java.util.List;
import org.liber.api.dao.BookshelfDAO;
import org.liber.api.dao.ReviewDAO;
import org.liber.api.model.ReviewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author prashant
 */
@RestController
@RequestMapping("/review")
public class ReviewController {
    
    private static final String SUCCESS_STATUS = "success";

    private static final String ERROR_STATUS = "error";

    private static final int CODE_SUCCESS = 100;

    private static final int AUTH_FAILURE = 102;
 
    @Autowired
    private ReviewDAO reviewDAO;
    
    @RequestMapping(value="/reviews", method = RequestMethod.GET)
    public List<ReviewEntity> userReviews(){
        
        List<ReviewEntity> reviews = reviewDAO.getAllReviews();        
        return reviews;
    }
 
    @PostMapping(value="/uploadReview")
    public void uploadReview(@RequestBody ReviewEntity review){
        
        ReviewEntity b = new ReviewEntity();    
        b.setUId(review.getUId());
        b.setUReview(review.getUReview());
        b.setUStar(review.getUStar());
        b.setUDate(review.getUDate());
        b.setUBook(review.getUBook());
        reviewDAO.insertUserReview(b);        
    }
}
