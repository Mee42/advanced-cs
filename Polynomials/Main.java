public class Main {
	public static void main(String[] args){
      double [] c = {1, 0, 3, 4};
      double [] c1 = {-2, -5};
   
      Poly p1 = new ArrayBasedPoly(c);  // 4x^3 + 3x^2 + 1
      System.out.println("p1(x) =     " + p1);
   
      Poly p2 = new ArrayBasedPoly(c1);   // - 5x – 2
      System.out.println("p2(x) =     " + p2);                 // p2(x) = - 5x^1 – 2
   
      Poly p3   = new ArrayBasedPoly (-4,1);  // coeff = -4, exp = 1
      System.out.println("p3(x) =     " + p3);
   
      Poly p    = p1.plus(p2).plus(p2);   // 4x^3 + 3x^2 - 10x – 3
      System.out.println("p(x) =     " + p);       // p(x) = 4x^3 + 3x^2 - 10x^1 – 3
   
      Poly p4   = p.minus(p3);   // 4x^3 + 3x^2 - 6x^1 – 3   <====
      System.out.println("p4(x) =     " + p4);
   
   
      Poly p5   = p4.differentiate();   // 12x^2 + 6x^1 - 6   <====
      System.out.println("p5(x) =     " + p5);
      
        System.out.println ("p5(0) = " + p5.evaluate(0));
      System.out.println ("p5(1) = " + p5.evaluate(1));
      }
}

/*
p1(x) =     4.0x^3 + 3.0x^2 + 1.0
p2(x) =     -5.0x + -2.0
p3(x) =     -4.0x
p(x) =     4.0x^3 + 3.0x^2 + -10.0x + -3.0
p4(x) =     4.0x^3 + 3.0x^2 + -6.0x + -3.0
p5(x) =     12.0x^2 + 6.0x + -6.0
p5(0) = -6.0
p5(1) = 12.0
 */
