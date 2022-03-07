package com.petrov.dao;

import com.petrov.entity.Category;
import com.petrov.entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class CategoryDaoImpl implements CategoryDao {

    private static final CategoryDao categoryDao = new CategoryDaoImpl();

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
        return executeSessionFunction(session1 -> session1.createQuery("select c from Category c").list());
    }


    @Override
    public Optional<Category> findById(Long id) {
        return executeSessionFunction(session -> Optional.ofNullable(session.get(Category.class, id)));
    }

    @Override
    public void saveOrUpdate(Category category) {
        executeSessionConsumer(session -> session.saveOrUpdate(category));
    }

    @Override
    public void delete(Category category) {
        executeSessionConsumer(session -> session.delete(category));
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

    public static CategoryDao getDao() {
        return categoryDao;
    }
}
