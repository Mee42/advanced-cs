import java.util.ArrayList;
import java.util.List;

public class HeapQueue<E extends Comparable<E>> {
    public static void main(String[] args){
        HeapQueue<Integer> heap = new HeapQueue<Integer>();
        for(int i = 0; i < 10; i++){
            heap.add((int)(Math.random()*100));
        }
        System.out.println(heap + "\nremoved numbers:");
        while(!heap.isEmpty()) {
            int under = heap.remove();
            System.out.println(under + "   " + heap);

            for(int i = 0; i < 2; i++){
                int gen = (int)(Math.random()*100);
                if(gen > under - 5) heap.add(gen);
            } // dynamic add/removes
        }
    }
    private final List<E> array;
    public HeapQueue() {
        array = new ArrayList<E>();
        array.add(null);
    }
    public HeapQueue(int capacity) {
        array = new ArrayList<E>(capacity + 1);
        array.add(null);
    }
    public boolean isEmpty(){ return array.size() == 1; }
    public E peek(){
        return array.get(1);
    }
    public E remove(){
        // special case: there is a single element left
        if(array.size() == 2) return array.remove(1);

        // remove the last element
        E removed = array.remove(array.size() - 1);
        // swap it with the first element
        E first = array.get(1);
        array.set(1, removed);
        // now, balance the tree from the top down
        int set = 1;
        while(set < array.size()){
            E parent = array.get(set);
            E leftChild  = array.size() > set*2   ? array.get(set*2  ) : null;
            E rightChild = array.size() > set*2+1 ? array.get(set*2+1) : null;
            boolean parentBiggerThanLeft = leftChild == null ? false : parent.compareTo(leftChild) > 0;
            boolean parentBiggerThanRight = rightChild == null ? false : parent.compareTo(rightChild) > 0;
            if(parentBiggerThanLeft && parentBiggerThanRight){
                // which is bigger?
                boolean leftIsBigger = leftChild.compareTo(rightChild) > 0;
                // swap with the left child
                if(leftIsBigger) {
                    // swap the right one
                    array.set(set*2 + 1, parent);
                    array.set(set, rightChild);
                    set = set*2 + 1;
                } else {
                    array.set(set*2 , parent);
                    array.set(set, leftChild);
                    set = set*2;
                }
            } else if(parentBiggerThanLeft) {
                // left < parent < right
                // swap parent with left
                array.set(set*2 , parent);
                array.set(set, leftChild);
                set = set*2;
            } else if(parentBiggerThanRight) {
                array.set(set*2 + 1, parent);
                array.set(set, rightChild);
                set = set*2 + 1;
            } else {
                return first; // we good!
            }
        }
        
        return first;
    }
    public void add(E obj){
        array.add(obj);
        // bubble up
        int insertIndex = array.size() - 1;
        while(insertIndex >= 0){
            int parentIndex = insertIndex / 2;
            if(parentIndex == 0) return;
            if(array.get(parentIndex).compareTo(array.get(insertIndex)) <= 0){
                return;
            }
            // swap
            E parent = array.get(parentIndex);
            E sub    = array.get(insertIndex);
            array.set(parentIndex, sub);
            array.set(insertIndex, parent);
            insertIndex = parentIndex;
        }
    }
    public String toString(){
        StringBuilder b = new StringBuilder();
        b.append('[');
        for(int i = 1; i < array.size(); i++){
            if(i != 1) b.append(", ");
            b.append(array.get(i));
        }
        return b.append(']').toString();
    }
}