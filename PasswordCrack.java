class PasswordCrack{

    // mangle(int count, Student s)


	public static void main(String args[]){
        // java PasswordCrack inputFile1 inputFile2
        // read from the file 
        // 1. dictionary 
        // 2. passwords to crack

        // parce passwords to crack file
        // String username
        // :
        // String password (2 char salt + 11 char password)
        // some numbers :500:500:
        // String studentName "Michael Ferris"
        // the rest doesn't seem to be important

        // store in array of students

        // set a counter
        // LOOP through array of students
        // if password hasn't been cracked

        //=======================================
        // if 0 <= counter < # of mingles
        // username
        
        // if # of mingles <= counter < 2 * (# of mingles)
        // first name

        // if # of mingles <= counter < 2 * (# of mingles)
        // last name

        // if # of mingles <= counter < 2 * (# of mingles)
        // first and last name

        // if # of mingles <= counter < 2 * (# of mingles)
        // words from dictionary 

        // then maybe combeinations of words from the dictioanry???
        //=======================================

        // call next function to generate new password
        // encode generated password
        // String crypt(String salt, String original)
        // compare it with stored encrypted password using 1st 8 characters

        // if they match
        // print the cracked line in the terminal with real password in it
        // change cracked to true

        // increment counter
   }
}