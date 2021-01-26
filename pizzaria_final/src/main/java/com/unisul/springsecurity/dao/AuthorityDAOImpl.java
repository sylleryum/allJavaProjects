package com.unisul.springsecurity.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unisul.springsecurity.Entity.Authority;
import com.unisul.springsecurity.Entity.Cliente;

@Component
public class AuthorityDAOImpl implements AuthorityDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Authority> getAuthorities() {
		return null;
	}

	@Override
	@Transactional
	public void saveAuthority(Authority theAuthority) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(theAuthority);
	}

	@Override
	public Authority getAuthority(String theAuthority) {
		return null;
	}

	@Override
	public void deleteAuthority(int theId) {
	}

}
