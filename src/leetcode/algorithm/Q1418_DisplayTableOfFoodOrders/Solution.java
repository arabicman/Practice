package leetcode.algorithm.Q1418_DisplayTableOfFoodOrders;

import java.util.*;

public class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<List<String>>();
        TreeMap<Integer, TreeMap<String,Integer>> map = new TreeMap<>();
        TreeMap<String, Integer> ord = new TreeMap<>();
        for(List<String> l: orders)
        {
            String str = l.get(2);
            int id = Integer.parseInt(l.get(1));
            if(map.containsKey(id))
            {

                map.get(id).put(str, map.get(id).getOrDefault(str,0) + 1);
                ord.put(str,0);
            }
            else
            {
                TreeMap<String, Integer> temp = new TreeMap<>();
                map.put(id, temp);
                map.get(id).put(str, map.get(id).getOrDefault(str,0) + 1);
                ord.put(str,0);
            }
        }
        ArrayList<String> les = new ArrayList<>();
        les.add("Table");
        for(String s: ord.keySet())
        {
            les.add(s);
        }
        res.add(les);

        for(int i: map.keySet())
        {
            ArrayList<String> l1 = new ArrayList<>();
            String no = String.valueOf(i);
            l1.add(no);

            for(String s: ord.keySet())
            {
                l1.add(String.valueOf(map.get(i).getOrDefault(s , 0)));
            }
            res.add(l1);

        }
        return res;
    }

}
