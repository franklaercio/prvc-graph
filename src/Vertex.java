public class Vertex {

  private String label;

  private int capacity;

  private boolean visited;

  public Vertex(String label, int capacity) {
    this.label = label;
    this.capacity = capacity;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }
}
