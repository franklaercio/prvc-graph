import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Route {

  private final Map<Vertex, List<Vertex>> vertices;

  public Route() {
    this.vertices = new HashMap<>();
  }

  public Map<Vertex, List<Vertex>> getVertices() {
    return vertices;
  }

  public void addVertex(String label, int capacity) {
    vertices.putIfAbsent(new Vertex(label, capacity), new ArrayList<>());
  }

  public void addEdge(String label1, int capacity1, String label2, int capacity2) {
    Vertex v1 = new Vertex(label1, capacity1);
    Vertex v2 = new Vertex(label2, capacity2);
    vertices.get(v1).add(v2);
    vertices.get(v2).add(v1);
  }

}
