package programmers.ayaan.week5;

import java.util.ArrayList;
import java.util.HashMap;

public class 성격유형검사_ayaan {

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5,3,2,7,5};

        String result = solution(survey, choices);
    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";

        int[] score_value = {3,2,1,0,1,2,3};

        int[][] score = new int[4][2];

        for(int i=0; i<survey.length; i++){
            String s = survey[i];

            int val = choices[i];
            switch(s){
                case "RT":
                    if(val < 4) {
                        score[0][0] += score_value[val-1];
                    } else {
                        score[0][1] += score_value[val-1];
                    }
                    break;
                case "TR":
                    if(val < 4) {
                        score[0][1] += score_value[val-1];
                    } else {
                        score[0][0] += score_value[val-1];
                    }
                    break;
                case "CF":
                    if(val < 4) {
                        score[1][0] += score_value[val-1];
                    } else {
                        score[1][1] += score_value[val-1];
                    }
                    break;
                case "FC":
                    if(val < 4) {
                        score[1][1] += score_value[val-1];
                    } else {
                        score[1][0] += score_value[val-1];
                    }
                    break;
                case "JM":
                    if(val < 4) {
                        score[2][0] += score_value[val-1];
                    } else {
                        score[2][1] += score_value[val-1];
                    }
                    break;
                case "MJ":
                    if(val < 4) {
                        score[2][1] += score_value[val-1];
                    } else {
                        score[2][0] += score_value[val-1];
                    }
                    break;
                case "AN":
                    if(val < 4) {
                        score[3][0] += score_value[val-1];
                    } else {
                        score[3][1] += score_value[val-1];
                    }
                    break;
                case "NA":
                    if(val < 4) {
                        score[3][1] += score_value[val-1];
                    } else {
                        score[3][0] += score_value[val-1];
                    }
                    break;
            }
        }

        int[] first = score[0];
        if(first[0] > first[1]){
            answer += "R";
        } else if(first[0] < first[1]){
            answer += "T";
        } else {
            answer += "R";
        }
        int[] second = score[1];
        if(second[0] > second[1]){
            answer += "C";
        } else if(second[0] < second[1]){
            answer += "F";
        } else {
            answer += "C";
        }
        int[] third = score[2];
        if(third[0] > third[1]){
            answer += "J";
        } else if(third[0] < third[1]){
            answer += "M";
        } else {
            answer += "J";
        }
        int[] fourth = score[3];
        if(fourth[0] > fourth[1]){
            answer += "A";
        } else if(fourth[0] < fourth[1]){
            answer += "N";
        } else {
            answer += "A";
        }

        return answer;
    }
}