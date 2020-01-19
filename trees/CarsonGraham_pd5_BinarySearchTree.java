/*
 * ***************************************************************************************************************
 * NAME: Carson Graham PERIOD: 5 DUE DATE: Wednesday
 *
 * <p>PURPOSE: To write a binary search tree, an unordered collection with O(log n) insert, retrieval, and remove time complexity
 *
 * <p>WHAT I LEARNED: serializing the BST was interesting, I could probably have just dumped the in-order into a file and reconstructed it later
 * but that would have been slower, probably O(n log n). My algorithm is O(n) n being # of nodes.
 * However, it would have a nice in terms in storage usage.
 *
 * The challange said "seralize to a file" but reading/writting text to a file is
 * A) trivial
 * B) going to be all buffered anyway so there's no performance boost for iterating over bytes without holding everything in memory
 * C) harder to test (or, just more annoying)
 * D) leads to code integration where there should be seperation
 * etc;
 * You can save the string and read it from the file if you want to.
 *
 * <p>HOW I FEEL ABOUT THIS LAB: Pretty easy, getting left and right mixed up was annoying though
 *
 * <p>CREDITS (BE SPECIFIC: FRIENDS, PEERS, ONLINE WEBSITE):
 *  Talked with Kelsey about what exactly the smallestToLargest method does
 *  My experience with json lead me to use brackets {} in the seralized output, but I also used custom deliminators so it's not that similar
 *   (in the real world, I would just write to json and then read from json, which would do a single iteration over the string to build it in a good parser)
 *
 *
 * <p>**************************************************************************************************************
 */


/**
 * ************************************************************** Practice with a Binary Search
 * Tree. Uses TreeNode. Prompt the user for an input string. Build a Binary Search Tree using
 * Comparables. Display it as a sideways tree (take the code from the Tree Lab). Prompt the user for
 * a target and search the tree for it. Display the tree's minimum and maximum values. Print the
 * data in order from smallest to largest.
 * ***************************************************************
 */
class BinarySearchTree {
  public static void main(String[] args) {
    runTestSuite("AMERICAN", "X");
    System.out.print("\n\n\n\n\n\n\n\n\n");
    runTestSuite("MAENIRAC", "I");
  }
  static void runTestSuite(String str, String search) {
      TreeNode<String> root = null;
      for(char c : str.toCharArray()) {
          root = insert(root, "" + c);
      }
      display(root);
      System.out.println("Searching for " + search + ", " + (exists(root, search) ? "Found it!" : "Does not exist"));
      System.out.println("Min: "+ min(root));
      System.out.println("Max: " + max(root));
      System.out.println("In Order:");
      smallToLarge(root);
      String out = serialize(root);
      System.out.println("Serialized: " + out);
      System.out.println("Deserialized:");
      display(fromString(out));
  }


  // everything in the left tree is smaller or equal, everything in the right tree is bigger
  /**
   * ************************************************************** Recursive algorithm to build a
   * BST: if the node is null, insert the new node. Else, if the item is less, set the left node and
   * recur to the left. Else, if the item is greater, set the right node and recur to the right.
   * ***************************************************************
   */
  public static <T extends Comparable<T>> TreeNode<T> insert(TreeNode<T> t, T s) {
    if(t == null) return new TreeNode<>(s);
    if(s.compareTo(t.getValue()) <= 0) {// if(s <= t) it goes on the left tree
        t.setLeft(insert(t.getLeft(), s));
    } else {
        t.setRight(insert(t.getRight(), s));
    }
    return t;
  }
    public static <T> void display(TreeNode<T> t) { display(t, 0); }
  public static <T> void display(TreeNode<T> t, int level) {
    if (t == null) return;

    display(t.getRight(), level + 1); // recurse right

    for (int k = 0; k < level; k++) System.out.print("\t");
    System.out.println(t.getValue());

    display(t.getLeft(), level + 1); // recurse left
  }

  /**
   * ************************************************************* Iterative algorithm: create a
   * temporary pointer p at the root. While p is not null, if the p's value equals the target,
   * return true. If the target is less than the p's value, go left, otherwise go right. If the
   * target is not found, return false.
   *
   * <p>Find the target. Recursive algorithm: If the tree is empty, return false. If the target is
   * less than the current node value, return the left subtree. If the target is greater, return the
   * right subtree. Otherwise, return true. .
   * ***************************************************************
   */
  public static <T> boolean exists(TreeNode<T> t, T value) {
    return t != null && (t.getValue().equals(value) || exists(t.getLeft(), value) || exists(t.getRight(), value));
  }

  /**
   * ************************************************************* starting at the root, return the
   * min value in the BST. Use iteration. Hint: look at several BSTs. Where are the min values
   * always located? *************************************************************
   */
  public static <T extends Comparable<T>> T min(TreeNode<T> t) {
    if(t == null) return null;
    if(t.getLeft() != null) return min(t.getLeft());
    return t.getValue();
    // java, sigh, so verbose. Null-operators are part of any modern language with nullable values
      // t?.left?.apply(min) ?: t.value

  }
  /**
   * *************************************************************** starting at the root, return
   * the max value in the BST. Use recursion!
   * ***************************************************************
   */
  public static <T extends Comparable<T>> T max(TreeNode<T> t) {
    if(t == null) return null;
    if(t.getRight() != null) return max(t.getRight());
    return t.getValue();
  }

  public static <T> void smallToLarge(TreeNode<T> t) {
      if(t == null) return; // just handle the end case here, cleans up this java code
      smallToLarge(t.getLeft());
      System.out.print(t.getValue() + " ");
      smallToLarge(t.getRight());
  }

  // serialization code
  public static String serialize(TreeNode<String> root) {
      // (poor implementation of) JSON TIME!
      // edit: no longer json
      if(root == null) {
          return "null";
      }
      return "{" + root.getValue()/*todo: only works on alphabetical characters*/ +
              ":" + serialize(root.getLeft()) + "," +  serialize(root.getRight()) + "}";
  }
  public static TreeNode<String> fromString(String str) {
      if(str.equals("null")) {
          return null;
      }
      String withoutBrackets = str.substring(1, str.length() - 1);
      // take up to the first ':' and use that as the value
      String[] split = withoutBrackets.split(":", 2);
      String value = split[0];
      String leftAndRight = split[1];
      // okay let's find the first comma that's NOT inside brackets
      int brackets = 0;
      int i = 0;
      for(;;i++){
          // we assume well-formed input, so we should never need to worry about hitting indexoutofbounds
          if(leftAndRight.charAt(i) == '{') brackets++;
          if(leftAndRight.charAt(i) == '}') brackets--;
          if(leftAndRight.charAt(i) == ',' && brackets == 0) break;
      }
      String left = leftAndRight.substring(0, i);
      String right = leftAndRight.substring(i + 1);
      return new TreeNode<String>(value, fromString(left), fromString(right));
  }
} // end of class

/* TreeNode class for the AP Exams */

class TreeNode<T> {
  private T value;
  private TreeNode<T> left, right;

  public TreeNode(T initValue) {
    value = initValue;
    left = null;
    right = null;
  }

  public TreeNode(T initValue, TreeNode<T> initLeft, TreeNode<T> initRight) {
    value = initValue;
    left = initLeft;
    right = initRight;
  }

  public T getValue() {
    return value;
  }

  public TreeNode<T> getLeft() {
    return left;
  }

  public TreeNode<T> getRight() {
    return right;
  }

  public void setValue(T theNewValue) {
    value = theNewValue;
  }

  public void setLeft(TreeNode<T> theNewLeft) {
    left = theNewLeft;
  }

  public void setRight(TreeNode<T> theNewRight) {
    right = theNewRight;
  }
}
/*
		R
			N
	M
			I
		E
			C
A
	A
Searching for X, Does not exist
Min: A
Max: R
In Order:
A A C E I M N R Serialized: {A:{A:null,null},{M:{E:{C:null,null},{I:null,null}},{R:{N:null,null},null}}}
Deserialized:
		R
			N
	M
			I
		E
			C
A
	A









		R
	N
M
			I
		E
			C
	A
		A
Searching for I, Found it!
Min: A
Max: R
In Order:
A A C E I M N R Serialized: {M:{A:{A:null,null},{E:{C:null,null},{I:null,null}}},{N:null,{R:null,null}}}
Deserialized:
		R
	N
M
			I
		E
			C
	A
		A
 */