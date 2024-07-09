package com.BankDemo.bank;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface repo extends JpaRepository<Account,Integer> {

	

	Account findById(UUID id);

	Account deleteById(UUID id);
	

}
