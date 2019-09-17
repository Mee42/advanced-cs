import java.util.Scanner;


// I do not use a public class for several reasons.
// first is because it is not going to be used in other places
// it is used only in the driver method, which is in the same package as this class
// so it is okay and encouraged to keep package-private
// it's also nice because it mean's the java compiler doesn't enforce the file-name-eq-class-name
// convention. This let's me have Pd5_CarsonGrahamSinglyLinkedListOne.java
// and have a reasonable class name
//
//
//
// author: Carson Graham, pd 5
// date: 2019-9-something
// other notes:
//
// this could be done recursivly
// which would be fun
// 
//
// I also dislike the mutating of data in memory and then returning an address 
// that may or may not point to a different location.
// I much prefer to use a wrapper class LinkedList<T>. 
//
// It's better OOP as well because it can encapsulate the nodes and extend the List interface  
class LinkedListOne {
	// node class has non-private members because set and get methods
	// are unnessessary and add overhead to the function. It also makes it more readable,
	// in my opinion
	static class Node<T> {
		Node<T> next;
		T value;
		Node(Node<T> next,T value){
			this.next = next;
			this.value = value;
		}
		Node(T value){
			this(null,value);
		}
	}
	// null is considered an empty list >.>
	public static <T> Node<T> add(Node<T> head, T element){
		//insert at the end of the list
		if(head == null){
			return new Node<T>(element);
			//edge case
		}
		Node<T> current = head;
		while(true){
			if(current.next == null){
				current.next = new Node<T>(element);
				return head;
			}
			current = current.next;// 100% not null
		}
	}

	public static <T> boolean hasTwo(Node<T> head){
		return head != null && head.next != null;
	}
	public static <T> int size(Node<T> head){
		int size = 0;
		while(head != null){
			size++;
			head = head.next;
		}
		return size;
	}
	static <T> Node<T> remove(Node<T> head,T element){
		if(head == null)
			return null;
		if(head.value.equals(element)){
			return head.next;
		}
		Node<T> actualHead = head;
		Node<T> last = head;
		while(head != null){
			if(head.value.equals(element)){
				last.next = head.next;
				return actualHead;
			}
			last = head;
			head = head.next;
		}
		return actualHead; // could not find it?
	}
	public static <T> Node<T> removeFirst(Node<T> head){
		if(head == null)
			return null;
		return head.next;
	
	}
	// don't use remove(size(head),head) because that would interate twice
	public static <T> Node<T> removeLast(Node<T> head){
		Node<T> last = head;
		if(last == null){
			return null; // there is zero elements
		}
		if(last.next == null){
			return null; // there is one element, remove for zero
		}
		while(last.next.next != null){
			last = last.next;
		}
		last.next = null;
		return head;
	}
	// traverse using a trailing head
	public static <T> Node<T> reverse(Node<T> head){
		Node<T> newHead = null;
		Node<T> pointer = head;
		while(pointer != null){
			newHead= new Node(newHead,pointer.value);
			pointer = pointer.next;
		}
		return newHead;
	}
	//
	public static <T> Node<T> rotate(Node<T> head){
		if(head == null)
			return null;
		
		Node<T> last = head;
		while(last.next != null)
			last = last.next;
		last.next = head;
		Node<T> secondToLast = head.next;
		head.next = null;
		return secondToLast;
	}
	// interate through the array with two interators
	// the second one iterates one element and the first interates 2 elements at a time
	// when the first reatches the ned
	// the second is in the middle
	//
	// yay!
	public static <T> Node<T> middleNode(Node<T> head){
		Node<T> trailing = head;
		while(head != null && head.next != null){
			trailing = trailing.next;
			head = head.next.next;
		}
		return trailing;

	}
	// uses tho middleNode method to make better code.
	//
	public static <T> Node<T> split(Node<T> head){
		if(head == null){
			printLinkedList(null);
			return null;
		}
		if(head.next == null){
			printLinkedList(null);
			return head;
		}
		if(head.next.next == null){
			printLinkedList(head.next);
			head.next = null;
			return head;
		}
		Node<T> middle = middleNode(head);
		Node<T> startOfSecond = middle.next;
		middle.next = null;
		printLinkedList(startOfSecond);
		return head;
	}



	// Scanner is a horrible class;
	// It automaticly closes the input stream when you close the scanner
	// this means that you have two options
	// - create a single static scanner from a single static input source (System.in)
   	// or
	// - never close a scanner object (bad!)
	static Scanner input = new Scanner(System.in);


    	public static char menu() {
		System.out.println("\n====> What would you like to do?");
		System.out.println("a) Print list");
		System.out.println("b) Check if list has at least two nodes");
		System.out.println("c) Get size of the list");
		System.out.println("d) Remove first node");
		System.out.println("e) Add a node");
		System.out.println("f) Reverse");
		System.out.println("g) Rotate");
		System.out.println("h) Get middle node");
		System.out.println("i) Remove last node");
		System.out.println("j) Remove node with value");
		System.out.println("k) Split List");
		System.out.println("z) Quit?");
		String choice = input.next();
		return choice.charAt(0);
    	} // end of menu
  
	static <T> void printLinkedList(Node<T> head){
		if(head == null){
			System.out.println("[]");
			return;
		}
		String str = "";
		while(head != null){
			str += "," + head.value;
			head = head.next;
		}
		String s = "[" + str.substring(1) + "]";
		System.out.println(s);
	}

	public static void main(String[] args){
		Node<Integer> h = new Node<Integer>(null,5);
		h = new Node<Integer>(h,4);
		h = new Node<Integer>(h,3);
		h = new Node<Integer>(h,2);
		h = new Node<Integer>(h,1);

		char option;
		do {
			option = menu();
			if (option == 'a') {
				System.out.println("list: ");
				printLinkedList(h);
			} else if (option == 'b') {
				System.out.println("The List has atleast two element?");
				System.out.println(hasTwo(h));
			} else if (option == 'c') {
				System.out.print("The size of the array is: ");
				System.out.println(size(h));
			} else if (option == 'd') {
				h = removeFirst(h);
				System.out.print("New list is: ");
				printLinkedList(h);
			} else if (option == 'e') {
				System.out.println("Enter the number to be inserted at the end: ");

				h = add(h, input.nextInt());
				System.out.println("New list is: ");
				printLinkedList(h);
			} else if (option == 'f') {
				h = reverse(h);
				System.out.println("Reverse is: ");
				printLinkedList(h);
			} else if (option == 'g') {
				h = rotate(h);         // rotate the list clockwise
				System.out.println("rotated array is: ");
				printLinkedList(h);
			} else if (option == 'h') {
				printLinkedList(h);
				System.out.println("\nmiddle node is: " + middleNode(h).value);
			}

			else if (option == 'i') {
				h = removeLast(h);
				System.out.println("New list is: ");
				printLinkedList(h);
			}

			else if (option == 'j') {
				System.out.println("Please enter the value you want to remove");
				int v = input.nextInt();
				h = remove(h, v);
				System.out.println("New list is: ");
				printLinkedList(h);
			}

			else if (option == 'k') {
				h = split(h);
				System.out.print("New list it: ");
				printLinkedList(h);
			}

		} while (option != 'z');
	}


}
