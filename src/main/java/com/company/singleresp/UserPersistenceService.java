package com.company.singleresp;

public class UserPersistenceService {

    private Store store = new Store();
    public void saveUser(User user){
        store.store(user);
    }
	
}
