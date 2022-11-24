package usecases;

import java.util.List;

import domain.Node;

/**
 * This class sort a list of nodes with the MergeSort algorithm.
 * 
 * @see java.util.List
 * @see domain.Node
 *
 * @author Frank Laércio
 */
public interface MergeSortUseCase {

  /**
   * Method to sort a list of nodes.
   *
   * @param nodes nodes to sort.
   */
  void sorterSavings(List<Node> nodes);
}
