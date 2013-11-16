import java.util.*;

class Student{

	String username;
	String salt;
	String password;
	String firstName;
	String lastName;
	String name;
	boolean cracked;
	ArrayList<String> passwords;

	Student(String u, String s, String p, String fn, String ln){
		this.username = u;
		this.salt = s;
		this.password = p;
		this.firstName = fn;
		this.lastName = ln;
		this.name = fn + ln;
		this.cracked = false;
		passwords = new ArrayList<String>();
		// System.out.println("Student!");
	}
}