/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.liber.api.dao;

import java.util.List;
import org.liber.api.model.ReviewEntity;
import org.liber.api.model.UserEntity;

/**
 *
 * @author prashant
 */
public interface UserDAO {
    public UserEntity getUser(String mob);
    public void insertUser(UserEntity r);
    public int updateUser(UserEntity r);
    public List<UserEntity> getUsers();
}
