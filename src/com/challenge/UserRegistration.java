package com.challenge;
import com.challenge.model.Enums.DifficultyLevel;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

import static com.challenge.model.Enums.DifficultyLevel.*;

public class UserRegistration {
    public static DifficultyLevel difficultyLevel = EASY;

    public void register() throws FileNotFoundException, InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter User Name: ");
        String Uname = sc.nextLine();
        System.out.println(Uname);

        System.out.println("Enter Password: ");
        String Pass = sc.nextLine();
        System.out.println(Pass);

        System.out.println("Confirm Password: ");
        String ConPass = sc.nextLine();
        System.out.println(ConPass);
        Uname = Uname.trim();
        Pass = Pass.trim();
        ConPass = ConPass.trim();


        String x = Uname + " " + Pass;
        if (Pass.equals(ConPass)) {

            File f = new File("Registration.txt");
            Scanner content = new Scanner(f);


            int flag = 0;
            while (content.hasNextLine()) {
                String data = content.nextLine();
                if (data.equals(x)) {
                    System.out.println("Already Registered");
                    flag = 1;
                    System.out.println("1. Registration. ");
                    System.out.println("2. Login. ");

                    System.out.println("Enter your Choice");
                    int choice = sc.nextInt();
                    if (choice == 1) {
                        this.register();
                    } else if (choice == 2) {
                        this.login();
                    } else {
                        System.out.println("Choose Proper Option");
                    }
                    break;
                }
            }
            content.close();

            if (flag == 0) {
                try {
                    BufferedWriter out = new BufferedWriter(new FileWriter("Registration.txt", true));
                    out.write(Uname + " " + Pass + "\n");
                    out.close();
                } catch (IOException e) {
                    System.out.println("Error" + e);
                }

                System.out.println("Successfully Registered");
                System.out.println();
                Thread.sleep(2000);
                System.out.println("Please login");
                System.out.println();
                Thread.sleep(2000);
                this.login();
            }


        } else {
            System.out.println("Recheck");
            System.out.println("1. Registration. ");
            System.out.println("2. Login. ");

            System.out.println("Enter your Choice");
            int choice = sc.nextInt();
            if (choice == 1) {
                this.register();
            } else if (choice == 2) {
                this.login();
            } else {
                System.out.println("Choose Proper Option");
            }
        }
        sc.close();
    }

    public void login() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter User Name: ");
        String Uname = sc.nextLine();
        System.out.println(Uname);

        System.out.println("Enter Password: ");
        String Pass = sc.nextLine();
        System.out.println(Pass);
        Uname = Uname.trim();
        Pass = Pass.trim();
        String x = Uname + " " + Pass;


        try {

            File f = new File("Registration.txt");
            Scanner content = new Scanner(f);
            int flag = 0;
            while (content.hasNextLine()) {
                String data = content.nextLine();
                if (data.equals(x)) {
                    System.out.println( "Login Successful!");
                    System.out.println("******************* Welcome " + Uname + "! ******************* ");
                    System.out.println();
                    Thread.sleep(2000);
                    int selection;
                    Scanner input =new Scanner(System.in);
                    System.out.println("Select Game Mode:\n 1. EASY\n 2. MEDIUM\n 3. HARD");
                    selection = input.nextInt();
                    if(selection == 1){
                        difficultyLevel = EASY;
                    }else if(selection ==2){
                        difficultyLevel = MEDIUM;
                    }
                    else if(selection == 3){
                        difficultyLevel = HARD;
                    }
                    else
                        System.out.println("Enter a correct option.");
                    System.out.println("                       *** You have chosen mode: " + selection + " ***");
                    input.close();
                    System.out.println("====== **************** Welcome to the War Game Application.**************** ======");
                    System.out.println();
                    System.out.println();
                    flag = 1;
                    break;
                }
                Thread.sleep(3000);
            }
            if (flag == 0) {
                System.out.println("Login Failed");
                System.out.println("1. Registration. ");
                System.out.println("2. Login. ");

                System.out.println("Enter your Choice");
                int choice = sc.nextInt();
                if (choice == 1) {
                    this.register();
                } else if (choice == 2) {
                    this.login();
                } else {
                    System.out.println("Choose Proper Option");
                }
            }

            content.close();
        } catch (FileNotFoundException e) {


            System.out.println("Error.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        sc.close();
    }

}