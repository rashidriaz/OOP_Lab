package project.semester.java;

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        String fileName = "info.txt";
        readDataFromFile(fileName);
        ArrayList<Student> studentList = readDataFromFile();
        ArrayList<Student> sortedByAge = Student.sortByAge(new ArrayList<>(studentList));
        ArrayList<Student> sortedByCGPA = Student.sortByCGPA(new ArrayList<>(studentList));
        ArrayList<Student> sortedBySID = Student.sortBySID(new ArrayList<>(studentList));
        ArrayList<Student> sortedByFirstName = Student.sortByFirstName(new ArrayList<>(studentList));
        printList(studentList, "Unsorted List");
        printList(sortedBySID, "sorted List By SID");
        printList(sortedByAge, "sorted List By Age");
        printList(sortedByCGPA, "sorted List By CGPA");
        printList(sortedByFirstName, "sorted List By First Name");
        Iterator<Student> studentListIterator = studentList.iterator();
        double averageAge = 0, averageCGPA = 0;
        int count = 0;

        while(studentListIterator.hasNext()){
            Student student = studentListIterator.next();
            averageCGPA += student.getCgpa();
            averageAge += student.getAge();
            count++;
        }
        averageAge /= count;
        averageCGPA /= count;
        System.out.printf("Average Age = %.2f\tAverage CGPA = %.2f", averageAge, averageCGPA);
        printContentOfErrorFile();

    }

    private static void readDataFromFile(String path) {
        try (Scanner readDataFile = new Scanner(new BufferedReader(new FileReader(path)))) {
            ObjectOutputStream validRecords = new ObjectOutputStream(new FileOutputStream("StudentData.ser"));
            PrintWriter inValidRecords = new PrintWriter(new BufferedWriter(new FileWriter("ErrorMsgs.txt")));
            while (readDataFile.hasNext()) {
                // Reading and Tokenizing Records
                String record = readDataFile.nextLine();
                String[] fields = record.split(",");
                // ArrayList : Validations contains boolean values returned from matcher method for each class in order

                ArrayList<Boolean> validations = ValidPatterns.matchAllFields(fields);
                    boolean studentRecordIsValid = isStudentRecordValid(validations);
                    if (studentRecordIsValid) {
                        Student student = createInstanceOfStudent(fields);
                        validRecords.writeObject(student);
                    } else {
                        StringBuilder errorString = new StringBuilder();
                        ArrayList<String> labels = getLabels();//Error Labels
                        ArrayList<Integer> indexes = getIndexes(); // Indexes of field array.
                        Iterator<Boolean> booleanIterator = validations.iterator();//List of validations(Boolean Values) of all the fields for every record
                        Iterator<String> labelIterator = labels.iterator();
                        Iterator<Integer> indexIterator = indexes.iterator();
                        while (booleanIterator.hasNext() && labelIterator.hasNext() && indexIterator.hasNext()) {
                            if (!booleanIterator.next()) {
                                errorString.append(labelIterator.next()).append(fields[indexIterator.next()]).append("\n");
                            } else {
                                labelIterator.next();
                                indexIterator.next();
                            }

                        }
                        errorString.append("lINE: ").append(record).append(" contains wrong data");
                        inValidRecords.println(errorString);

                    }

            }
            validRecords.close();
            inValidRecords.close();
        } catch (IOException e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private static ArrayList<Student> readDataFromFile(){
        ArrayList<Student> studentList = new ArrayList<>();
        try(ObjectInputStream studentFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("StudentData.ser")))){
            boolean eof = false;
            while(!eof){
                try{
                    Student student = (Student) studentFile.readObject();
                    studentList.add(student);
                }catch(EOFException e){
                    eof = true;
                }
            }
        }catch(IOException e){
            System.out.println("IO Exception " + e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("Class not Found Exception " + e.getMessage());
        }
        return studentList;
    }

    private static boolean isStudentRecordValid(ArrayList<Boolean> validations) {
        return validations.get(0) && validations.get(1) && validations.get(2) && validations.get(3) && validations.get(4) && validations.get(5) && validations.get(6);
    }

    private static Student createInstanceOfStudent(String[] fields) {
        String studentID = fields[0];
        String firstName = fields[1];
        String lastName = fields[2];
        String cnic = fields[3];
        int age = Integer.parseInt(fields[4]);
        double cgpa = Double.parseDouble(fields[5]);
        String emailID = fields[6];
        return new Student(studentID, firstName, lastName, cnic, age, cgpa, emailID);
    }

    private static ArrayList<String> getLabels() {
        ArrayList<String> labels = new ArrayList<>();
        labels.add("Incorrect SID: ");
        labels.add("Invalid First Name: ");
        labels.add("Invalid Last Name: ");
        labels.add("Incorrect CNIC: ");
        labels.add("Incorrect Age: ");
        labels.add("Incorrect CGPA: ");
        labels.add("Incorrect EmailId: ");
        return labels;
    }

    private static ArrayList<Integer> getIndexes() {
        ArrayList<Integer> indexes = new ArrayList<>();
        indexes.add(0);
        indexes.add(1);
        indexes.add(2);
        indexes.add(3);
        indexes.add(4);
        indexes.add(5);
        indexes.add(6);
        return indexes;
    }
    private static void printList(ArrayList<Student> studentList, String string){
        System.out.println("Here is " + string);
        for (Student student: studentList) {
            System.out.println(student.toString());
        }
        System.out.println("\n\n_____________________________________________________________________________________________\n\n");
    }
    private static void printContentOfErrorFile(){
        System.out.println("\n____________________________________________________________________________\n");
        System.out.println("The contents of the ErrorMsgs.txt file are as follows:\n");
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("ErrorMsgs.txt")))){
            while(scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        }catch(IOException e){
            e.getStackTrace();
        }
    }
}
