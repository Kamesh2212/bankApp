package com.BankDemo.bank;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccService {

	@Autowired(required = true)
	private repo repo;

	public String addAcc(Account a) {
		Account b = repo.save(a);

		return "account created with id "+b.getId();

	}

	public Account getAcc(UUID id) {
		return repo.findById(id);

	}

	public String delAcc(UUID id) {
		repo.delete(repo.findById(id));
		return "Account Deleted";

	}

	public String updateAcc(UUID id, Account newDetails) {
		Account old = repo.findById(id);
		old.setFirstName(newDetails.getFirstName());
		old.setLastName(newDetails.getLastName());
		old.setAccType(newDetails.getAccType());
		repo.save(old);
		return "Account Updated Successfully";

	}

}
