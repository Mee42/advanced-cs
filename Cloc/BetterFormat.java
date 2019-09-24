import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

//AUTHOR: Carson Graham
//src/BetterFormat.java
public class BetterFormat// converts any java file into the superior format - and outputs it to stdout
{
    // the `sponge` command can be used to properly overwrite a file
    // use it like this:

    // $ java BetterFormat src/BetterFormat.java | sponge src/BetterFormat.java

    // that should work... sponge will prevent read/write errors
  public static void main(String[] args)
  {
      File file;
      if (args.length > 1)// use the argument and don't pollute stdout/in if possible
      {
          file = new File(args[0]);
      } else
      {
        System.out.print("file:");
        file = new File(new Scanner(System.in).nextLine());
      }
      List<String> lines;
      try
      {
          lines = Files.readAllLines(file.toPath());
      } catch (IOException e)
      {
          System.err.println("Error reading file. Please try again\n\nDebug Information:");
          e.printStackTrace();
          System.exit(1);//error
          return;//remove error on line 42 - proves that `lines` is initialized
      }
      StringBuilder textBuilder = new StringBuilder();
      for (String line : lines)
      {
          textBuilder.append(line).append('\n');//because it spans multiple lines, we can't process it line by line
      }
      String text = textBuilder.toString();
      // when faced with a problem, a programmer decides to use regular expressions
      //        now he has 2 problems
      String newText = Pattern.compile("\n\\s*\\{\n").matcher(text).replaceAll(" {\n");
      // in all actuality it took me 10 minutes to figure out that java needs me to escape the '{' character
      // unlike any other regex parser
      //   oracle... I swear

      //here's the regex if you want the explanation:
      /*
        \n       : the newline character
        \s       : any whitespace (tab,spaces)
          *      : repeated zero or more times //this is for indentation
        \{       : the literal character '{'
        /n       : the newline character after the character



        try <newline
        { <the literal '{', then a newline
     ^indentation (whitespace)
        //code
        }
               */
      System.out.println(newText);// output it
  }
}
/*

 */