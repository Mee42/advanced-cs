import java.util.Arrays;
import java.util.stream.Stream;

class R1_1 {
  public static void main(String[] args) {
      System.out.println(vowels("abcde"));
      System.out.println(vowels("aaaaa"));
      System.out.println(vowels("fffff"));
  }
  private static int vowels(String str){
      int counter = 0;
      for (char c : str.toCharArray()){
          if("aeiouy".contains("" + c)){
              counter++;
          }
      }
      return counter;
  }
}