package prompt1;

import java.io.*;
import java.util.*;

public class RadixSort_Diego_Cruz_146 {

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

	// Utility println function
	public void sop(String input) {
		System.out.println(input);
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

	// Radix Sort
	// Out of place

	// Best Case Omega(d * n)
	// Worst Case O(d * n)

	// Stable
	void radixSort(int inputArray[], int maxDigits) {
		// Find max number to find number of digits
		int maxVal = this.getMax(inputArray, maxDigits);

		// Does a count sort with base 10 increments
		for (int basePower = 1; maxVal / basePower > 0; basePower *= 10)
			this.countSort(inputArray, maxDigits, basePower);
	}

	public static void main(String[] args) {
		// Init main object and input variables
		RadixSort_Diego_Cruz_146 mainObj = new RadixSort_Diego_Cruz_146();
		File mainInput = new File("src/prompt1/MyList.txt");

		try {
			// Read numbers from file to int array
			int[] toSort = mainObj.readToArray(mainInput);

			// Initial message to indicate that initialization was successful
			mainObj.sop("Running RadixSort...");
			mainObj.sop("---------------------------------------------");

			// Message and show-case of pre-sort
			mainObj.sop("Pre-Sorted Array:");
			for (int i = 0; i < toSort.length; i++) {
				int output = toSort[i];
				mainObj.sop(Integer.toString(output));
			}

			mainObj.radixSort(toSort, 70);

			// Message and show-case of post-sort
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