import java.lang.Math;
import java.util.Scanner;
/*
 * This code is based on the code from Dr. Faeq's slides
 */
public class Dice{
    private int faceUp;

    public Dice(){
    //this is the constructor of the Dice class
    //It initialises the faceUp to 0 when a new Dice object is created
    //The constructor is called when an object of a class is created
        faceUp = 0;    
    }

    public void rollDice(){
        //generates a random num from 1 to 6
        faceUp = (int)((Math.random() * 6) + 1);
    }

    public int reportDice(){
        //reports the current value of faceUp
        return faceUp;
    }

    public static void main(String[] args){
        int firstRoll = 0;//first dice
        int secondRoll = 0;//second dice
        Dice Dice1 = new Dice();//create an object of class Dice
        Scanner sc = new Scanner(System.in);

        char playing;

        do {
            Dice1.rollDice();//get a random number 
            firstRoll = Dice1.reportDice();//assign the random number to first dice
            Dice1.rollDice();
            secondRoll = Dice1.reportDice();

            System.out.println("First die: " + firstRoll);
            System.out.println("Second die: " + secondRoll);

            if(firstRoll == secondRoll){
                System.out.println("You are a winner");
            } else{
                System.out.println("Better luck next time");
            }

            System.out.println("Do you want to play again(Y/N)?");
            playing = sc.next().charAt(0);

        } while((playing == 'Y') || (playing == 'y'));
        System.out.println("Thank you for playing");
        sc.close();
    }
}