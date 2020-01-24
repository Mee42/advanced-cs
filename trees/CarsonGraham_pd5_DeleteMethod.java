  /*****************************************************************************************************************
NAME: Carson Graham      
PERIOD: 5
DUE DATE: today 

PURPOSE:   deletemethod 

WHAT I LEARNED:    
HOW I FEEL ABOUT THIS LAB:
            
CREDITS (BE SPECIFIC: FRIENDS, PEERS, ONLINE WEBSITES && what kind of 
         help did you get from the source?): 

****************************************************************************************************************/
import java.util.Scanner;
/****************************************************************
Practice with a Binary Search Tree. Uses TreeNode.
Step 1: Prompt the user for an input string.  
Step 2: Build a Binary Search Tree using Comparables.  
Step 3: Display it as a sideways tree (take the code from TreeLab).  
Step 4: Prompt the user for a target and delete that node, if it exists. 
*****************************************************************/
class BinarySearchTreeDelete_shell
{
   
   static class TreeNode {
	   TreeNode left;
	   TreeNode right;
	   String value;
	   public TreeNode(String value, TreeNode left, TreeNode right){
		   this.left = left;
		   this.right = right;
		   this.value = value;
	   }
   }
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Input string: ");
      String s = sc.nextLine();   // Use	ECSBPWANR
   	         				   							    
      TreeNode t = null;
      for(int x = 0; x<s.length(); x++)
         t = insert(t, s.substring(x, x+1));
      display(t, 0);
   
      while (true)
      {
         System.out.print("Delete? ");
         String target = sc.next();
         if( contains( t, target ) )
         {
            t = delete( t, target );
            System.out.println("\n" + target+" deleted.");
         }
         else
            System.out.println("\n" + target+" not found");
         display(t, 0);   
      }     
   }
   
	/**************************
	Recursive algorithm to build a BST:  if the node is null, insert the 
	new node.  Else, if the item is less, set the left node and recur to 
	the left.  Else, if the item is greater, set the right node and recur 
	to the right.   
	*****************************/
   public static TreeNode insert(TreeNode t, String s)
   {  	
      if(t==null)
         return new TreeNode(s,null,null);
      if(s.compareTo(t.value+"")<0)
         t.left = insert(t.left, s);
      else
         t.right = insert(t.right, s);
      return t;
   }
   public static void display(TreeNode t, int level)
   {
      if(t == null)
         return;
      display(t.right, level + 1); //recurse right
      for(int k = 0; k < level; k++)
         System.out.print("\t");
      System.out.println(t.value);
      display(t.left, level + 1); //recurse left
     
   }
   
   public static boolean contains( TreeNode current, String target )
   {
      while(current !=null)
      {
         int compare = target.compareTo(current.value);
         if( compare == 0 )
            return true;
         else if(compare<0)
            current = current.left;
         else if(compare>0)
            current = current.right;
      }
      return false;
   }
   public static TreeNode delete(TreeNode root, String target){
	   if(root == null) { System.out.println("null");return null; }
	   if(root.value.compareTo(target) > 0){
		   root.left = delete(root.left, target);
	   	return root;
	   } else if(root.value.compareTo(target) < 0){
		   root.right = delete(root.right,target);
	   	return root;
	   } else if(root.right == null){

		   return root.left;
           } else if (root.left == null){

		   return root.right;
	   } else {
		   root.value = getMax(root.left).value;
		   root.left = delete(root.left, root.value);
	
	   }
	   

       
      return root;  //never reached
   } // end of delete
   static TreeNode getMax(TreeNode root) {
	   if(root.right == null) return root;
	   return getMax(root.right);
   }
}  // end of class

/*  Sample Runs

 Input string: ECSBPWANR
 		W
 	S
 			R
 		P
 			N
 E
 	C
 		B
 			A
 Delete? A
 
 A deleted.
 		W
 	S
 			R
 		P
 			N
 E
 	C
 		B
 Delete? E
 
 E deleted.
 		W
 	S
 			R
 		P
 			N
 C
 	B
 Delete? S
 
 S deleted.
 		W
 	R
 		P
 			N
 C
 	B
 Delete? N
 
 N deleted.
 		W
 	R
 		P
 C
 	B
 Delete? 


*/
