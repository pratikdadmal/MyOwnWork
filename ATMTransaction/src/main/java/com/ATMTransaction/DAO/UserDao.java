package com.ATMTransaction.DAO;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.ATMTransaction.Entity.User1ATM;

@Repository
public class UserDao
{

	@Autowired
	private SessionFactory sf;
	
//	@Autowired
//	UserRepository userrepository;
	
	public boolean insertDetails(User1ATM user) {
		
		boolean b = false;
		Session session = sf.getCurrentSession();
		session.save(user);
		b=true;
		return b;
	
	}
	
	
	
}
