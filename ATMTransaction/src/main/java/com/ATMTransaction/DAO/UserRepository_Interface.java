package com.ATMTransaction.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ATMTransaction.Entity.User1ATM;

public interface UserRepository_Interface extends CrudRepository<User1ATM, Integer> {
	
	@Query("select u FROM User1ATM u")
	public List<User1ATM> getAlldata();
	
	@Query("select u FROM User1ATM u WHERE u.uAccount =:a")
	public List<User1ATM> getAmountByAccount(@Param("a") Integer uAccount);

}
