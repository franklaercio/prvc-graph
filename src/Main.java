import java.util.List;

import core.ClarkeWright;
import core.FileUtil;
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
    String filePathName = args[0];

    List<Customer> customers = FileUtil.readCustomersFromCSV(filePathName);

    Customer deposit = customers.get(0);
    customers.remove(deposit);

    List<Node> nodes = ClarkeWright.createInitialRoutes(deposit, customers);

    MergeSort.sorterSavings(nodes);

    List<Route> routes = ClarkeWright.mergeRoutes(deposit, nodes);

    for (Route route : routes) {
      for (Customer customer : route.getRoutes()) {
        System.out.print("(" + customer.getX() + ", " + customer.getY() + ") ");
      }
      System.out.println("with total cost: " + route.getCapacity());
    }
  }
}