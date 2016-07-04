package co.cg.demo.repo;

import com.cg.demo.beans.Account;

public interface AccountRepo {

	boolean save(Account a);
	
	 Account findById(int id);
}
