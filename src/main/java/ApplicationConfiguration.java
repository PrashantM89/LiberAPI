import javax.sql.DataSource;
import org.liber.api.dao.BookshelfDAO;
import org.liber.api.dao.ReviewDAO;
import org.liber.api.dao.TransactionDAO;
import org.liber.api.dao.UserDAO;
import org.liber.api.dao.WalletDAO;
import org.liber.api.daoImpl.BookshelfDAOImpl;
import org.liber.api.daoImpl.ReviewDAOImpl;
import org.liber.api.daoImpl.TransactionDAOImpl;
import org.liber.api.daoImpl.UserDAOImpl;
import org.liber.api.daoImpl.WalletDAOImpl;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author prashant
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.liber.api")
public class ApplicationConfiguration {
    
    @Bean
    public BookshelfDAO getBookshelfDAO(){
        return new BookshelfDAOImpl(getDataSource());
    }
   
    @Bean
    public ReviewDAO getReviewDAO(){
        return new ReviewDAOImpl(getDataSource());
    }
    
    @Bean
    public UserDAO getUserDAO(){
        return new UserDAOImpl(getDataSource());
    }
    
    @Bean
    public TransactionDAO getTxnDAO(){
        return new TransactionDAOImpl(getDataSource());
    }
    
//    @Bean
//    public TransactionDAO getNotificationDAO(){
//        return new NotificationDAOImpl(getDataSource());
//    }
    
    
    @Bean
    public WalletDAO getWalletDAO(){
        return new WalletDAOImpl(getDataSource());
    }
    
    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
         dataSource.setUrl("jdbc:mysql://localhost:3306/liber_db");
        dataSource.setUsername("liber");
        dataSource.setPassword("liber");
        return dataSource;
    }
}
