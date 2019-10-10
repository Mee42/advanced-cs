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



   public static boolean powerof3(int x)
   {
       if(x == 3){ // three is a power of three
           return true;
       }
       if(x % 3 != 0){ // if x is not divisible by three,
           return false;
       }
      if(x > 3){
          return powerof3(x/3);
      }
      return false;
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
