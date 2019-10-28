import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

/**
 * name: Carson
 * date: today
 *
 * notes:
 *
 * I don't prefer this style of coding.
 *
 * Back-tracking by unsetting works, and sometimes produces shorter code.
 * However, I don't like it. It's mutability. Mutability isn't good.
 *
 * immutable code is, most of the time, easier to write, maintain, and debug.
 *
 * Higher-level languages (Lisp, Haskell, etc) don't have mutability.
 * More modern languages (Kotlin, Scala, etc) attempt to decrease mutability but don't limit it completely.
 *
 * speaking of programming languages, I got sidetracked on this assigment by watching videos on APL.
 * for example, https://www.youtube.com/watch?v=a9xAKttWgP4. Game of life in 2 lines of code in APL.
 *
 *
 *
 * it also doesn't let you turn it into a all-solutions thing easily.
 * unless you want to have more mutability, of course.
 * and just try and multi-thread that. It's not going to work very well.
 *
 * ¯\_(ツ)_/¯. I can live with it
 *
 * this wasn't hard. There's a couple things that couple be improved, ei
 * - used enums instead of a char array (this might even save memory on a 8-bit machine)
 * - have an actual Maze object (done)
 * - have a better wrapper for solving it
 * - keep a direction and pass it to the thing
 * - do the thing better
 *
 */
class Maze {
    private static final char END = 'E';
    private static final char START = 'S';
    private static final char EMPTY = '.';
    private static final char TRAVELLED = '*';



    private char[][] arr;


    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
          System.out.print("File: ");
          Maze maze = readFile(new File(scan.nextLine()));
          System.out.println(maze);
          maze.solve();
          System.out.println(maze);
        }
    }

    private boolean solve(){
        int x = -1;
        int y = -1;
        for(int xx = 0;xx<arr.length;xx++){
            for(int yy = 0;yy<arr[xx].length;yy++){
                if(arr[xx][yy] == START){
                    x = xx;
                    y = yy;
                    break;
                }
            }
            if(x != -1) break;
        }
        return solve(x,y);
    }
    private int travelled(){
        int i = 0;
        for (char[] chars : arr) {
            for (char aChar : chars) {
                if (aChar == TRAVELLED) {
                    i++;
                }
            }
        }
        return i;
    }
    private boolean solve(int x,int y) {
        if(x < 0 || x >= arr.length || y < 0 || y >= arr[x].length)
            return false;

        char c = arr[x][y];
        if(c == END){
            return true;
        }
        boolean yes = c == EMPTY;
        if(yes || c == START){
            if(yes) arr[x][y] = TRAVELLED;
            boolean good = solve(x + 1,y) ||
                           solve(x - 1,y) ||
                           solve(x, y + 1) ||
                           solve(x,y - 1);
            if (good) return true;
            if(yes) arr[x][y] = EMPTY;
        }
        return false;
    }
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for (char[] chars : arr) {
            for (char c : chars) s.append(c).append(' ');
            s.append('\n');
        }
        return s.toString();
    }

    private Maze(char[][] arr) {
        this.arr = arr;
    }

    private static Maze readFile(File f){
        List<String> lines;
        try {
            lines = Files.readAllLines(f.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] size = lines.remove(0).split(" ");
        int xx = Integer.parseInt(size[0]);
        int yy = Integer.parseInt(size[1]);
        char[][] arr = new char[xx][yy];
        for(int x = 0;x<xx;x++){
            String line = lines.get(x);
            for(int y = 0;y<yy;y++){
                arr[x][y] = line.charAt(y);
            }
        }
        return new Maze(arr);
    }
}
/*
/usr/lib/jvm/java-8-openjdk/bin/java -javaagent:/opt/intellij-idea-ultimate-edition/lib/idea_rt.jar=38725:/opt/intellij-idea-ultimate-edition/bin -Dfile.encoding=UTF-8 -classpath /usr/lib/jvm/java-8-openjdk/jre/lib/charsets.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/cldrdata.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/dnsns.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/jaccess.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/localedata.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/nashorn.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/sunec.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/sunjce_provider.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/sunpkcs11.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/ext/zipfs.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/jce.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/jsse.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/management-agent.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/resources.jar:/usr/lib/jvm/java-8-openjdk/jre/lib/rt.jar:/home/carson/school/cs/build/production/cs Maze
File: maze1.txt
W W W W W W W W
W . . . . W . W
W W . W W . . W
W . . . . W . W
W . W . W W . E
S . W . W W . W
W W . . . . . W
W W W W W W W W

W W W W W W W W
W . . . . W . W
W W . W W . . W
W * * * . W . W
W * W * W W * E
S * W * W W * W
W W . * * * * W
W W W W W W W W

File: maze2.txt
W W W S W W W W W W
W . . . . W . W . W
W W W W . . . . . W
W . . . W . W W . W
W . W . . . . W . W
W E W W W W W W W W

W W W S W W W W W W
W . . * * W . W . W
W W W W * * . . . W
W * * * W * W W . W
W * W * * * . W . W
W E W W W W W W W W

File: maze3.txt
. . W W
W . . S
E . W W

. . W W
W * * S
E * W W

File:
Process finished with exit code 130 (interrupted by signal 2: SIGINT)

 */