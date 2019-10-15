import java.util.stream.Stream;

public class Elfish {


    private static boolean isElfish(String str){
        return isXIsh(str,"elf"); // reuse code!
    }
    private static boolean isXIsh(String baseStr, String characters){
    return characters
        .chars()
        .mapToObj(i -> (char)i)
        .allMatch(charr -> baseStr.contains("" + charr));
    }

  public static void main(String[] args) {
    // this is the testing method
      assert_(isElfish("whiteleaf"));
      assert_(isElfish("tasteful"));
      assert_(isElfish("unfriendly"));
      assert_(isElfish("waffles"));
      assert_(!isElfish("no"));
      assert_(isElfish("fle"));
      assert_(!isElfish("hello"));

      assert_(isXIsh("abcdefg","caf"));
      assert_(!isXIsh("ohno","f"));
    System.out.println("passed all tests!");
  }
  private static void assert_(boolean tru){
      if(!tru){
          throw new AssertionError("boolean result was not true");
      }
  }
}
