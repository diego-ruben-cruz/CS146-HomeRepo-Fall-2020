package prompt1;

import java.io.*;
import java.util.*;

public class ArraySort {

	public static void sop(String input) {
		System.out.println(input);
	}

	public int[] readToArray(File input) throws FileNotFoundException {
		try {
			// Integer array with correct size
			int[] toSort = new int[50];

			FileReader fr = new FileReader(input);
			BufferedReader br = new BufferedReader(fr);
			int i = 0;

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
			return toSort;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public int[] append(int[] a, int[] b) {
		int[] output = new int[a.length + b.length];
		for (int i = 0; i < a.length; i++) {
			output[i] = a[i];
		}
		for (int j = 0; j < b.length; j++) {
			output[j + 50] = b[j];
		}
		return output;
	}

	// BubbleSort with improved complexity
	// O(n^2) but the best-case complexity has been improved
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

	// Insertion Sort
	// O(n^2)
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

	public static void main(String[] args) {

		// Sets up object and basic file
		ArraySort mainObject = new ArraySort();
		File input1 = new File("src/prompt1/arr1.txt");

		// initialize array
		int[] array1 = null;
		try {
			array1 = mainObject.readToArray(input1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mainObject.improvedBubbleSort(array1, 50);

		File input2 = new File("src/prompt1/arr2.txt");
		int[] array2 = null;
		try {
			array2 = mainObject.readToArray(input2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainObject.selectionSort(array2, 50);

		int[] array3 = mainObject.append(array1, array2);
		mainObject.insertionSort(array3, 100);
		for (int i = 0; i < array3.length; i++) {
			mainObject.sop(Integer.toString(array3[i]));
		}

			}
}