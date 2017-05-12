/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htm;

import java.util.*;
import static htm.Board.bitScanForwardDeBruijn64;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dan Hochberg
 */
public class Position {

    boolean fully_searched = false;
    /*true means all children have been searched, false means otherwise*/

    boolean move;
    /* true is white to move, false is black to move */

    int identity;
    int father_identity;
    
    int evaluation_value;

    boolean evaluation_assigned=false;
    //indicates node has not been evaluated 
    
    int material_white;
    int material_black;
    
    int moves_white;
    int moves_black;

    public int depth;
    
    Move best_move;
    
    List<Position> Child_Position_List = new LinkedList<>();

    List<Move> full_move_list = new LinkedList<>();

    List<Position> children_list = new LinkedList<>();

    public Position(int id, int father_id, int depth_input) {
        depth = depth_input;
        identity = id;
        father_identity = father_id;

    }
    


}
