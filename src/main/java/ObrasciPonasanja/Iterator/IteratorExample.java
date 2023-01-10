package ObrasciPonasanja.Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {

    public static void main(String[] args) {
        whilePetlja();
        System.out.println();
        forPetlja();
    }

    public static void whilePetlja(){

        List<Integer> intList = new ArrayList<Integer>();
        Integer[] as = {1,2,3,4,5,6};
        intList.addAll(Arrays.stream(as).toList());

        Iterator<Integer> i = intList.iterator();

        while(i.hasNext()){
            Integer a = i.next();
            System.out.print(a);
        }

    }

    public static void forPetlja(){
        List<Integer> intList = new ArrayList<Integer>();
        Integer[] as = {1,2,3,4,5,6};
        intList.addAll(Arrays.stream(as).toList());

        for(Integer i: intList){
            System.out.print(i);
        }
    }
}
