//Implementation of the Lomuto partition scheme for the Quicksort Algorithm.
public class LomutoJavaImplementation {
	
	LomutoJavaImplementation(){}
	
	void quicksort(int[] A, int lo, int hi) {
		if (lo < hi) {
			int p = partition(A, lo, hi);			
			quicksort(A, lo, p - 1);
			quicksort(A, p + 1, hi);
		}		
	}
	
	int partition(int A[], int lo, int hi) {
		int pivot = A[hi];
		int i = lo - 1;
		
		for (int j = lo; j < hi ; j++) {
			if (A[j] < pivot) {
				i = i + 1;
				swap(A, i, j);
			}
		}
		swap(A, i + 1, hi);
		return i + 1;
	}
	
	void swap(int[] A, int pos1, int pos2) {
		int temp = A[pos1];
		A[pos1] = A[pos2];
		A[pos2] = temp;		
	}
	
	void printArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(" " + A[i]);
		}
		System.out.print("\n");
	}
	
	public static void main(String [] args) {
		int[] A1 = { 9, 3, 2, 6, 7, 4, 5, 8, 1, 0 };
		
		LomutoJavaImplementation Lomuto = new LomutoJavaImplementation();
		
		System.out.println("Original Array:");
		Lomuto.printArray(A1);
		
		Lomuto.quicksort(A1, 0, A1.length - 1);
		
		System.out.println("Sorted Array:");
		Lomuto.printArray(A1);		
	//END OF MAIN FUNCTION
	}
}
