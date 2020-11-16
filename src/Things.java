import java.lang.Override;

public class Things implements Comparable <Things> {
    private int weight;
    private int value;

    Things(){
        weight = 0;
        value = 0;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }


    @Override
//compare to descending order
    public int compareTo(Things el){

        if(this.getValue() > el.getValue())
            return -1;

        else if(this.getValue() < el.getValue())
            return 1;

        else
            return 0;


    }

}
