package com.vikram.striver.sde.sheet.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<List<Integer>> list = pascalsTriangle.generate(9);
        list.forEach(System.out::println);
    }

    // 1. Extreme naive
    public List<String> getPascals(int n) {
        List<String> list = new ArrayList<>();
        if (n == 1) {
            list.add("1");
        }
        if (n == 2) {
            list.add("1");
            list.add("11");
        } else {
            list.add("1");
            list.add("11");
            for (int i = 2; i< n; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append("1");
                String str = list.get(i-1);
                for (int j = 0; j<list.get(i-1).length()-1; j++) {
                    sb.append(
                            Integer.parseInt(str.charAt(j)+"")
                                    + Integer.parseInt(str.charAt(j+1)+""));
                }
                sb.append("1");
                list.add(sb.toString());
            }
        }
        return list;
    }

    // 2. Using NCR formula
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> cur = generateRow(i);
            resultList.add(cur);
        }
        return resultList;
    }

    private static List<Integer> generateRow(int row) {
        List<Integer> cur = new ArrayList<>();
        int result = 1;
        cur.add(1);
        for (int col = 1; col < row; col++) {
            result = result * (row - col);
            result = result / col;
            cur.add(result);
        }
        return cur;
    }
}
