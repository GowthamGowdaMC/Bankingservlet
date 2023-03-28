package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.BankAccount;

public class Bankdao 
{
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void save(BankAccount bank)
	{
		entityTransaction.begin();
		entityManager.persist(bank);
		entityTransaction.commit();
	}
	public List<BankAccount> fetchAll()
	{
		return entityManager.createQuery("select x from BankAccount x").getResultList();
		
	}
	public BankAccount find(long acc)
	{
		return entityManager.find(BankAccount.class, acc);
	}
	public void update(BankAccount bank)
	{
		entityTransaction.begin();
		entityManager.merge(bank);
		entityTransaction.commit();
	}
}
