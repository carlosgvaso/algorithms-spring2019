/**
 * Integer set implementation.
 */
package hw1;


/**
 * Integer set implementation class.
 * 
 * @author Jose Carlos Martinez Garcia-Vaso <carlosgvaso@utexas.edu> 
 */
public class IntSet {

	private int size;
	private int[] set;

	// class invariant: set[0..(size-1)] contains unique elements and no repetitions;
	// 0 <= size <= set.length
	
	public boolean repOk() {
		// postcondition: returns true if and only <this> satisfies the class invariant

		// your code goes here
		
		// check the size is correct (should the size be set.lenght?)
		if (size < 0 || size > set.length) {
			return false;
		}
		
		// check the set contains no repetitions by comparing all possible unordered
		// element pairs in the set (for a, b in S={a,b}, if a!=b, then b!=a, so only
		// consider one case for better efficiency)
		for (int i=0; i<size-1; i++) {
			for (int j=i+1; j<size; j++) {
				if (set[i] == set[j]) {
					return false;
				}
			}
		}
		
		return true;
	}

	public IntSet() { // constructor
		size = 0;
		set = new int[10]; // default maximum number of elements in the set
	}

	public int size() { // getter for size
		return size;
	}

	public boolean contains(int x) {
		// postcondition: returns true if set contains x and false otherwise

		// your code goes here
		
		// loop over all elements in the set to check if the value is included
		for (int i=0; i<size; i++) {
			if (x == set[i]) {
				return true;
			}
		}
		
		return false;
	}

	public boolean add(int x) {
		// postcondition: adds x to set; returns true if x was not
		// already in set (in pre-state) and false otherwise;
		// allocates a larger underlying set array if it does not
		// have capacity to add <x>

		// your code goes here
		// Hint: you may use java.util.Arrays.copyOf(...)
		
		// check if x is already included in the set
		if (!contains(x)) {
			// check if we need to increase the size of the array to add x
			if (size == set.length) {
				// increase the set's array length by 10
				set = java.util.Arrays.copyOf(set, (set.length + 10));
			}
			// add x, increase the set size and return true
			set[size] = x;	// the size will always be the index of the next available space
			size++;
			return true;
		}
		
		// x is already in set
		return false;
	}

	public boolean remove(int x) {
		// postcondition: removes x from set; returns true if x was
		// in set in pre-state and false otherwise

		// your code goes here
		
		// loop over all elements in the set to check if the value is included
		for (int i=0; i<size; i++) {
			if (x == set[i]) {
				// value is included, so remove by moving the rest of the
				// set values with a higher array index one place back
				for (int j=i; j<size-1; j++) {
					set[j] = set[j+1];
				}
				
				// decrease the size and return true
				size--;
				return true;
			}
		}
		
		// x was not in the set
		return false;
	}

	/**
	 * Runs IntSet class tests.
	 * 
	 * @param args	The arguments are ignored.
	 */
	public static void main(String[] args) {
		// Ignore the args and run some testing cases
		IntSet s = new IntSet();
		
		System.out.println("Is the class invariant respected after creating the set? " + s.repOk());
		System.out.println("Initial set size: " + s.size());
		System.out.println("Added element 5 to set? " + s.add(5));
		System.out.println("Added element 7 to set? " + s.add(7));
		System.out.println("Set size: " + s.size());
		System.out.println("Is the class invariant respected? " + s.repOk());
		System.out.println("Does the set contain element 5? " + s.contains(5));
		System.out.println("Does the set contain element 7? " + s.contains(7));
		System.out.println("Does the set contain element 1? " + s.contains(1));
		System.out.println("Removed element 5 from the set? " + s.remove(5));
		System.out.println("Does the set contain element 5? " + s.contains(5));
		System.out.println("Set size: "+ s.size());
		System.out.println("Is the class invariant respected? " + s.repOk());
		System.out.println("Removed element 1 from the set? " + s.remove(1));
		System.out.println("Set size: "+ s.size());
		System.out.println("Is the class invariant respected? " + s.repOk());
		System.out.println("Removed element 7 from the set? " + s.remove(7));
		System.out.println("Does the set contain element 7? " + s.contains(7));
		System.out.println("Set size: "+ s.size());
		System.out.println("Is the class invariant respected? " + s.repOk());
		System.out.println("Added element 0 to set? " + s.add(0));
		System.out.println("Added element 1 to set? " + s.add(1));
		System.out.println("Added element 2 to set? " + s.add(2));
		System.out.println("Added element 3 to set? " + s.add(3));
		System.out.println("Added element 4 to set? " + s.add(4));
		System.out.println("Added element 5 to set? " + s.add(5));
		System.out.println("Added element 6 to set? " + s.add(6));
		System.out.println("Added element 7 to set? " + s.add(7));
		System.out.println("Added element 8 to set? " + s.add(8));
		System.out.println("Added element 9 to set? " + s.add(9));
		System.out.println("Added element 10 to set? " + s.add(10));
		System.out.println("Set size: " + s.size());
		System.out.println("Is the class invariant respected? " + s.repOk());
		System.out.println("Can we add a repeated element, like adding element 5 again? " + s.add(5));
		System.out.println("Set size: "+ s.size());
		System.out.println("Is the class invariant respected? " + s.repOk());
	}

}


