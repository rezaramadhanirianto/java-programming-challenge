package programmingChallenge.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    static List<String> list1 = new ArrayList();
    static List<String> list2 = new ArrayList();

    public static void main(String[] args){
        System.out.println("test");
    }

    static int recursion(int i, String key){
        if(i == 0) return 0;
        else if(i == 1) return 1;
        int f = recursion(i-1, "left");
        int s = recursion(i-2, "right");
        list1.add(i + key);
        return f + s;
    }

    static int recursion2(int i, String key){
        if(i == 0) return 0;
        else if(i == 1) return 1;

        var a = recursion2(i-1, "left") + recursion2(i-2, "right");
        list2.add(i + key);
        return a;
    }
}

