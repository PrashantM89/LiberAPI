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
import org.liber.api.dao.UserDAO;
import org.liber.api.model.ReviewEntity;
import org.liber.api.model.UserEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author prashant
 */
public class UserDAOImpl implements UserDAO{

  private JdbcTemplate jdbcTemplate;
    
    
    public UserDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public UserEntity getUser(String u_mob) {
        
        UserEntity user = null;
        String sql="SELECT * FROM user where u_mob = ?";
        try{
            user = jdbcTemplate.queryForObject(sql, new Object[]{u_mob},new RowMapper<UserEntity>() {
                @Override
                public UserEntity mapRow(ResultSet u, int i) throws SQLException {
                      UserEntity user = new UserEntity();
                        user.setUname(u.getString("u_name"));
                        user.setUemail(u.getString("u_email"));
                        user.setUmob(u.getString("u_mob"));
                        user.setUpin(u.getString("u_pin"));
                        user.setUaddress(u.getString("u_address"));               
                        user.setUsignup_date(u.getString("u_signup_date"));
                        user.setUlast_update(u.getString("u_last_update"));                  
                        user.setUdelete(u.getString("u_delete"));
                      return user;
                }
            });   
        }catch(DataAccessException e){
            e.printStackTrace();            
        }
        
            return user;                                  
    }

    @Override
    public void insertUser(UserEntity r) {
        String sql =  "INSERT INTO user (u_name, u_email, u_mob, u_pin,u_address,u_signup_date,u_last_update,u_delete"
                + " VALUES (?, ?, ?, ?, ?,?,?,? )";       
        jdbcTemplate.update(sql,r.getUname(),r.getUemail(),r.getUmob(),r.getUpin(),r.getUaddress(),r.getUsignup_date(),r.getUlast_update(),r.getUdelete());           
    }
    
    @Override 
    public int updateUser(UserEntity r){                
        
     String sql = "UPDATE user SET u_name= ?, u_email= ?, u_pin = ?, u_address = ?, u_last_update = ?, u_delete= ?, u_signup_date = ? WHERE u_mob = ?";
         
        
     int count = jdbcTemplate.update(sql,new Object[]{r.getUname(),r.getUemail(),r.getUpin(),r.getUaddress(),r.getUlast_update(),r.getUdelete(),r.getUsignup_date(),r.getUmob()});
     
     return count;
    }

    @Override
    public List<UserEntity> getUsers() {
        List<UserEntity> users = null;
        try {
            users = jdbcTemplate.query("SELECT * FROM user",new RowMapper<UserEntity>() {
                @Override
                public UserEntity mapRow(ResultSet u, int i) throws SQLException {
                      UserEntity user = new UserEntity();
                        user.setUname(u.getString("u_name"));
                user.setUemail(u.getString("u_email"));
                user.setUmob(u.getString("u_mob"));
                user.setUpin(u.getString("u_pin"));
                user.setUaddress(u.getString("u_address"));               
                user.setUsignup_date(u.getString("u_signup_date"));
                user.setUlast_update(u.getString("u_last_update"));                  
                user.setUdelete(u.getString("u_delete"));
                      return user;
                }
            });   
        } catch (DataAccessException e) {
            e.printStackTrace();
          }
  return users;
    }
    
}
