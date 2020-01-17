import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;

/**
 * Name: Carson Graham Period: 5
 *
 * <p>Purpose of the Program: Learn about trees Date Submitted: tuesday
 *
 * <p>What I learned: trees are hard to do level-order for.
 * Trees are easier to deal with when complete and full
 * java standard librarie's Function class is bad (and so is the ordering class)
 *
 * <p>How I feel about this lab:
 * You can't compare Objects
 * Generics should have been used
 *
 * <p>What I wonder: Where are trees used? Credits: Students whom I helped: talked with kelsey a bit about the vagueness of the depth implementation
 */
class BinaryTree {
  public static void main(String[] args) {
    String s = "XCOMPUTERSCIENCE";

    TreeNode root = new TreeNode("" + s.charAt(1), null, null);

    // The root node has index 1
    // The second level nodes' indices: 2, 3
    // The third level nodes' indices: 4,5,6,7
    // Idea: based on the index of the node, log (pos) of base 2 calculates the level of the
    //          node: root (index 1) on level 1. Node with index 2 or 3 is on level 2
    for (int pos = 2; pos < s.length(); pos++)
      insert(root, "" + s.charAt(pos), pos, (int) (1 + Math.log(pos) / Math.log(2)));

    // NOTE: The following 3 lines are supposed to further show you how insert works. You
    //             uncomment them and see how the tree looks like with these 3 additional nodes
    // insert(root, "A", 17, 5);
    // insert(root, "B", 18, 5);
    // insert(root, "C", 37, 6); //B's right child

    // display the tree sideway; see the sample output at the end of this file
    display(root, 0);

    System.out.print("\nPreorder: ");
    preorderTraverse(root);
    System.out.print("\nInorder: ");
    inorderTraverse(root);
    System.out.print("\nPostorder: ");
    postorderTraverse(root);

    System.out.println("\n\nNodes = " + countNodes(root));
    System.out.println("Leaves = " + countLeaves(root));
    System.out.println(
        "Grandparents = " + countGrandParentNodes(root)); // count the number grandparent nodes
    System.out.println(
        "Only childs = "
            + countSingleChildNodes(root)); // count the number of nodes that has only 1 child

    // System.out.println("\nDepth = " + numOfLevels(root));
    System.out.println("Height = " + height(root));

    System.out.println("Min = " + min(root));
    System.out.println("Max = " + max(root));

    System.out.println("\nBy Level: ");
    displayLevelOrder(
        root); // level by level display of the nodes (starts from left to right for nodes on the
               // same level)
  } // end of main

  // insert a new node in the tree based on the node's level
  public static void insert(TreeNode t, String s, int pos, int level) {
    TreeNode p = t;
    for (int k = level - 2; k > 0; k--)
      //  then 1 << 4 will insert four 0-bits at the right of 1 (binary representation of 1 is 1.
      // 1 << 4 results in 10000 (in binary)
      if ((pos & (1 << k)) == 0)
        p =
            p
                .getLeft(); // What does this do? Answer this question first.  What does '&' do?
                            // Google it!!!!
      else //  We did not learn this in AP CS A!  :
      p = p.getRight(); // What does this do? Answer this question first.

    if ((pos & 1) == 0) p.setLeft(new TreeNode(s, null, null));
    else p.setRight(new TreeNode(s, null, null));
  } // end of insert

  /**
   * ***************************************************************************************************
   * postcondition: display the tree sideway
   * ***************************************************************************************************
   */
  public static void display(TreeNode t, int level) {
    if (t == null) return;
    display(t.getRight(), level + 1); // recurse right

    for (int k = 0; k < level; k++) System.out.print("\t");
    System.out.println(t.getValue());

    display(t.getLeft(), level + 1); // recurse left
  } // end of display

  public static void preorderTraverse(TreeNode t) { // C L R
      ifnn(t, null, () -> {
        System.out.print(t.getValue());
        preorderTraverse(t.getLeft());
        preorderTraverse(t.getRight());
        return null;
      });
  }

  public static void inorderTraverse(TreeNode t) {
    ifnn(t, null, () -> {
      inorderTraverse(t.getLeft());
      System.out.print(t.getValue());
        inorderTraverse(t.getRight());
        return null;
      });
  }

  public static void postorderTraverse(TreeNode t) {
        ifnn(t, null, () -> {
      postorderTraverse(t.getLeft());
          postorderTraverse(t.getRight());

          System.out.print(t.getValue());
        return null;
      });
  }

    @FunctionalInterface
    interface Producer<R> {
        R produce();
    }
    @FunctionalInterface
    interface Comparator<T> {
        int compare(T a, T b);
    }

    private static <T,A> T ifnn(A nullable, T default_, Producer<T> producer) {
      if(nullable == null) return default_;
      return producer.produce();
  }
  public static int countNodes(TreeNode t) {
    return ifnn(t,0, () -> countNodes(t.getLeft()) + countNodes(t.getRight()) + 1);
  }

  public static int countLeaves(TreeNode t) {
      return t.getLeft() == null ? 1 : countLeaves(t.getLeft()) + countLeaves(t.getRight());
  }

  public static int countGrandParentNodes(TreeNode t) {
      if(t.getLeft() == null || t.getLeft().getLeft() == null) return 0;
      if(t.getLeft().getLeft().getLeft() == null) return 1;
      return countGrandParentNodes(t.getLeft()) + countGrandParentNodes(t.getRight()) + 1;
  }

  public static int countSingleChildNodes(TreeNode t) {
    return 0; // this is a complete binary tree, there's no only childs? lol
  }
    private static String pickString(Comparator<String> compare,String...strs) {
      if(strs.length == 0) return null;
      String retur = strs[0];
      for(int i = 1; i < strs.length; i++) {
          if(strs[i] == null) continue;
          if(retur == null || compare.compare(retur, strs[i]) < 0) retur = strs[i];
      }
      return retur;
    }
  public static int height(TreeNode t) {
    return ifnn(t, 0, () -> 1 + height(t.getLeft()));
  }
  public static String min(TreeNode t) {
    return ifnn(t, null, () -> pickString(String::compareTo,(String)t.getValue(), min(t.getLeft()), min(t.getRight())));
  }
  public static String max(TreeNode t) {
      return ifnn(t, null, () -> pickString((a,b) -> -1 * a.compareTo(b), (String)t.getValue(), min(t.getLeft()), min(t.getRight())));

  }

  /**
   * ***************************************************************************************************
   * This method is not recursive. Hint: Use a local queue to store the children of the current
   * node.
   * ***************************************************************************************************
   */
  public static void displayLevelOrder(TreeNode t) {
      Queue<TreeNode> start = new ArrayDeque<>();
      start.offer(t);
      Queue<TreeNode> build = new ArrayDeque<>();

      while(!start.isEmpty()) {
          while(!start.isEmpty()) {
              TreeNode f = start.remove();
              System.out.print(f.getValue() + " ");
              if(f.getRight() != null) build.offer(f.getRight());
              if(f.getLeft() != null) build.offer(f.getLeft());
          }
          System.out.println();
          while(!build.isEmpty()) start.offer(build.remove());
      }

  }
} // end of TreeLab_shell

class TreeNode {
  private Object value;
  private TreeNode left, right;

  public TreeNode(Object initValue) {
    value = initValue;
    left = null;
    right = null;
  }

  public TreeNode(Object initValue, TreeNode initLeft, TreeNode initRight) {
    value = initValue;
    left = initLeft;
    right = initRight;
  }

  public Object getValue() {
    return value;
  }

  public TreeNode getLeft() {
    return left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setValue(Object theNewValue) {
    value = theNewValue;
  }

  public void setLeft(TreeNode theNewLeft) {
    left = theNewLeft;
  }

  public void setRight(TreeNode theNewRight) {
    right = theNewRight;
  }
}
/*

Nodes = 15
Leaves = 8
Grandparents = 3
Only childs = 0
Height = 4
Min = U
Max = C

By Level:
C
M O
E T U P
E C N E I C S R
 */