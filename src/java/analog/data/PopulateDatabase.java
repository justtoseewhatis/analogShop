/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analog.data;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceUnitTransactionType;
import analog.business.Product;
import static org.eclipse.persistence.config.EntityManagerProperties.JDBC_DRIVER;
import static org.eclipse.persistence.config.EntityManagerProperties.JDBC_PASSWORD;
import static org.eclipse.persistence.config.EntityManagerProperties.JDBC_URL;
import static org.eclipse.persistence.config.EntityManagerProperties.JDBC_USER;
import static org.eclipse.persistence.config.PersistenceUnitProperties.TARGET_SERVER;
import static org.eclipse.persistence.config.PersistenceUnitProperties.TRANSACTION_TYPE;
import org.eclipse.persistence.config.TargetServer;

public class PopulateDatabase {
    private static EntityManagerFactory emf;
    
    public static void insertProduct(Product product) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }
    
    public static void main(String[] args) {
        Map props = new HashMap();
        props.put(TRANSACTION_TYPE,
                PersistenceUnitTransactionType.RESOURCE_LOCAL.name());
        props.put(JDBC_DRIVER, "com.mysql.jdbc.Driver");
        props.put(JDBC_URL,
                "jdbc:mysql://localhost:3306/analog_jpa?zeroDateTimeBehavior=convertToNull");
        props.put(JDBC_USER, "root");
        props.put(JDBC_PASSWORD, "sesame");
        props.put(TARGET_SERVER, TargetServer.None);
        
        emf = Persistence.createEntityManagerFactory("musicStorePU", props);
        
        
        Product product1 = new Product();
        product1.setCode("vcs3");
        product1.setDescription("EMS VCS3");
        product1.setPrice(550.00);
        insertProduct(product1);
        
        Product product2 = new Product();
        product2.setCode("minimoog");
        product2.setDescription("Moog Minimoog");
        product2.setPrice(1495.00);
        insertProduct(product2);
        
        Product product3 = new Product();
        product3.setCode("odyssey");
        product3.setDescription("ARP Odyssey");
        product3.setPrice(1495.00);
        insertProduct(product3);
        
        Product product4 = new Product();
        product4.setCode("cs80");
        product4.setDescription("Yamaha CS-80");
        product4.setPrice(6900.00);
        insertProduct(product4);
    }
}
