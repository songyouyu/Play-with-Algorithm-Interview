import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 17
 * @author youyusong
 * @date 2018/8/28
 */
public class Solution {

    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if ("".equals(digits)) {
            return res;
        }

        findCombination(digits, 0, "");
        return res;
    }

    /**
     *  s中保存了此时从digits[0...index-1]翻译得到的一个字母字符串
     *  寻找和digits[index]匹配的字母, 获得digits[0...index]翻译得到的解
     * @param digits
     * @param index
     * @param s
     */
    private void findCombination(String digits, int index, String s){
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        Character c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for ( int i = 0; i < letters.length(); i ++ ) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
        return;
    }
}
