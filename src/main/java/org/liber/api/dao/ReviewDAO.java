/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.liber.api.dao;

import java.util.List;
import org.liber.api.model.ReviewEntity;

/**
 *
 * @author prashant
 */
public interface ReviewDAO {
    public List<ReviewEntity> getAllReviews();
    public void insertUserReview(ReviewEntity r);
}
