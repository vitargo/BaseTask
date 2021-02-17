package com.github.strmethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrMethods {
    public static void main(String[] args) {

        String sentence = "Hello!!! Word!!! I'm.. a-homo sapience!)-,?";
        System.out.println("The shortest word has " + shortestWord(sentence) + " letter(s).");

        String[] words = {"hello", "wow", "door", "me", "blue", "cat", "mood"};
        System.out.println(Arrays.toString(dollarSign(words, 4)));

        System.out.println("New sentence with spaces: " + addSpace(sentence));

        System.out.println("New sentence without repeated char: " + noRepeatedChar(sentence));

        System.out.println("Number of words in sentence: " + numberOfWords(sentence));

        System.out.println("New string: " + deletePart(sentence, 8, 8));

        System.out.println("Reverse string: " + reverseString(sentence));

        System.out.println("New string without last word: " + deleteLastWord(sentence));

    }

    public static int shortestWord(String sentence){
        if(sentence == null){
            throw new NumberFormatException ("String is null!");
        }
        sentence = sentence.replaceAll("\\p{Punct}", "");
        String[] words = sentence.split(" ");
        int min = words[0].length();
        for (String word : words){
            if(word.length()< min){
                min = word.length();
            }
        }
        return min;
    }

    public static String[] dollarSign(String[] words, int length){
        if(words == null){
            throw new NullPointerException ("Array of words is null!");
        }
        for(int i = 0; i < words.length; i++){
            if(words[i].length() == length){
                words[i] = words[i].replaceAll(".{3}$", "\\$\\$\\$");
            }
        }
        return words;
    }

    public static String addSpace(String sentence){
        if(sentence == null) {
            throw new NullPointerException ("String is null!");
        }
        sentence = sentence.replaceAll("(?<=[,.:!?])(?=\\S)", " ");
        return sentence;
    }

    public static String noRepeatedChar(String sentence){
        if(sentence == null){
            throw new NullPointerException ("String is null!");
        }
        StringBuilder sb = new StringBuilder();
        sentence.chars().distinct().forEach(c -> sb.append((char) c));
        return sb.toString();
    }

    public static int numberOfWords(String sentence){
        if (sentence == null) {
            return 0;
        }
        String[] words = sentence.split("[\\pP\\s&&[^']]+");
        return words.length;
    }

    public static String deletePart(String sentence, int start, int length){
        if(sentence == null){
            throw new NullPointerException ("String is null!");
        }
        if(start < 0 ||length < 0){
            return sentence;
        }
        return sentence.substring(0, start) + sentence.substring(start+length);
    }

    public static String reverseString (String sentence){
        if(sentence == null){
            throw new NullPointerException ("String is null!");
        }
        StringBuilder sb = new StringBuilder(sentence);
        return sb.reverse().toString();
    }

    public static String deleteLastWord(String sentence){
        if(sentence == null){
            throw new NullPointerException ("String is null!");
        }
        String[] words = sentence.trim().split(" ");
        String[] newWords = new String[words.length-1];
        for(int i = 0; i < newWords.length; i++){
            newWords[i] = words[i];
        }
        return String.join(" ", newWords);
    }
}
