package Leetcode;

import java.util.*;

public class Destination_City {
    public static void main(String[] args) {

    }
    static String destCity(List<List<String>> paths) {
        HashMap<String, String> hm = new HashMap<>();

        for (List<String> path: paths){
            String u = path.get(0);
            String v = path.get(1);
            hm.put(u,v);
        }

        String str = paths.get(0).get(0);

        while (hm.containsKey(str)){
            str = hm.get(str);
            if (!hm.containsKey(str)) return str;
        }

        return "";
    }

    static String destCity2(List<List<String>> paths) {
        HashSet<String> hs = new HashSet<>();

        for (List<String> path: paths){
            String u = path.get(0);
            hs.add(u);
        }

        for (List<String> path: paths){
            String v = path.get(1);
            if (!hs.contains(v)) return v;
        }

        return "";
    }
}
