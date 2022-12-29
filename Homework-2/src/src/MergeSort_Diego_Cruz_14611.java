package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MergeSort_Diego_Cruz_14611 {

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
		// Basic setup of utility vars,
		// uses temp array so space complexity is a factor to consider
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
				// arr[x];
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

	//Utility println function
	public void sop(String input) {
		System.out.println(input);
	}

	public static void main(String[] args) {
		// Init main object and input vars
		MergeSort_Diego_Cruz_14611 mainObj = new MergeSort_Diego_Cruz_14611();
		File mainInput = new File("src/src/MyList.txt");

		try {
			// Read numbers from file to int array
			int[] toSort = mainObj.readToArray(mainInput);

			// Initial message to indicate that init was successful
			mainObj.sop("Running MergeSort...");
			mainObj.sop("---------------------------------------------");

			// Message and showcase of pre-sort
			mainObj.sop("Pre-Sorted Array:");
			for (int i = 0; i < toSort.length; i++) {
				int output = toSort[i];
				mainObj.sop(Integer.toString(output));
			}

			mainObj.mergeSort(toSort, 0, 69);

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