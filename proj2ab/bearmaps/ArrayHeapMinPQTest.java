package bearmaps;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class ArrayHeapMinPQTest {
    @Test
    public void checkAdd(){
        ArrayHeapMinPQ c = new ArrayHeapMinPQ();
        c.add(4, 4);
        c.add(3,3);
        c.add(6,6);
        c.add(2,2);
        c.add(5,5);
        c.add(1,1);
        c.add(7,7);
        c.add(8,8);
        c.add(10,10);
        c.add(11,11);
        c.add(24,24);
        c.add(15,15);


        for (int i = 0; i <c.size(); i++){
            System.out.println(c.printPriority(i));
        }


    }
    @Test
    public void checkremovesmallest(){
        ArrayHeapMinPQ c = new ArrayHeapMinPQ();
        c.add(4, 4);
//        System.out.println(c.size());
//        System.out.println("1:     " + c.getSmallest());
        c.add(3,3);
//        System.out.println(c.size());
//        System.out.println("2:     " + c.getSmallest());
        c.add(6,6);
//        System.out.println("it should be 1 0 2 after this line");
//        for (int i = 0; i <c.size(); i++){
//            System.out.println(c.printPriority(i));
//        }
//        System.out.println("3:     " + c.getSmallest());
        c.add(2,2);
//        System.out.println("4:     " + c.getSmallest());
        c.add(5,5);
//        System.out.println("5:     " + c.getSmallest());
        c.add(1,1);
//        System.out.println("6:     " + c.getSmallest());
        c.add(7,7);
        for (int i = 0; i <c.size(); i++){
            System.out.println(c.printPriority(i));
        }
        c.removeSmallest();
        for (int i = 0; i <c.size(); i++){
            System.out.println(c.printPriority(i));
        }
    }
}
