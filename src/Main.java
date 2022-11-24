import java.util.ArrayList;
import java.util.List;

import core.ClarkeWright;
import core.MergeSort;
import domain.Customer;
import domain.Node;
import domain.Route;

/**
 * This is the heuristic scan of Clarke and Wrights to calculate the routing of
 * skilled vehicles. <br>
 * 
 * <ul>
 * <li>First the route to and from the warehouse to the customers is calculated.
 * <li>Then the list of nodes are sorted by the MergeSort algorithm.
 * <li>The calculation is made to group routes respecting the capacity of each
 * vehicle.
 * </ul>
 *
 * @see core.ClarkeWright
 * @see core.MergeSort
 *
 * @author Frank Laércio
 */
public class Main {

  public static void main(String[] args) {

    ClarkeWright clarkeWright = new ClarkeWright();
    MergeSort mergeSort = new MergeSort();

    Customer deposit = new Customer(250, 250, 50);

    List<Customer> customers = new ArrayList<Customer>();
    customers.add(new Customer(200, 200, 20));
    customers.add(new Customer(250, 150, 20));
    customers.add(new Customer(300, 200, 10));
    customers.add(new Customer(200, 300, 20));
    customers.add(new Customer(250, 350, 20));
    customers.add(new Customer(300, 300, 10));

    List<Node> nodes = clarkeWright.createInitialRoutes(deposit, customers);

    mergeSort.sorterSavings(nodes);

    List<Route> routes = clarkeWright.mergeRoutes(deposit, nodes);

    for (Route route : routes) {
      for (Customer customer : route.getRoutes()) {
        System.out.print(customer.getX() + ":" + customer.getY() + " -> ");
      }
      System.out.println("");
    }
  }
}