package com.petrov.dao;

import com.petrov.entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class ProductDaoImpl implements ProductDao {

    private static final ProductDao productDao = new ProductDaoImpl();

    private Session session;

    private Transaction transaction;

    public Session openSessionWithTransaction() {
        session = Config.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public void closeSessionWithTransaction() {
        transaction.commit();
        session.close();
    }

    @Override
    public List findAll() {
        return executeSessionFunction(session1 -> session1.createQuery("select p from Product p").list());
    }


    @Override
    public Optional<Product> findById(Long id) {
        return executeSessionFunction(session -> Optional.ofNullable(session.get(Product.class, id)));
    }

    @Override
    public void saveOrUpdate(Product product) {
        executeSessionConsumer(session -> session.saveOrUpdate(product));
    }

    @Override
    public void delete(Product product) {
        executeSessionConsumer(session -> session.delete(product));
    }

    private <T> T executeSessionFunction(Function<Session, T> function) {
        try {
            return function.apply(openSessionWithTransaction());
        } finally {
            closeSessionWithTransaction();
        }
    }

    private <T> void executeSessionConsumer(Consumer<Session> consumer) {
        try {
            consumer.accept(openSessionWithTransaction());
        } finally {
            closeSessionWithTransaction();
        }
    }

    public static ProductDao getProductDao() {
        return productDao;
    }
}
