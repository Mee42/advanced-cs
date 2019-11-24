import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Author: Carson Graham Date: 2019-11-23 This code licensed under GPLv3.
 *
 * Notes:
 * - Streams are better then Iterators.
 * - I'm going to fail this next quiz because I've touched iterators once
 * - None of these methods need to be public.
 * - Don't put comments above imports
 * - Programmers who still use iterators are like programmers who still use Java 1.8.
 * - Java 1.8 was released in March 2014, about 6 years ago
 * - Java 1.8 lost commercial support in the middle of my freshmen year
 * - Java 1.8 lost support for personal use this month (according to wikipedia/Java_version_history)
 */
public class IteratorLab_shell {
  public static void main(String[] args) {
    System.out.println("Iterator Lab\n");
    int[] rawNumbers = {-9, 4, 2, 5, -10, 6, -4, 24, 20, -28};
    for (int n : rawNumbers) System.out.print(n + " ");
    ArrayList<Integer> numbers = createNumbers(rawNumbers);
    System.out.println("ArrayList: " + numbers); // Implicit Iterator!
    System.out.println("Count negative numbers: " + countNeg(numbers));
    System.out.println("Average: " + average(numbers));
    System.out.println("Replace negative numbers: " + replaceNeg(numbers));
    System.out.println("Delete zeros: " + deleteZero(numbers));
    String[] rawMovies = {
      "High_Noon",
      "High_Noon",
      "Star_Wars",
      "Tron",
      "Mary_Poppins",
      "Dr_No",
      "Dr_No",
      "Mary_Poppins",
      "High_Noon",
      "Tron"
    };
    ArrayList<String> movies = createMovies(rawMovies);
    System.out.println("Movies: " + movies);
    System.out.println("Movies: " + removeDupes(movies));
  }
  // pre: an array of just int values
  // post: return an ArrayList containing all the values
  private static ArrayList<Integer> createNumbers(int[] rawNumbers) {
    ArrayList<Integer> arr =
        new ArrayList<>(
            rawNumbers.length); // make sure we delegate enough memory so we don't resize
    for (int i : rawNumbers) arr.add(i);
    return arr;
  }
  // pre: an array of just Strings
  // post: return an ArrayList containing all the Strings
  private static ArrayList<String> createMovies(String[] rawWords) {
    return new ArrayList<>(Arrays.asList(rawWords));
  }

  // pre: ArrayList a is not empty and contains only Integer objects
  // post: return the number of negative values in the ArrayList a
  private static int countNeg(ArrayList<Integer> a) {
    return (int) a.stream().filter(i -> i < 0).count();
  }
  // pre: ArrayList a is not empty and contains only Integer objects
  // post: return the average of all values in the ArrayList a
  private static double average(ArrayList<Integer> a) {
    return a.stream().reduce(0, Integer::sum).doubleValue() / a.size();
  }
  // pre: ArrayList a is not empty and contains only Integer objects
  // post: replaces all negative values with 0
  private static ArrayList<Integer> replaceNeg(ArrayList<Integer> a) {
    a.replaceAll((x -> x < 0 ? 0 : x));
    return a;
  }
  // pre: ArrayList a is not empty and contains only Integer objects
  // post: deletes all zeros in the ArrayList a
  private static ArrayList<Integer> deleteZero(ArrayList<Integer> a) {
    while (a.contains(0)) a.remove(Integer.valueOf(0));
    return a;
  }
  // pre: ArrayList a is not empty and contains only String objects
  // post: return ArrayList without duplicate movie titles
  // strategy: start with an empty array and add movies as needed
  private static ArrayList<String> removeDupes(ArrayList<String> a) {
    return a.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
  }
}
