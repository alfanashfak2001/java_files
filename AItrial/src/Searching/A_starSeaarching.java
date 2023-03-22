package Searching;

import java.util.ArrayList;

public class A_starSeaarching {
    public static void dfs(int a, int b) {
        ArrayList<ArrayList<Integer>> PossibleMoves = new ArrayList<ArrayList<Integer>>(); //create 2d arraylist
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


        //Blocked nodes option/barrier
        ArrayList<Integer> Blocks = new ArrayList<Integer>(); // Arraylist for blocked nodes
        Blocks.add(6);
        Blocks.add(19);
        Blocks.add(31);
        Blocks.add(22);
        for (int k = 0; k < 36; k++) {
            PossibleMoves.get(k).remove(Blocks.get(0));
            PossibleMoves.get(k).remove(Blocks.get(1));//remove blocked nodes from the array list possible moves
        }
        //xy coordinates finding
        int[][] arrayOfMaze = { { 0, 1,2,3,4,5 },
                        { 6, 7,8,9,10,11 },
                        { 12, 13,14,15,16,17 },
                        { 18, 19,20,21,22,23 },
                        { 24, 25,26,27,28,29 },
                        { 30, 31,32,33,34,35 }};
        int[][] xycoordinates = new int[36][2];

        int StartingPoint=a;
        int GoalPoint=b;
        int Gx = 0;
        int Gy = 0;
        int node=0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                xycoordinates[node][0]=i;
                xycoordinates[node][1]=j;
                node+=1;
                if (arrayOfMaze[i][j] == b) {
                    Gx = i;
                    Gy = j;

                }
            }
        }


        ArrayList<Integer>VisitedList=new ArrayList<>();
        
        VisitedList.add(a);
        int CurrentNode=a;
        ArrayList<Integer>Heuristicvalues=new ArrayList<>();

        while(VisitedList.get(VisitedList.size()-1)!=b){
            for (int i=0;i<PossibleMoves.get(CurrentNode).size();i++){
                //finding heuristic values
                int N=PossibleMoves.get(CurrentNode).get(i);
                int Nx=xycoordinates[N][0];
                int Ny=xycoordinates[N][1];
                int HeuristicCostcheck1=Nx-Gx;
                int HeuristicCostcheck2=Ny-Gy;
                if (HeuristicCostcheck1<0){
                    HeuristicCostcheck1=-1*HeuristicCostcheck1;
                }
                if (HeuristicCostcheck2<0){
                    HeuristicCostcheck2=HeuristicCostcheck2*-1;
                }
                int HeuristicValue=Math.max(HeuristicCostcheck1,HeuristicCostcheck2);
                Heuristicvalues.add(HeuristicValue);



            }
        }
        System.out.println(Heuristicvalues);

    }

    public static void main(String[] args) {
        dfs(2,27);


    }
}
