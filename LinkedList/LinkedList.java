class LinkedList<T> {
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
	public static Node<T> add(Node<T> head, T element){
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


	public boolean hasTwo(Node<T> head){
		return head != null && head.next != null;
	}
	public int size(Node<T> head){
		int size = 0;
		while(head != null){
			size++;
			head = head.next;
		}
		return size;
	}
	public Node<T> removeFirst(Node<T> head){
		return remove(0);
	}
	public Node<T> removeLast(Node<T> head){
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

	public Node<T> reverse(Node<T> head){
		Node<T> newHead = null;
		Node<T> pointer = head;
		while(pointer != null){
			newTail= new Node(pointer.value,newTail);
			pointer = pointer.next;
		}
		return newHead;
	}
	public Node<T> rotate(){
		throw new AssertionError();
	}
	public T getMiddleNode(){
		throw new AssertionError();
	}
	public Pair<LinkedList,LinkedList> split(){
		throw new AssertionError();
	}




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
   
	public static void main(String[] args){
		ListNode<Integer> h = new ListNode <>(5, null);
		h = new ListNode(4, h);
		h = new ListNode(3, h);
		h = new ListNode(2, h);
		h = new ListNode(1, h);

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
				h = reverseList(h);
				System.out.println("Reverse is: ");
				printLinkedList(h);
			} else if (option == 'g') {
				h = rotate(h);         // rotate the list clockwise
				System.out.println("rotated array is: ");
				printLinkedList(h);
			} else if (option == 'h') {
				printLinkedList(h);
				System.out.println("\nmiddle node is: " + middleNode(h).getValue());
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
				split(h);
			}

		} while (option != 'z');
	}


}
