package domain;

import java.util.ArrayList;

/**
 * This class maps routes with the client list and capacity of that route.
 *
 * @see java.util.ArrayList
 *
 * @author Frank Laércio
 */
public class Route {

  /** List of routes with each customer */
  private ArrayList<Customer> routes;

  /** Capacity of route */
  private int capacity;

  /** Constructor of Route */
  public Route() {
    routes = new ArrayList<>();
    capacity = 0;
  }

  /**
   * Method responsible for add one customer and sum capacity.
   *
   * @param customer it's a customer to add in route.
   */
  public void addCustomerAndSumCapacity(Customer customer) {
    routes.add(customer);
    capacity += customer.getCapacity();
  }

  /** Method responsible for returning all customer in this route. */
  public ArrayList<Customer> getRoutes() {
    return routes;
  }

  /** Method responsible for returning this capacity of route. */
  public int getCapacity() {
    return capacity;
  }
}
