/*
Name: Carson 
Period: 5
Date: 2019-8-2


I decided to make it a imutable object because it is a number value.
this is a good design feature and is present in more modern math libraries.
It mimiks how primitives are pass-by-value and allows library calls to be done without
mutability issues to occur.

This also make all instances thread-safe,
leaving it up to the implementor to properly code threadsafety as values may change. 

This also means I can remove the getter methods and make num and demon "public final"
External code can not modify the values so it is safe.


How I feel:

I have no feelings about this lab.

Other languages like C++ and Kotlin would allow you to overload operators like + and - with custom implementation. Making code like

val ten = new RationalNum(5,1) + new RationalNum(10,2)

perfectly valid and very nice and neat.



 
*/

public class RationalNum {

   // private not needed for final variables
   final int num;
   final int denom;
	
	//Constructor method
	//Pre:
	//Post: sets instance variables
   public RationalNum(int num, int denom) {
      //simplifies the num and denom so that all RationalNum instances are always
      //simified THIS IS ONLY POSSIBLE BECAUSE RATIONAL NUM IS IMMUTABLE	   
      for(int i = Math.min(num,denom);i >= 2;i--){
	     while (num % i == 0 && denom % i == 0){
		     num = num / i;
	     denom = denom / i;
	     }
      }
      
      this.num = num;
      this.denom = denom;
   }
	
	//copy constructor
	//Pre: copy is not null
	//Post: creates a copy of copy param
   public RationalNum(RationalNum copy) // useless with imutable objects
   {
      this.num = copy.num;
      this.denom = copy.denom;
      
   }
	
	//Pre:  other is defined correctly
   
	//Post: adds both RationalNums and returns that RationalNum
   public RationalNum add(RationalNum other) 
   {
        return new RationalNum(this.num * other.denom + other.num * this.denom,this.denom * other.denom);  
   	
   }
	
	//Pre:  other is defined correctly
	//Post: subtracts both RationalNums and returns that RationalNum
   public RationalNum subtract(RationalNum other) 
   {
   	return this.add(other.negative());
   }
   public RationalNum negative(){
        return new RationalNum(this.num * -1,this.denom);
   }
	
	//Pre:  other is defined correctly
	//Post: multiples both RationalNums and returns that RationalNum
   public RationalNum multiply(RationalNum other) 
   {
    	return new RationalNum(this.num * other.num,this.denom * other.denom);
   }
	
	//Pre:  other is defined correctly and has nonzero numerator
	//Post: divides both RationalNums and returns that RationalNum
   public RationalNum divide(RationalNum other)
   {
   	return new RationalNum(this.num * other.denom,this.denom * other.num);
   
   }
	
	//Pre:  both RationalNums are defined correctly
	//Post: returns whether this is the same as param
   public boolean equals(RationalNum other) 
   {
        // because fractions are simplified on construct, this does not need to simpify
	return this.num == other.num && this.denom == other.denom;
   }
	
	//toString method
	//returns a String representing a RationalNum
   public String toString() 
   {
      return this.num + "/" + this.denom;
   }
	
   public static void main(String [] args) {
      RationalNum r1 = new RationalNum(52, 36);
      System.out.println("r1 = " + r1);
      RationalNum r2 = new RationalNum(7, 14);
      System.out.println("r2 = " + r2 + "\n");
      System.out.println("r1 + r2: " + r1.add(r2));
      System.out.println("r1 - r2: " + r1.subtract(r2));
      System.out.println("r1 * r2: " + r1.multiply(r2));
      System.out.println("r1 / r2: " + r1.divide(r2));
      System.out.println("r1 equals r2: " + r1.equals(r2));
   	
   }
}

