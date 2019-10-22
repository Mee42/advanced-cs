import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * name: Carson Graham
 * pd: 3
 * date: today
 *
 * notes:
 *
 *  doing this without mutability would be interesting...
 *
 */
class AreaFill {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.print("Filename: ");
         String filename = sc.next();
         char[][] grid = read(filename);
        display(grid);
        String doesUserWantToCont;
         do {
             System.out.print("\nEnter ROW COL to fill from: ");
             int row = sc.nextInt();
             int col = sc.nextInt(); sc.nextLine();// fix scanner
             System.out.print("fill char: ");
             char fillChar = sc.nextLine().charAt(0);
             fill(grid, row, col, fillChar,grid[row][col]);
             display(grid);
             System.out.print("Do you want to quit (q): ");
             doesUserWantToCont = sc.nextLine();
         }while(!doesUserWantToCont.equalsIgnoreCase("q"));
         sc.close();
    }

       private static char[][] read(String filename) {
         File file = new File(filename);
           Scanner in;
           try {
               in = new Scanner(file.toPath());
           } catch (IOException e) {
               throw new RuntimeException(e); // program should die when we can't read the file
           }
           char [] [] arr = new char [in.nextInt ()] [in.nextInt ()];
           in.nextLine (); // fix problems with the Scanner class
           for (int i = 0; i < arr.length; i++) {
               String line = in.nextLine();
               for (int j = 0; j < arr [i].length; j++) {
                   arr [i] [j] = line.charAt (j);
               }
           }
           return arr;
       }

       private static void display(char[][] arr) {
           for (char[] chars : arr) {
               for (char aChar : chars) {
                   System.out.print(aChar + " ");
               }
               System.out.println(); // newline
           }
      }
       private static void fill(char[][] arr, int r, int c, char fillChar, char filling) {
            if(r < 0 || r >= arr.length || c < 0 || c >= arr[0].length)
                return; // check bounds
            char currentlyAt = arr[r][c];
            if (currentlyAt == fillChar) {
                return; // character already filled
            }
            if(currentlyAt != filling){
                return; // not supposed to fill this char
            }
            arr[r][c] = fillChar;
            int[][] both = new int[][] { {-1,0},{1,0},{0,1},{0,-1}};
            for(int[] offsets : both){
                fill(arr,r + offsets[0],c + offsets[1],fillChar,filling);
            }
       }


}
