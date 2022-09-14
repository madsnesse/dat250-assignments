package no.hvl.dat250.jpa.assignment2.driver;

import no.hvl.dat250.jpa.assignment2.*;
import org.apache.derby.iapi.store.raw.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "experiment2";

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Person person = new Person();
        person.setName("Max Mustermann");

        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);

        Pincode pincode = new Pincode();
        pincode.setPincode("123");
        pincode.setCount(1);

        CreditCard cc1 = new CreditCard();
        cc1.setNumber(12345);
        cc1.setBalance(-5000);
        cc1.setLimit(-10000);
        cc1.setPincode(pincode);
        cc1.setOwner(person);

        CreditCard cc2 = new CreditCard();
        cc2.setNumber(123);
        cc2.setBalance(1);
        cc2.setLimit(2000);
        cc2.setPincode(pincode);
        cc2.setOwner(person);

        Bank bank = new Bank();
        bank.setName("Pengebank");
        bank.setOwnedCards(Set.of(cc1, cc2));
        person.setAddresses(List.of(address));
        address.setOwners(Set.of(person));
        person.setCreditCards(List.of(cc1, cc2));
        cc1.setOwningBank(bank);
        cc2.setOwningBank(bank);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(person);
        em.persist(address);
        em.persist(pincode);
        em.persist(cc1);
        em.persist(cc2);
        em.persist(bank);
        transaction.commit();
        em.close();
    }
}
