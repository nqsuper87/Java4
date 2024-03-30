package com.fpoly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.fpoly.bean.User;
import com.fpoly.utils.JPAUtils;

public class UserDAO {
	private EntityManager em = JPAUtils.getEntityManager();
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		em.close();
		super.finalize();
	}
	
	public User create(User entity) {
		em.persist(entity);
		return entity;
	}
	
	public User update(User entity) {
		em.merge(entity);
		return entity;
	}
	
	public User delete(User entity) {
		em.remove(entity);
		return entity;
	}
	
	public User findById(String id) {
		User user = em.find(User.class, id);
		return user;
	}
	
	public List<User> findAll() {
		String jpql = "SELECT u FROM USER u";
		TypedQuery<User> uQuery = em.createQuery(jpql,User.class);
		return uQuery.getResultList();
	}
}
