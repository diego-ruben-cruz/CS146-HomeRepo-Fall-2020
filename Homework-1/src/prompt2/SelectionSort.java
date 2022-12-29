package prompt2;

import java.util.*;

public class SelectionSort {
	// Swap operation for an integer array
	private void swap(int[] inputArray, int currentIndex, int prevIndex) {
		int temp;
		temp = inputArray[prevIndex];
		inputArray[prevIndex] = inputArray[currentIndex];
		inputArray[currentIndex] = temp;
	}

	// Selection Sort
	// O(n^2)
	// Unstable
	public void selectionSort(int a[], int n) {
		// These two nested loops look for the max valued index.
		for (int i = n - 1; i >= 1; i--) {
			int maxIndex = i;
			for (int j = 0; j < i; j++)
				if (a[j] >= a[maxIndex]) {
					maxIndex = j;
				}
			// Swaps max index and preceding index.
			swap(a, i, maxIndex);
		}
	}

	public int inputOp() {
		Scanner lineScan = new Scanner(System.in);
		return lineScan.nextInt();

	}

	// Binary Search Utility
	// O(log(n))
	// AKA Divide and Conquer
	private int binSearch(int[] Arr, int k, int lo, int hi) {
		// pre: A array is already sorted
		// post: if k in A[lo..hi] return its position, else return (-1)
		int r;
		if (lo > hi)
			r = -1;
		else {
			int mid = (lo + hi) / 2;
			if (k == Arr[mid])
				r = mid;
			else if (k < Arr[mid])
				r = binSearch(Arr, k, lo, mid - 1);
			else
				r = binSearch(Arr, k, mid + 1, hi);
		}
		return r;
	}

	public static void sop(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		// Formalities for setup of ops
		SelectionSort mainObj = new SelectionSort();
		int[] toManipulate = new int[] { 94, 4, 53, 45, 5, 81, 35, 10, 64, 2 };
		mainObj.sop("Running...");
		mainObj.sop("-----------------------");

		// Print Util Statement
		mainObj.sop("Starting Array");
		for (int i = 0; i < toManipulate.length; i++) {
			mainObj.sop(Integer.toString(toManipulate[i]));
		}

		mainObj.sop("-----------------------");

		// Sort operation
		mainObj.selectionSort(toManipulate, 10);

		// Print Util Statement
		mainObj.sop("Sorted Array");
		for (int i = 0; i < toManipulate.length; i++) {
			mainObj.sop(Integer.toString(toManipulate[i]));
		}

		mainObj.sop("-----------------------");

		// The prompt to ask what integer will be searched and the subsequent input op.
		System.out.print("What integer would you like to search for? ");
		int input = mainObj.inputOp();
		mainObj.sop("Your Input: " + Integer.toString(input));

		// Binary Search Op
		mainObj.sop("-----------------------");

		int resultIndex = mainObj.binSearch(toManipulate, input, 0, 9);
		if (resultIndex == -1) {
			mainObj.sop("your searched number was not found");
		} else {
			mainObj.sop("Found!");
			mainObj.sop("Index of number: " + Integer.toString(resultIndex));
		}
	}
}