import java.util.Scanner;
/*This is the updated version of Dr.Faeq's code
 * I maintained this line : while(sc.next().charAt(0) == 'Y' to)
 * but I added some code to avoid the users input 'y'
 */
public class studentCounter {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        char again;

        do{
            System.out.println("Enter student number: ");
            int no = sc.nextInt();

            Student student = new Student(no);

            System.out.println("Enter another student?(Y/N)");
        
            again = sc.next().charAt(0);
            again = Character.toUpperCase(again);
        
        } while(again == 'Y');
        
        System.out.println("Number of students:" + Student.noOfStudents);
    }
}
