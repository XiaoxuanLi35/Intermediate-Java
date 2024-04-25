package Assignment1;
import javax.swing.JOptionPane;
/*
 * ID:23005491
 * NAME：Xiaoxuan Li
 */


 class Username {
    private String userName;

    public Username(String userName) {//constructor
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String toString() {//convert the location into the string itself or it will be like @user1234
        return userName;
    }

    public boolean isValid() {//check if the names correct
        String pattern = "^[a-zA-Z0-9_]{2,15}$";
        if (!userName.matches(pattern)) {
            JOptionPane.showMessageDialog(null, "Please enter a username at length between 2 and 15, \nit could be numbers, characters and underscore.");
            return false;
        }
        return true;
    }
}

class PlayAgain {
    public static boolean Repeat() {
        while (true) {
            String endChoice = JOptionPane.showInputDialog("Do you want to play again? (Y/N)");
            if (endChoice.equalsIgnoreCase("y")) {
                return true; //tell the program to stop asking
            } else if (endChoice.equalsIgnoreCase("n")) {// end the game
                JOptionPane.showMessageDialog(null, "Goodbye!");
                return false;
            } else {// invalid input, repeat until correct input
                JOptionPane.showMessageDialog(null, "Please enter Y/y to play again or N/n to end the game.");
            }
        }
    }
}

class Scenario1 {//all of choices will go to Scenario2
    private Username name;

    public Scenario1(Username name) {
        this.name = name;
    }

    public void Dialog1() {
        String userChoice;
        do {
            /** the first dialog should be an input dialog. This goes for all other scenarios */
            JOptionPane.showMessageDialog(null, name + " finds themselves lost in a dense forest with no clear path forward.\nchoices:\n1-Stay there and signal for help\n2-Try to navigate with the direction of the sun\n3-Climb up to some high places to find the way");
            userChoice = JOptionPane.showInputDialog("Please enter your choice (1-3):");
            if (userChoice.equals("1") || userChoice.equals("2") || userChoice.equals("3")) {
                JOptionPane.showMessageDialog(null, name + " continues their journey");
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 3");
            }
        } while (!userChoice.equals("1") && !userChoice.equals("2") && !userChoice.equals("3"));
    }
}

class Scenario2 {
    private Username name;

    public Scenario2(Username name) {//initialises the name field with the provided Username object
        this.name = name;
    }

    public String Dialog2() {
        String userChoice;
        do {
            JOptionPane.showMessageDialog(null, "While wandering through the forest, " + name + " encounters a mysterious stranger who offers them assistance. " + name + " must decide whether to trust the stranger.\n1 - Accept the stranger's help\n2 - Politely decline and continue on your own\n3 - Confront the stranger and demand answers");
            userChoice = JOptionPane.showInputDialog("Please enter your choice (1-3):");
            if (userChoice.equals("1")) {
                int randomNumber = (int) (Math.random() * 10 + 1);
                if (randomNumber <= 7) {
                    JOptionPane.showMessageDialog(null, name + " is saved! [Happy End]");
                } else {
                    JOptionPane.showMessageDialog(null, name + " is killed! [Sad End]");
                }
                break;
            } else if (userChoice.equals("2")) {
                JOptionPane.showMessageDialog(null, name + " continues their journey");
                break;
            } else if (userChoice.equals("3")) {
                JOptionPane.showMessageDialog(null, "The stranger offers " + name + " to play a game");
                return userChoice; // Return the choice for Scenario 4
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 3");
            }
        } while (true);

        return userChoice;
    }
}

class Scenario3 {
    private Username name;

    public Scenario3(Username name) {
        this.name = name;
    }

    public void Dialog3() {
        String userChoice;
        do {
            JOptionPane.showMessageDialog(null, name + " comes across a wide river blocking their path." + name + " must figure out how to cross it safely\n1- Attempt to swim across the river\n2- Look for a shallow area to wade through\n3- Build a makeshift raft to cross the river");
            userChoice = JOptionPane.showInputDialog("Please enter your choice (1-3):");
            if (userChoice.equals("1")) {
                JOptionPane.showMessageDialog(null, name + " drowns! [Sad End]");
            } else if (userChoice.equals("2") || userChoice.equals("3")) {
                JOptionPane.showMessageDialog(null, name + " is saved! [Happy End]");
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 3");
            }
        } while (!userChoice.equals("1") && !userChoice.equals("2") && !userChoice.equals("3"));
    }
}

class Scenario4 {
    private Username name;

    public Scenario4(Username name) {
        this.name = name;
    }

    public boolean Dialog4() {
        int correctAnswer = (int) (Math.random() * 10 + 1);
        int attemptNum = 3;
        JOptionPane.showMessageDialog(null, "The game is to guess the number hidden in this mysterious box. It should be between 1 and 10 (inclusive). You have THREE tries.");

        for (int i = 0; i < 3; i++) {
            String userChoice = JOptionPane.showInputDialog("Please enter your choice (1-10):");
            /** should check that the user entered a non-integer, e.g., a letter */
            int guess = Integer.parseInt(userChoice);

            if (guess == correctAnswer) {
                JOptionPane.showMessageDialog(null, name + " is saved!");
                return true; // Correct guess, return true
            } else if (guess > correctAnswer) {
                JOptionPane.showMessageDialog(null, "INCORRECT. You should aim [LOWER] in your next try, " + name);
            } else if (guess < correctAnswer) {
                JOptionPane.showMessageDialog(null, "INCORRECT. You should aim [HIGHER] in your next try, " + name);
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 10");
            }
            attemptNum--;
            if (attemptNum == 1) {
                JOptionPane.showMessageDialog(null, "...You have ONE FINAL try left.");
            }
        }

        JOptionPane.showMessageDialog(null, name + " is killed!");
        return false; // Player did not guess correctly, return false
    }
}


public class ID23005491_Assignment1 {
    public static void main(String[] args) {
        
        while(true){
            Username name;
            do {
                String userinput = JOptionPane.showInputDialog("Welcome to the adventure game, please choose a name for your player");
                name = new Username(userinput);
            } while (!name.isValid());

            Scenario1 scenario1 = new Scenario1(name);
            Scenario2 scenario2 = new Scenario2(name);
            Scenario3 scenario3 = new Scenario3(name);
            Scenario4 scenario4 = new Scenario4(name);

            scenario1.Dialog1();

            String choice;

            choice = scenario2.Dialog2();
            if (choice.equals("3")) {//go to Scenario4 directly
                scenario4.Dialog4(); 
            } else if (choice.equals("2")) {
                scenario3.Dialog3();
            }

            boolean playAgain = PlayAgain.Repeat();
            if(!playAgain){
                break;
            }
        }                  
    }
}