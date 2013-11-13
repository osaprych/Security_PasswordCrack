import java.io.*;
import java.lang.String;
import java.lang.Object;
import java.util.*;

class PasswordCrack{

    // mangle(int count, Student s)
    public static void mangle(int count, Student s){
        if(count % 12 == 1){

        }
    }

    public static void manglePrepend(Student s){
        // String[] mangledPrepend = new String[92];
        // String newMangle;
        for(int i = 32; i < 125; i++){
            if(s.cracked == false){
                // mangledPrepend[i-32] = Character.toChars(i).toString() + s;
                PasswordCrack.checkMatch(s, Character.toChars(i).toString() + s);
            }
            else
                break;
        }
        // return mangledPrepend;
    }

    // good
    public static String mangleToUpper(String s){
        return s.toUpperCase();
    }

    public static String mangleToLower(String s){
        return s.toLowerCase();
    }

    public static String mangleDuplicate(String s){
        return s + s;
    }

    public static String mangleReverse(String s){
        return new StringBuilder(s).reverse().toString();
    }

    public static String mangleDelFirstChar(String s){
        return s.substring(1, s.length());
    }

    public static String mangleDelLastChar(String s){
        return s.substring(0, s.length() - 1);
    }    

    public static String mangleReflect(String s){
        return s + new StringBuilder(s).reverse().toString();
    }

    public static String mangleCapitalize(String s){
        return s.substring(0, 1).toUpperCase() + s.substring(1, s.length()).toLowerCase();
    }

    public static String mangleNCapitalize(String s){
        return s.substring(0, 1).toLowerCase() + s.substring(1, s.length()).toUpperCase();
    }

    public static String mangleToggleCase(String s, int count){
        int toggleCase;
        if(count % 2 == 0){
            toggleCase = 0;
        }
        else{
            toggleCase = 1;;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(i % 2 == toggleCase){
                sb.append(s.substring(i, i + 1).toUpperCase());
            }
            else{
                sb.append(s.substring(i, i + 1).toLowerCase());
            }
        }
        return sb.toString();
    }

    public static void mangles(Student s, String str, int count){
        // no mangle
        String newStr = str;
        PasswordCrack.checkMatch(s, PasswordCrack.mangleToUpper(newStr));
        if(s.cracked == false){
            newStr = str;
            PasswordCrack.checkMatch(s, PasswordCrack.mangleToLower(newStr));
        }
        else if(s.cracked == false){
            newStr = str;
            PasswordCrack.checkMatch(s, PasswordCrack.mangleDuplicate(newStr));
        }
        else if(s.cracked == false){
            newStr = str;
            PasswordCrack.checkMatch(s, PasswordCrack.mangleReverse(newStr));
        }
        else if(s.cracked == false){
            newStr = str;
            PasswordCrack.checkMatch(s, PasswordCrack.mangleDelFirstChar(newStr));
        }
        else if(s.cracked == false){
            newStr = str;
            PasswordCrack.checkMatch(s, PasswordCrack.mangleDelLastChar(newStr));
        }
        else if(s.cracked == false){
            newStr = str;
            PasswordCrack.checkMatch(s, PasswordCrack.mangleReflect(newStr));
        }
        else if(s.cracked == false){
            newStr = str;
            PasswordCrack.checkMatch(s, PasswordCrack.mangleCapitalize(newStr));
        }
        else if(s.cracked == false){
            newStr = str;
            PasswordCrack.checkMatch(s, PasswordCrack.mangleNCapitalize(newStr));
        }
        else if(s.cracked == false){
            newStr = str;
            PasswordCrack.checkMatch(s, PasswordCrack.mangleToggleCase(newStr, 1));
        }
        else if(s.cracked == false){
            newStr = str;
            PasswordCrack.checkMatch(s, PasswordCrack.mangleToggleCase(newStr, 2));
        }
    }

    public static void checkMatch(Student s, String original){
        // encode generated password
        String encrypted = jcrypt.crypt(s.salt, original);
                    
        // compare it with stored encrypted password using 1st 8 characters
        if(encrypted.regionMatches(0, s.salt + s.password, 0, 8)){
            System.out.println("Matched password!");
            System.out.println(s.username + " has password " + original);
            s.cracked = true;
        }
    }

	public static void main(String args[]) throws IOException{
        // java PasswordCrack inputFile1 inputFile2
        File inputFile1 = new File(args[0]);
        File inputFile2 = new File(args[1]);
        Student[] students = new Student[20];
        // read from the file 
        // 1. dictionary 
        // 2. passwords to crack

        Scanner studentText = new Scanner(new FileReader(inputFile2));
        String line;
        String delims = ":";
        String space = " ";
        int i = 0;
        while(studentText.hasNextLine()){
            line = studentText.nextLine();
            String[] tokens = line.split(delims);
            String username = tokens[0];
            String pwWithSalt = tokens[1];
            String[] name = tokens[4].split(space);
            String salt = pwWithSalt.substring(0, 2);
            String pw = pwWithSalt.substring(2, pwWithSalt.length());
            students[i] = new Student(username, salt, pw, name[0], name[1]);
            i++;
        }
        // parce passwords to crack file
        // String username
        // :
        // String password (2 char salt + 11 char password)
        // some numbers :500:500:
        // String studentName "Michael Ferris"
        // the rest doesn't seem to be important

        // store in array of students

        // set a counter
        int count = 0;
        String original;
        while(true){
        // LOOP through array of students
            for(int j = 0; j < students.length; j++){
        // if password hasn't been cracked
                if(students[j].cracked == false){
                    // System.out.println(students[j].username);

                    original = students[j].username;
                    if(count % 3 == 0){
                        // original = students[j].username;
                        PasswordCrack.mangles(students[j], students[j].username, count);
                    }

                    else if(count % 3 == 1){
                        // original = students[j].firstName;
                        PasswordCrack.mangles(students[j], students[j].firstName, count);
                    }

                    else if(count % 3 == 2){
                        // original = students[j].lastName;
                        PasswordCrack.mangles(students[j], students[j].lastName, count);
                    }

                    //===================================================
                    /*
                    if(count % 10 == 0){
                        original = PasswordCrack.mangleToUpper(original);
                        // System.out.println(original);
                    }

                    else if(count % 10 == 1){
                        original = PasswordCrack.mangleToLower(original);
                        // System.out.println(original);
                    }

                    else if(count % 10 == 2){
                        original = PasswordCrack.mangleDuplicate(original);
                        // System.out.println(original);
                    }

                    else if(count % 10 == 3){
                        original = PasswordCrack.mangleReverse(original);
                        // System.out.println(original);
                    }

                    else if(count % 10 == 4){
                        original = PasswordCrack.mangleDelFirstChar(original);
                        // System.out.println(original);
                    }

                    else if(count % 10 == 5){
                        original = PasswordCrack.mangleDelLastChar(original);
                        // System.out.println(original);
                    }

                    else if(count % 10 == 6){
                        original = PasswordCrack.mangleReflect(original);
                        // System.out.println(original);
                    }

                    else if(count % 10 == 7){
                        original = PasswordCrack.mangleCapitalize(original);
                        // System.out.println(original);
                    }

                    else if(count % 10 == 8){
                        original = PasswordCrack.mangleToggleCase(original, count);
                        // System.out.println(original);
                    }

                    else if(count % 10 == 9){
                        original = PasswordCrack.mangleToggleCase(original, count);
                        // System.out.println(original);
                    }
                    */
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

        // call next function to generate new password and check match
                    // PasswordCrack.checkMatch(students[j], original);        

        // if they match
        // print the cracked line in the terminal with real password in it
        // change cracked to true
                }
            }

        // increment counter
            count++;
        }
   }
}