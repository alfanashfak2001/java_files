package Searching;

import java.util.ArrayList;

public class checkingclass {

     public static void DFS() {

        ArrayList<ArrayList<Integer>> ABCD = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> zero = new ArrayList<Integer>();
        zero.add(0); zero.add(1);zero.add(2); zero.add(3);
        ArrayList<Integer> one = new ArrayList<Integer>();
        one.add(0); one.add(1);one.add(5); one.add(3);
        ArrayList<Integer> two = new ArrayList<Integer>();
        two.add(0); two.add(1);two.add(2); two.add(3);
        ArrayList<Integer> three = new ArrayList<Integer>();
        three.add(0); three.add(1);three.add(2); three.add(3);

        ABCD.add(zero);ABCD.add(one);ABCD.add(two);ABCD.add(three);
        ArrayList<Integer> needed = new ArrayList<Integer>();
        needed.add(5);

       /* for (int i=0;i<4;i++){
            for (int j=0;j<ABCD.get(i).size();j++){
                if (ABCD.get(i).get(j)==2){
                    needed.add(i); needed.add(j);
                    }
                }

          }

        ArrayList<Integer> Place0 =new ArrayList<Integer>(); //create normal arraylist
        Place0.add(1); Place0.add(3);Place0.add(4); //add values to normal arraylist
        ArrayList<Integer> Place1 =new ArrayList<Integer>();
        Place1.add(0); Place1.add(2);Place1.add(3);Place1.add(4); Place1.add(5);
        ArrayList<Integer> Place2 =new ArrayList<Integer>();
        Place2.add(1); Place2.add(4);Place2.add(5);
        ArrayList<Integer> Place3 =new ArrayList<Integer>();
        Place3.add(0); Place3.add(1);Place3.add(4);Place3.add(6); Place3.add(7);
        ArrayList<Integer> Place4 =new ArrayList<Integer>();
        Place4.add(0); Place4.add(1);Place4.add(2);Place4.add(3); Place4.add(5);Place4.add(6);Place4.add(7); Place4.add(8);
        ArrayList<Integer> Place5 =new ArrayList<Integer>();
        Place5.add(1); Place5.add(2);Place5.add(4);Place5.add(7); Place5.add(8);
        ArrayList<Integer> Place6 =new ArrayList<Integer>();
        Place6.add(3); Place6.add(4);Place6.add(7);
        ArrayList<Integer> Place7 =new ArrayList<Integer>();
        Place7.add(3); Place7.add(4);Place7.add(5);Place7.add(6); Place7.add(8);
        ArrayList<Integer> Place8 =new ArrayList<Integer>();
        Place8.add(4); Place8.add(5);Place8.add(7);
        */











     }


    public static void main(String[] args) {
        DFS();
    }

}
