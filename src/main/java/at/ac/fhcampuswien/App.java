package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void oneMonthCalendar(int numDay, int firstDay) {
        int d = 1;
        for(int i = 1; i < firstDay; i++) {
            System.out.print("   ");
            d++;
            if(d == 8) {
                d = 1;
                System.out.println();
            }
        }
        for(int j = 1; j <= numDay; j++) {
            if(d == 8) {
                d = 1;
                System.out.println();
            }
            if(j < 10) {
                System.out.print(" ");
            }
            System.out.print(j + " ");
            d++;
        }
        System.out.println();
    }

    public static long[] lcg(long x0) {
        long m = (long) Math.pow(2, 31);
        long a = 1103515245;
        long c = 12345;
        long[] numbers = new long[10];
        numbers[0] = (a*x0 + c) % m;
        for(int i = 1; i < numbers.length; i++) {
            numbers[i] = (a*numbers[i-1] + c) % m;
            System.out.println(numbers[i]);
        }
        return numbers;
    }

    public static void guessingGame(int guessNum) {
        Scanner scan = new Scanner(System.in);
        int c = 1;
        do{
            System.out.print("Guess number " + c + ": ");
            int guess = scan.nextInt();
            c++;
            if(guess != guessNum) {
                if(c > 10) {
                    System.out.println("You lost! Have you ever heard of divide & conquer?");
                    break;
                }
                if(guess > guessNum) {
                    System.out.println("The number AI picked is lower than your guess.");
                }
                if(guess < guessNum) {
                    System.out.println("The number AI picked is higher than your guess.");
                }
            }
            if(guess == guessNum) {
                System.out.println("You won wisenheimer!");
                break;
            }
        }while(true);
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random gen = new Random();
        return gen.nextInt(100) + 1;
    }

    public static boolean swapArrays(int[] array1, int[] array2) {
        if(array1.length != array2.length) {
            return false;
        }
        for(int i = 0; i < array1.length; i++) {
            int t = array2[i];
            array2[i] = array1[i];
            array1[i] = t;
        }
        return true;
    }

    public static String camelCase(String sentence) {
        char[] senChar = sentence.toCharArray();
        StringBuilder camel = new StringBuilder();
        boolean nw = true;
        boolean iw = false;
        for(int i = 0; i < senChar.length; i++) {
            char x = senChar[i];
            if(x == ' ') {
                nw = true;
                iw = false;
            }
            else
            if(Character.isLowerCase(x) && nw) {
                x = Character.toUpperCase(x);
                nw = false;
                camel.append(x);
                iw = true;
            }
            else
            if(Character.isUpperCase(x) && iw) {
                x = Character.toLowerCase(x);
                camel.append(x);
            }
            else
            if(Character.isUpperCase(x) && nw) {
                nw = false;
                camel.append(x);
                iw = true;
            }
            else
            if (x != 33 && x != 34 && x != 39 && x != 44 && x != 46 && x != 63) {
                camel.append(x);
            }
        }
        System.out.println(camel);
        return camel.toString();
    }

    public static int checkDigit(int[] code) {
        int sum = 0;
        for(int i = 0; i < code.length; i++) {
            code[i] *= i+2;
            sum += code[i];
        }
        sum %= 11;
        int pr = 11 - sum;
        if(pr == 10) {
            pr = 0;
        }
        if(pr == 11) {
            pr = 5;
        }
        return pr;
    }

    public static void main(String[] args) {
        oneMonthCalendar(28, 1);
        swapArrays(new int[]{1, 2, 3}, new int[]{100, 90, 80});
        guessingGame(randomNumberBetweenOneAndHundred());
        camelCase("AnY noise annoYs an oYster but a noisY noise annoYs an oYster more.");
    }
}