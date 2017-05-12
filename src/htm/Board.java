/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htm;

import java.util.*;
import org.apache.commons.lang3.StringUtils;
import java.util.LinkedList;
import java.util.Iterator;

/**
 *
 * @author Dan Hochberg
 */
public class Board {

    boolean move;
    /* true is white to move, false is black to move */
    int previous_identity = 0;
    int current_identity = 1;

    public long WR;
    public long WN;
    public long WB;
    public long WQ;
    public long WK;
    public long WP;

    public long BR;
    public long BN;
    public long BB;
    public long BQ;
    public long BK;
    public long BP;

    List WR_list = new LinkedList();
    int WR_count = 0;
    List WN_list = new LinkedList();
    int WN_count = 0;
    List WB_list = new LinkedList();
    int WB_count = 0;
    List WQ_list = new LinkedList();
    int WQ_count = 0;
    List WK_list = new LinkedList();
    int WK_count = 0;
    List WP_list = new LinkedList();
    int WP_count = 0;

    List BR_list = new LinkedList();
    int BR_count = 0;
    List BN_list = new LinkedList();
    int BN_count = 0;
    List BB_list = new LinkedList();
    int BB_count = 0;
    List BQ_list = new LinkedList();
    int BQ_count = 0;
    List BK_list = new LinkedList();
    int BK_count = 0;
    List BP_list = new LinkedList();
    int BP_count = 0;

    int move_count_white = 0;
    int move_count_black = 0;

    //stores current best evaluated line
    Move best_move;
    Move prev_best_move;

    List<Move> current_line = new LinkedList<>();

    int last_eval;
    int best_eval;

    boolean eval_initialized = false;

    public Board(long WR_Start, long WN_Start, long WB_Start, long WQ_Start, long WK_Start, long WP_Start, long BR_Start, long BN_Start, long BB_Start, long BQ_Start, long BK_Start, long BP_Start, boolean move_input) {

        WR = WR_Start;
        WN = WN_Start;
        WB = WB_Start;
        WQ = WQ_Start;
        WK = WK_Start;
        WP = WP_Start;

        BR = BR_Start;
        BN = BN_Start;
        BB = BB_Start;
        BQ = BQ_Start;
        BK = BK_Start;
        BP = BP_Start;

        long emptyset = 0b0000000000000000000000000000000000000000000000000000000000000000L;

        move = move_input;
        /* true is white to move, false is black to move */

        long testset = 0b1L;

        int counter = 0;
        int position;

        testset = WR_Start;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            WR_list.add(position);
            WR_count++;
            testset = testset & ~(0b1L << position);
            System.out.print("\n" + WR_list);
            System.out.print("\n" + WR_count);
        }

        testset = WN_Start;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            WN_list.add(position);
            WN_count++;
            testset = testset & ~(0b1L << position);
            System.out.print("\n" + WN_list);
            System.out.print("\n" + WN_count);
        }
        testset = WB_Start;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            WB_list.add(position);
            WB_count++;
            testset = testset & ~(0b1L << position);
            System.out.print("\n" + WB_list);
            System.out.print("\n" + WB_count);
        }
        testset = WQ_Start;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            WQ_list.add(position);
            WQ_count++;
            testset = testset & ~(0b1L << position);
            System.out.print("\n" + WQ_list);
            System.out.print("\n" + WQ_count);
        }
        testset = WK_Start;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            WK_list.add(position);
            WK_count++;
            testset = testset & ~(0b1L << position);
            System.out.print("\n" + WK_list);
            System.out.print("\n" + WK_count);
        }
        testset = WP_Start;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            WP_list.add(position);
            WP_count++;
            testset = testset & ~(0b1L << position);
            System.out.print("\n" + WP_list);
            System.out.print("\n" + WP_count);
        }
        testset = BR_Start;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            BR_list.add(position);
            BR_count++;
            testset = testset & ~(0b1L << position);
            System.out.print("\n" + BR_list);
            System.out.print("\n" + BR_count);
        }
        testset = BN_Start;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            BN_list.add(position);
            BN_count++;
            testset = testset & ~(0b1L << position);
            System.out.print("\n" + BN_list);
            System.out.print("\n" + BN_count);
        }
        testset = BB_Start;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            BB_list.add(position);
            BB_count++;
            testset = testset & ~(0b1L << position);
            System.out.print("\n" + BB_list);
            System.out.print("\n" + BB_count);
        }
        testset = BQ_Start;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            BQ_list.add(position);
            BQ_count++;
            testset = testset & ~(0b1L << position);
            System.out.print("\n" + BQ_list);
            System.out.print("\n" + BQ_count);
        }
        testset = BK_Start;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            BK_list.add(position);
            BK_count++;
            testset = testset & ~(0b1L << position);
            System.out.print("\n" + BK_list);
            System.out.print("\n" + BK_count);
        }
        testset = BP_Start;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            BP_list.add(position);
            BP_count++;
            testset = testset & ~(0b1L << position);
            System.out.print("\n" + BP_list);
            System.out.print("\n" + BP_count);
        }

    }

    void rescanlists() {

        long testset = 0b1L;

        int counter = 0;
        int position;

        testset = WR;
        WR_list.clear();
        WR_count = 0;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            WR_list.add(position);
            WR_count++;
            testset = testset & ~(0b1L << position);
            //System.out.print("\n" + WR_list);
            //System.out.print("\n" + WR_count);
        }

        testset = WN;
        WN_list.clear();
        WN_count = 0;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            WN_list.add(position);
            WN_count++;
            testset = testset & ~(0b1L << position);
            //System.out.print("\n" + WN_list);
            //System.out.print("\n" + WN_count);
        }
        testset = WB;
        WB_list.clear();
        WB_count = 0;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            WB_list.add(position);
            WB_count++;
            testset = testset & ~(0b1L << position);
            //System.out.print("\n" + WB_list);
            //System.out.print("\n" + WB_count);
        }
        testset = WQ;
        WQ_list.clear();
        WQ_count = 0;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            WQ_list.add(position);
            WQ_count++;
            testset = testset & ~(0b1L << position);
            //System.out.print("\n" + WQ_list);
            //System.out.print("\n" + WQ_count);
        }
        testset = WK;
        WK_list.clear();
        WK_count = 0;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            WK_list.add(position);
            WK_count++;
            testset = testset & ~(0b1L << position);
            //System.out.print("\n" + WK_list);
            //System.out.print("\n" + WK_count);
        }
        testset = WP;
        WP_list.clear();
        WP_count = 0;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            WP_list.add(position);
            WP_count++;
            testset = testset & ~(0b1L << position);
            //System.out.print("\n" + WP_list);
            //System.out.print("\n" + WP_count);
        }
        testset = BR;
        BR_list.clear();
        BR_count = 0;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            BR_list.add(position);
            BR_count++;
            testset = testset & ~(0b1L << position);
            //System.out.print("\n" + BR_list);
            //System.out.print("\n" + BR_count);
        }
        testset = BN;
        BN_list.clear();
        BN_count = 0;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            BN_list.add(position);
            BN_count++;
            testset = testset & ~(0b1L << position);
            //System.out.print("\n" + BN_list);
            //System.out.print("\n" + BN_count);
        }
        testset = BB;
        BB_list.clear();
        BB_count = 0;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            BB_list.add(position);
            BB_count++;
            testset = testset & ~(0b1L << position);
            //System.out.print("\n" + BB_list);
            //System.out.print("\n" + BB_count);
        }
        testset = BQ;
        BQ_list.clear();
        BQ_count = 0;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            BQ_list.add(position);
            BQ_count++;
            testset = testset & ~(0b1L << position);
            //System.out.print("\n" + BQ_list);
            //System.out.print("\n" + BQ_count);
        }
        testset = BK;
        BK_list.clear();
        BK_count = 0;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            BK_list.add(position);
            BK_count++;
            testset = testset & ~(0b1L << position);
            //System.out.print("\n" + BK_list);
            //System.out.print("\n" + BK_count);
        }
        testset = BP;
        BP_list.clear();
        BP_count = 0;
        while (testset != 0) {
            position = bitScanForwardDeBruijn64(testset);
            BP_list.add(position);
            BP_count++;
            testset = testset & ~(0b1L << position);
            //System.out.print("\n" + BP_list);
            //System.out.print("\n" + BP_count);
        }
    }

    //incorporates negamax
    int search_position_deep(int depth_to_search, Position current, Move last) {
        this.rescanlists();

        //if end node, evaluate and return
        if (current.depth == depth_to_search) {
            //printboard();
            //System.out.println("Reached End Node");
            last_eval = evaluate_position(current);
            if (this.eval_initialized == false) {
                System.out.println("evaluated first node");
                best_eval = last_eval;
                this.eval_initialized = true;
            }
            prev_best_move = last;
            last.end_node = true;
            UnMakeMove(last);
            return last_eval;
        }
        //System.out.println("New call of search_position_deep!");
        //boolean keep_going = true;

        Iterator<Move> move_iterator = current.full_move_list.iterator();

        //if not end node, make all possible moves and extract best value
        while (move_iterator.hasNext()) {
            //while (current.depth < depth_to_search && move_iterator.hasNext()) {
            //System.out.println("Depth and iterator check passed!");
            Move value = move_iterator.next();
            //System.out.println("Moving Forward!");
            MakeMove(value);
            this.rescanlists();
            //System.out.println("Print 2");
            //printboard();
            //System.out.println("Position evaluation is:" + evaluate_position());
            //Position next_position = new Position(current_identity, previous_identity, (current.depth + 1));
            Position next_position = store_moves();
            next_position.depth = (current.depth + 1);
            last_eval = search_position_deep(depth_to_search, next_position, value);
            if (last_eval < best_eval || current.evaluation_assigned == false) {
                System.out.println(last_eval);
                System.out.println(best_eval);
                System.out.println("Found Best Move");
                current.evaluation_value = last_eval;
                current.evaluation_assigned = true;
                current.best_move = value;
                last.next_move_best = value;
                best_eval = last_eval;
                //current.position_best=next_position;
            }
        }
        //revert to previous state
        //System.out.println("Moving Backward!");
        if (last.starter_move == false) {
            UnMakeMove(last);
        }
        this.rescanlists();
        if (last_eval < current.evaluation_value || current.evaluation_assigned == false) {
            current.evaluation_value = last_eval;
            current.evaluation_assigned = true;
            current.best_move = last;
            //current.position_best=next_position;
        }
        //System.out.println("Print 3");
        //printboard();
        //System.out.println("Position evaluation is:" + evaluate_position());
        if (current.depth == 0) {
            System.out.println("End of Search!");
            printboard();

            print_move_list(last);
        }

        return last_eval;
    }

    void print_move_list(Move list_seed) {
        if (list_seed.end_node == true) {
            return;
        }

        if (list_seed.starter_move == true) {
            printboard();
            print_move_list(list_seed.next_move_best);
            return;
        }
        MakeMovePrint(list_seed);
        printboard();
        print_move_list(list_seed.next_move_best);
        return;
    }

//    void search_position_deep(int depth_to_search, Position current) {
//        //note to self, no need to have Position argument   
//          
//        
//
//        System.out.println("New call of search_position_deep!");
//
//        boolean keep_going = true;
//        Iterator<Move> move_iterator = current.full_move_list.iterator();
//        if (current.depth < depth_to_search) {
//            while (move_iterator.hasNext() && keep_going == true) {
//                if (current.depth < depth_to_search) {
//                    //store_moves();
//                    Move value = move_iterator.next();
//                    MakeMove(value);
//                    printboard();
//                    System.out.println("current depth is: " + current.depth);
//                    Position next_position = new Position(current_identity, previous_identity, (current.depth + 1));
//                    System.out.println("New depth is: " + next_position.depth);
//                    current.Child_Position_List.add(next_position);
//                    search_position_deep(depth_to_search, next_position);
//                    UnMakeMove(value);
//                    printboard();
//                } else {
//                    keep_going = !keep_going;
//                }
//            }
//        }
//    }
    void generate_positions(Position seed) {
        Iterator<Move> move_iterator = seed.full_move_list.iterator();
        while (move_iterator.hasNext()) {
            Move value = move_iterator.next();
            MakeMove(value);
            Position First = new Position(current_identity, previous_identity, (seed.depth + 1));
            seed.Child_Position_List.add(First);

            UnMakeMove(value);

        }
        seed.fully_searched = true;
    }

    Position store_moves() {

        Position trial = new Position(current_identity, previous_identity, 0);

        long testset;
        int position;
        char test;

        trial.moves_white = 0;
        trial.moves_black = 0;

        if (move == true) {
            Iterator<Integer> writ = WR_list.iterator();
            while (writ.hasNext()) {
                int value = writ.next();
                testset = searchrook(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    test = identify_opposing_piece(position);
                    Move First = new Move(position, value, 1, 'R', test, move);
                    trial.full_move_list.add(First);
                    trial.moves_white++;
                }
            }
            Iterator<Integer> wnit = WN_list.iterator();
            while (wnit.hasNext()) {
                int value = wnit.next();
                testset = searchknight(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    test = identify_opposing_piece(position);
                    Move First = new Move(position, value, 1, 'N', test, move);
                    trial.full_move_list.add(First);
                    trial.moves_white++;
                }
            }
            Iterator<Integer> wbit = WB_list.iterator();
            while (wbit.hasNext()) {
                int value = wbit.next();
                testset = searchbishop(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    test = identify_opposing_piece(position);
                    Move First = new Move(position, value, 1, 'B', test, move);
                    trial.full_move_list.add(First);
                    trial.moves_white++;
                }
            }
            Iterator<Integer> wqit = WQ_list.iterator();
            while (wqit.hasNext()) {
                int value = wqit.next();
                testset = searchqueen(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    test = identify_opposing_piece(position);
                    Move First = new Move(position, value, 1, 'Q', test, move);
                    trial.full_move_list.add(First);
                    trial.moves_white++;
                }
            }
            Iterator<Integer> wkit = WK_list.iterator();
            while (wkit.hasNext()) {
                int value = wkit.next();
                testset = searchking(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    test = identify_opposing_piece(position);
                    Move First = new Move(position, value, 1, 'K', test, move);
                    trial.full_move_list.add(First);
                    trial.moves_white++;
                }
            }
            Iterator<Integer> wpit = WP_list.iterator();
            while (wpit.hasNext()) {
                int value = wpit.next();
                testset = searchpawn(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    test = identify_opposing_piece(position);
                    Move First = new Move(position, value, 1, 'P', test, move);
                    trial.full_move_list.add(First);
                    trial.moves_white++;
                }
            }
            move = !move;
            //toggles move to search black pieces
            Iterator<Integer> brit = BR_list.iterator();
            while (brit.hasNext()) {
                int value = brit.next();
                testset = searchrook(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    trial.moves_black++;
                }
            }
            Iterator<Integer> bnit = BN_list.iterator();
            while (bnit.hasNext()) {
                int value = bnit.next();
                testset = searchknight(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    trial.moves_black++;
                }
            }
            Iterator<Integer> bbit = BB_list.iterator();
            while (bbit.hasNext()) {
                int value = bbit.next();
                testset = searchbishop(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    trial.moves_black++;
                }
            }
            Iterator<Integer> bqit = BQ_list.iterator();
            while (bqit.hasNext()) {
                int value = bqit.next();
                testset = searchqueen(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    trial.moves_black++;
                }
            }
            Iterator<Integer> bkit = BK_list.iterator();
            while (bkit.hasNext()) {
                int value = bkit.next();
                testset = searchking(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    trial.moves_black++;
                }
            }
            Iterator<Integer> bpit = BP_list.iterator();
            while (bpit.hasNext()) {
                int value = bpit.next();
                testset = searchpawn(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    trial.moves_black++;
                }
            }
            move = !move;
            //toggles move back after searching black pieces
        }

        if (move == false) {
            Iterator<Integer> brit = BR_list.iterator();
            while (brit.hasNext()) {
                int value = brit.next();
                testset = searchrook(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    test = identify_opposing_piece(position);
                    Move First = new Move(position, value, 1, 'R', test, move);
                    trial.full_move_list.add(First);
                    trial.moves_black++;
                }
            }
            Iterator<Integer> bnit = BN_list.iterator();
            while (bnit.hasNext()) {
                int value = bnit.next();
                testset = searchknight(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    test = identify_opposing_piece(position);
                    Move First = new Move(position, value, 1, 'N', test, move);
                    trial.full_move_list.add(First);
                    trial.moves_black++;
                }
            }
            Iterator<Integer> bbit = BB_list.iterator();
            while (bbit.hasNext()) {
                int value = bbit.next();
                testset = searchbishop(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    test = identify_opposing_piece(position);
                    Move First = new Move(position, value, 1, 'B', test, move);
                    trial.full_move_list.add(First);
                    trial.moves_black++;
                }
            }
            Iterator<Integer> bqit = BQ_list.iterator();
            while (bqit.hasNext()) {
                int value = bqit.next();
                testset = searchqueen(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    test = identify_opposing_piece(position);
                    Move First = new Move(position, value, 1, 'Q', test, move);
                    trial.full_move_list.add(First);
                    trial.moves_black++;
                }
            }
            Iterator<Integer> bkit = BK_list.iterator();
            while (bkit.hasNext()) {
                int value = bkit.next();
                testset = searchking(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    test = identify_opposing_piece(position);
                    Move First = new Move(position, value, 1, 'K', test, move);
                    trial.full_move_list.add(First);
                    trial.moves_black++;
                }
            }
            Iterator<Integer> bpit = BP_list.iterator();
            while (bpit.hasNext()) {
                int value = bpit.next();
                testset = searchpawn(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    test = identify_opposing_piece(position);
                    Move First = new Move(position, value, 1, 'P', test, move);
                    trial.full_move_list.add(First);
                    trial.moves_black++;
                }
            }
            move = !move;
            //toggles move to search white pieces
            Iterator<Integer> writ = WR_list.iterator();
            while (writ.hasNext()) {
                int value = writ.next();
                testset = searchrook(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    trial.moves_white++;
                }
            }
            Iterator<Integer> wnit = WN_list.iterator();
            while (wnit.hasNext()) {
                int value = wnit.next();
                testset = searchknight(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    trial.moves_white++;
                }
            }
            Iterator<Integer> wbit = WB_list.iterator();
            while (wbit.hasNext()) {
                int value = wbit.next();
                testset = searchbishop(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    trial.moves_white++;
                }
            }
            Iterator<Integer> wqit = WQ_list.iterator();
            while (wqit.hasNext()) {
                int value = wqit.next();
                testset = searchqueen(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    trial.moves_white++;
                }
            }
            Iterator<Integer> wkit = WK_list.iterator();
            while (wkit.hasNext()) {
                int value = wkit.next();
                testset = searchking(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    trial.moves_white++;
                }
            }
            Iterator<Integer> wpit = WP_list.iterator();
            while (wpit.hasNext()) {
                int value = wpit.next();
                testset = searchpawn(value);
                while (testset != 0) {
                    position = bitScanForwardDeBruijn64(testset);
                    testset = testset & ~(0b1L << position);
                    trial.moves_white++;
                }
            }
            move = !move;
            //toggles move after searching white pieces
        }
        //System.out.println("Mobility for White is:" + trial.moves_white);
        //System.out.println("Mobility for Black is:" + trial.moves_black);
        return trial;
    }

    public void MakeMove(Move make_it) {

        if (make_it.piece_capture != '0') {
            removepiece(make_it.new_square, make_it.piece_capture, !move);
            //System.out.println("Removed piece:" + make_it.new_square);
        }

        shiftpiece(make_it.old_square, make_it.new_square, make_it.piece_type, make_it.color);
        //System.out.println("Made Move!");
        //System.out.println("Piece move type is " + make_it.piece_type);
        //System.out.println("Piece capture type is " + make_it.piece_capture);
        //System.out.println("New square is " + make_it.new_square);
        //System.out.println("Old square is " + make_it.old_square);

        move = !move;
        //toggles move
    }

    public void MakeMovePrint(Move make_it) {

        if (make_it.piece_capture != '0') {
            removepiece(make_it.new_square, make_it.piece_capture, !move);
            //System.out.println("Removed piece:" + make_it.new_square);
        }

        shiftpiece(make_it.old_square, make_it.new_square, make_it.piece_type, make_it.color);
        System.out.println("Made Move!");
        System.out.println("Piece move type is " + make_it.piece_type);
        System.out.println("Piece capture type is " + make_it.piece_capture);
        System.out.println("New square is " + make_it.new_square);
        System.out.println("Old square is " + make_it.old_square);

        move = !move;
        //toggles move
    }

    public void UnMakeMove(Move make_it) {

        shiftpiece(make_it.new_square, make_it.old_square, make_it.piece_type, make_it.color);
        if (make_it.piece_capture != '0') {
            placepiece(make_it.new_square, make_it.piece_capture, !move);
            //System.out.println("Placed piece:" + make_it.new_square);
        }

        //System.out.println("UnMade Move!");
        //System.out.println("Piece move type is " + make_it.piece_type);
        //System.out.println("Piece replaced type is " + make_it.piece_capture);
        //System.out.println("New square is " + make_it.old_square);
        //System.out.println("Old square is " + make_it.new_square);
        move = !move;
        //toggles move
    }

    public void UnMakeMovePrint(Move make_it) {

        shiftpiece(make_it.new_square, make_it.old_square, make_it.piece_type, make_it.color);
        if (make_it.piece_capture != '0') {
            placepiece(make_it.new_square, make_it.piece_capture, !move);
            //System.out.println("Placed piece:" + make_it.new_square);
        }

        System.out.println("UnMade Move!");
        System.out.println("Piece move type is " + make_it.piece_type);
        System.out.println("Piece replaced type is " + make_it.piece_capture);
        System.out.println("New square is " + make_it.old_square);
        System.out.println("Old square is " + make_it.new_square);
        move = !move;
        //toggles move
    }

    void removepiece(int square, char piece_type, boolean color) {

        //for boolean color, white is true, black is false
        if (color == false) {
            if (piece_type == 'R') {
                BR = BR & ~(0b1L << square);
                return;
            }
            if (piece_type == 'N') {

                BN = BN & ~(0b1L << square);
                return;
            }
            if (piece_type == 'B') {

                BB = BB & ~(0b1L << square);
                return;
            }
            if (piece_type == 'Q') {

                BQ = BQ & ~(0b1L << square);
                return;
            }
            if (piece_type == 'K') {

                BK = BK & ~(0b1L << square);
                return;
            }
            if (piece_type == 'P') {

                BP = BP & ~(0b1L << square);
                return;
            }
        }

        if (color == true) {
            if (piece_type == 'R') {
                WR = WR & ~(0b1L << square);
                return;
            }
            if (piece_type == 'N') {

                WN = WN & ~(0b1L << square);
                return;
            }
            if (piece_type == 'B') {

                WB = WB & ~(0b1L << square);
                return;
            }
            if (piece_type == 'Q') {

                WQ = WQ & ~(0b1L << square);
                return;
            }
            if (piece_type == 'K') {

                WK = WK & ~(0b1L << square);
                return;
            }
            if (piece_type == 'P') {

                WP = WP & ~(0b1L << square);
                return;
            }
        }
        return;
    }

    void placepiece(int square, char piece_type, boolean color) {

        //for boolean color, white is true, black is false
        if (color == true) {
            if (piece_type == 'R') {
                BR = BR | (0b1L << square);
                return;
            }
            if (piece_type == 'N') {

                BN = BN | (0b1L << square);
                return;
            }
            if (piece_type == 'B') {

                BB = BB | (0b1L << square);
                return;
            }
            if (piece_type == 'Q') {

                BQ = BQ | (0b1L << square);
                return;
            }
            if (piece_type == 'K') {

                BK = BK | (0b1L << square);
                return;
            }
            if (piece_type == 'P') {

                BP = BP | (0b1L << square);
                return;
            }
        }

        if (move == false) {
            if (piece_type == 'R') {
                WR = WR | (0b1L << square);
                return;
            }
            if (piece_type == 'N') {

                WN = WN | (0b1L << square);
                return;
            }
            if (piece_type == 'B') {

                WB = WB | (0b1L << square);
                return;
            }
            if (piece_type == 'Q') {

                WQ = WQ | (0b1L << square);
                return;
            }
            if (piece_type == 'K') {

                WK = WK | (0b1L << square);
                return;
            }
            if (piece_type == 'P') {

                WP = WP | (0b1L << square);
                return;
            }
        }

    }

    void shiftpiece(int original_square, int new_square, char piece_type, boolean color) {

        if (color == true) {
            if (piece_type == 'R') {

                WR = WR & ~(0b1L << original_square);
                WR = WR | (0b1L << new_square);

                return;
            }
            if (piece_type == 'N') {

                WN = WN & ~(0b1L << original_square);
                WN = WN | (0b1L << new_square);
                return;
            }
            if (piece_type == 'B') {

                WB = WB & ~(0b1L << original_square);
                WB = WB | (0b1L << new_square);
                return;
            }
            if (piece_type == 'Q') {

                WQ = WQ & ~(0b1L << original_square);
                WQ = WQ | (0b1L << new_square);
                return;
            }
            if (piece_type == 'K') {

                WK = WK & ~(0b1L << original_square);
                WK = WK | (0b1L << new_square);
                return;
            }
            if (piece_type == 'P') {

                WP = WP & ~(0b1L << original_square);
                WP = WP | (0b1L << new_square);
                return;
            }
        }
        if (color == false) {
            if (piece_type == 'R') {

                BR = BR & ~(0b1L << original_square);
                BR = BR | (0b1L << new_square);
                return;
            }
            if (piece_type == 'N') {

                BN = BN & ~(0b1L << original_square);
                BN = BN | (0b1L << new_square);
                return;
            }
            if (piece_type == 'B') {

                BB = BB & ~(0b1L << original_square);
                BB = BB | (0b1L << new_square);
                return;
            }
            if (piece_type == 'Q') {

                BQ = BQ & ~(0b1L << original_square);
                BQ = BQ | (0b1L << new_square);
                return;
            }
            if (piece_type == 'K') {

                BK = BK & ~(0b1L << original_square);
                BK = BK | (0b1L << new_square);
                return;
            }
            if (piece_type == 'P') {

                BP = BP & ~(0b1L << original_square);
                BP = BP | (0b1L << new_square);
            }
        }
    }

    long blackset() {
        long all_black = BP | BR | BN | BB | BQ | BK;
        return all_black;
    }

    long whiteset() {
        long all_black = WP | WR | WN | WB | WQ | WK;
        return all_black;
    }

    char identify_opposing_piece(int original_square) {

        long white_set = whiteset();

        long black_set = blackset();

        if (((0b1L << (original_square)) & white_set) == 0) {
            if (((0b1L << (original_square)) & black_set) == 0) {
                return '0';
            }
        }

        if (((0b1L << (original_square)) & BR) != 0) {
            return 'R';
        }
        if (((0b1L << (original_square)) & BN) != 0) {
            return 'N';
        }
        if (((0b1L << (original_square)) & BB) != 0) {
            return 'B';
        }
        if (((0b1L << (original_square)) & BQ) != 0) {
            return 'Q';
        }
        if (((0b1L << (original_square)) & BK) != 0) {
            return 'K';
        }
        if (((0b1L << (original_square)) & BP) != 0) {
            return 'P';
        }

        if (((0b1L << (original_square)) & WR) != 0) {
            return 'R';
        }
        if (((0b1L << (original_square)) & WN) != 0) {
            return 'N';
        }
        if (((0b1L << (original_square)) & WB) != 0) {
            return 'B';
        }
        if (((0b1L << (original_square)) & WQ) != 0) {
            return 'Q';
        }
        if (((0b1L << (original_square)) & WK) != 0) {
            return 'K';
        }
        if (((0b1L << (original_square)) & WP) != 0) {
            return 'P';
        }
        return '0';
    }

    //This function removes a captured piece
    //If it is white to move, black piece is assumed to be captured and vice versa
    void capture_piece(int original_square, char piece_type) {
        if (move == false) {
            if (piece_type == 'R') {

                WR = WR & ~(0b1L << original_square);

                return;
            }
            if (piece_type == 'N') {

                WN = WN & ~(0b1L << original_square);

                return;
            }
            if (piece_type == 'B') {

                WB = WB & ~(0b1L << original_square);

                return;
            }
            if (piece_type == 'Q') {

                WQ = WQ & ~(0b1L << original_square);

                return;
            }
            if (piece_type == 'K') {

                WK = WK & ~(0b1L << original_square);

                return;
            }
            if (piece_type == 'P') {

                WP = WP & ~(0b1L << original_square);

                return;
            }
        }
        if (move == false) {
            if (piece_type == 'R') {

                BR = BR & ~(0b1L << original_square);

                return;
            }
            if (piece_type == 'N') {

                BN = BN & ~(0b1L << original_square);

                return;
            }
            if (piece_type == 'B') {

                BB = BB & ~(0b1L << original_square);

                return;
            }
            if (piece_type == 'Q') {

                BQ = BQ & ~(0b1L << original_square);

                return;
            }
            if (piece_type == 'K') {

                BK = BK & ~(0b1L << original_square);

                return;
            }
            if (piece_type == 'P') {

                BP = BP & ~(0b1L << original_square);

            }
        }

    }

    long searchknight(int original_square
    ) {
        int[] new_positions;
        new_positions = new int[8];

        int position_count = 0;

        long moveset = 0b0L;

        long occupied_set;
        if (move == true) {
            occupied_set = whiteset();
        } else {
            occupied_set = blackset();
        }

        if (((original_square + 1) % 8) == 1) {
            new_positions[0] = original_square - 6;
            new_positions[1] = original_square - 15;
            new_positions[2] = original_square + 10;
            new_positions[3] = original_square + 17;
            position_count = 4;
        }

        if (((original_square + 1) % 8) == 2) {
            new_positions[0] = original_square - 6;
            new_positions[1] = original_square - 15;
            new_positions[2] = original_square - 17;
            new_positions[3] = original_square + 10;
            new_positions[4] = original_square + 15;
            new_positions[5] = original_square + 17;
            position_count = 6;
        }

        if (((original_square + 1) % 8) == 0) {
            new_positions[0] = original_square - 10;
            new_positions[1] = original_square - 17;
            new_positions[2] = original_square + 6;
            new_positions[3] = original_square + 15;
            position_count = 4;
        }

        if (((original_square + 1) % 8) == 7) {
            new_positions[0] = original_square - 10;
            new_positions[1] = original_square - 17;
            new_positions[2] = original_square - 15;
            new_positions[3] = original_square + 6;
            new_positions[4] = original_square + 15;
            new_positions[5] = original_square + 17;
            position_count = 6;
        }

        if ((((original_square + 1) % 8) > 2) && (((original_square + 1) % 8) < 7)) {
            new_positions[0] = original_square - 6;
            new_positions[1] = original_square - 10;
            new_positions[2] = original_square - 15;
            new_positions[3] = original_square - 17;
            new_positions[4] = original_square + 6;
            new_positions[5] = original_square + 10;
            new_positions[6] = original_square + 15;
            new_positions[7] = original_square + 17;
            position_count = 8;
        }

        for (int i = 0; i < position_count; i++) {
            if ((new_positions[i] <= 63) && (new_positions[i] >= 0) && (((0b1L << new_positions[i]) & (occupied_set)) == 0)) {
                moveset = moveset | (0b1L << new_positions[i]);
            }
        }
        return moveset;
    }

    long searchpawn(int original_square) {

        long occupied_set;
        long other_set;
        long all_set;

        if (move == true) {
            occupied_set = whiteset();
            other_set = blackset();
        } else {
            occupied_set = blackset();
            other_set = whiteset();
        }

        all_set = occupied_set | other_set;

        long moveset = 0b0L;

        if (move == true) {
            if ((((0b1L << (original_square + 8)) & all_set) == 0)) {
                moveset = moveset | (0b1L << (original_square + 8));
                if ((((0b1L << (original_square + 16)) & all_set) == 0) && (original_square > 7) && (original_square < 16)) {
                    moveset = moveset | (0b1L << (original_square + 16));
                }
            }
            if ((((0b1L << (original_square + 9)) & other_set) != 0) && (((original_square) % 8) != 7)) {
                moveset = moveset | (0b1L << (original_square + 9));
            }
            if ((((0b1L << (original_square + 7)) & other_set) != 0) && (((original_square) % 8) != 0)) {
                moveset = moveset | (0b1L << (original_square + 7));
            }
        }

        if (move == false) {
            if ((((0b1L << (original_square - 8)) & all_set) == 0)) {
                moveset = moveset | (0b1L << (original_square - 8));
                if ((((0b1L << (original_square - 16)) & all_set) == 0) && (original_square > 47) && (original_square < 56)) {
                    moveset = moveset | (0b1L << (original_square - 16));
                }
            }
            if ((((0b1L << (original_square + 9)) & other_set) != 0) && (((original_square) % 8) != 7)) {
                moveset = moveset | (0b1L << (original_square + 9));
            }
            if ((((0b1L << (original_square + 7)) & other_set) != 0) && (((original_square) % 8) != 0)) {
                moveset = moveset | (0b1L << (original_square + 7));
            }
        }

        return moveset;
    }

    long searchbishop(int original_square
    ) {

        boolean path_block;
        path_block = false;

        long occupied_set;
        long other_set;

        if (move == true) {
            occupied_set = whiteset();
            other_set = blackset();
        } else {
            occupied_set = blackset();
            other_set = whiteset();
        }

        long moveset = 0b0L;

        int k;
        k = 1;

        if (((original_square + 7) <= 63) && (((original_square + 7) % 8) != 7) && (((0b1L << (original_square + 7)) & occupied_set) == 0)) {

            moveset = moveset | (0b1L << (original_square + 7));
            if (((original_square + 14) > 63) || ((original_square + 14) % 8 == 7) || (((0b1L << (original_square + 14)) & (occupied_set)) != 0) || (((0b1L << (original_square + 7)) & (other_set)) != 0)) {
                path_block = true;

            }
            while (path_block == false) {
                k++;
                moveset = moveset | (0b1L << (original_square + (k * 7)));

                if (((original_square + ((k + 1) * 7)) > 63) || ((original_square + ((k + 1) * 7)) % 8 == 7) || (((0b1L << (original_square + (k * 7))) & (occupied_set)) != 0) || (((0b1L << (original_square + (k * 7))) & (other_set)) != 0)) {
                    path_block = true;

                }
            }
        }

        path_block = false;
        k = 1;

        if (((original_square + 9) <= 63) && (((original_square + 9) % 8) != 0) && (((0b1L << (original_square + 9)) & occupied_set) == 0)) {

            moveset = moveset | (0b1L << (original_square + 9));

            if (((original_square + 18) > 63) || ((original_square + 18) % 8 == 0) || (((0b1L << (original_square + 18)) & (occupied_set)) != 0) || (((0b1L << (original_square + 9)) & (other_set)) != 0)) {
                path_block = true;

            }
            while (path_block == false) {
                k++;
                moveset = moveset | (0b1L << (original_square + (k * 9)));

                if (((original_square + ((k + 1) * 9)) > 63) || ((original_square + (k * 9)) % 8 == 7) || (((0b1L << (original_square + ((k + 1) * 9))) & (occupied_set)) != 0) || (((0b1L << (original_square + (k * 9))) & (other_set)) != 0)) {
                    path_block = true;

                }
            }
        }

        path_block = false;
        k = 1;

        if (((original_square - 9) >= 0) && (((original_square - 9) % 8) != 7) && (((0b1L << (original_square - 9)) & occupied_set) == 0)) {

            moveset = moveset | (0b1L << (original_square - 9));

            if (((original_square - 18) < 0) || ((original_square - 18) % 8 == 7) || (((0b1L << (original_square - 18)) & (occupied_set)) != 0) || (((0b1L << (original_square - 9)) & (other_set)) != 0)) {
                path_block = true;

            }
            while (path_block == false) {
                k++;

                moveset = moveset | (0b1L << (original_square - (k * 9)));

                if (((original_square - ((k + 1) * 9)) < 0) || ((original_square - (k * 9)) % 8 == 0) || (((0b1L << (original_square - ((k + 1) * 9))) & (occupied_set)) != 0) || (((0b1L << (original_square + (k * 9))) & (other_set)) != 0)) {
                    path_block = true;

                }
            }
        }

        path_block = false;
        k = 1;

        if (((original_square - 7) >= 0) && (((original_square - 7) % 8) != 0) && (((0b1L << (original_square - 7)) & occupied_set) == 0)) {

            moveset = moveset | (0b1L << (original_square - 7));

            if (((original_square - 14) < 0) || ((original_square - 14) % 8 == 0) || (((0b1L << (original_square - 14)) & (occupied_set)) != 0) || (((0b1L << (original_square - 7)) & (other_set)) != 0)) {
                path_block = true;

            }
            while (path_block == false) {
                k++;

                moveset = moveset | (0b1L << (original_square - (k * 7)));

                if (((original_square - ((k + 1) * 7)) < 0) || ((original_square - (k * 7)) % 8 == 7) || (((0b1L << (original_square - ((k + 1) * 7))) & (occupied_set)) != 0) || (((0b1L << (original_square + (k * 7))) & (other_set)) != 0)) {
                    path_block = true;

                }
            }
        }

        return moveset;
    }

    long searchrook(int original_square
    ) {

        boolean path_block;
        path_block = false;

        long occupied_set;
        long other_set;

        if (move == true) {
            occupied_set = whiteset();
            other_set = blackset();
        } else {
            occupied_set = blackset();
            other_set = whiteset();
        }

        long moveset = 0b0L;

        int k;
        k = 1;

        if ((((original_square + 1) % 8) != 0) && (((0b1L << (original_square + 1)) & occupied_set) == 0) && (original_square != 63)) {

            moveset = moveset | (0b1L << original_square + 1);
            if (((original_square + 2) % 8 == 0) || (((0b1L << (original_square + 2)) & (occupied_set)) != 0) || (((0b1L << (original_square + 1)) & (other_set)) != 0)) {
                path_block = true;

            }
            while (path_block == false) {
                k++;
                moveset = moveset | (0b1L << (original_square + k));

                if (((original_square + k + 1) % 8 == 0) || (((0b1L << (original_square + k + 1)) & (occupied_set)) != 0) || (((0b1L << (original_square + k)) & (other_set)) != 0)) {
                    path_block = true;

                }
            }
        }
        path_block = false;
        k = 1;
        if ((((original_square - 1) % 8) != 7) && (((0b1L << (original_square - 1)) & occupied_set) == 0) && (original_square != 0)) {

            if (original_square != 0) {
                moveset = moveset | (0b1L << original_square - 1);
            }
            if (((original_square - 1) % 8 == 7) || (((0b1L << (original_square - 2)) & (occupied_set)) != 0) || (((0b1L << (original_square - 1)) & (other_set)) != 0)) {
                path_block = true;

            }
            while (path_block == false) {
                k++;
                moveset = moveset | (0b1L << (original_square - k));

                if (((original_square - k + 1) % 8 == 1) || (((0b1L << (original_square - k - 1)) & (occupied_set)) != 0) || (((0b1L << (original_square - k)) & (other_set)) != 0)) {
                    path_block = true;

                }
            }
        }

        path_block = false;
        k = 1;

        if ((((original_square + 8) <= 63) && (((0b1L << (original_square + 8)) & occupied_set) == 0))) {

            moveset = moveset | (0b1L << original_square + 8);
            if (((original_square + 16) > 63) || (((0b1L << (original_square + 16)) & (occupied_set)) != 0) || (((0b1L << (original_square + 8)) & (other_set)) != 0)) {
                path_block = true;

            }
            while (path_block == false) {
                k++;
                moveset = moveset | (0b1L << (original_square + (k * 8)));

                if (((original_square + ((k + 1) * 8) > 63) || (((0b1L << (original_square + ((k + 1) * 8))) & (occupied_set)) != 0) || (((0b1L << (original_square + ((k) * 8))) & (other_set)) != 0))) {
                    path_block = true;

                }
            }
        }
        path_block = false;
        k = 1;

        if ((((original_square - 8) >= 0) && (((0b1L << (original_square - 8)) & occupied_set) == 0))) {

            moveset = moveset | (0b1L << original_square - 8);
            if (((original_square - 16) < 0) || (((0b1L << (original_square - 16)) & (occupied_set)) != 0) || ((0b1L << (original_square - 8) & (other_set)) != 0)) {
                path_block = true;

            }
            while (path_block == false) {
                k++;
                moveset = moveset | (0b1L << (original_square - (k * 8)));

                if (((original_square - ((k + 1) * 8) < 0) || (((0b1L << (original_square - ((k + 1) * 8))) & (occupied_set)) != 0) || (((0b1L << (original_square - ((k) * 8))) & (other_set)) != 0))) {
                    path_block = true;

                }
            }
        }

        return moveset;
    }

    long searchqueen(int original_square
    ) {
        long moveset;

        moveset = searchrook(original_square) | searchbishop(original_square);

        return moveset;
    }

    long searchking(int original_square
    ) {
        long moveset = 0b0L;

        long occupied_set;

        if (move == true) {
            occupied_set = whiteset();
        } else {
            occupied_set = blackset();
        }

        if ((((original_square - 8) >= 0) && (((0b1L << (original_square - 8)) & occupied_set) == 0))) {
            moveset = moveset | (0b1L << original_square - 8);
        }

        if ((((original_square + 8) <= 63) && (((0b1L << (original_square + 8)) & occupied_set) == 0))) {
            moveset = moveset | (0b1L << original_square + 8);
        }

        if (original_square % 8 != 0) {
            if ((((0b1L << (original_square - 1)) & occupied_set) == 0) && ((original_square - 1) >= 0)) {
                moveset = moveset | (0b1L << original_square - 1);
            }
            if ((((0b1L << (original_square - 9)) & occupied_set) == 0) && ((original_square - 9) >= 0)) {
                moveset = moveset | (0b1L << original_square - 9);
            }
            if ((((0b1L << (original_square + 7)) & occupied_set) == 0) && ((original_square + 7) <= 63)) {
                moveset = moveset | (0b1L << original_square + 7);
            }
        }

        if (original_square % 8 != 7) {
            if ((((0b1L << (original_square + 1)) & occupied_set) == 0) && ((original_square + 1) <= 63)) {
                moveset = moveset | (0b1L << original_square + 1);
            }
            if ((((0b1L << (original_square - 7)) & occupied_set) == 0) && ((original_square - 7) >= 0)) {
                moveset = moveset | (0b1L << original_square - 7);
            }
            if ((((0b1L << (original_square + 9)) & occupied_set) == 0) && ((original_square + 9) <= 63)) {
                moveset = moveset | (0b1L << original_square + 9);
            }
        }

        return moveset;
    }

    void printboard() {

        String[] board_strings = new String[]{"0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 ", "0 "};

        String WR_string = StringUtils.leftPad(Long.toBinaryString(WR), 64, "0");
        char[] WR_char = WR_string.toCharArray();
        for (int i = 0; i <= 63; i++) {
            if (WR_char[i] == '1') {
                board_strings[i] = "WR";
            }
        }

        String WN_string = StringUtils.leftPad(Long.toBinaryString(WN), 64, "0");
        char[] WN_char = WN_string.toCharArray();
        for (int i = 0; i <= 63; i++) {
            if (WN_char[i] == '1') {
                board_strings[i] = "WN";
            }
        }

        String WB_string = StringUtils.leftPad(Long.toBinaryString(WB), 64, "0");
        char[] WB_char = WB_string.toCharArray();
        for (int i = 0; i <= 63; i++) {
            if (WB_char[i] == '1') {
                board_strings[i] = "WB";
            }
        }

        String WQ_string = StringUtils.leftPad(Long.toBinaryString(WQ), 64, "0");
        char[] WQ_char = WQ_string.toCharArray();
        for (int i = 0; i <= 63; i++) {
            if (WQ_char[i] == '1') {
                board_strings[i] = "WQ";
            }
        }

        String WK_string = StringUtils.leftPad(Long.toBinaryString(WK), 64, "0");
        char[] WK_char = WK_string.toCharArray();
        for (int i = 0; i <= 63; i++) {
            if (WK_char[i] == '1') {
                board_strings[i] = "WK";
            }
        }

        String WP_string = StringUtils.leftPad(Long.toBinaryString(WP), 64, "0");
        char[] WP_char = WP_string.toCharArray();
        for (int i = 0; i <= 63; i++) {
            if (WP_char[i] == '1') {
                board_strings[i] = "WP";
            }
        }

        String BR_string = StringUtils.leftPad(Long.toBinaryString(BR), 64, "0");
        char[] BR_char = BR_string.toCharArray();
        for (int i = 0; i <= 63; i++) {
            if (BR_char[i] == '1') {
                board_strings[i] = "BR";
            }
        }

        String BN_string = StringUtils.leftPad(Long.toBinaryString(BN), 64, "0");
        char[] BN_char = BN_string.toCharArray();
        for (int i = 0; i <= 63; i++) {
            if (BN_char[i] == '1') {
                board_strings[i] = "BN";
            }
        }

        String BB_string = StringUtils.leftPad(Long.toBinaryString(BB), 64, "0");
        char[] BB_char = BB_string.toCharArray();
        for (int i = 0; i <= 63; i++) {
            if (BB_char[i] == '1') {
                board_strings[i] = "BB";
            }
        }

        String BQ_string = StringUtils.leftPad(Long.toBinaryString(BQ), 64, "0");
        char[] BQ_char = BQ_string.toCharArray();
        for (int i = 0; i <= 63; i++) {
            if (BQ_char[i] == '1') {
                board_strings[i] = "BQ";
            }
        }

        String BK_string = StringUtils.leftPad(Long.toBinaryString(BK), 64, "0");
        char[] BK_char = BK_string.toCharArray();
        for (int i = 0; i <= 63; i++) {
            if (BK_char[i] == '1') {
                board_strings[i] = "BK";
            }
        }

        String BP_string = StringUtils.leftPad(Long.toBinaryString(BP), 64, "0");
        char[] BP_char = BP_string.toCharArray();
        for (int i = 0; i <= 63; i++) {
            if (BP_char[i] == '1') {
                board_strings[i] = "BP";
            }
        }

        for (int i = 0; i <= 63; i++) {
            if (((i) % 8) == 0) {
                System.out.print("\n");
            }
            System.out.print(board_strings[i] + " ");

        }
        System.out.print("\n");

    }

    void printset(long set
    ) {
        System.out.print("\n");
        String toprint = StringUtils.leftPad(Long.toBinaryString(set), 64, "0");
        for (int i = 0; i < 64; i = i + 8) {
            System.out.print(toprint.charAt(i));
            System.out.print(toprint.charAt(i + 1));
            System.out.print(toprint.charAt(i + 2));
            System.out.print(toprint.charAt(i + 3));
            System.out.print(toprint.charAt(i + 4));
            System.out.print(toprint.charAt(i + 5));
            System.out.print(toprint.charAt(i + 6));
            System.out.print(toprint.charAt(i + 7));
            System.out.print("\n");
        }

    }
    /**
     * @author Charles E. Leiserson Harald Prokop Keith H. Randall "Using de
     * Bruijn Sequences to Index a 1 in a Computer Word"
     * @return index 0..63
     * @param bb a 64-bit word to bitscan, should not be zero
     */
    static private final long deBruijn = 0x03f79d71b4cb0a89L;
    static private final int[] magicTable = {
        0, 1, 48, 2, 57, 49, 28, 3,
        61, 58, 50, 42, 38, 29, 17, 4,
        62, 55, 59, 36, 53, 51, 43, 22,
        45, 39, 33, 30, 24, 18, 12, 5,
        63, 47, 56, 27, 60, 41, 37, 16,
        54, 35, 52, 21, 44, 32, 23, 11,
        46, 26, 40, 15, 34, 20, 31, 10,
        25, 14, 19, 9, 13, 8, 7, 6,};

    static public int bitScanForwardDeBruijn64(long b) {
        int idx = (int) (((b & -b) * deBruijn) >>> 58);
        return magicTable[idx];
    }

    int evaluate_position(Position to_evaluate) {
        int white_material;
        int black_material;
        int material_evaluated;
        int mobility_evaluated;
        int positional_evaluation;

        mobility_evaluated = to_evaluate.moves_white - to_evaluate.moves_black;

        white_material = (WK_count * 2000) + (WR_count * 50) + (WN_count * 30) + (WB_count * 30) + (WQ_count * 90) + (WP_count * 10);
        black_material = (BK_count * 2000) + (BR_count * 50) + (BN_count * 30) + (BB_count * 30) + (BQ_count * 90) + (BP_count * 10);

        material_evaluated = white_material - black_material;
        positional_evaluation = material_evaluated + (mobility_evaluated);
        positional_evaluation = material_evaluated;

        if (move == false) {
            positional_evaluation = (positional_evaluation * -1);
        }

        //System.out.println(positional_evaluation);
        return positional_evaluation;

    }
}
