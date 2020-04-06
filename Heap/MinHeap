// Java program to implement Min Heap 
public class MinHeap { 
	private int[] Heap; 
	private int size; 
	private int maxsize; 

	// Constructor to initialize an 
	// empty min heap with given maximum 
	// capacity. 
	public MinHeap(int maxsize) 
	{ 
		this.maxsize = maxsize; 
		this.size = 0; 
		Heap = new int[this.maxsize + 1]; 
		Heap[0] = Integer.MIN_VALUE; 
	} 

	// Returns position of parent 
	private int parent(int pos) 
	{ 
		return pos / 2; 
	} 

	// Below two functions return left and 
	// right children. 
	private int leftChild(int pos) 
	{ 
		return (2 * pos); 
	} 
	private int rightChild(int pos) 
	{ 
		return (2 * pos) + 1; 
	} 

	// Returns true of given node is leaf 
	private boolean isLeaf(int pos) 
	{ 
		if (pos >= (size / 2) && pos <= size) { 
			return true; 
		} 
		return false; 
	} 

	private void swap(int fpos, int spos) 
	{ 
		int tmp; 
		tmp = Heap[fpos]; 
		Heap[fpos] = Heap[spos]; 
		Heap[spos] = tmp; 
	} 

	// A recursive function to min heapify the given 
	// subtree. This function assumes that the left and 
	// right subtrees are already heapified, we only need 
	// to fix the root. 
	private void minHeapify(int pos) 
	{ 
		if (isLeaf(pos)) 
			return; 

		if (Heap[pos] > Heap[leftChild(pos)] || 
			Heap[pos] > Heap[rightChild(pos)]) { 

			if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) { 
				swap(pos, leftChild(pos)); 
				minHeapify(leftChild(pos)); 
			} 
			else { 
				swap(pos, rightChild(pos)); 
				minHeapify(rightChild(pos)); 
			} 
		} 
	} 

	// Inserts a new element to min heap 
	public void insert(int element) 
	{ 
		Heap[++size] = element; 

		// Traverse up and fix violated property 
		int current = size; 
		while (Heap[current] < Heap[parent(current)]) { 
			swap(current, parent(current)); 
			current = parent(current); 
		} 
	} 

	public void print() 
	{ 
		for (int i = 1; i <= size / 2; i++) { 
			System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + 
					Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]); 
			System.out.println(); 
		} 
	} 

	// Remove an element from min heap 
	public int extractMin() 
	{ 
		int popped = Heap[1]; 
		Heap[1] = Heap[size--]; 
		minHeapify(1); 
		return popped; 
	} 

	public static void main(String[] arg) 
	{ 
		System.out.println("The Min Heap is "); 
		MinHeap minHeap = new MinHeap(15); 
        minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        minHeap.insert(84); 
        minHeap.insert(19); 
        minHeap.insert(6); 
        minHeap.insert(22); 
        minHeap.insert(9); 
      
  
        minHeap.print();
		System.out.println("The min val is " + minHeap.extractMin()); 
	} 
} 
