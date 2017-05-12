/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dan Hochberg
 */
public class Move {

    public int new_square;
    public int old_square;
    public char piece_capture;
    public char piece_type;
    boolean color;
    boolean end_node=false;
    private Move parent = null;
    
    boolean starter_move=false;
    
    
    Move next_move_best;

    enum moved_piece {
        WP, WR, WN, WB, WQ, WK, BP, BR, BN, BB, BQ, BK,
    }

    enum captured_piece {
        WP, WR, WN, WB, WQ, WK, BP, BR, BN, BB, BQ, BK, NULL,
    }

    private List<Move> children = new ArrayList<Move>();



    public Move(int new_spot, int old_spot, long parent, char piece_m, char piece_c,boolean c_to_move) {
        new_square = new_spot;
        old_square = old_spot;
        piece_type = piece_m;
        piece_capture = piece_c;
        color=c_to_move;

    }




}
