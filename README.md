Security_PasswordCrack

http://www.cs.utexas.edu/~byoung/cs361/crack-assignment.html

======================

Olga Saprycheva

My algorithms has two classes Studend and PasswordCrack. Student stores infromation about students 
while PasswordCrack has main method and has many "mangles" functions which generate various mangles.
In addition I have several functions that combine this mangles in different ways. 
I also have generateMangle function which would generate a number within a range of number of functions, 
i.e. 17, and randomly calls a function on a given string using switch.

In the main method, my first strategy is to look for the easiest password which are just combinations
of username, first name, last name, or full name. Then, I mangle words from the given short dictionary. 
While generating parts of them, I send them to be encrypted and checked against encrypted passwords.
In addition, I check the passwords against a short array of most commonly used passwords.

At the end, I run the function that calls mangles randomly and random number of times on each word from the 
dictionary, encrypt them, and compare with encrypted version of password.



From the passwd1 file I was able to crack 18 passwords in less than two minutes.

#1. michael has password michael
Total time:        0.41

#2. abigail has password liagiba
Total time:        0.42

#3. maria has password Salizar
Total time:        0.56

#4. benjamin has password abort6
Total time:        0.72

#5. samantha has password amazing
Total time:        1.34

#6. tyler has password eeffoc
Total time:        4.05

#7. morgan has password rdoctor
Total time:        5.67

#8. jennifer has password doorrood
Total time:        5.74

#9. connor has password enoggone
Total time:        7.32

#10. evan has password Impact
Total time:        7.97

#11. nicole has password keyskeys
Total time:        8.57

#12. rachel has password obliqu3
Total time:        9.72

#13. jack has password sATCHEL
Total time:       11.27

#14. alexander has password squadro
Total time:       11.83

#15. victor has password THIRTY
Total time:       12.22

#16. james has password icious
Total time:       12.52

#17. caleb has password teserP
Total time:       15.29

#18. dustin has password litpeR
Total time:       99.36


From the passwd2 file I was able to crack 14 passwords in less than a half of a minute:

#1. samantha has password cOnNeLlY
Total time:        0.57

#2. jennifer has password ElmerJ
Total time:        0.59

#3. evan has password ^bribed
Total time:        3.49

#4. morgan has password dIAMETER
Total time:        6.33

#5. james has password enchant$
Total time:        7.38

#6. tyler has password eltneg
Total time:        8.71

#7. nicole has password INDIGNITY
Total time:        9.89

#8. abigail has password Saxon
Total time:       14.86

#9. dustin has password Swine3
Total time:       16.35

#10. michael has password tremors
Total time:       16.85

#11. jack has password ellows
Total time:       17.64

#12. caleb has password zoossooz
Total time:       17.67

#13. benjamin has password soozzoos
Total time:       17.68

#14. alexander has password Lacque
Total time:       24.02

