package kr.ac.hanrw.webapp.common;


import kr.ac.hanrw.webapp.dto.User;

public class LoginUserThreadLocal {
	public static final ThreadLocal<User> userThreadLocal = new ThreadLocal<User>();
	
	public static void set(User user) {
		userThreadLocal.set(user);
	}
	
	public static void unSet() {
		userThreadLocal.remove();
	}
	
	public static User get() {
		return (User) userThreadLocal.get();
	}
}
