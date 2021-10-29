package com.zahid;

import com.zahid.string.Converter;

public class StringExample {
    public static void main(String[] args) {

        // upperCase converter using anonymous inner class
        String text = "Once upon a time in the wild west.";
        Converter upperCaseConverter = new Converter() {
            @Override
            public String convert(String str) {
                return str.toUpperCase();
            }
        };
        System.out.println("# upperCaseConverter: using anonymous inner class");
        System.out.println(upperCaseConverter.convert(text));
        System.out.println();
        
        // using lambda expression
        System.out.println("# uConverter: using lambda expression");
        Converter uConverter = s -> s.toUpperCase();
        System.out.println(uConverter.convert(text));
        System.out.println();

        // now lowerCase converter using the same functional interface
        String line = "CODING IS FUN AT LAST.";
        Converter lowerCaseConverter = new Converter() {
            @Override
            public String convert(String s) {
                return s.toLowerCase();
            }
        };
        System.out.println("# lowerCaseConverter: using anonymous inner class");
        System.out.println(lowerCaseConverter.convert(line));
        System.out.println();
        
        // using lambda expression
        System.out.println("# lConverter: using lambda expression");
        Converter lConverter = s -> s.toLowerCase();
        System.out.println(lConverter.convert(line));
        System.out.println();
        
        // titleCaseConverter
        Converter titleCaseConverter = new Converter() {
            
            @Override
            public String convert(String str) {
                
                StringBuilder sb = new StringBuilder();
                boolean nextTitleCase = true;
                
                for(char ch: str.toCharArray()) {
                    if(Character.isSpaceChar(ch)) { // after space the immediate char is first letter of the word
                        nextTitleCase = true;
                    } else if(nextTitleCase) {
                        ch = Character.toTitleCase(ch);
                        nextTitleCase = false;
                    }
                    sb.append(ch);
                }
                
                return sb.toString();
            }
            
        };
        System.out.println("# lConverter: using anonymous inner class");
        System.out.println(titleCaseConverter.convert("sheldon cooper"));
        System.out.println(titleCaseConverter.convert("sheldon lee cooper"));
        System.out.println();
        
        System.out.println("# stringReverser: using lambda expression");
        Converter stringReverser = (str) -> {
            String revsersed = "";
            for(int i=str.length() - 1 ; i >= 0; i--) {
                revsersed += str.charAt(i);
            }
            return revsersed;
        };
        System.out.println(stringReverser.convert("lambda expression"));
        System.out.println(stringReverser.convert("anonymous"));
        System.out.println();

    }
}
