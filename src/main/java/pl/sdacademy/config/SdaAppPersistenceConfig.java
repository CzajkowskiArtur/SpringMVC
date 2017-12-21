package pl.sdacademy.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.sdacademy.entity.Customer;

import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class SdaAppPersistenceConfig {


    @Bean
    public LocalSessionFactoryBean getSessionFactory(DataSource ds) {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(ds);
        factoryBean.setPackagesToScan(new String[] { "pl.sdacademy.entity" });

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setHibernateProperties(additionalProperties());
        //factoryBean.setJpaVendorAdapter(vendorAdapter);
        //factoryBean.setsetJpaProperties(additionalProperties());
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    @Bean
    public DataSource dataSource() throws NamingException {
        //return (DataSource) new JndiTemplate().lookup("jdbc/YouSklep42");
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
  //      ds.setPassword("root");
        ds.setUsername("root");
        ds.setUrl("jdbc:mysql://localhost:3306/sklep42?serverTimezone=UTC");
        return ds;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }
}
