import java.util.Scanner;

public class ContactChecking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //由于 . 在正则表达式中具有特殊含义（匹配任意字符），因此需要使用 \\. 来匹配字面量的点号
        String patternOfEmail = "[0-9]{7,8}@studentmail\\.ul\\.ie";
        String patternOfPhone = "0*0*353[0-9]{9}";

        System.out.println("Enter your email: ");
        String userEmail = sc.nextLine();
        System.out.println("Enter your phone: ");
        String userPhone = sc.nextLine();

        if(userEmail.matches(patternOfEmail)){
            System.out.println("The email format is correct.");
        } else {
            System.out.println("The email format is incorrect.");
        }

        if(userPhone.matches(patternOfPhone)){
            System.out.println("The phone format is correct.");
        } else {
            System.out.println("The phone format is incorrect.");
        }
    }
}
