/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analog.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import analog.business.Product;

public class ProductDB {

    public static Product selectProduct(String code) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p FROM Product p " +
                "WHERE p.code = :code";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        q.setParameter("code", code);
        Product result = null;
        try {
            result = q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        
        return (Product)result;
    }
    
    public static Product selectProduct(long productId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        return em.find(Product.class, productId);
    }
    
    public List<Product> selectProducts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p from Product p";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        List<Product> results = null;
        try {
            results = q.getResultList();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        
        return results;
    }
}
