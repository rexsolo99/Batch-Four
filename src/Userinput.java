import java.util.Scanner;
 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Userinput;

/**
 *
 * @author JAKES
 */
public class Userinput {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner input = new Scanner (System.in);
       System.out.println("Enter some number ");
       int user_input_number = input.nextInt();
      
       
       System.out.println("The entered value is ");
       System.out.print(user_input_number);
       
       //Example entering decimal value
       Scanner  Scan1 = new Scanner (System.in);
       System.out.println("Enter some decimal number ");
       double user_input_double = Scan1.nextDouble();
       
       System.out.println("The entered value is");
       System.out.print(user_input_double);
       
       //Example entering string value
       Scanner Scan2 = new Scanner (System.in);
       System.out.println("Enter your name");
       String user_input_string = Scan2.nextLine();
       
       System.out.println("your name is");
       System.out.print(user_input_string);
    }
    
}

