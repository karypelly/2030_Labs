import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 */

public class RecursiveMethods {

	/**
	 * Return an array storing the first n numbers in a Fibonacci sequence. The
	 * Fibonacci starts with the first two numbers being 1 and 1, then starting from
	 * the 3rd number, it is the sum of the previous two numbers. You can assume
	 * that n is positive. e.g., fibArray(5) returns an array {1, 1, 2, 3, 5}.
	 * 
	 * @param n
	 *            the first n Fibonacci numbers
	 * @return an array representing the first n Fibonacci numbers
	 * 
	 *         You are forbidden to use the fibList method below to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] fibArray(int n) {
		if (n == 2) {
			int[] seq = { 1, 1 };
			return seq;
		}
		if (n == 1) {
			int[] seq = { 0 };
			return seq;
		} else {
			int[] seq = new int[n];
			seq[0] = 1;
			seq[1] = 1;
			fibArrayHelper(2, seq);
			return seq;
		}
	}

	private void fibArrayHelper(int i, int[] seq) {
		if (i < seq.length) {
			seq[i] = seq[i - 1] + seq[i - 2];
			fibArrayHelper(i + 1, seq);
		}
	}

	/**
	 * Return a list storing the first n numbers in a Fibonacci sequence. The
	 * Fibonacci starts with the first two numbers being 1 and 1, then starting from
	 * the 3rd number, it is the sum of the previous two numbers. You can assume
	 * that n is positive. e.g., fibList(5) returns a list {1, 1, 2, 3, 5}.
	 * 
	 * @param n
	 *            the first n Fibonacci numbers
	 * @return a list representing the first n Fibonacci numbers
	 * 
	 *         You are forbidden to use the fibArray method above to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> fibList(int n) {
		if (n == 2) {
			List<Integer> seq = new ArrayList<>();
			seq.add(1);
			seq.add(1);
			return seq;
		} else {
			List<Integer> seq = new ArrayList<>();
			seq.add(0, 1);
			seq.add(1, 1);
			fibListHelper(2, n, seq);
			return seq;
		}
	}

	private void fibListHelper(int i, int n, List<Integer> seq) {

		if (i < n) {
			seq.add(i, seq.get(i - 1) + seq.get(i - 2));
			fibListHelper(i + 1, n, seq);
		}

	}

	/**
	 * Return whether or not an array represents the first n numbers in a Fibonacci
	 * sequence. The Fibonacci starts with the first two numbers being 1 and 1, then
	 * starting from the 3rd number, it is the sum of the previous two numbers. The
	 * array may or may not be empty. e.g., isFibArray({1, 2}) returns false and
	 * isFibArray({1, 1, 2, 3, 5, 8}) returns true.
	 * 
	 * @param a
	 *            an array
	 * @return true if input array a (of length n) represents the first n Fibonacci
	 *         numbers; false otherwise.
	 * 
	 *         You are forbidden to use the isFibList method below to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isFibArray(int[] a) {
		if (a.length == 1 && a[0] == 1) {
			return true;
		}
		if (a[0] == 1 && a[1] == 1) {
			return isFibArrayHelper(a, 2);
		}
		return false;
	}

	private boolean isFibArrayHelper(int[] a, int i) {
		if (i < a.length) {
			if (a[i] == a[i - 1] + a[i - 2]) {
				return isFibArrayHelper(a, i + 1);
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * Return whether or not a list represents the first n numbers in a Fibonacci
	 * sequence. The Fibonacci starts with the first two numbers being 1 and 1, then
	 * starting from the 3rd number, it is the sum of the previous two numbers. The
	 * array may or may not be empty. e.g., isFibList({1, 2}) returns false and
	 * isFibList({1, 1, 2, 3, 5, 8}) returns true.
	 * 
	 * @param a
	 *            an array
	 * @return true if input list a (of length n) represents the first n Fibonacci
	 *         numbers; false otherwise.
	 * 
	 *         You are forbidden to use the isFibArray method above to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isFibList(List<Integer> list) {
		if (list.size() == 1 && list.get(0) == 1) {
			return true;
		}
		if (list.get(0) == 1 && list.get(1) == 1) {
			return isFibListHelper(list, 2);
		}
		return false;
	}

	private boolean isFibListHelper(List<Integer> list, int i) {
		if (i < list.size()) {
			if (list.get(i) == list.get(i - 1) + list.get(i - 2)) {
				return isFibListHelper(list, i + 1);
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1,
	 * consisting of all elements of array a and integer i.
	 * 
	 * @param a
	 *            an array that is sorted in a non-descending order
	 * @param i
	 *            an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of
	 *         array a and integer i. e.g., insertIntoSortedArray({1, 2, 4, 5}, 3)
	 *         returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 *         You are forbidden to use the insertIntoSortedList method below to
	 *         solve this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {
		if (a.length == 0) {
			int[] l = new int[1];
			l[0] = i;
			return l;
		}
		int[] l = new int[a.length + 1];
		if (a[0] >= i) {
			l[0] = i;
		}
		insertIntoSortedArrayHelper(a, 0, i, l, false);
		return l;
	}

	private void insertIntoSortedArrayHelper(int[] a, int index, int i, int[] result, boolean isFound) {
		if (index == a.length && isFound) {
			return;
		}
		if (index == a.length && !isFound) {
			result[index] = i;
			return;
		}
		if (isFound == false) {
			if (a[index] >= i) {
				result[index] = i;
				result[index + 1] = a[index];
				insertIntoSortedArrayHelper(a, index + 1, i, result, true);
			} else {
				result[index] = a[index];
				insertIntoSortedArrayHelper(a, index + 1, i, result, false);
			}

		} else {
			result[index + 1] = a[index];
			insertIntoSortedArrayHelper(a, index + 1, i, result, true);
		}
	}

	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1,
	 * consisting of all elements of the input list and integer i.
	 * 
	 * @param list
	 *            a list that is sorted in a non-descending order
	 * @param i
	 *            an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of
	 *         the input list and integer i. e.g., insertIntoSortedList({1, 2, 4,
	 *         5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 *         You are forbidden to use the insertIntoSortedArray method above to
	 *         solve this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i) {
		List<Integer> l = new ArrayList<>();
		if (list.size() == 0) {
			l.add(i);
			return l;
		}
		if (list.get(list.size() - 1) <= i) {
			l.addAll(list);
			l.add(i);
			return l;
		}
		if (list.get(0) > i) {
			l.add(i);
			l.addAll(list);
			return l;
		}
		if (list.get(0) <= i && list.get(1) >= i) {
			l.add(list.get(0));
			l.add(i);
			l.addAll(list.subList(1, list.size()));
		}
		if (list.get(0) < i && list.get(1) < i) {
			l.add(list.get(0));
			l.add(list.get(1));
			l.addAll(insertIntoSortedList(list.subList(2, list.size()), i));
		}
		return l;
	}

	/**
	 * Given two sorted arrays left and right, return a sorted array of size
	 * left.length + right.length, consisting of all elements of arrays left and
	 * right.
	 * 
	 * @param left
	 *            a sorted array
	 * @param right
	 *            a sorted array
	 * @return a sorted array of size left.length + right.length, consisting of all
	 *         elements of arrays left and right. e.g., mergeSortedArrays({1, 3, 5,
	 *         7}, {2, 4, 6, 8}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         You are forbidden to use the mergeSortedLists method below to solve
	 *         this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] mergeSortedArrays(int[] left, int[] right) {
		int[] merge = new int[left.length + right.length];
		MergeSortedArraysHelper(left, right, 0, 0, merge, 0);
		return merge;
	}

	private void MergeSortedArraysHelper(int[] left, int[] right, int l, int r, int[] result, int re) {
		if (left.length == l && right.length == r) {
			return;
		}
		if (l < left.length && r < right.length) {
			if (left[l] < right[r]) {
				result[re] = left[l];
				MergeSortedArraysHelper(left, right, l + 1, r, result, re + 1);
			} else {
				result[re] = right[r];
				MergeSortedArraysHelper(left, right, l, r + 1, result, re + 1);
			}
		}
		if (left.length == l && r < right.length) {
			result[re] = right[r];
			MergeSortedArraysHelper(left, right, l, r + 1, result, re + 1);
		}
		if (right.length == r && l < left.length) {
			result[re] = left[l];
			MergeSortedArraysHelper(left, right, l + 1, r, result, re + 1);
		}
	}

	/**
	 * Given two sorted lists left and right, return a sorted list of size
	 * left.size() + right.size(), consisting of all elements of lists left and
	 * right.
	 * 
	 * @param left
	 *            a sorted list
	 * @param right
	 *            a sorted list
	 * @return a sorted list of size left.size() + right.size(), consisting of all
	 *         elements of lists left and right. e.g., mergeSortedLists({1, 3, 5,
	 *         7}, {2, 4, 6, 8}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         You are forbidden to use the mergeSortedArrays method above to solve
	 *         this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
		List<Integer> merge = new ArrayList<>();
		if (right.size() == 0) {
			return left;
		}
		if (left.size() == 0) {
			return right;
		}
		if (right.get(0) > left.get(0)) {
			merge.add(left.get(0));
			left.remove(0);
		} else {
			merge.add(right.get(0));
			right.remove(0);
		}
		merge.addAll(mergeSortedLists(left, right));
		return merge;
	}
}