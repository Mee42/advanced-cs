import java.util.Scanner;   
class RecursionLab{
   //Pre: c is a lower case letter - Post: all lower case letters a-char c are printed 
   public static void letters(char c){
     if(c != 'a'){
       letters((char)((int)c - 1));
     }
     System.out.print(c);
     
   }
	//Pre: none - Post: returns number of times two can go into x
   public static int twos(int x)
   {
      if(x % 2 == 0){
        return twos(x/2) + 1;
      }
      return 0;
   }

   // given a number K
   // the only divisers of (3^K) are (3^(K-1)) and so on
   // so if we find the biggest K possible
   //   (which is calculatable by floor(log3(MAX_INT)))
   // then we can do this in O(1)
   //
   // 3 is a prime number. For any *set* of primes, their product is unique.
   //
   // Any power of 3 will factor out to only 3's, where as any other number will
   // factor out to other numbers and not divide evenly.
   //
   // 3^5 = 243
   // 3^3 = 27
   // 243 % 27 == 0
   // 
   //
   // insperation: https://leetcode.com/articles/power-of-three/
   //
   // recursion is the wrong solution to this problem
   //
   private static final int MASK = 1162261467;// 3^(floor(log3(MAX_INT))) 
	//Pre: none - Post: returns if x is a power of 3
   public static boolean powerof3(int x)
   {
      return x > 0 && MASK % x == 0;
   }
	//Pre: none - Post: returns String of x reversed
  public static String reverse(long x){
      if(x < 10) return "" + x;
      return x % 10 + reverse(x/10);
   }

	//Pre: x > 0 - Post: returns x in base 5
   public static String base5(int x){
     if(x < 5) return "" + x;
     return base5(x/5) + x%5;
   }
	// Pre: x > 0 - Post: returns x with commas
   public static String printWithCommas(long x){
     if(x < 1000) return "" + x;
     return printWithCommas(x / 1000) + "," + x % 1000;
   }
	
	
   public static void main(String []args)
   {
      Scanner scan = new Scanner (System.in);
      int choice;
      do
      {
         System.out.println("\n\n1)Letters"+
                           "\n2)Twos"+
                           "\n3)Power Of 3"+
                           "\n4)Reverse"+
                           "\n5)Base 5"+
                           "\n6)Print With Commas"+
                           "\n7)Exit");
         choice = scan.nextInt();
         if (choice == 1)
         {
            System.out.println("Enter a letter");
            char charA = scan.next().charAt(0);
            if (charA < 'a' || charA > 'z')
               System.out.println("That letter not valid");
            else
               letters(charA);
         }
         else if (choice == 2)
         {
            System.out.println("Enter a number");
            System.out.println(twos(scan.nextInt()));
         }
         else if (choice == 3)
         {
            System.out.println("Enter a number");
            System.out.println(powerof3(scan.nextInt()));
         }
         else if (choice == 4)
         {
            System.out.println("Enter a number");
            System.out.println(reverse(scan.nextLong()));
         }
         else if (choice == 5)
         {
            System.out.println("Enter a number");
            int number = scan.nextInt();
            if (number > 0)
               System.out.println(base5(number));
            else
               System.out.println("That number is not valid");
         }
         else if (choice == 6)
         {
            System.out.println("Enter a number");
            int number = scan.nextInt();
            if (number > 0)
               System.out.println(printWithCommas(number));
            else
               System.out.println("That number is not valid");
         }
      }while(choice != 7);
   }
}
