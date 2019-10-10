import java.util.Scanner;


/**
 * name: Carson graham
 * notes:
 *
 * this wasn't that hard but many of these solutions are sub-optiomal because of their recursion requirement
 *
 * some things required some thought to come up with a solution but the actual solutions are not very hard
 *
 *
 * For example, the powerof3 method, which could be done with a single call to mod, is massivly inefficent
 */
class RecursionLab{

   //Pre: c is a lower case letter - Post: all lower case letters a-char c are printed 
   public static void letters(char c){
     if(c != 'a'){
       letters((char)((int)c - 1)); // recusion before printing for reversed
     }
     System.out.print(c);
     
   }
	//Pre: none - Post: returns number of times two can go into x
   public static int twos(int x)
   {
       if(x == 0) return 0;
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
  public static String reverse(long x){ // hmm
      if(x < 10) return "" + x;
      return x % 10 + reverse(x/10);
   }

	//Pre: x > 0 - Post: returns x in base 5
   public static String base5(int x){ // same thing as reverse except not reversed and base 5
     if(x < 5) return "" + x;
     return base5(x/5) + x%5;
   }
	// Pre: x > 0 - Post: returns x with commas
   public static String printWithCommas(long x){ // some contrys use commas as the decimal point and periods as the diveder
     if(x < 1000) return "" + x;
     return printWithCommas(x / 1000) + "," + x % 1000;
   }
	
	
   public static void main(String []args)
   {
      Scanner scan = new Scanner (System.in);
      int choice;
      do // this notation :(
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

/* test cases


1)Letters
2)Twos
3)Power Of 3
4)Reverse
5)Base 5
6)Print With Commas
7)Exit
1
Enter a letter
f
abcdef

1)Letters
2)Twos
3)Power Of 3
4)Reverse
5)Base 5
6)Print With Commas
7)Exit

2
Enter a number
888
3


1)Letters
2)Twos
3)Power Of 3
4)Reverse
5)Base 5
6)Print With Commas
7)Exit
3
Enter a number
5
false


1)Letters
2)Twos
3)Power Of 3
4)Reverse
5)Base 5
6)Print With Commas
7)Exit
3
Enter a number
27
true


1)Letters
2)Twos
3)Power Of 3
4)Reverse
5)Base 5
6)Print With Commas
7)Exit

4
Enter a number
1234567
7654321


1)Letters
2)Twos
3)Power Of 3
4)Reverse
5)Base 5
6)Print With Commas
7)Exit
5
Enter a number
32475
2014400


1)Letters
2)Twos
3)Power Of 3
4)Reverse
5)Base 5
6)Print With Commas
7)Exit

6
Enter a number
325
325


1)Letters
2)Twos
3)Power Of 3
4)Reverse
5)Base 5
6)Print With Commas
7)Exit
6
Enter a number
3247575
3,247,575


1)Letters
2)Twos
3)Power Of 3
4)Reverse
5)Base 5
6)Print With Commas
7)Exit
7

 */
