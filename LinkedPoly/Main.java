public class Main {
	public static void main(String[] args){
      double [] c = {1, 0, 3, 4};
      double [] c1 = {-2, -5};
   
      Poly p1 = new LinkedPoly(c);  // 4x^3 + 3x^2 + 1
      System.out.println("p1(x) =     " + p1);
   
      Poly p2 = new LinkedPoly(c1);   // - 5x – 2
      System.out.println("p2(x) =     " + p2);                 // p2(x) = - 5x^1 – 2
   
      Poly p3   = new LinkedPoly (-4,1);  // coeff = -4, exp = 1
      System.out.println("p3(x) =     " + p3);
   
      Poly p    = p1.plus(p2).plus(p2);   // 4x^3 + 3x^2 - 10x – 3
      System.out.println("p(x) =     " + p);       // p(x) = 4x^3 + 3x^2 - 10x^1 – 3
   
      Poly p4   = p.minus(p3);   // 4x^3 + 3x^2 - 6x^1 – 3   <====
      System.out.println("p4(x) =     " + p4);
   
   
      Poly p5   = p4.differentiate();   // 12x^2 + 6x^1 - 6   <====
      System.out.println("p5(x) =     " + p5);
      
        System.out.println ("p5(0) = " + p5.evaluate(0));
      System.out.println ("p5(1) = " + p5.evaluate(1));
      secondMain();
  }
  static void secondMain(){
          double[] arr = {4,3,3,2,1,0};
          Poly p1 = new LinkedPoly(arr);  // 4x^3 + 3x^2 + 1
          System.out.println("p1(x) =     " + p1);
                         
          double[] arr2 = {-5,1,-2,0};
          Poly p2 = new LinkedPoly(arr2);   // - 5x – 2
          System.out.println("p2(x) =     " + p2);                 // p2(x) = - 5x^1 – 2
          System.out.println("p1 and p2 are the same: " + p1.equals(p2));
                                                    
          double[] arr3 = {-4,1};
          Poly p3   = new LinkedPoly(arr3);  // coeff, exp = -4x
          System.out.println("p3(x) =     " + p3);
                                                                   
          Poly p    = p1.plus(p2).plus(p2);   // 4x^3 + 3x^2 - 10x – 3
          System.out.println("p(x)  =     " + p);       // p(x) = 4x^3 + 3x^2 - 10x^1 – 3
          
          Poly p4   = p.minus(p3);   // 4x^3 + 3x^2 - 6x^1 – 3   <====
          System.out.println("p4(x) =     " + p4);
                                                                                           
          Poly p5   = p4.differentiate();   // 12x^2 + 6x^1 - 6   <====
          System.out.println("p5(x) =     " + p5);
                                                                                                                
          Poly clone = new LinkedPoly((LinkedPoly)p5);
          System.out.println("clone(x) =     " + clone);
          System.out.println("p5 and clone are the same: " + p5.equals(clone));
                                                                                                                            
          Poly clone2 = p5;
          System.out.println("clone2(x) =    " + clone2);
          System.out.println("p5 and clone 2 are the same: " + p5.equals(clone2));
          Poly product = p1.multiply (p2);
          System.out.println("product of p1(x) and p2(x) is     " + product);
          System.out.println ("p5(0) = " + p5.evaluate(0));
          System.out.println ("p5(1) = " + p5.evaluate(1));
  }
}
