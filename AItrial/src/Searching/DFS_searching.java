package Searching;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS_searching {
    public static void dfs(int a,int b){
        ArrayList<ArrayList<Integer>> PossibleMoves= new ArrayList<ArrayList<Integer>>(); //create 2d arraylist

        ArrayList<Integer> Place0 =new ArrayList<Integer>(); //create normal arraylist
        Place0.add(1); Place0.add(6);Place0.add(7); //add values to normal arraylist
        ArrayList<Integer> Place1 =new ArrayList<Integer>();
        Place1.add(0); Place1.add(2);Place1.add(6);Place1.add(7); Place1.add(8);
        ArrayList<Integer> Place2 =new ArrayList<Integer>();
        Place2.add(1); Place2.add(3);Place2.add(7);Place2.add(8); Place2.add(9);
        ArrayList<Integer> Place3 =new ArrayList<Integer>();
        Place3.add(2); Place3.add(4);Place3.add(8);Place3.add(9); Place3.add(10);
        ArrayList<Integer> Place4 =new ArrayList<Integer>();
        Place4.add(3); Place4.add(5);Place4.add(9);Place4.add(10); Place4.add(11);
        ArrayList<Integer> Place5 =new ArrayList<Integer>();
        Place5.add(4); Place5.add(10);Place5.add(11);
        ArrayList<Integer> Place6 =new ArrayList<Integer>();
        Place6.add(0); Place6.add(1);Place6.add(7);Place6.add(12);Place6.add(13);
        ArrayList<Integer> Place7 =new ArrayList<Integer>();
        Place7.add(0); Place7.add(1);Place7.add(2);Place7.add(6); Place7.add(8);Place7.add(12);Place7.add(13); Place7.add(14);
        ArrayList<Integer> Place8 =new ArrayList<Integer>();
        Place8.add(1); Place8.add(2);Place8.add(3);Place8.add(7);Place8.add(9); Place8.add(13);Place8.add(14);Place8.add(15);
        ArrayList<Integer> Place9 =new ArrayList<Integer>();
        Place9.add(2); Place9.add(3);Place9.add(4);Place9.add(8);Place9.add(10); Place9.add(14);Place9.add(15);Place9.add(16);
        ArrayList<Integer> Place10 =new ArrayList<Integer>();
        Place10.add(3); Place10.add(4);Place10.add(5);Place10.add(9);Place10.add(11); Place10.add(15);Place10.add(16);Place10.add(17);
        ArrayList<Integer> Place11 =new ArrayList<Integer>();
        Place11.add(4); Place11.add(5);Place11.add(10);Place11.add(16);Place11.add(17);
        ArrayList<Integer> Place12 =new ArrayList<Integer>();
        Place12.add(6); Place12.add(7);Place12.add(13);Place12.add(18);Place12.add(19);
        ArrayList<Integer> Place13 =new ArrayList<Integer>();
        Place13.add(6); Place13.add(7);Place13.add(8);Place13.add(12);Place13.add(14); Place13.add(18);Place13.add(19);Place13.add(20);
        ArrayList<Integer> Place14 =new ArrayList<Integer>();
        Place14.add(7); Place14.add(8);Place14.add(9);Place14.add(13);Place14.add(15); Place14.add(19);Place14.add(20);Place14.add(21);
        ArrayList<Integer> Place15 =new ArrayList<Integer>();
        Place15.add(8); Place15.add(9);Place15.add(10);Place15.add(14);Place15.add(16); Place15.add(20);Place15.add(21);Place15.add(22);
        ArrayList<Integer> Place16 =new ArrayList<Integer>();
        Place16.add(9); Place16.add(10);Place16.add(11);Place16.add(15);Place16.add(17); Place16.add(21);Place16.add(22);Place16.add(23);
        ArrayList<Integer> Place17 =new ArrayList<Integer>();
        Place17.add(10); Place17.add(11);Place17.add(16);Place17.add(22);Place17.add(23);
        ArrayList<Integer> Place18 =new ArrayList<Integer>();
        Place18.add(12); Place18.add(13);Place18.add(19);Place18.add(24);Place18.add(25);
        ArrayList<Integer> Place19 =new ArrayList<Integer>();
        Place19.add(12); Place19.add(13);Place19.add(14);Place19.add(18);Place19.add(20); Place19.add(24);Place19.add(25);Place19.add(26);
        ArrayList<Integer> Place20 =new ArrayList<Integer>();
        Place20.add(13); Place20.add(14);Place20.add(15);Place20.add(19);Place20.add(21); Place20.add(25);Place20.add(26);Place20.add(27);
        ArrayList<Integer> Place21 =new ArrayList<Integer>();
        Place21.add(14); Place21.add(15);Place21.add(16);Place21.add(20);Place21.add(22); Place21.add(26);Place21.add(27);Place21.add(28);
        ArrayList<Integer> Place22 =new ArrayList<Integer>();
        Place22.add(15); Place22.add(16);Place22.add(17);Place22.add(21);Place22.add(23); Place22.add(27);Place22.add(28);Place22.add(29);
        ArrayList<Integer> Place23 =new ArrayList<Integer>();
        Place23.add(16); Place23.add(17);Place23.add(22);Place23.add(28);Place23.add(29);
        ArrayList<Integer> Place24 =new ArrayList<Integer>();
        Place24.add(18); Place24.add(19);Place24.add(25);Place24.add(30);Place24.add(31);
        ArrayList<Integer> Place25 =new ArrayList<Integer>();
        Place25.add(18); Place25.add(19);Place25.add(20);Place25.add(24);Place25.add(26); Place25.add(30);Place25.add(31);Place25.add(32);
        ArrayList<Integer> Place26 =new ArrayList<Integer>();
        Place26.add(19); Place26.add(20);Place26.add(21);Place26.add(25);Place26.add(27); Place26.add(31);Place26.add(32);Place26.add(33);
        ArrayList<Integer> Place27 =new ArrayList<Integer>();
        Place27.add(20); Place27.add(21);Place27.add(22);Place27.add(26);Place27.add(28); Place27.add(32);Place27.add(33);Place27.add(34);
        ArrayList<Integer> Place28 =new ArrayList<Integer>();
        Place28.add(21); Place28.add(22);Place28.add(23);Place28.add(27);Place28.add(29); Place28.add(33);Place28.add(34);Place28.add(35);
        ArrayList<Integer> Place29 =new ArrayList<Integer>();
        Place29.add(22); Place29.add(23);Place29.add(28);Place29.add(34);Place29.add(35);
        ArrayList<Integer> Place30 =new ArrayList<Integer>();
        Place30.add(24); Place30.add(25);Place30.add(31);
        ArrayList<Integer> Place31 =new ArrayList<Integer>();
        Place31.add(24); Place31.add(25);Place31.add(26);Place31.add(30);Place31.add(32);
        ArrayList<Integer> Place32 =new ArrayList<Integer>();
        Place32.add(25); Place32.add(26);Place32.add(27);Place32.add(31);Place32.add(33);
        ArrayList<Integer> Place33 =new ArrayList<Integer>();
        Place33.add(26); Place33.add(27);Place33.add(28);Place33.add(32);Place33.add(34);
        ArrayList<Integer> Place34 =new ArrayList<Integer>();
        Place34.add(27); Place34.add(28);Place34.add(29);Place34.add(33);Place34.add(35);
        ArrayList<Integer> Place35 =new ArrayList<Integer>();
        Place35.add(28); Place35.add(29);Place35.add(34);


        //append normal arrays in 2d arraylist
        PossibleMoves.add(Place0);PossibleMoves.add(Place1);PossibleMoves.add(Place2);PossibleMoves.add(Place3);
        PossibleMoves.add(Place4);PossibleMoves.add(Place5);PossibleMoves.add(Place6);PossibleMoves.add(Place7);PossibleMoves.add(Place8);
        PossibleMoves.add(Place9);PossibleMoves.add(Place10);PossibleMoves.add(Place11);PossibleMoves.add(Place12);PossibleMoves.add(Place13);
        PossibleMoves.add(Place14);PossibleMoves.add(Place15);PossibleMoves.add(Place16);PossibleMoves.add(Place17);PossibleMoves.add(Place18);
        PossibleMoves.add(Place19);PossibleMoves.add(Place20);PossibleMoves.add(Place21);PossibleMoves.add(Place22);PossibleMoves.add(Place23);
        PossibleMoves.add(Place24);PossibleMoves.add(Place25);PossibleMoves.add(Place26);PossibleMoves.add(Place27);PossibleMoves.add(Place28);
        PossibleMoves.add(Place29);PossibleMoves.add(Place30);PossibleMoves.add(Place31);PossibleMoves.add(Place32);PossibleMoves.add(Place33);
        PossibleMoves.add(Place34);PossibleMoves.add(Place35);

        //create a 2d arraylist for fianl goal process

        ArrayList<ArrayList<Integer>> DuplicatedPossibleMoves=PossibleMoves;


        //Blocked nodes option/barrier
        ArrayList<Integer> Blocks = new ArrayList<Integer>(); // Arraylist for blocked nodes
        Blocks.add(6); Blocks.add(19);Blocks.add(22);Blocks.add(31);
        System.out.println(Blocks +"are bariers");
        for (int k=0;k<36;k++){
            for(int j=0;j<Blocks.size();j++) {
                PossibleMoves.get(k).remove(Blocks.get(j));
            }
            //PossibleMoves.get(k).remove(Blocks.get(1));
            // remove blocked nodes from the array list possible moves

        }

        //System.out.println(PossibleMoves);



        int StartingPoint=a;
        int GoalPoint=b;
        int Time=0;
        ArrayList<Integer> VisitedList=new ArrayList<>();
        VisitedList.add(StartingPoint);
        int CurrentNode=StartingPoint;
        ArrayList<Integer> same= new ArrayList<Integer>();
        while (VisitedList.get(VisitedList.size()-1)!=GoalPoint) {

            // check for visiting node
            for (int i = PossibleMoves.get(CurrentNode).size()-1; i > -1; i--) {
                for (int j = 0; j < VisitedList.size(); j++) {
                    if (PossibleMoves.get(CurrentNode).get(i) == VisitedList.get(j)) {
                        same.add(PossibleMoves.get(CurrentNode).get(i));
                    }
                }
            }
            //remove visited node to prevent revisit
            while(same.size()!=0){
                PossibleMoves.get(CurrentNode).remove(same.get(0));//remove by object not index
                same.remove(0);//remove by index
            }
            //check for possible move
            // first condition => there are possible move to move on

            if (PossibleMoves.get(CurrentNode).size() != 0) {
                VisitedList.add(PossibleMoves.get(CurrentNode).get(0));//move on to the first element of last visited node
                Time+=1;
                PossibleMoves.get(CurrentNode).remove(0);
                CurrentNode= VisitedList.get(VisitedList.size() - 1);
            }
            //second if there are no possible moves from current node for that the loop will check and go back to the visited node and search for other possible moves
            else if (PossibleMoves.get(CurrentNode).size() == 0) {
                for (int i=1;i <50;i++){
                    Time+=1;
                    CurrentNode= VisitedList.get(VisitedList.size() - i);
                    if (PossibleMoves.get(CurrentNode).size() != 0){
                        break;
                    }
                }
            }
        }
        System.out.println(VisitedList);
        //System.out.println(PossibleMoves);
        System.out.println(Time+" Minutes");



//        //remove elements
//        for (int k=0;k<36;k++){
//            PossibleMoves.get(k).clear();
//        }
//        //fresh possible moves
//        //append normal arrays in 2d arraylist
//        //add values to arraylist
//        Place0.add(1); Place0.add(6);Place0.add(7); Place1.add(0); Place1.add(2);Place1.add(6);Place1.add(7); Place1.add(8);Place2.add(1); Place2.add(3);Place2.add(7);Place2.add(8); Place2.add(9);Place3.add(2); Place3.add(4);Place3.add(8);Place3.add(9); Place3.add(10);Place4.add(3); Place4.add(5);Place4.add(9);Place4.add(10); Place4.add(11);Place5.add(4); Place5.add(10);Place5.add(11);Place6.add(0); Place6.add(1);Place6.add(7);Place6.add(12);Place6.add(13);Place7.add(0); Place7.add(1);Place7.add(2);Place7.add(6); Place7.add(8);Place7.add(12);Place7.add(13); Place7.add(14);Place8.add(1); Place8.add(2);Place8.add(3);Place8.add(7);Place8.add(9); Place8.add(13);Place8.add(14);Place8.add(15);Place9.add(2); Place9.add(3);Place9.add(4);Place9.add(8);Place9.add(10); Place9.add(14);Place9.add(15);Place9.add(16);Place10.add(3); Place10.add(4);Place10.add(5);Place10.add(9);Place10.add(11); Place10.add(15);Place10.add(16);Place10.add(17);Place11.add(4); Place11.add(5);Place11.add(10);Place11.add(16);Place11.add(17);Place12.add(6); Place12.add(7);Place12.add(13);Place12.add(18);Place12.add(19);Place13.add(6); Place13.add(7);Place13.add(8);Place13.add(12);Place13.add(14); Place13.add(18);Place13.add(19);Place13.add(20);Place14.add(7); Place14.add(8);Place14.add(9);Place14.add(13);Place14.add(15); Place14.add(19);Place14.add(20);Place14.add(21);Place15.add(8); Place15.add(9);Place15.add(10);Place15.add(14);Place15.add(16); Place15.add(20);Place15.add(21);Place15.add(22);Place16.add(9); Place16.add(10);Place16.add(11);Place16.add(15);Place16.add(17); Place16.add(21);Place16.add(22);Place16.add(23);Place17.add(10); Place17.add(11);Place17.add(16);Place17.add(22);Place17.add(23);Place18.add(12); Place18.add(13);Place18.add(19);Place18.add(24);Place18.add(25);Place19.add(12); Place19.add(13);Place19.add(14);Place19.add(18);Place19.add(20); Place19.add(24);Place19.add(25);Place19.add(26);Place20.add(13); Place20.add(14);Place20.add(15);Place20.add(19);Place20.add(21); Place20.add(25);Place20.add(26);Place20.add(27);Place21.add(14); Place21.add(15);Place21.add(16);Place21.add(20);Place21.add(22); Place21.add(26);Place21.add(27);Place21.add(28);Place22.add(15); Place22.add(16);Place22.add(17);Place22.add(21);Place22.add(23); Place22.add(27);Place22.add(28);Place22.add(29);Place23.add(16); Place23.add(17);Place23.add(22);Place23.add(28);Place23.add(29);Place24.add(18); Place24.add(19);Place24.add(25);Place24.add(30);Place24.add(31);Place25.add(18); Place25.add(19);Place25.add(20);Place25.add(24);Place25.add(26); Place25.add(30);Place25.add(31);Place25.add(32);Place26.add(19); Place26.add(20);Place26.add(21);Place26.add(25);Place26.add(27); Place26.add(31);Place26.add(32);Place26.add(33);Place27.add(20); Place27.add(21);Place27.add(22);Place27.add(26);Place27.add(28); Place27.add(32);Place27.add(33);Place27.add(34);Place28.add(21); Place28.add(22);Place28.add(23);Place28.add(27);Place28.add(29); Place28.add(33);Place28.add(34);Place28.add(35);Place29.add(22); Place29.add(23);Place29.add(28);Place29.add(34);Place29.add(35);Place30.add(24); Place30.add(25);Place30.add(31);Place31.add(24); Place31.add(25);Place31.add(26);Place31.add(30);Place31.add(32);Place32.add(25); Place32.add(26);Place32.add(27);Place32.add(31);Place32.add(33);Place33.add(26); Place33.add(27);Place33.add(28);Place33.add(32);Place33.add(34);Place34.add(27); Place34.add(28);Place34.add(29);Place34.add(33);Place34.add(35);Place35.add(28); Place35.add(29);Place35.add(34);


    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Starting node");
        int StartingNode=scanner.nextInt();
        System.out.println("Enter Goal Node");
        int GoalNode= scanner.nextInt();

        dfs(StartingNode,GoalNode);

    }
}
