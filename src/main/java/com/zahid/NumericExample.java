package com.zahid;

import com.zahid.numeric.BinaryEvaluation;
import com.zahid.numeric.BooleanEvaluation;
import com.zahid.numeric.UnaryEvaluation;

/**
 * Hello world!
 *
 */
public class NumericExample 
{
    public static void main( String[] args ) {

        System.out.println("# BooleanEvaluation: ");
        // isEven using anonymous inner class
        BooleanEvaluation isEven1 = new BooleanEvaluation() {
            @Override
            public boolean test(int n) {
                return n % 2 == 0;
            }
        };
        System.out.println(isEven1.test(4));
        System.out.println(isEven1.test(9));

        // isEven using lambda expression
        BooleanEvaluation isEven2 = num -> num % 2 == 0;
        System.out.println(isEven2.test(4));
        System.out.println(isEven2.test(9));
        System.out.println();

        // isPositive using lambda expression
        BooleanEvaluation isPositive = n -> n > 0;
        System.out.println(isPositive.test(4));
        System.out.println(isPositive.test(-9));
        System.out.println();

        // isPrime using lambda
        BooleanEvaluation isPrime = (num) -> {
            int limit = (int)Math.sqrt(num);

            for(int i=2; i<= limit; i++) {
                if(num % i == 0) {
                    return false;
                }
            }
            return true;
        };

        System.out.println(isPrime.test(4));
        System.out.println(isPrime.test(9));
        System.out.println(isPrime.test(13));
        System.out.println(isPrime.test(17));
        System.out.println();

        System.out.println("# UnaryEvaluation: ");
        UnaryEvaluation squareIt = new UnaryEvaluation() {

            @Override
            public int evaluate(int n) {
                return n*n;
            }
            
        };
        System.out.println(squareIt.evaluate(12));

        UnaryEvaluation cubeIt = n -> n*n*n;
        System.out.println(cubeIt.evaluate(9));
        System.out.println();

        System.out.println("# Binary Evaluation: ");
        BinaryEvaluation addition = new BinaryEvaluation() {

            @Override
            public int calculate(int x, int y) {
                
                return x + y;
            }
            
        };
        System.out.println(addition.calculate(4, 9));

        BinaryEvaluation multiplication = (x, y) -> x * y;
        System.out.println(multiplication.calculate(4, 9));

        BinaryEvaluation gcd = (x, y) -> {
            int min = x < y? x: y;

            for(int i=min; i>=1; i--) {
                if(x % i == 0 && y % i == 0) {
                    return i;
                }
            }
            return 1;
        };
        System.out.println(gcd.calculate(36, 48));
        System.out.println(gcd.calculate(48, 72));
        System.out.println(gcd.calculate(6, 8));
        System.out.println(gcd.calculate(3, 97));
    }
}
