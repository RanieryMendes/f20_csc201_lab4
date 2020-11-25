/*
Raniery Mendes
CSC201 Fall 2020
Programming Assignment 4
November 24, 2020
 */

import java.lang.Override;

//Class of Things objects that will contain the weight and value of each possible thing that can go into the knapsack
public class Things implements Comparable <Things> {
    private int weight;
    private int value;

    //default constructor
    Things(){
        weight = 0;
        value = 0;
    }

    //setter methods for value and weight

    public void setValue(int value) {
        this.value = value;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    //getter methods for value and weight
    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }



    @Override
//compare to method that sorts in descending order
    public int compareTo(Things el){

        if(this.getValue() > el.getValue())
            return -1;

        else if(this.getValue() < el.getValue())
            return 1;

        else
            return 0;


    }

}
