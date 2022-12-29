package algorithms;

import java.util.Arrays;

public class AlgorithmsWithUtility {

	// --------------------------------------------------------------------------
	// BubbleSort 2
	// In Place

	// Best Case (n)
	// Worst Case (n^2)

	// Stable
	public void improvedBubbleSort(int a[], int n) {
		// Loop 1 and 2 take care of the adjacent numbers
		for (int i = n - 1; i >= 1; i--) {

			// Initially assumes that the array is sorted unless proven otherwise in loop 2
			boolean is_sorted = true;

			// Loop 2 swaps if necessary
			for (int j = 1; j <= i; j++) {
				if (a[j - 1] > a[j]) {
					swap(a, j, j - 1);
					is_sorted = false;
				}
			}
			// Final condition check to see if sorted
			if (is_sorted)
				return;
		}
	}

	// --------------------------------------------------------------------------

	// Selection Sort
	// In Place

	// Best Case (n^2)
	// Worst Case (n^2)

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

	// --------------------------------------------------------------------------

	// Insertion Sort
	// In Place

	// Best Case (n)
	// Worst Case (n^2)

	// Stable
	public void insertionSort(int a[], int n) {
		for (int i = 1; i < n; i++) {
			int next = a[i];
			int j;
			for (j = i - 1; j >= 0 && a[j] > next; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = next;
		}
	}

	// --------------------------------------------------------------------------

	// Merge Sort
	// Out of place

	// Best Case (n log(n))
	// Worst Case (n log(n))

	// Stable
	public void mergeSort(int a[], int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;

			// Divides input array into two halves
			this.mergeSort(a, low, mid);
			this.mergeSort(a, mid + 1, high);

			// Glues the two sorted array together
			this.merge(a, low, mid, high);
		}
	}

	// Utility Operation for MergeSort
	public void merge(int a[], int low, int mid, int high) {
		// Basic setup of utility variables,
		// uses temporary array so space complexity is a factor to consider
		int n = high - low + 1;
		int[] temp = new int[n];
		int left = low;
		int right = mid + 1;
		int tempIndex = 0;

		// This while loop merges the splits after sorting them.
		while (left <= mid && right <= high) {
			if (a[left] <= a[right]) {
				//
				// Note: tempIndex++ and left++ occur after the fact,
				// meaning that this is what executes:
				//
				// array[x];
				// x++;
				//
				// Use this for future reference
				temp[tempIndex++] = a[left++];
			} else {
				temp[tempIndex++] = a[right++];
			}
		}

		while (left <= mid) {
			temp[tempIndex++] = a[left++];
		}
		while (right <= high) {
			temp[tempIndex++] = a[right++];
		}

		// A wrap-up loop to get the merged result back into input array
		for (int k = 0; k < n; k++) {
			a[low + k] = temp[k];
		}

	}

	// --------------------------------------------------------------------------

	// Utility partition function for quickSort
	// i is lower bound
	// j is upper bound
	public int partition(int a[], int i, int j) {
		int pivot = a[i];
		int m = i;

		// Checks each element in the unsorted region
		for (int k = i + 1; k <= j; k++) {
			if (a[k] < pivot) {
				m++;
				this.swap(a, k, m);
			}
		}

		// swaps pivot with a[m]
		this.swap(a, i, m);

		// returns the index of pivot
		return m;
	}

	// Quick Sort
	// In Place

	// Best Case (n log(n))
	// Worst Case (n^2)

	// Stable
	public void quickSort(int a[], int low, int high) {
		if (low < high) {
			// Finds the pivot index with partition function
			int pivotIndex = this.partition(a, low, high);

			// Recursive calls to sort both portions
			this.quickSort(a, low, pivotIndex - 1);
			this.quickSort(a, pivotIndex + 1, high);
		}
	}

	// --------------------------------------------------------------------------

	// Radix Sort
		// Out of place

		// Best Case O(d * n)
		// Worst Case O(d * n)

		// Stable
		void radixSort(int inputArray[], int maxDigits) {
			// Find max number to find number of digits
			int maxVal = this.getMax(inputArray, maxDigits);

			// Does a count sort with base 10 increments
			for (int basePower = 1; maxVal / basePower > 0; basePower *= 10)
				this.countSort(inputArray, maxDigits, basePower);
		}
	
	// Utility function to get the max value out of the array for the sake of
	// RadixSort
	private int getMax(int[] toSearch, int arrLength) {
		// Initialize max variable to return at end of function
		int max = toSearch[0];

		// Searches thru array to find out true max
		for (int i = 0; i < arrLength; i++) {
			if (toSearch[i] > max) {
				max = toSearch[i];
			}
		}

		// Returns max element after iterating thru array
		return max;
	}

	// Utility function that sorts by order of base power
	void countSort(int inputArr[], int arrSize, int numBase) {
		int output[] = new int[arrSize]; // output array
		int i = 0; // variable used by multiple loops, for continuity
		int count[] = new int[10];
		Arrays.fill(count, 0);

		// Store count of occurrences
		for (i = 0; i < arrSize; i++)

			// gets a number and increments it by 1 which
			// will get fixed in the following loop
			count[(inputArr[i] / numBase) % 10]++;

		// Change count[i] so that count[i] now contains
		// its respective position in output[]
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		// Build the output array
		for (i = arrSize - 1; i >= 0; i--) {
			output[count[(inputArr[i] / numBase) % 10] - 1] = inputArr[i];
			count[(inputArr[i] / numBase) % 10]--;
		}

		// Copy the output array to array[], so that array[] now
		// contains sorted numbers according to current digit
		for (i = 0; i < arrSize; i++)
			inputArr[i] = output[i];
	}
	
	// --------------------------------------------------------------------------

	// Swap operation for an integer array
	private void swap(int[] inputArray, int currentIndex, int prevIndex) {
		int temp;
		temp = inputArray[prevIndex];
		inputArray[prevIndex] = inputArray[currentIndex];
		inputArray[currentIndex] = temp;
	}

	// --------------------------------------------------------------------------

	// Binary Search Utility

	// Worst Case [log(n)]

	// AKA Divide and Conquer
	private int binSearch(int[] Arr, int k, int lo, int hi) {
		// Precondition: A array is already sorted
		// Output: if k is in A[low ... high] return its position, else return (-1)
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
}