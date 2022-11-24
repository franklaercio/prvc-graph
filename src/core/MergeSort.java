package core;

import java.util.Arrays;
import java.util.List;

import domain.Node;

/**
 * This class sort a list of nodes with the MergeSort algorithm.
 *
 * @see java.util.ArrayList
 * @see java.util.List
 * @see domain.Node
 * @see usecases.MergeSortUseCase
 *
 * @author Frank Laércio
 */
public class MergeSort {

  /**
   * Method to sort a list of nodes.
   *
   * @param nodes nodes to sort.
   */
  public static void sorterSavings(List<Node> nodes) {
    mergeSort(nodes, 0, nodes.size() - 1);
  }

  /**
   * Function for sorting elements.
   * In this case we going to get middle position.
   * Call with recursive way mergesort for numbers and joins the lists.
   *
   * @param nodes nodes to sort.
   * @param start point to start.
   * @param end   point to end.
   */
  private static void mergeSort(List<Node> nodes, int start, int end) {
    // Stop condition
    if (start >= end) {
      return;
    }

    // Get middle position
    int middle = start + ((end - start) / 2);

    mergeSort(nodes, start, middle);
    mergeSort(nodes, middle + 1, end);

    merge(nodes, start, middle, end);
  }

  /**
   * Function for merge elements.
   * In this case going to go define left list and right list.
   * After that we will compare the numbers of the two lists and we going to do a
   * merge.
   *
   * @param nodes nodes to merge into the list.
   * @param start start index.
   * @param end   end index.
   */
  private static void merge(List<Node> nodes, int start, int middle, int end) {
    int lengthLeft = middle - start + 1;
    int lengthRight = end - middle;

    List<Node> left = Arrays.asList(new Node[lengthLeft]);
    List<Node> right = Arrays.asList(new Node[lengthRight]);

    // Copy numbers of left middle
    for (int i = 0; i < lengthLeft; i++) {
      left.set(i, nodes.get(start + i));
    }

    // Copy numbers of right middle
    for (int j = 0; j < lengthRight; j++) {
      right.set(j, nodes.get(middle + 1 + j));
    }

    int topLeft = 0, topRight = 0, k = start;

    // Sorting numbers
    while (topLeft < lengthLeft && topRight < lengthRight) {
      if (left.get(topLeft).getSavings() <= right.get(topRight).getSavings()) {
        nodes.set(k, left.get(topLeft));
        topLeft++;
      } else {
        nodes.set(k, right.get(topRight));
        topRight++;
      }
      k++;
    }

    // Adding numbers that have not been distorted in the merge
    while (topLeft < lengthLeft) {
      nodes.set(k, left.get(topLeft));
      topLeft++;
      k++;
    }

    // Adding numbers that have not been distorted in the merge
    while (topRight < lengthRight) {
      nodes.set(k, right.get(topRight));
      topRight++;
      k++;
    }
  }
}
