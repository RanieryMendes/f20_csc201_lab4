/*
Raniery Mendes
CSC201 Fall 2020
Programming Assignment 4
November 24, 2020
 */

//Class that implements the knapsack and performs the greedy and optimal filling methods

import java.util.ArrayList;
import java.util.Arrays;

public class knapsack {

    //arraylist that will perform the role of the knapsack, so it store the things objects added to the sac
    ArrayList<Things> bag;

    int sac_capacity = 0;

    int current_capacity = 0;

    int value;

    int length_list;

    Things[] listOfThings_optimal;

    Things[] listOfThings_greedy;


    //constructor that receives as parameters the total capacity the knapsack will have and the list of Things objects
    knapsack(int total_capacity, ArrayList<Things> list) {

        bag = new ArrayList<>();
        length_list = list.size();
        sac_capacity = total_capacity;
        value = 0;

        //set two different variable to the list of Things objects because greedyFill method will alter the list's order.
        listOfThings_optimal = list.toArray(new Things[list.size()]);
        listOfThings_greedy = list.toArray(new Things[list.size()]);


    }


    //method that performs a greedy filling of the knpasack
    public void greedyFill() {

        System.out.println("Performing the greedyFill Method:");

        //Sort the list of things objects by value using the overriden comparable.
        Arrays.sort(listOfThings_greedy); //the list is sorted in descending order so at index 0 is the things will highest value


        //variable that will keep track of the total value stored in the sac
        int total_value =0;


        //loop that iterates through the whole list of things objects
        //within the loop is evaluated which items can fit in the knapsack
        for (int j = 0; j < listOfThings_greedy.length; j++) {


            //this statement checks if it is
            if ((current_capacity + listOfThings_greedy[j].getWeight()) < sac_capacity) {

                bag.add(listOfThings_greedy[j]);

                total_value = total_value + listOfThings_greedy[j].getValue();


                current_capacity = current_capacity + listOfThings_greedy[j].getWeight();
            }


        }

        //print statements about the results obtained using this filling method

        System.out.println("Total value in my knapsack: " + total_value + ". The total weight in the knapsack is: " + current_capacity);
        System.out.println("There are " + bag.size() + " item in my knapsack");
        if(bag.size() <= 15) {


            System.out.println("These are the items stored in the knapsack: ");
            for (int t = 0; t < bag.size(); t++) {
                System.out.println("Weight:" + bag.get(t).getWeight() + " Value:" + bag.get(t).getValue());
            }
        }


    }

    //method that performs a optimal filling of the knapsack
    public void optimalFill() {

        System.out.println("Performing optimalFill Method: ");

        //ArrrayList that will store all the Things that will be inserted into the Knapsack
        ArrayList<Things> taken = new ArrayList<Things>();

        //Perform filling with optimization using recursion
        //Inform knapsack's value and size
        System.out.print( "Total value in my knapsack: " + optimization(sac_capacity, listOfThings_optimal, listOfThings_optimal.length, taken) );

        //Assign the array of taken Thing objects to the knapsack private variable
        bag = taken;

        //gets total weight stored in the sac
        int total_weight=0;

        for (int i =0; i<bag.size(); i++){

            total_weight = total_weight + bag.get(i).getWeight();

        }
        System.out.println(". The total weight in the knapsack is: " +total_weight);


        System.out.println("There are "+ taken.size() +  " items in the knapsack.");


        //If knapsack stored 15 or less Things objects, print out their values and weights
        if(bag.size()<=15) {

            System.out.println("These are the items stored in the knapsack: ");
            for (int i = 0; i < bag.size(); i++) {
                System.out.println("Weight:" + bag.get(i).getWeight() + " Value:" + bag.get(i).getValue());
            }
        }


    }



    //recursive method that performs the brutal work of optimal filling the knapsack
    //it carries out backtracking

    public int optimization(int capacity, Things[] items, int numItems, ArrayList<Things> taken) {


        //check base case: if either it has already visited all possible things objects or if it has reached maximum weight capacity
        if (numItems == 0 || capacity == 0)
            return 0;

        //if adding the next object of the list of Things object will exceed the knapsack maximum weight capacity,
        // it makes a recursive call moving to the next Thing object of the list (since it cannot take this object in)
        if (items[numItems - 1].getWeight() > capacity)
            return optimization(capacity, items, numItems - 1, taken);



        //else statement = take the element in
        else {

             //keep track of the current size of the knapsack before going into another recursive call
             int preSize = taken.size();

             //perform recursive call adding element to the "right subtree". This variable will store the value of the right node solution
             int right = items[numItems - 1].getValue() + optimization(capacity - items[numItems - 1].getWeight(), items, numItems - 1, taken);

             //get the new current size of the bag after performing the recursive call above
             int pre_left_length = taken.size();

            //perform recursive call adding element to the "left subtree". This variable will store the value of the left node solution
             int left = optimization(capacity, items, numItems - 1, taken);


             //check which of the sides has the greatest value, that is,
            // check whether its is the right or left node that has the best "solution" ( best filling of the knapsack)


            if (right > left) { //right node offers best solution (highest value)

                //readjust (clean) the knapsack and add the item to the bag
                if (taken.size() > pre_left_length )
                     taken.subList(pre_left_length , taken.size()).clear();

                    //add thing object to the knapsack
                     taken.add(items[numItems-1]);


                taken.indexOf(items);
                return right;
            }



            else {//left node offers best solution (highest value)

                //readjust (clean) the knapsack
                if (pre_left_length  > preSize)
                    taken.subList(preSize, pre_left_length ).clear();


                return left;
            }

        }

    }
}
