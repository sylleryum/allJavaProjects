package com.unisul.springsecurity.dao;

import java.util.List;

import com.unisul.springsecurity.Entity.Authority;
import com.unisul.springsecurity.Entity.Cliente;

public interface AuthorityDAO {

	public List<Authority> getAuthorities();

	public void saveAuthority(Authority theAuthority);

	public Authority getAuthority(String theAuthority);

	public void deleteAuthority(int theId);
	
}
