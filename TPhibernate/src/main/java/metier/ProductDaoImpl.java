package metier;

import dao.IDao;
import entities.Product;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class ProductDaoImpl implements IDao<Product> {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public boolean create(Product o) {
        Session session = sessionFactory.getCurrentSession();
        session.save(o);
        return true;
    }

    @Override
    public boolean delete(Product o) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(o);
        return true;
    }

    @Override
    public boolean update(Product o) {
        Session session = sessionFactory.getCurrentSession();
        session.update(o);
        return true;
    }

    @Override
    public Product findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class,id);
        return product;
    }

    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> products = session.createQuery("from Product",Product.class).list();
        return products;
    }
}
