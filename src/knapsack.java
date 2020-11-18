
import java.util.ArrayList;


import java.util.Arrays;

public class knapsack {

    ArrayList<Things> bag;

    int sac_capacity = 0;

    int current_capacity = 0;

    int value;

    int length_list;
    Things[] forOptimal;

    Things[] listOfThings;


    knapsack(int total_capacity, ArrayList<Things> list) {
        bag = new ArrayList<>();
        length_list = list.size();
        sac_capacity = total_capacity;
        value = 0;
        forOptimal = list.toArray(new Things[list.size()]);
        listOfThings = list.toArray(new Things[list.size()]);


    }


    public void greedyFill() {

        System.out.println("Performing the greedyFill Method");

        Arrays.sort(listOfThings);

        for (int i = 0; i < listOfThings.length; i++) {
            System.out.println("i:" + i + " value: " + listOfThings[i].getValue() + " weight: " + listOfThings[i].getWeight());
        }

        int i = 0;
        for (int j = 0; j < listOfThings.length; j++) {


            if ((current_capacity + listOfThings[i].getWeight()) < sac_capacity) {

                bag.add(listOfThings[i]);

                current_capacity = current_capacity + listOfThings[i].getWeight();
            }

            i++;
        }


        System.out.println(" ");

        System.out.println("That is my bag. Its total weight is:  " + current_capacity);
        for (int t = 0; t < bag.size(); t++) {
            System.out.println("t:" + t + " value: " + bag.get(t).getValue() + " weight:" + bag.get(t).getWeight());
        }


    }

    public void optimalFill() {

        System.out.println("Performing optimal Fill: ");

        int[] array_of_weights = new int[length_list];

        for (int i = 0; i < length_list; i++) {
            array_of_weights[i] = listOfThings[i].getWeight();
        }

        int[] array_of_values = new int[length_list];


        for (int i = 0; i < length_list; i++) {
            array_of_values[i] = listOfThings[i].getValue();
        }


       // System.out.println(knapsack(array_of_weights, array_of_values, sac_capacity, 0));

        for (int i = 0; i < bag.size(); i++) {

            System.out.println("Bag poderosa: " + bag.size() + " items");

            System.out.println("i: " + i + " Value: " + bag.get(i).getValue() + "  Weight: " + bag.get(i).getWeight());

        }
        System.out.println();

        ArrayList<Things> taken = new ArrayList<Things>();
        System.out.println( "Total value in my knapsack: " +KnapSack(sac_capacity, forOptimal, forOptimal.length, taken));

        System.out.println("There are "+ taken.size() +  " items inside the knapsack: ");

        for (int i = 0; i< taken.size(); i++){
            System.out.println("This is my weight: " +taken.get(i).getWeight() + " This is my value:  " +taken.get(i).getValue());
        }


    }

    //change code

    public int knapsack(int[] weight, int[] val, int w, int itemNum) {
        if (w == 0 || itemNum == weight.length) {

            if (w == 0) {
                System.out.println(weight[itemNum] + "  val: " + val[itemNum]);
            }


            return 0;
        }

        if (weight[itemNum] > w) {


            return knapsack(weight, val, w, itemNum + 1);
        } else {

            int rMax = val[itemNum] + knapsack(weight, val, w - weight[itemNum], itemNum + 1);
            int lMax = knapsack(weight, val, w, itemNum + 1);

            if (rMax == Math.max(rMax, lMax)) {

                System.out.println("ADICIONAR: RIGHT " + weight[itemNum]);
            }

            if (lMax == Math.max(rMax, lMax)) {
                System.out.println("ADICIONAR: LEFT " + lMax);
            }
            //System.out.println( "O maior:  "+ Math.max(rMax, lMax));


            return Math.max(rMax, lMax);
        }
    }


    public int KnapSack(int capacity, Things[] items, int numItems, ArrayList<Things> taken) {
        System.out.println("Current Capacity" + capacity);


        if (numItems == 0 || capacity == 0)
            return 0;
        if (items[numItems - 1].getWeight() > capacity)
            return KnapSack(capacity, items, numItems - 1, taken);
        else {
            final int preTookSize = taken.size();
            final int took = items[numItems - 1].getValue() + KnapSack(capacity - items[numItems - 1].getWeight(), items, numItems - 1, taken);

            final int preLeftSize = taken.size();
            final int left = KnapSack(capacity, items, numItems - 1, taken);

            if (took > left) {
                if (taken.size() > preLeftSize)
                    taken.subList(preLeftSize, taken.size()).clear();
                    //taken.removeRange(preLeftSize, taken.size());

                //taken.add(Integer.valueOf(numItems - 1));
                taken.add(items[numItems-1]);

                taken.indexOf(items);
                return took;
            } else {
                if (preLeftSize > preTookSize)
                    taken.subList(preTookSize, preLeftSize).clear();
                   // taken.removeRange(preTookSize, preLeftSize);

                return left;
            }

        }

    }
}
