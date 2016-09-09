package com.samples.many2one;

import com.samples.many2one.models.CarCompany;
import com.samples.many2one.models.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

/**
 * Created by edara on 9/8/16.
 */
@Component
public class ServiceEx1 {
    @Autowired
    EntityManagerFactory emf;

    public void run() {
        saveCompany();
    }
    public void saveCompany(){
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        CarCompany company = new CarCompany();
        company.setCompanyName("Toyota");
        CarModel model1 = new CarModel();
        CarModel model2 = new CarModel();
        model1.setModelName("HighLander");
        model1.setPrice(35000);
        model2.setModelName("Camry");
        model2.setPrice(30000);
        entityManager.persist(company);
        model1.setCompany(company);
        model2.setCompany(company);
        entityManager.persist(model1);
        entityManager.persist(model2);
        transaction.commit();
    }

}
