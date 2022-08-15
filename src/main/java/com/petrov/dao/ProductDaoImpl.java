package com.petrov.dao;

//import com.petrov.HibernateConfig;
import com.petrov.Config;
import com.petrov.entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ejb.Stateful;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

@Stateful
public class ProductDaoImpl implements ProductDao {

    private Session session;

    private Transaction transaction;

//    public Session openSessionWithTransaction() {
//        session = HibernateConfig.getSessionFactory().openSession();
//        session.beginTransaction();
//        return session;
//    }
//
//    public void closeSessionWithTransaction() {
//        session.getTransaction().commit();
//        if (session != null && session.isOpen()) {
//            session.close();
//        }
//    }

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
    public Collection findAll() {
        return executeSessionFunction(session1 -> session1.createQuery("select p from com.petrov.entity.Product p").list());
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
}
