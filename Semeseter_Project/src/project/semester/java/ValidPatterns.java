package project.semester.java;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPatterns {
    public static final Pattern STUDENT_ID=Pattern.compile("(?i)(FA|SP)\\d\\d-[B|Mb|m][A-Za-z][A-Za-z]-\\d\\d\\d");
    public static final Pattern FIRST_NAME= Pattern.compile("[A-Z][a-zA-Z]*");
    public static final Pattern LAST_NAME=Pattern.compile("[A-Z][a-zA-Z]*");
    public static final Pattern AGE = Pattern.compile("\\d{2}");
    public static final Pattern CNIC= Pattern.compile("\\d{5}-\\d{7}-\\d");
    public static final Pattern EMAIL= Pattern.compile("(?i)(FA|SP)\\d\\d-[B|Mb|m][A-Za-z][A-Za-z]-\\d\\d\\d(@cuilahore.edu.pk)");
    public static final Pattern CGPA= Pattern.compile("([0-3].[0-9][0-9])|([0-4].00)");

    public static boolean matchID(String studentID){
        Matcher matcher = STUDENT_ID.matcher(studentID);
        return matcher.matches();
    }
    public static boolean matchFirstName(String firstName){
        Matcher matcher = FIRST_NAME.matcher(firstName);
        return matcher.matches();
    }
    public static boolean matchLastName(String lastName){
        Matcher matcher = LAST_NAME.matcher(lastName);
        return matcher.matches();
    }
    public static boolean matchAge(String age){
        Matcher matcher = AGE.matcher(age);
        return matcher.matches();
    }
    public static boolean matchCNIC(String cnic){
        Matcher matcher = CNIC.matcher(cnic);
        return matcher.matches();
    }
    public static boolean matchEmail(String email){
        Matcher matcher = EMAIL.matcher(email);
        return matcher.matches();
    }
    public static boolean matchCGPA(String cgpa){
            Matcher matcher = CGPA.matcher(cgpa);
        return matcher.matches();
    }
    public static ArrayList<Boolean> matchAllFields(String[] fields){
        ArrayList<Boolean> validations = new ArrayList<>();
        validations.add(matchID(fields[0]));
        validations.add(matchFirstName(fields[1]));
        validations.add(matchLastName(fields[2]));
        validations.add(matchCNIC(fields[3]));
        validations.add(matchAge(fields[4]));
        validations.add(matchCGPA(fields[5]));
        validations.add(matchEmail(fields[6]));
        return validations;
    }
}
