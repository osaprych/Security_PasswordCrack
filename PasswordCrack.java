import java.io.*;
import java.lang.String;
import java.lang.Object;
import java.util.*;

class PasswordCrack{

    public static ArrayList<String> manglePrepend(String s){
        ArrayList<String> vector = new ArrayList<String>();
        for(int i = 32; i < 125; i++){
            vector.add(Character.toString((char)i) + s);
        }
        return vector;
    }

    public static ArrayList<String> mangleAppend(String s){
        ArrayList<String> vector = new ArrayList<String>();
        // if(s.length() < 8){
            for(int i = 32; i < 125; i++){
                vector.add(s + Character.toString((char)i));
            }
        // }
        return vector;
    }

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

    public static String mangleReplaceE(String s){
        String s1 = s.replace("e", "3");
        String s2 = s1.replace("E", "3");
        // System.out.println(s2);
        return s2;
    }

    public static String mangleReplaceO(String s){
        String s1 = s.replace("o", "0");
        String s2 = s1.replace("O", "0");
        // System.out.println(s2);
        return s2;
    }

    public static String mangleReplaceA(String s){
        String s1 = s.replace("a", "@");
        String s2 = s1.replace("A", "@");
        // System.out.println(s2);
        return s2;
    }

    public static String mangleReplaceL(String s){
        String s1 = s.replace("l", "1");
        String s2 = s1.replace("L", "1");
        // System.out.println(s2);
        return s2;
    }

    public static String mangleReplaceI(String s){
        String s1 = s.replace("i", "!");
        String s2 = s1.replace("I", "!");
        // System.out.println(s2);
        return s2;
    }

    public static String mangleReplaceAll(String s){
        String s1 = PasswordCrack.mangleReplaceE(PasswordCrack.mangleReplaceO(PasswordCrack.mangleReplaceI(PasswordCrack.mangleReplaceA(PasswordCrack.mangleReplaceL(s)))));
        // System.out.println(s1);
        return s1;
    }

    public static ArrayList<String> easyMangles(String str){
        // no mangle
        // String newStr = str;
        ArrayList<String> container = new ArrayList<String>();
        container.add(PasswordCrack.mangleToLower(str));
        container.add(PasswordCrack.mangleToUpper(str));
        container.add(PasswordCrack.mangleDuplicate(str));
        container.add(PasswordCrack.mangleReverse(str));
        container.add(PasswordCrack.mangleDelFirstChar(str));
        container.add(PasswordCrack.mangleDelLastChar(str));
        container.add(PasswordCrack.mangleReflect(str));
        container.add(PasswordCrack.mangleCapitalize(str));
        container.add(PasswordCrack.mangleNCapitalize(str));
        container.add(PasswordCrack.mangleToggleCase(str, 1));
        container.add(PasswordCrack.mangleToggleCase(str, 2));
        ArrayList<String> mergeHelper1 = new ArrayList<String>(PasswordCrack.manglePrepend(str));
        container.addAll(mergeHelper1);
        // container.addAll(PasswordCrack.mangleAppend(str));
        ArrayList<String> mergeHelper2 = new ArrayList<String>(PasswordCrack.mangleAppend(str));
        container.addAll(mergeHelper2);
        return container;
    }

    public static ArrayList<String> comboMangles(String str){
        ArrayList<String> container = new ArrayList<String>();
        container.add(PasswordCrack.mangleReverse(str) + str);
        // capitalize and append
        ArrayList<String> mergeHelper1 = new ArrayList<String>(PasswordCrack.mangleAppend(PasswordCrack.mangleCapitalize(str)));
        container.addAll(mergeHelper1);
        // Ncapitalize and append
        ArrayList<String> mergeHelper2 = new ArrayList<String>(PasswordCrack.manglePrepend(PasswordCrack.mangleNCapitalize(str)));
        container.addAll(mergeHelper2);
        // capitalize and prepend
        ArrayList<String> mergeHelper3 = new ArrayList<String>(PasswordCrack.mangleAppend(PasswordCrack.mangleCapitalize(str)));
        container.addAll(mergeHelper3);
        // Ncapitalize and prepend
        ArrayList<String> mergeHelper4 = new ArrayList<String>(PasswordCrack.manglePrepend(PasswordCrack.mangleNCapitalize(str)));
        container.addAll(mergeHelper4);
        return container;
    }

    public static ArrayList<String> replaceMangles(String str){
        ArrayList<String> container = new ArrayList<String>();
        container.add(PasswordCrack.mangleReplaceE(str));
        container.add(PasswordCrack.mangleReplaceL(str));
        container.add(PasswordCrack.mangleReplaceA(str));
        container.add(PasswordCrack.mangleReplaceI(str));
        container.add(PasswordCrack.mangleReplaceO(str));
        container.add(PasswordCrack.mangleReplaceAll(str));
        // System.out.println(container.toString());
        return container;
    }

    public static ArrayList<String> replaceOtherMangles(String str){
        ArrayList<String> container = new ArrayList<String>();
        container.add(PasswordCrack.mangleReplaceAll(PasswordCrack.mangleCapitalize(str)));
        container.add(PasswordCrack.mangleReplaceAll(PasswordCrack.mangleNCapitalize(str)));
        container.add(PasswordCrack.mangleReplaceAll(PasswordCrack.mangleToUpper(str)));
        container.add(PasswordCrack.mangleReplaceAll(PasswordCrack.mangleToLower(str)));
        container.add(PasswordCrack.mangleReplaceAll(PasswordCrack.mangleToggleCase(str, 1)));
        container.add(PasswordCrack.mangleReplaceAll(PasswordCrack.mangleToggleCase(str, 2)));
        container.add(PasswordCrack.mangleReplaceAll(PasswordCrack.mangleDuplicate(str)));
        container.add(PasswordCrack.mangleReplaceAll(PasswordCrack.mangleReverse(str)));
        container.add(PasswordCrack.mangleReplaceAll(PasswordCrack.mangleReflect(str)));
        container.add(PasswordCrack.mangleReplaceAll(PasswordCrack.mangleDelLastChar(str)));
        container.add(PasswordCrack.mangleReplaceAll(PasswordCrack.mangleDelFirstChar(str)));
        // System.out.println(container.toString());
        return container;
    }

    public static void checkMatch(Student s, String original){
        // encode generated password
        String encrypted = jcrypt.crypt(s.salt, original);
                    
        // compare it with stored encrypted password using 1st 8 characters
        if(encrypted.regionMatches(0, s.salt + s.password, 0, 8)){
            // System.out.println("Matched password!");
            System.out.println(s.username + " has password " + original + "\n");
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
        ArrayList<String> possiblePW = new ArrayList<String>();
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<String> pwDictionary = new ArrayList<String>();

        Scanner dictionaryText = new Scanner(new FileReader(inputFile1));
        while(dictionaryText.hasNextLine()){
            words.add(dictionaryText.nextLine());
        }

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
        // generate vector of possible passwords
        for(int j = 0; j < students.length; j++){
            ArrayList<String> mergeHelper1 = new ArrayList<String>(easyMangles(students[j].username));
            ArrayList<String> mergeHelper4 = new ArrayList<String>(comboMangles(students[j].username));
            ArrayList<String> mergeHelper7 = new ArrayList<String>(replaceMangles(students[j].username));
            ArrayList<String> mergeHelper10 = new ArrayList<String>(replaceOtherMangles(students[j].username));
            students[j].passwords.addAll(mergeHelper10);
            students[j].passwords.addAll(mergeHelper7);
            students[j].passwords.addAll(mergeHelper1);
            students[j].passwords.addAll(mergeHelper4);
            ArrayList<String> mergeHelper2 = new ArrayList<String>(easyMangles(students[j].firstName));
            ArrayList<String> mergeHelper5 = new ArrayList<String>(comboMangles(students[j].username));
            ArrayList<String> mergeHelper8 = new ArrayList<String>(replaceMangles(students[j].username));
            ArrayList<String> mergeHelper11 = new ArrayList<String>(replaceOtherMangles(students[j].username));
            students[j].passwords.addAll(mergeHelper11);
            students[j].passwords.addAll(mergeHelper8);
            students[j].passwords.addAll(mergeHelper2);
            students[j].passwords.addAll(mergeHelper5);
            ArrayList<String> mergeHelper3 = new ArrayList<String>(easyMangles(students[j].lastName));
            ArrayList<String> mergeHelper6 = new ArrayList<String>(comboMangles(students[j].username));
            ArrayList<String> mergeHelper9 = new ArrayList<String>(replaceMangles(students[j].username));
            ArrayList<String> mergeHelper12 = new ArrayList<String>(replaceOtherMangles(students[j].username));
            students[j].passwords.addAll(mergeHelper12);
            students[j].passwords.addAll(mergeHelper9);
            students[j].passwords.addAll(mergeHelper3);
            students[j].passwords.addAll(mergeHelper6);
            // students[j].passwords.addAll(easyMangles(students[j].username));
            // students[j].passwords.addAll(easyMangles(students[j].firstName));
            // students[j].passwords.addAll(easyMangles(students[j].lastName));
        }

        for(int j = 0; j < words.size(); j++){
            ArrayList<String> mergeHelper1 = new ArrayList<String>(easyMangles(words.get(j)));
            pwDictionary.addAll(mergeHelper1);
            ArrayList<String> mergeHelper2 = new ArrayList<String>(comboMangles(words.get(j)));
            pwDictionary.addAll(mergeHelper2);
            ArrayList<String> mergeHelper3 = new ArrayList<String>(replaceMangles(words.get(j)));
            pwDictionary.addAll(mergeHelper3);
            ArrayList<String> mergeHelper4 = new ArrayList<String>(replaceOtherMangles(words.get(j)));
            pwDictionary.addAll(mergeHelper4);
        }
        // System.out.println(pwDictionary.toString());

        // System.out.println(students[0].passwords.toString());
        // String original;
        for(int count = 0; count < students[0].passwords.size(); count++){
        // LOOP through array of students
            for(int j = 0; j < students.length; j++){
                if(students[j].cracked == false){
                    PasswordCrack.checkMatch(students[j], students[j].passwords.get(count));
                }
            }
        }

        for(int count = 0; count < pwDictionary.size(); count++){
        // LOOP through array of students
            for(int j = 0; j < students.length; j++){
                if(students[j].cracked == false){
                    PasswordCrack.checkMatch(students[j], pwDictionary.get(count));
                }
            }
        }
   }
}