import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter age in years");
        int age = sc.nextInt();

        sc.nextLine();
        System.out.println("Enter name please");
        String name = sc.nextLine();//if use only nextLine(), user will not have chance to input
        //nextLine() program does not pause to allow the user enter the name of the patient but proceeds directly to the output statement

        System.out.println("Enter mobile phone");
        long mobileNo = sc.nextLong();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Mobile: " + mobileNo);
    }
}
