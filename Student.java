class Student{

	String username;
	String salt;
	String password;
	String firstName;
	String lastName;
	boolean cracked;

	Student(String u, String s, String p, String fn, String ln){
		this.username = u;
		this.salt = s;
		this.password = p;
		this.firstName = fn;
		this.lastName = ln;
		this.cracked = false;
		// System.out.println("Student!");
	}
}