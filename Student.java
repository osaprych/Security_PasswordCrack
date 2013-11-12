class Student{

	String username;
	String salt;
	String password;
	String studentName;
	boolean cracked;

	Student(String u, String s, String p, String n){
		this.username = u;
		this.salt = s;
		this.password = p;
		this.studentName = n;
		cracked = FALSE;
		System.out.println("Student!");
	}
}