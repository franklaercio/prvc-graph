package domain;

/**
 * This class mapping the nodes and the distance between them.
 *
 * @author Frank Laércio
 */
public class Node {

  /** Client from where the node departs. */
  private Customer from;

  /** Client where the node goes. */
  private Customer to;

  /** Total cost of the node. */
  private double savings;

  /**
   * Constructor of the Node
   * 
   * @param c1      customer from node
   * @param c2      customer to node
   * @param savings the cost of the node
   */
  public Node(Customer c1, Customer c2, double savings) {
    this.from = c1;
    this.to = c2;
    this.savings = savings;
  }

  /** Methor to get a custormer from. */
  public Customer getFrom() {
    return from;
  }

  /** Methor to get a custormer to. */
  public Customer getTo() {
    return to;
  }

  /** Methor to get a cost of node. */
  public double getSavings() {
    return savings;
  }
}
