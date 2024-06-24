package Leetcode;

import java.util.*;

public class Euler_Circuit_in_an_Undirected_Graph {
    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // The degree for each node will be even, if it visits the same node in the end when it starts, ie, if its euler circuit
        for (int i = 0; i < adj.size(); i++){
            if (adj.get(i).size() % 2 != 0) return false;
        }

        return true;
    }
}
