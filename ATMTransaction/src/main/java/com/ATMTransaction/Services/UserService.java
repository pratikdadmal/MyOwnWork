package com.ATMTransaction.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ATMTransaction.DAO.UserDao;
import com.ATMTransaction.Entity.User1ATM;

@Service
@Transactional
public class UserService
{
	@Autowired
	private UserDao userdao;

		public boolean insertDetails(User1ATM user) {
			boolean b = userdao.insertDetails(user);
			return b;

		}


}
