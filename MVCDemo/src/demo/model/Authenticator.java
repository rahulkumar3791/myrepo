package demo.model;

public class Authenticator {
	
	public String authenticate(String username, String password) {
		if (("rahul".equalsIgnoreCase(username))
				&& ("rahul".equals(password))) {
			return "success";
		} else {
			return "error";
		}
	}

}
