package Leet;

import java.util.*;

public class q22_succ {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(res, 0, 0, n, "");
        return res;
    }
    private void backtracking(List<String> res, int left, int right, int n, String temp){
        if(temp.length() == n * 2){
            res.add(temp);
            return;
        }
        if(left < n){
            backtracking(res, left + 1, right, n, temp+"(");
        }
        if(right < left){
            backtracking(res, left, right + 1, n, temp+")");
        }
    }
}
