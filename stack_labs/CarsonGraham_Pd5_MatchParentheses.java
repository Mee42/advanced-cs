import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class MatchParentheses {
  public static void main(String[] args) {
    check("5+7");
    check("(5+7)");
    check(")5+7(");
    check("((5+7)*3)");
    check("[(5+7)*]3");
    check("<{5+7}*3>");
    check("(5+7)*3");
    check("5+(7*3)");
    check("((5+7)*3");
    check("[(5+7]*3)");
    check("[(5+7)*3])");
    check("([(5+7)*3]");
    check("[(((a)))]}");
    check("(a)a");
    check("(((");
  }
  static List<Pair<Character,Character>> pairs = new ArrayList<Pair<Character,Character>>() {{
    add(new Pair<>('(',')'));
    add(new Pair<>('[',']'));
    add(new Pair<>('<','>'));
    add(new Pair<>('{','}'));
  }};
  static void check(String in) {
    Deque<Character> stack = new ArrayDeque<>();
    for(int i = 0; i<in.length();i++) {
      char at = in.charAt(i);
      if (pairs.stream().anyMatch(pair -> pair.a == at)) {
        stack.push(pairs.stream().filter(pair -> pair.a == at).findFirst().get().b);
      } else if (pairs.stream().anyMatch(pair -> pair.b == at)) {
        if(stack.isEmpty()) {
          System.err.println("Error. No open bracket exists to close " + at + " at");
          System.err.println("    " + in);
          System.err.println("    " + repeat(' ', i) + "^\n");
          return;
        }
        char pop = stack.pop();
        if(at != pop) {
          System.err.println("Error. Looking for " + pop + " but found " + at + " at");
          System.err.println("    " + in);
          System.err.println("    " + repeat(' ', i) + "^\n");
          return;
        }
      }
    }
    if(!stack.isEmpty()) {
      System.err.println("Error. Reached end of line while parsing \"" + in + "\". Looking for " + stack.pop() + ".\n");
      return;
    }
    System.out.println("String \"" + in + "\" is a valid string");
  }
  static String repeat(char c, int i) {
    StringBuilder b = new StringBuilder();
    for(int x = 0;x<i;x++) {
      b.append(c);
    }
    return b.toString();
  }
}



class Pair<A,B> {
  final A a;
  final B b;

  Pair(A a, B b) {
    this.a = a;
    this.b = b;
  }
}
/*
/usr/lib/jvm/java-8-openjdk/bin/java -javaagent:/opt/intellij-idea-ultimate-edition/lib/idea_rt.jar=45685:/opt/intellij-idea-ultimate-edition/bin -Dfile.encoding=UTF-8 -classpath /usr/lib/jvm/java-8-openjdk/jre/lib/charsets.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/cldrdata.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/dnsns.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/jaccess.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/localedata.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/nashorn.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/sunec.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/sunjce_provider.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/sunpkcs11.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/zipfs.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/jce.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/jsse.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/management-agent.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/resources.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/rt.jar:/home/carson/school/cs/build/production/cs MatchParentheses
String "5+7" is a valid string
String "(5+7)" is a valid string
String "((5+7)*3)" is a valid string
String "[(5+7)*]3" is a valid string
String "<{5+7}*3>" is a valid string
String "(5+7)*3" is a valid string
String "5+(7*3)" is a valid string
String "(a)a" is a valid string
Error. No open bracket exists to close ) at
    )5+7(
    ^

Error. Reached end of line while parsing "((5+7)*3". Looking for ).

Error. Looking for ) but found ] at
    [(5+7]*3)
         ^

Error. No open bracket exists to close ) at
    [(5+7)*3])
             ^

Error. Reached end of line while parsing "([(5+7)*3]". Looking for ).

Error. No open bracket exists to close } at
    [(((a)))]}
             ^

Error. Reached end of line while parsing "(((". Looking for ).


Process finished with exit code 0

 */
