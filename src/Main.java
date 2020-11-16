


import java.util.ArrayList;

public class Main {




    public static void main(String[] args) {


        /* an integer representing the capacity of the knapsack
the number of things available to pack
a list of the weights of each of these things (integers)
a list of the values of each of these things (integers)*/

        int capacity = 200;

        int number_things= 50;

        int [] weight_things= new int[number_things];

        int [] value_things = new int[number_things];

        ArrayList<Things> list_of_things = new ArrayList<>();

        for (int i = 0; i < number_things ; i++) {

            weight_things[i] = (int)(Math.random() * number_things-1);
            value_things[i] = (int)(Math.random() * number_things-1);

            Things obj = new Things();

            obj.setWeight(weight_things[i]);
            obj.setValue(value_things[i]);

            list_of_things.add(obj);

            System.out.println(i +": Weight:  " + weight_things[i] + " Value: " + value_things[i]);

        }

        knapsack knapsack = new knapsack(capacity, list_of_things);




        System.out.println(list_of_things.size());

        knapsack.greedyFill();

        knapsack.optimalFill();






    }

}
