import java.util.ArrayList;
import java.util.List;

public class SavingsMain {

  public static void main(String[] args) {
    List<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Vehicle(40));
    vehicles.add(new Vehicle(50));
    vehicles.add(new Vehicle(60));

    Route routes = new Route();
    routes.addVertex("CEASA/RN", 0);
    routes.addVertex("Escola 1", 10);
    routes.addVertex("Escola 2", 20);
    routes.addVertex("Escola 3", 40);
    routes.addVertex("Escola 4", 60);
    routes.addVertex("Escola 5", 10);
    routes.addVertex("Escola 5", 90);

    Vertex ceasa = routes.getVertices().keySet().stream().filter(v -> v.getLabel().equals("CEASA/RN")).findFirst().orElseThrow();
    Vertex v2 = ceasa;

    for (Vehicle vehicle: vehicles) {
      int capacity = vehicle.getCapacity();

      for(Vertex vertex : routes.getVertices().keySet()){
        if(!vertex.isVisited() && !vertex.getLabel().equals(ceasa.getLabel())) {
          routes.addEdge(v2.getLabel(), v2.getCapacity(), vertex.getLabel(), vertex.getCapacity());
          capacity -= vertex.getCapacity();
          v2 = vertex;
        }

        if(capacity == 0) {
          routes.addEdge(v2.getLabel(), v2.getCapacity(), ceasa.getLabel(), ceasa.getCapacity());
          break;
        }
      }
    }
  }
}