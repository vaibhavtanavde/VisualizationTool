package dev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OSS {
	private Map<String, String> userDatabase;
	public OSS() {
        userDatabase = new HashMap<>();
        userDatabase.put("username", "password");
        
	}
	 public boolean login(String username, String password) {
	        String storedPassword = userDatabase.get(username);
	        return storedPassword != null && storedPassword.equals(password);
	    }
	 


}