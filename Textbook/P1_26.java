import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1_26 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);//never use scanner, it auto-closes System.in
      List<String> strs = new ArrayList<>();
      while(in.hasNextLine()){
          String input = in.nextLine();
          if (input.isEmpty())  break;
          strs.add(0,input);//insert into front
      }
      for (String str : strs){
        System.out.println(str);
      }
  }
}
