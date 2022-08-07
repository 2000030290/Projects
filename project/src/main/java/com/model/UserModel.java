package com.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.User;


@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)

public class UserModel implements UserRemote{

	@Override
	public String insertData(User u) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("project");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return "Record inserted succesfylly...";

	}

	@Override
	public List<User> readAll() throws Exception {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("project");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query qry = em.createQuery("select e from user e");
		@SuppressWarnings("unchecked")
		List<User> L = qry.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return L;

	}

	@Override
	public User findData(String name) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("project");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User E = em.find(User.class, name);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return E;

	}

	@Override
	public String updateData(String name, User data) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("project");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User E = em.find(User.class, name);
		E.setName(data.getName());
		E.setAge(data.getAge());
		E.setMobileno(data.getMobileno());
		E.setAddress(data.getAddress());
		E.setPassword(data.getPassword());
		E.setEmail(data.getEmail());
		E.setGender(data.getGender());
		em.getTransaction().commit();
		em.close();
		emf.close();
		return "Record updated successfully...";

	}

	@Override
	public String deleteData(String name) throws Exception {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("project");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User E = em.find(User.class, name);
		em.remove(E);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return "Record deleted successfully...";

	}

}
