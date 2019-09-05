public class C1_19 {
  public static void main(String[] args) {
      System.out.println(f(2));
      System.out.println(f(20));
  }

  static int f(int input){ return f(input,0); }
  static int f(int input,int counter){
    if (input < 2){
        return counter;
    } else {
        return f(input/2,counter+1);
    }
  }
}
