import java.util.Scanner;   
public class RecursionLab
{
   //Pre: c is a lower case letter - Post: all lower case letters a-char c are printed 
   public static void letters(char c)
   {
   }
	//Pre: none - Post: returns number of times two can go into x
   public static int twos(int x)
   {
      return 0;
   }
	//Pre: none - Post: returns if x is a power of 3
   public static boolean powerof3(int x)
   {
      return false;
   }
	//Pre: none - Post: returns String of x reversed 
   public static String reverse(long x)
   {
      return null;
   }
	//Pre: x > 0 - Post: Prints x in base 5
   public static void base5(int x)
   {
   }
	// Pre: x > 0 - Post: Prints x with commas
   public static void printWithCommas(long x)
   {
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
               base5(number);
            else
               System.out.println("That number is not valid");
         }
         else if (choice == 6)
         {
            System.out.println("Enter a number");
            int number = scan.nextInt();
            if (number > 0)
               printWithCommas(number);
            else
               System.out.println("That number is not valid");
         }
      }while(choice != 7);
   }
}
