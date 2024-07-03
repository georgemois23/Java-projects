package bb;
//import edu.uci.ics.jung.graph.*;
//import edu.uci.ics.jung.visualization.*;
//import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
//import org.apache.commons.collections15.Transformer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Visualisation extends JFrame {
	
	public Visualisation() {
	setSize(500, 400);
	setVisible(true);
	setTitle("City Airport Connections Network");
	JPanel Graph=new JPanel();
	add(Graph);
	
//	 Graph<String, String> graph = new SparseGraph<>();
//	graph.addVertex("A");
//    graph.addVertex("B");
//    graph.addVertex("C");
//
//    // Add edges
//    graph.addEdge("Edge1", "A", "B");
//    graph.addEdge("Edge2", "B", "C");
//    graph.addEdge("Edge3", "C", "A");
//
//    // Visualize the graph
//    visualizeGraph(graph);
	}
}