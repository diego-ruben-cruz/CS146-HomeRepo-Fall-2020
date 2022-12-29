package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuickSort_Diego_Cruz_14611 {

	public int[] readToArray(File input) throws FileNotFoundException {
		try {
			// Integer array with correct size
			int[] toSort = new int[70];

			// sets up a new file reader to read numbers off
			FileReader fr = new FileReader(input);
			BufferedReader br = new BufferedReader(fr);
			int i = 0;

			// reads numbers off and puts them into the output int array
			boolean mainCond = true;
			while (mainCond) {
				String outputLine;

				outputLine = br.readLine();
				if (outputLine == null) {
					mainCond = false;
					break;
				}
				toSort[i] = Integer.parseInt(outputLine);
				i++;
			}

			// returns the array
			return toSort;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// Swap operation for an integer array
	private void swap(int[] inputArray, int currentIndex, int prevIndex) {
		int temp;
		temp = inputArray[prevIndex];
		inputArray[prevIndex] = inputArray[currentIndex];
		inputArray[currentIndex] = temp;

	}

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

	// Utility println function
	public void sop(String input) {
		System.out.println(input);
	}

	public static void main(String[] args) {
		// Init main object and input vars
		QuickSort_Diego_Cruz_14611 mainObj = new QuickSort_Diego_Cruz_14611();
		File mainInput = new File("src/src/MyList.txt");

		try {
			// Read numbers from file to int array
			int[] toSort = mainObj.readToArray(mainInput);

			// Initial message to indicate that init was successful
			mainObj.sop("Running QuickSort...");
			mainObj.sop("---------------------------------------------");

			// Message and showcase of pre-sort
			mainObj.sop("Pre-Sorted Array:");
			for (int i = 0; i < toSort.length; i++) {
				int output = toSort[i];
				mainObj.sop(Integer.toString(output));
			}

			mainObj.quickSort(toSort, 0, 69);

			// Message and showcase of post-sort
			mainObj.sop("---------------------------------------------");
			mainObj.sop("Post-Sorted Array:");
			for (int i = 0; i < toSort.length; i++) {
				int output = toSort[i];
				mainObj.sop(Integer.toString(output));
			}

			// end screen if program fully executes
			mainObj.sop("---------------------------------------------");
			mainObj.sop("");
			mainObj.sop("Congrats! You were able to make it to the end of the operation!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}