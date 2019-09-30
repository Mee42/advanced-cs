/***********************************************************************************************************************************************
 * Name:   Carson             
 * Period: 5
 * Name of the Lab: DoublyLinkedList
 * Purpose of the Program: To write implementation of a DLL and learn how it works
  * Due Date: 9/29
 * Date Submitted: 9/30
 * What I learned: 
 * 1.
 * 2.
 * ... 
 * How I feel about this lab: 
 * What I wonder: 
 * Student(s) who helped me (to what extent):  
 * Student(s) whom I helped (to what extent):
 *************************************************************************************************************************************************/
class DLL <E>
{
   // private static nested class
   private class DLNode <E>
   {
      private E value;
      private DLNode prev;
      private DLNode next;
      public DLNode(E arg, DLNode <E> p, DLNode <E> n)
      {
         value=arg;
         prev=p;
         next=n;
      }
      public DLNode()
      {
         value=null;
         next=this;
         prev=this;
      }
      public void setValue(E arg)
      {
         value=arg;
      }
      public void setNext(DLNode <E> arg)
      {
         next=arg;
      }
      public void setPrev(DLNode <E> arg)
      {
         prev=arg;
      }
      public DLNode <E> getNext()
      {
         return next;
      }
      public DLNode <E> getPrev()
      {
         return prev;
      }
      public E getValue()
      {
         return value;
      }
   }  // end of DLNode
   
   //*********************************************************************************************  DLL class

   private int size = 0;
   private DLNode <E> head = null;
   
   public int size()
   {
      return size;
   }
   /* appends obj to end of list; increases size;
     @return true  */
   public boolean add(E obj){
      addLast(obj);
      return true; // I guess this just returns true? why return anything?
   }
   /* inserts obj at position index.  increments size. 
   	*/
   public void add(int index, E obj)
   { 
       DLNode<E> a = getAt(index - 1);
       DLNode<E> ne = new DLNode<E>(obj,a,a.getNext());
       if(a.getNext() != null)
           a.getNext().setPrev(ne);
       a.setNext(ne);
       size++;
   }

   private DLNode<E> getAt(int index){
       DLNode<E> p = head;
       for(int i = 0;i<index;i++) p = p.getNext();
       return p; 
   }
   /* return obj at position index.  
   	*/
   public E get(int index)
   {
      return getAt(index).getValue();
   }
   /* replaces obj at position index.  
   	*/
   public void set(int index, E obj)
   {
       getAt(index).setValue(obj);
   }
   /*  removes the node from position index.  decrements size.
     @return the object at position index.
    */
   public E remove(int index)
   {
      DLNode<E> t = getAt(index);
      t.getPrev().setNext(t.getNext());
      size--;
      return t.getValue();
   }
   /* inserts obj at front of list; increases size;
     */
   public void addFirst(E obj){
      head = new DLNode<E>(obj,null,head);
      size++;
   }
   /* appends obj to end of list; increases size;
       */
   public void addLast(E obj){ 
        size++;
        if(head == null){
             head = new DLNode<E>(obj,null,null);
             return;
        }
        DLNode<E> last = getAtLast();
        last.setNext(new DLNode<E>(obj,last,null));
   }
   public E getFirst()
   {
      return get(0);
   }
   private DLNode<E> getAtLast(){
      DLNode<E> trail = head;
      while(trail.getNext() != null){
          trail = trail.getNext();
      }
      return trail;
   }
   public E getLast()
   {
      return getAtLast().getValue();
   }
   public E removeFirst()
   {
      E v = head.getValue();
      head = head.getNext();
      head.setPrev(null);
      size--;
      return v;
   }
   public E removeLast()
   {
      DLNode<E> last = getAtLast();
      if(last == null){
          return null;
      }
      size--;
      if(last.getPrev() == null){
          head = null;
      } else {
          last.getPrev().setNext(null);
      }
      return last.getValue();
   }
   public String toString()
   {
      String s = "";
      DLNode<E> f = head;
      while(f != null){
          s += "(" + f.getValue() + ")";
          if(f.getNext() != null) s += " -> ";
          f = f.getNext();
      }
      return s;
   }



   public static void main(String args[])
   {
      DLL <String> list = new DLL <String> ();	
      list.addLast("Apple");
      list.addLast("Banana");
      list.addLast("Cucumber");
      list.add("Dumpling");
      list.add("Escargot");
      System.out.println(list);
      System.out.println("Size: " + list.size());
      Object obj = list.remove(3);
      System.out.println(list);
      System.out.println("Size: " +list.size());
      System.out.println("Removed "+ obj);
      System.out.print("Add at 3:   ");
      list.add(3,"Cheese");
      System.out.println(list);
      System.out.println("Get values at 1 and first: " + list.get(1)+" and " + list.getFirst());
      System.out.println("No change: " +list);
      System.out.println( list.removeFirst() + " is now removed!"); 
      System.out.println(list);
      System.out.print("Add first:  ");
      list.addFirst("Anchovie");
      System.out.println(list);
      System.out.println("Size: " + list.size());
      System.out.print("Set the second:  ");
      list.set(2, "Rread");
      System.out.println(list);
   }
}


