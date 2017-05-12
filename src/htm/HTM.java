/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htm;

import java.util.*;
import org.apache.commons.lang3.StringUtils;
import htm.Board;
import htm.Move;

/**
 *
 * @author Dan Hochberg
 */
public class HTM {

    public static void main(String[] args) {
        // TODO code application logic here

        long emptyset = 0b0000000000000000000000000000000000000000000000000000000000000000L;

        long fullset = 0b1111111111111111111111111111111111111111111111111111111111111111L;

        long test_set = 0b0000000000000000000000000000000000000000000000000000000000000010L;

        long WR_Start = 0b0000000000000000000000000000000000000000000000000000000010000001L;
        long WN_Start = 0b0000000000000000000000000000000000000000000000000000000001000010L;
        long WB_Start = 0b0000000000000000000000000000000000000000000000000000000000100100L;
        long WQ_Start = 0b0000000000000000000000000000000000000000000000000000000000010000L;
        long WK_Start = 0b0000000000000000000000000000000000000000000000000000000000001000L;
        long WP_Start = 0b0000000000000000000000000000000000000000000000001111111100000000L;

        long BR_Start = 0b1000000100000000000000000000000000000000000000000000000000000000L;
        long BN_Start = 0b0100001000000000000000000000000000000000000000000000000000000000L;
        long BB_Start = 0b0010010000000000000000000000000000000000000000000000000000000000L;
        long BQ_Start = 0b0001000000000000000000000000000000000000000000000000000000000000L;
        long BK_Start = 0b0000100000000000000000000000000000000000000000000000000000000000L;
        long BP_Start = 0b0000000011111111000000000000000000000000000000000000000000000000L;
        
        long BP_Test = 0b0000000011011011000000000000000000000000000000000000000000000000L;

        System.out.print("\n");

        Board test = new Board(WR_Start, WN_Start, WB_Start, WQ_Start, WK_Start, WP_Start, BR_Start, BN_Start, BB_Start, BQ_Start, BK_Start, BP_Start, true);
        Board test2 = new Board(emptyset, emptyset, emptyset, WQ_Start, emptyset, emptyset, emptyset, emptyset, emptyset, emptyset, emptyset, BP_Start, true);

        //test.printboard();
        test.rescanlists();


        //System.out.print(test.move);
        //test.shiftpiece(14, 30, 'P');
        //test.move = !test.move;

        //test.printboard();


        //test.shiftpiece(51, 51 - 24, 'P');
        //test.printboard();

        //test.printset(test.blackset());
        //test.printset(test.whiteset());  
        //test.printset(test.searchknight(33));    

        //test.printset(test.searchqueen(22));
        //test.printset(test.searchking(16));
        //test.printset(test.searchpawn(15));
        //System.out.print("\n" + test.move);

//        System.out.print("\n" + bit_index_list);

        //System.out.print("Piece is:" + test.identify_opposing_piece(61));
        System.out.print("\n");
        Move test_move = new Move(4, 5, 1, 'Q', '0',false);
        test_move.starter_move=true;
        //test2.printboard();

        //test2.shiftpiece(0, 2, 'R');
        //test2.printboard();

        //test.printboard();
        //test2.MakeMove(position_test.WR_move_list.get(0));
        //test.printboard();
        //test2.UnMakeMove(position_test.WR_move_list.get(0));
        //test.printboard();
//        System.out.println("Start Generating!");
//        test.generate_positions(position_test);
        Position current = test2.store_moves(); 
        test2.search_position_deep(5,current,test_move);
        //System.out.println(test.identify_opposing_piece(63));
    }
}
