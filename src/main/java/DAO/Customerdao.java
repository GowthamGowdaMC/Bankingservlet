package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.Customer;

public class Customerdao 
{
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void save(Customer cust)
	{
		entityTransaction.begin();
		entityManager.persist(cust);
		entityTransaction.commit();
	}
	public List<Customer> check(String email)
	{
		return entityManager.createQuery("select x from Customer x where email=?1").setParameter(1, email).getResultList();
	}
	public List<Customer> check(Long mob)
	{
		return entityManager.createQuery("select x from Customer x where mobile=?1").setParameter(1, mob).getResultList();
	}
	public Customer login(int custid)
	{
		return entityManager.find(Customer.class, custid);
	}
	public void update(Customer cust)
	{
		entityTransaction.begin();
		entityManager.merge(cust);
		entityTransaction.commit();
	}
}
