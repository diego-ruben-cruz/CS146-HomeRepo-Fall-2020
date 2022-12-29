package prompt3;

class Solution {

	public ListNode insertionSortList(ListNode head) {
		// Checks base case if input is empty.
		if (head == null) {
			return null;
		}

		// Size variable to account for
		int size = 1;

		// temp0 keeps tabs on head while linked list is traversed to figure out size of
		// array
		ListNode temp0 = head;
		while (head.next != null) {
			size++;
			head = head.next;
		}

		// Creates new array and puts raw input inside of it.
		int[] toSort = new int[size];
		for (int i = 0; i < toSort.length; i++) {
			toSort[i] = temp0.val;
			temp0 = temp0.next;
		}

		// Quick check of array to see if it got the input correctly
		/*
		 * for (int i = 0; i < toSort.length; i++) { System.out.println(toSort[i]); }
		 */

		// Sorts the array using Insertion Sort algorithm into a new returnable linked
		// list node
		this.insertionSort(toSort, toSort.length);
		ListNode temp1 = new ListNode(toSort[0]);
		ListNode temp2 = temp1;

		// transcribes the sorted array into the returnable linked list
		for (int i = 1; i < toSort.length; i++) {
			temp1.next = new ListNode(toSort[i]);
			temp1 = temp1.next;
		}

		// final return contingency
		return temp2;
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
}