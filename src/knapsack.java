
import java.util.ArrayList;

import java.util.Arrays;

public class knapsack {

    ArrayList<Things> bag;

    int sac_capacity  = 0;

    int current_capacity = 0;

    int value;

    int length_list;

    Things [] listOfThings;


    knapsack (int total_capacity, ArrayList<Things> list){
       bag  = new ArrayList<>();
       length_list = list.size();
       sac_capacity = total_capacity;
       value = 0;
       listOfThings = list.toArray(new Things[list.size()]);


    }


    public void greedyFill(){

        System.out.println("Performing the greedyFill Method");

        Arrays.sort(listOfThings);

        for (int i=0; i< listOfThings.length; i++){
            System.out.println("i:" + i + " value: " + listOfThings[i].getValue() + " weight: " + listOfThings[i].getWeight());
        }

        int i=0;
        for(int j=0; j<listOfThings.length; j++){


            if((current_capacity + listOfThings[i].getWeight()) < sac_capacity) {

                bag.add(listOfThings[i]);

                current_capacity = current_capacity + listOfThings[i].getWeight();
            }

            i++;
        }


        System.out.println(" ");

        System.out.println("That is my bag. Its total weight is:  " + current_capacity );
        for(int t=0; t<bag.size(); t++){
            System.out.println("t:" + t + " value: " + bag.get(t).getValue() + " weight:" + bag.get(t).getWeight());
        }


    }

    public void optimalFill(){

        System.out.println("Performing optimal Fill: ");

        int [] array_of_weights = new int[length_list];

        for(int i=0; i<length_list; i++){
            array_of_weights[i] = listOfThings[i].getWeight();
        }

        int [] array_of_values = new int[length_list];


        for(int i=0; i<length_list; i++){
           array_of_values[i] = listOfThings[i].getValue();
        }


        System.out.println(recursivePart(array_of_weights, array_of_values, length_list, sac_capacity));



    }


    public int recursivePart(int [] weight, int[] value, int number_of_things, int sac_capacity){

       if(number_of_things <=0){
           return 0;
       }

       if(weight[number_of_things-1] > sac_capacity){
            return  recursivePart(weight, value, number_of_things-1, sac_capacity);
       }

       else{
           return Math.max(recursivePart(weight, value,
                   number_of_things-1, sac_capacity),
                   (value[number_of_things-1]+ recursivePart(weight, value, number_of_things-1, sac_capacity-weight[number_of_things-1])));
       }



    };

}
