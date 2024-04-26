public class Student {
    int rollNo;
    private String name = "NAME";
    static String Uni = "UL";
    static int noOfStudents = 0;

    public Student(int rollNumber){
        rollNo = rollNumber;//rollNo: An integer representing the roll number of the student
        noOfStudents++;//every time a new Student object is created, this line ensures that the noOfStudents variable is incremented
        System.out.println("Name= " + name);
    }

    public int countStudents(){
        return noOfStudents;
    }
}
