/*
Olga Saprycheva
EID os3587
CSID osaprych
*/

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

    public static String manglePrependRand(String s){
        Random random = new Random();
        int i = random.nextInt((125 - 32) + 1) + 32;
        return Character.toString((char)i) + s;
    }

    public static String mangleAppendRand(String s){
        Random random = new Random();
        int i = random.nextInt((125 - 32) + 1) + 32;
        return s + Character.toString((char)i);
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
        if(s.length() > 0)
            return s.substring(1, s.length());
        else
            return s;
    }

    public static String mangleDelLastChar(String s){
        if(s.length() > 0)
            return s.substring(0, s.length() - 1);
        else
            return s;
    }    

    public static String mangleReflect(String s){
        return s + new StringBuilder(s).reverse().toString();
    }

    public static String mangleCapitalize(String s){
        if(s.length() > 0)
            return s.substring(0, 1).toUpperCase() + s.substring(1, s.length()).toLowerCase();
        else
            return s;
    }

    public static String mangleNCapitalize(String s){
        if(s.length() > 0)
            return s.substring(0, 1).toLowerCase() + s.substring(1, s.length()).toUpperCase();
        else
            return s;
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

    public static String mangleToggleCase0(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(i % 2 == 0){
                sb.append(s.substring(i, i + 1).toUpperCase());
            }
            else{
                sb.append(s.substring(i, i + 1).toLowerCase());
            }
        }
        return sb.toString();
    }

    public static String mangleToggleCase1(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(i % 2 == 1){
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
        return s2;
    }

    public static String mangleReplaceO(String s){
        String s1 = s.replace("o", "0");
        String s2 = s1.replace("O", "0");
        return s2;
    }

    public static String mangleReplaceA(String s){
        String s1 = s.replace("a", "@");
        String s2 = s1.replace("A", "@");
        return s2;
    }

    public static String mangleReplaceL(String s){
        String s1 = s.replace("l", "1");
        String s2 = s1.replace("L", "1");
        return s2;
    }

    public static String mangleReplaceI(String s){
        String s1 = s.replace("i", "!");
        String s2 = s1.replace("I", "!");
        return s2;
    }

    public static String mangleReplaceAll(String s){
        String s1 = PasswordCrack.mangleReplaceE(PasswordCrack.mangleReplaceO(PasswordCrack.mangleReplaceI(PasswordCrack.mangleReplaceA(PasswordCrack.mangleReplaceL(s)))));
        return s1;
    }

    public static ArrayList<String> easyMangles(String str){
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

    public static ArrayList<String> comboMangles2(String str){
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

    // public static ArrayList<String> comboManglesAppendPrepend(String str){
    //     // System.out.println("In comboManglesAppendPrepend");
    //     ArrayList<String> container = new ArrayList<String>();
    //     ArrayList<String> mergeHelper1 = new ArrayList<String>(PasswordCrack.manglePrepend(str));
        
    //     for(int i = 0; i < mergeHelper1.size(); i++){
    //         // System.out.println("In comboManglesAppendPrepend");
    //         ArrayList<String> mergeHelper2 = new ArrayList<String>(PasswordCrack.mangleAppend(mergeHelper1.get(i)));
    //         container.addAll(mergeHelper2);
    //     }
    //     // container.addAll(mergeHelper);
    //     // System.out.println("Getting out of comboManglesAppendPrepend");
    //     return container;
    // }

    public static ArrayList<String> replaceMangles(String str){
        ArrayList<String> container = new ArrayList<String>();
        container.add(PasswordCrack.mangleReplaceE(str));
        container.add(PasswordCrack.mangleReplaceL(str));
        container.add(PasswordCrack.mangleReplaceA(str));
        container.add(PasswordCrack.mangleReplaceI(str));
        container.add(PasswordCrack.mangleReplaceO(str));
        container.add(PasswordCrack.mangleReplaceAll(str));
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
        return container;
    }

    public static int checkMatch(Student s, String original, long timeStart, int foundNum){
        // encode generated password
        String encrypted = jcrypt.crypt(s.salt, original);
                    
        // compare it with stored encrypted password using 1st 8 characters
        if(encrypted.regionMatches(0, s.salt + s.password, 0, 8)){
            long timeFound = System.currentTimeMillis();
            double secondsElapsed = (timeFound - timeStart) / 1000.0;
            ++foundNum;
            System.out.println("\n#" + foundNum + ". " + s.username + " has password " + original);// + ". Time: %f10.5" + secondsElapsed);
            System.out.printf("%s %10.2f", "Total time: ", secondsElapsed);
            System.out.println("");
            s.cracked = true;
        }
        return foundNum;
    }

    public static String generateMangles(String str) {
        int caseNum = new Random().nextInt(17);
        String result = "";

        switch (caseNum) {
            case 0:
                result = PasswordCrack.mangleToUpper(str);
                break;

            case 1:
                result = PasswordCrack.mangleToLower(str);
                break;

            case 2:
                result = PasswordCrack.mangleDuplicate(str);
                break;

            case 3:
                result = PasswordCrack.mangleReverse(str);
                break;

            case 4:
                result = PasswordCrack.mangleDelFirstChar(str);
                break;

            case 5:
                result = PasswordCrack.mangleDelLastChar(str);
                break;

            case 6:
                result = PasswordCrack.mangleReflect(str);
                break;

            case 7:
                result = PasswordCrack.mangleCapitalize(str);
                break;

            case 8:
                result = PasswordCrack.mangleNCapitalize(str);
                break;

            case 9:
                result = PasswordCrack.mangleToggleCase0(str);
                break;

            case 10:
                result = PasswordCrack.mangleToggleCase1(str);
                break;

            case 11:
                result = PasswordCrack.mangleReplaceE(str);
                break;

            case 12:
                result = PasswordCrack.mangleReplaceO(str);
                break;

            case 13:
                result = PasswordCrack.mangleReplaceA(str);
                break;

            case 14:
                result = PasswordCrack.mangleReplaceL(str);
                break;

            case 15:
                result = PasswordCrack.mangleReplaceI(str);
                break;

            case 16:
                result = PasswordCrack.mangleReplaceAll(str);
                break;

            // case 17:
            //     result = PasswordCrack.mangleAppendRand(str);
            //     break;

            // case 18:
            //     result = PasswordCrack.manglePrependRand(str);
            //     break;
        } 

        return result;      
    }

    public static void main(String args[]) throws IOException{

        // returns the current time in milliseconds 
        long timeStart = System.currentTimeMillis();

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

        String[] naivePW = {"password", "123456", "12345678", "abc123", "qwerty","monkey","letmein","dragon","111111","baseball","iloveyou","trustno1",
        "1234567","sunshine","master","123123","welcome","shadow","ashley","football","jesus","ninja","mustang","password1"};

        int foundNum = 0;
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
            ArrayList<String> mergeHelper5 = new ArrayList<String>(comboMangles(students[j].firstName));
            ArrayList<String> mergeHelper8 = new ArrayList<String>(replaceMangles(students[j].firstName));
            ArrayList<String> mergeHelper11 = new ArrayList<String>(replaceOtherMangles(students[j].firstName));
            students[j].passwords.addAll(mergeHelper11);
            students[j].passwords.addAll(mergeHelper8);
            students[j].passwords.addAll(mergeHelper2);
            students[j].passwords.addAll(mergeHelper5);
            ArrayList<String> mergeHelper3 = new ArrayList<String>(easyMangles(students[j].lastName));
            ArrayList<String> mergeHelper6 = new ArrayList<String>(comboMangles(students[j].lastName));
            ArrayList<String> mergeHelper9 = new ArrayList<String>(replaceMangles(students[j].lastName));
            ArrayList<String> mergeHelper12 = new ArrayList<String>(replaceOtherMangles(students[j].lastName));
            students[j].passwords.addAll(mergeHelper12);
            students[j].passwords.addAll(mergeHelper9);
            students[j].passwords.addAll(mergeHelper3);
            students[j].passwords.addAll(mergeHelper6);
            ArrayList<String> mergeHelper13 = new ArrayList<String>(easyMangles(students[j].name));
            ArrayList<String> mergeHelper14 = new ArrayList<String>(comboMangles(students[j].name));
            ArrayList<String> mergeHelper15 = new ArrayList<String>(replaceMangles(students[j].name));
            ArrayList<String> mergeHelper16 = new ArrayList<String>(replaceOtherMangles(students[j].name));
            students[j].passwords.addAll(mergeHelper13);
            students[j].passwords.addAll(mergeHelper14);
            students[j].passwords.addAll(mergeHelper15);
            students[j].passwords.addAll(mergeHelper16);
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

        // String original;
        for(int count = 0; count < students[0].passwords.size(); count++){
        // LOOP through array of students
            for(int j = 0; j < students.length; j++){
                if(students[j].cracked == false){
                    foundNum = PasswordCrack.checkMatch(students[j], students[j].passwords.get(count), timeStart, foundNum);
                }
            }
        }

        // // check the most commonly used passwords
        for(int count = 0; count < naivePW.length; count++){
        // LOOP through array of students
            for(int j = 0; j < students.length; j++){
                if(students[j].cracked == false){
                    foundNum = PasswordCrack.checkMatch(students[j], naivePW[count], timeStart, foundNum);
                }
            }
        }

        // ArrayList<String> pwAppendPrepend = new ArrayList<String>();
        // for(int j = 0; j < words.size(); j++){
        //     ArrayList<String> mergeHelper1 = new ArrayList<String>(comboManglesAppendPrepend(words.get(j)));
        //     pwAppendPrepend.addAll(mergeHelper1);
        // }

        // // System.out.println(pwAppendPrepend.toString());
        // System.out.println(pwAppendPrepend.size());
        // for(int count = 0; count < pwAppendPrepend.size(); count++){
        // // LOOP through array of students
        //     for(int j = 0; j < students.length; j++){
        //         if(students[j].cracked == false){
        //             PasswordCrack.checkMatch(students[j], pwAppendPrepend.get(count));
        //             // System.out.println("Evaluating comboManglesAppendPrepend");
        //         }
        //     }
        // }
        
        for(int count = 0; count < pwDictionary.size(); count++){
        // LOOP through array of students
            for(int j = 0; j < students.length; j++){
                if(students[j].cracked == false){
                    foundNum = PasswordCrack.checkMatch(students[j], pwDictionary.get(count), timeStart, foundNum);
                }
            }
        }

        String str;
        while(true){
            for(int count = 0; count < words.size(); count++){
                // get word from the dictionary and mangle it at least once
                str = PasswordCrack.generateMangles(words.get(count));

                // generate a number of times to mangle word more
                int manglesNum = new Random().nextInt(17);
                for(int k = 0; k < manglesNum; k++){
                    str = PasswordCrack.generateMangles(str);
                }

                for(int j = 0; j < students.length; j++){
                    if(students[j].cracked == false){
                        foundNum = PasswordCrack.checkMatch(students[j], str, timeStart, foundNum);
                    }
                }
            }
        }

    }
}