public class Deque<T> {
	public static void main(String[] args) {
		Deque<String> d = new Deque<>();
		for(int i = 0; i <= 5; i++) {
			d.addLast("" + i);
			System.out.println(d.raw());
		}
		d.addFirst("" + 6);
		System.out.println(d.raw());
		d.addFirst("" + 7);
		System.out.println(d.raw());
		d.addFirst("" + 8);
		
		System.out.println(d.raw());
		System.out.println(d.removeFirst());
		System.out.println(d.raw());		
		System.out.println("removed last:" + d.removeLast());
		System.out.println(d.raw());
		System.out.println(d);

	}

	private T[] arr = (T[]) new Object[2];
	private int frontPointer = 0;
	private int size = 0;

	private int lastPointer() {
		return (frontPointer + size) % arr.length;
	}

	private void forEach(Consumer<IndexedItem<T>> consumer) {
		int index = 0;
		for(int i = frontPointer; i < arr.length && i - frontPointer < size;i++) {
			consumer.accept(new IndexedItem<>(index++, arr[i]));
		}
		if(lastPointer() <= frontPointer) {
			for(int i = 0; i < lastPointer(); i++) {
				consumer.accept(new IndexedItem<>(index++, arr[i]));
			}
		}

	}

	private void resizeIfNeeded() {
		if(size == arr.length) {
			System.out.println("resizing");
			// double the size of arr
			T[] ne = (T[]) new Object[arr.length * 2];
			forEach(f -> ne[f.index] = f.item);
			frontPointer = 0;
			arr = ne;	
		}
	}

	public void addFirst(T elem) {
		resizeIfNeeded();
		frontPointer--;
		if(frontPointer == -1) frontPointer = arr.length - 1;
		arr[frontPointer] = elem;
		size++;
	}
	public void addLast(T elem) {
		resizeIfNeeded();
		arr[lastPointer()] = elem;
		size++;
	}
	public T removeFirst() {
		if(size == 0) throw new IndexOutOfBoundsException();
		T element = arr[frontPointer];
		frontPointer = (frontPointer + 1) % arr.length;
		size--;
		return element;
	}
	public T removeLast() {
		if(size == 0) throw new IndexOutOfBoundsException();
		T element = arr[(frontPointer + size - 1) % arr.length];
		size--;
		return element;
	}
	public T peekFirst() {
		if(size == 0) throw new IndexOutOfBoundsException();
		return arr[frontPointer];
	}
	public T peekLast() {
		if(size == 0) throw new IndexOutOfBoundsException();
		return arr[(frontPointer + size - 1) % arr.length];
	}
	public boolean isEmpty() {
		return size == 0;
	}
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		forEach(i -> b.append(i.item).append(' '));
		return "[" + b.toString() + "]";
	}
	public String raw() {
		StringBuilder b = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == null) b.append("X ");
			else b.append(arr[i]).append(" ");
		}
		return "[" + b.toString() + "]  " + this.toString() + "\nfront:" + frontPointer + "  size: " + size + "  last: " + lastPointer();
	}
}

class IndexedItem<A> {
	public final int index;
	public final A item;
	public IndexedItem(int index, A item) {
		this.index = index;
		this.item = item;
	}
}

interface Consumer<E> {
	void accept(E element);
}
	
	

