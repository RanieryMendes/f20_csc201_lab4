/*
Raniery Mendes
CSC201 Fall 2020
Programming Assignment 4
November 24, 2020
 */

// This program performs the implementation of the knapsack algorithm with the greedyFill and optimaFill methods.

// This program reads input from the knapsack.txt file

import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {


        //file object that gets the txt file that contains the relevant data used by this program
        File txt = new File("/Users/ranierymendes/Documents/lab4/src/knapsack.txt");

        //scanner object to read the file mentioned above
        Scanner reader = new Scanner(txt);

        //variables that will store important information for resolution of the knapsack problem

        int capacity_knapsack;
        int total_things_available;

        //arrays that will store respectively the list of weights and values sent by the txt file
        int[]w ;

        int [] v;


        //read text file and assigns the  data to proper variables (as clarified above)
        while (reader.hasNextLine()){

            capacity_knapsack = Integer.parseInt(reader.next());

            total_things_available=Integer.parseInt(reader.next());

            w = new int[total_things_available];

            v = new int[total_things_available];

            //populate the arrays of values and weights, ensuring that each thing will have the proper value and weight as set by the txt file

            for(int i=0; i<total_things_available; i++){
                w[i]=Integer.parseInt(reader.next());
            }

            for(int i=0; i<total_things_available; i++){
                v[i] = Integer.parseInt(reader.next());
            }

            //if the number of total things available to be stored in the knapsack is <= 15,
            // print out all the things objects' values and weights

            if(total_things_available <=15) {

                System.out.println("There are " + total_things_available + " items available to be added to the knapsack. They are:");

                for (int i = 0; i < total_things_available; i++) {

                    System.out.println("T:" + i + " Weight: " + w[i] + " Value: " + v[i]);


                }
                System.out.println("\n");
            }

            //Arraylist that will store the Things objects
            ArrayList<Things> list_of_things = new ArrayList<>();


            //for loop that creates a Things object, assigns its correct value and weight, and finally performs the insertion of that
            // newly created object into the Arraylist
            for (int i = 0; i < total_things_available ; i++) {

                Things obj = new Things();

                obj.setWeight(w[i]);
                obj.setValue(v[i]);

                list_of_things.add(obj);


            }


            //create instance of knapsack class to call filler methods
            knapsack knapsack = new knapsack(capacity_knapsack, list_of_things);


            //call greedyFill method
            knapsack.greedyFill();

            System.out.println("\n");

            //call optimalFill method
            knapsack.optimalFill();



        }









    }

}
