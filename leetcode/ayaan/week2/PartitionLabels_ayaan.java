package leetcode.ayaan.week2;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_ayaan {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
//        String s = "caedbdedda";
        partitionLabels(s);
    }

    // 더 빠름
    public static List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        int first = 0;
        char standard = s.charAt(0);
        int last = s.lastIndexOf(standard);
        for(int i=0; i<s.length(); i++){
            char unit = s.charAt(i);
            if(i == last){
                result.add(s.substring(first, last+1).length());
                if(last == s.length()-1){
                    break;
                }
                first = last+1;
                standard = s.charAt(first);
                last = s.lastIndexOf(standard);
                continue;
            }
            if(standard == unit){
                continue;
            }
            int unitIndex = s.lastIndexOf(unit);
            if(last < unitIndex){
                last = unitIndex;
                standard = unit;
            }
        }

        return result;
    }
}
