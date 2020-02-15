import java.util.Arrays;

public class HeapSort {
  public static void main(String[] args) {
      int[] array = new int[10];
      array[0] = -1;
      for(int i = 1; i < array.length; i++) {
          array[i] = (int)(Math.random() * 10);
      }
      System.out.println(Arrays.toString(array));
      heapSort(array);
      System.out.println(Arrays.toString(array));
  }
  private static void heapSort(int[] array){
      // heapsort is cool, so like

      // first: create a max-heap in the array by reheapDown'ing up the tree
      createMaxHeap(array);
  }
  private static void createMaxHeap(int[] array){
      for(int i = array.length/2; i >= 1; i--){
        reheapDown(array, i);
      }
  }
  private static void reheapDown(int[] array, int root){
      if(root > array.length) return;

      int parent = array[root];
      int leftChild  = root*2 < array.length   ? array[root*2  ] : -1;
      int rightChild = root*2+1 < array.length ? array[root*2+1] : -1;
      boolean parentBiggerThanLeft = leftChild != -1 && parent < leftChild;
      boolean parentBiggerThanRight = rightChild != -1 && parent < rightChild;
      if(parentBiggerThanLeft && parentBiggerThanRight){
          // which is bigger?
          boolean leftIsBigger = leftChild > rightChild;
          // swap with the left child
          if(leftIsBigger) {
              // swap the right one
              array[root*2 + 1] =  parent;
              array[root] = rightChild;
              reheapDown(array, root*2 + 1);
          } else {
              array[root*2] = parent;
              array[root] = leftChild;
              reheapDown(array, root*2);
          }
      } else if(parentBiggerThanLeft) {
          // left < parent < right
          // swap parent with left
          array[root*2] = parent;
          array[root] = leftChild;
          reheapDown(array, root*2);
      } else if(parentBiggerThanRight) {
          array[root*2 + 1] = parent;
          array[root] = rightChild;
          reheapDown(array,root*2 + 1);
      }
  }
}
