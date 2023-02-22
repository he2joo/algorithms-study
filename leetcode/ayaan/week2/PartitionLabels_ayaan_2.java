package leetcode.ayaan.week2;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_ayaan_2 {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
//        String s = "eccbbbbdec";
        partitionLabels(s);
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        int first = 0;
        int last = 0;
        for(int i=0; i<s.length(); i++){
            last = Math.max(last, s.lastIndexOf(s.charAt(i)));
            if(i == last){
                result.add((last+1) - first);
                first = last+1;
            }
        }

        return result;
    }
}
