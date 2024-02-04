
public class Vertex {
	String label;
	boolean was_visited;
	
	public String Get_Label() {
		return this.label;
	}
	
	public Vertex(String label) {
		this.label = label;
		this.was_visited = false;
		
	}
}
