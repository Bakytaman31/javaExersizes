import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    //Task 1
    //Given a month as an integer from 1 to 12, return to which quarter of the year it belongs as an integer number.
    //
    //For example: month 2 (February), is part of the first quarter; month 6 (June), is part of the second quarter; and month 11 (November), is part of the fourth quarter.
    //
    //Constraint:
    //
    //1 <= month <= 12
    static int quarterOf(int month) {
        int quater = 0;
        if (month > 0 && month <= 3) {
            quater = 1;
        } else if (month > 3 && month <= 6) {
            quater = 2;
        } else if(month > 6 && month <= 9) {
            quater = 3;
        } else if(month > 9 && month <= 12) {
            quater = 4;
        }
        return quater;
    }

    //Task 2
    //Given a non-negative integer, 3 for example, return a string with a murmur: "1 sheep...2 sheep...3 sheep...". Input will always be valid, i.e. no negative integers.
     static String countingSheep(int num) {
        String text = " sheep...";
        String finalText = "";
        for (int i = 0; i < num; i++) {
            finalText += i+1 + text;
        }
        return finalText;
    }

    //Task 3
    //Simple, given a string of words, return the length of the shortest word(s).
    //
    //String will never be empty and you do not need to account for different data types.
    static int findShort(String s) {
        int smallestLength;
        String[] words = s.split(" ");
        smallestLength = words[0].length();
        for (String word : words) {
            if(word.length() < smallestLength) {
                smallestLength = word.length();
            }
        }
        return smallestLength;
    }

    //Task 4
    //Your task is to write a function which returns the sum of following series upto nth term(parameter).
    //
    //Series: 1 + 1/4 + 1/7 + 1/10 + 1/13 + 1/16 +...
    static String seriesSum(int n) {
        double sum = 0.0;
        for (int i = 0; i < n; i++)
            sum += 1.0 / (1 + 3 * i);

        return String.format("%.2f", sum);
    }

    //Task 5
    //Complete the solution so that the function will break up camel casing, using a space between words.
    static String camelCase(String input) {
        return input.replaceAll("([A-Z])", " $1");
    }

    //Task 6
    //Write a function that takes in a string of one or more words, and returns the same string, but with all five or more letter words reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.
    static String spinWords(String sentence) {
        StringBuilder sb = new StringBuilder();
        String [] splitSentence = sentence.split(" ");

        for (String word : splitSentence) {
            if (word.length() > 4) {
                sb.append(new StringBuilder(word).reverse().toString() + " ");
            } else {
                sb.append(word + " ");
            }
        }
        return sb.toString().trim();
    }

    //Task 7
    //I want to get the sum of two arrays... Actually the sum of all their elements.
    static int arrayPlusArray(int[] arr1, int[] arr2) {
        // arr1 + arr2 is not working...
        int arrSum1 = 0;
        int arrSum2 = 0;
        for (int num : arr1) {
            arrSum1 += num;
        }
        for (int num : arr2) {
            arrSum2 += num;
        }
        return arrSum1 + arrSum2;
    }

    //Task 8
    //Let us consider this example (array written in general format):
    //
    //ls = [0, 1, 3, 6, 10]
    //
    //Its following parts:
    //
    //ls = [0, 1, 3, 6, 10]
    //ls = [1, 3, 6, 10]
    //ls = [3, 6, 10]
    //ls = [6, 10]
    //ls = [10]
    //ls = []
    //The corresponding sums are (put together in a list): [20, 20, 19, 16, 10, 0]
    //
    //The function parts_sums (or its variants in other languages) will take as parameter a list ls and return a list of the sums of its parts as defined above.
     static int[] sumParts(int[] ls) {
        int[] result = new int[ls.length+1];
        for(int i = ls.length-1; i >= 0; --i) {
            result[i] = result[i+1] + ls[i];
        }
        return result;
    }

    //Task 9
    //John has invited some friends. His list is:
    //
    //s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
    //Could you make a program that
    //
    //makes this string uppercase
    //gives it sorted in alphabetical order by last name.
    //When the last names are the same, sort them by first name. Last name and first name of a guest come in the result between parentheses separated by a comma.
    //
    //So the result of function meeting(s) will be:
    //
    //"(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)"
    //It can happen that in two distinct families with the same family name two people have the same first name too.
    public static String meeting(String s) {
        return Arrays.stream(s.toUpperCase().split(";"))
                .map(guest -> guest.replaceAll("(\\w+):(\\w+)", "($2, $1)"))
                .sorted()
                .collect(Collectors.joining(""));
    }

    //Task 10
    //You are given an array (which will have a length of at least 3, but could be very large) containing integers. The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.
    static int find(int[] integers) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        int res = 0;
        for (int integer : integers) {
            if (integer % 2 == 0) {
                even.add(integer);
            } else {
                odd.add(integer);
            }
        }
        if (odd.size() > even.size()) {
            res = even.get(0);
        } else {
            res = odd.get(0);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println("Task 1");
        System.out.println(quarterOf(3));
        System.out.println(quarterOf(8));
        System.out.println(quarterOf(11));
        System.out.println("");
        System.out.println("Task 2");
        System.out.println(countingSheep(2));
        System.out.println(countingSheep(4));
        System.out.println(countingSheep(7));
        System.out.println("");
        System.out.println("Task 3");
        System.out.println(findShort("bitcoin take over the world maybe who knows perhaps"));
        System.out.println(findShort("turns out random test cases are easier than writing out basic ones"));
        System.out.println(findShort("Let's travel abroad shall we"));
        System.out.println("");
        System.out.println("Task 4");
        System.out.println(seriesSum(5));
        System.out.println(seriesSum(9));
        System.out.println(seriesSum(15));
        System.out.println("");
        System.out.println("Task 5");
        System.out.println(camelCase("camelCasing"));
        System.out.println(camelCase("camelCasingTest"));
        System.out.println(camelCase("camelcasingtest"));
        System.out.println("");
        System.out.println("Task 6");
        System.out.println(spinWords("Welcome"));
        System.out.println(spinWords("Hey fellow warriors"));
        System.out.println("");
        System.out.println("Task 7");
        System.out.println(arrayPlusArray(new int[]{1,2,3}, new int[]{4,5,6}));
        System.out.println(arrayPlusArray(new int[]{-1,-2,-3}, new int[]{-4,-5,-6}));
        System.out.println(arrayPlusArray(new int[]{0,0,0}, new int[]{4,5,6}));
        System.out.println("");
        System.out.println("Task 8");
        System.out.println(Arrays.toString(sumParts(new int[] {0, 1, 3, 6, 10})));
        System.out.println(Arrays.toString(sumParts(new int[] {1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(sumParts(new int[] {744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358})));
        System.out.println("");
        System.out.println("Task 9");
        System.out.println(meeting("Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn"));
        System.out.println(meeting("Alex:Arno;Alissa:Cornwell;Sarah:Bell;Andrew:Dorries;Ann:Kern;Haley:Arno;Paul:Dorny;Madison:Kern"));
        System.out.println("");
        System.out.println("Task 10");
        System.out.println(find(new int[] {2, 6, 8, -10, 3}));
        System.out.println(find(new int[] {206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781}));
        System.out.println(find(new int[] {Integer.MAX_VALUE, 0, 1}));
    }
}