package domain;

import java.awt.geom.Point2D;

/**
 * This class maps the clients that must be supplied.
 *
 * @see java.awt.geom.Point2D
 *
 * @author Frank Laércio
 */
public class Customer extends Point2D.Double {

  /** Capacity of customer. */
  private int capacity;

  /**
   * Constructor of Customer.
   * 
   * @param x        point x of distance.
   * @param y        point y of distance.
   * @param capacity capacity of customer.
   */
  public Customer(double x, double y, int capacity) {
    this.x = x;
    this.y = y;
    this.capacity = capacity;
  }

  /** Methor do get distance x. */
  public double getX() {
    return x;
  }

  /** Methor do set distance x. */
  public void setX(double x) {
    this.x = x;
  }

  /** Methor do get distance y. */
  public double getY() {
    return y;
  }

  /** Methor do set distance y. */
  public void setY(double y) {
    this.y = y;
  }

  /** Methor do get capacity of customer. */
  public int getCapacity() {
    return capacity;
  }

  /** Methor do set capacity of customer. */
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  /**
   * Methor to compare a customer to a customer.
   * 
   * @param o maybe a customer or not to compare.
   */
  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (!(o instanceof Customer)) {
      return false;
    }
    Customer c = (Customer) o;

    return c.distance(x, c.x) == 0 && c.distance(y, c.y) == 0;
  }
}
