package usecases;

import java.util.List;

import domain.Customer;
import domain.Node;
import domain.Route;

/**
 * This is a interface of class the heuristic scan of Clarke and Wrights to
 * calculate the routing of skilled vehicles.
 *
 * @see domain.Customer
 * @see domain.Node
 * @see domain.Route
 *
 * @author Frank Laércio
 */
public interface ClarkeWrightUseCase {

  /**
   * Method to create a initial routes in Clarke and Wrights algorithm. <br>
   * For this it is calculated by: Sij=C(0, i) +C(0, j) − C(i, j).
   *
   * @param deposit   deposit using by calculate the distance of customer.
   * @param customers list of customers loaded.
   * @return list of nodes and capacities.
   */
  List<Node> createInitialRoutes(Customer deposit, List<Customer> customers);

  /**
   * Methor to merge two routes into one, following by capacities. <br>
   * For this it is calculated by: sum of q1 and sum of q2 <= Q.
   * 
   * @param deposit deposit using by calculate the distance of customer.
   * @param nodes   list of nodes.
   * @return list of merged routes.
   */
  List<Route> mergeRoutes(Customer deposit, List<Node> nodes);
}
