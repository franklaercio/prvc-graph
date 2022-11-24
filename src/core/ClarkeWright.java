package core;

import java.util.ArrayList;
import java.util.List;

import domain.Customer;
import domain.Node;
import domain.Route;

/**
 * This is the heuristic scan of Clarke and Wrights to calculate the routing of
 * skilled vehicles.
 *
 * @see java.util.ArrayList
 * @see java.util.List
 * @see domain.Node
 * @see domain.Route
 * @see usecases.ClarkeWrightUseCase
 *
 * @author Frank Laércio
 */
public class ClarkeWright {

  /**
   * Method to create a initial routes in Clarke and Wrights algorithm. <br>
   * For this it is calculated by: Sij=C(0, i) +C(0, j) − C(i, j).
   *
   * @param deposit   deposit using by calculate the distance of customer.
   * @param customers list of customers loaded.
   */
  public static List<Node> createInitialRoutes(Customer deposit, List<Customer> customers) {
    ArrayList<Node> nodes = new ArrayList<>();

    for (int i = 0; i < customers.size(); i++) {
      for (int j = 0; j < customers.size(); j++) {
        if (i != j) {
          double saving = (deposit.distance(customers.get(i))
              + deposit.distance(customers.get(j)) - customers.get(i).distance(customers.get(j)));
          nodes.add(new Node(customers.get(i), customers.get(j), saving));
        }
      }
    }

    return nodes;
  }

  /**
   * Methor to merge two routes into one, following by capacities. <br>
   * For this it is calculated by: sum of q1 and sum of q2 <= Q.
   * 
   * @param deposit deposit using by calculate the distance of customer.
   * @param nodes   list of nodes.
   * @return list of merged routes.
   */
  public static List<Route> mergeRoutes(Customer deposit, List<Node> nodes) {
    List<Route> savingRoutes = new ArrayList<>();

    for (Node node : nodes) {
      if (!containsCustomer(node.getFrom(), savingRoutes) && !containsCustomer(node.getTo(), savingRoutes)) {
        if ((node.getFrom().getCapacity() + node.getTo().getCapacity()) <= deposit.getCapacity()) {
          Route route = new Route();
          route.addCustomerAndSumCapacity(node.getFrom());
          route.addCustomerAndSumCapacity(node.getTo());

          if (!savingRoutes.contains(route)) {
            savingRoutes.add(route);
          }
        }
      }
    }

    return savingRoutes;
  }

  /**
   * Methor to check the list of saving routes contains the customer.
   * 
   * @param customer     customer to check in the list.
   * @param savingRoutes routes savings.
   * @return customer contains in the savings routes.
   */
  private static boolean containsCustomer(Customer customer, List<Route> savingRoutes) {
    for (Route route : savingRoutes) {
      for (Customer customerInList : route.getRoutes()) {
        if (customer.equals(customerInList)) {
          return true;
        }
      }
    }

    return false;
  }
}
