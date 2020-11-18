


import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.io.File;
import java.util.Scanner;

public class Main {




    public static void main(String[] args) throws FileNotFoundException {


        /* an integer representing the capacity of the knapsack
the number of things available to pack
a list of the weights of each of these things (integers)
a list of the values of each of these things (integers)*/

        File txt = new File("/Users/ranierymendes/Documents/lab4/src/knapsack.txt");

        Scanner reader = new Scanner(txt);

        int a;
        int b;

        int[ ]w ;

        int [] v;

        while (reader.hasNextLine()){

            a = Integer.parseInt(reader.next());

            b=Integer.parseInt(reader.next());

            w = new int[b];

            v = new int[b];

            for(int i=0; i<b; i++){
                w[i]=Integer.parseInt(reader.next());
            }

            for(int i=0; i<b; i++){
                v[i] = Integer.parseInt(reader.next());
            }

            for (int i = 0; i < b; i++) {
                System.out.println("i: "+ i +" Weight: " + w[i] +" Value: " + v[i] );


            }

            System.out.println("Total capacity: " + a);
            ArrayList<Things> list_of_things = new ArrayList<>();

            for (int i = 0; i < b ; i++) {


                Things obj = new Things();

                obj.setWeight(w[i]);
                obj.setValue(v[i]);

                list_of_things.add(obj);

                System.out.println(i +": Weight:  " + w[i] + " Value: " + v[i]);

            }

            knapsack knapsack = new knapsack(a, list_of_things);

            knapsack knapsack1 = new knapsack(a, list_of_things);




            ArrayList<Integer> taken  =new ArrayList<Integer>();
            System.out.println(list_of_things.size());

            knapsack.greedyFill();
            knapsack1.optimalFill();




        }









    }

}
