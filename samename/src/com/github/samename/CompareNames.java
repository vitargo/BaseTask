package com.github.samename;

public class CompareNames {

    public static boolean compareNames(String a, String b){
        a = a.toLowerCase();
        b = b.toLowerCase();
        return a.equals(b);
    }
}
