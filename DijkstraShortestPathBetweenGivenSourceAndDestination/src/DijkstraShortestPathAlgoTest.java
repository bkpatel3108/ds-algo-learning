import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DijkstraShortestPathAlgoTest {

	public static void main(String[] args) {
		Graph<String, Integer> graph = new AdjacencyMapGraph<String, Integer>();
		BufferedReader inputFileBR = null;
		Vertex<String> src = null;
		Vertex<String> dest = null;
		Map<String, Vertex<String>> inputVertices = new HashMap<String, Vertex<String>>();
		try {
			Scanner reader = new Scanner(System.in); // Reading from System.in
			System.out.println(
					"Note :\n" + "Input format - input file must contain one arc per line, where each arc is \n"
							+ "represented by two nodes followed by a weight (of type integer). \n"
							+ "All three are separated by space.\n" + "first_vertex second_vertex weight\n" + "Ex : \n"
							+ "A B 4\n" + "A C 2");
			System.out.println(
					"Enter a number: \n1 - To use default input file (input.txt)\n2 - To enter input file path from command line");
			int testType = reader.nextInt();

			if (testType == 1) {
				try {
					inputFileBR = new BufferedReader(new FileReader("input.txt"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					inputFileBR = new BufferedReader(new FileReader("src/input.txt"));
				}

			} else if (testType == 2) {
				System.out.println("Please enter input file path");
				String filePath = reader.next();

				inputFileBR = new BufferedReader(new FileReader(filePath));

			}

			else {
				System.out.println("Please run program again and choose valid option");
				System.exit(0);
			}

			System.out.println("Please enter source vertex");
			String sourceVertex = reader.next();
			System.out.println("Please enter destination vertex");
			String destinationVertex = reader.next();
			String inputLine;

			while ((inputLine = inputFileBR.readLine()) != null) {
				Vertex<String> u;
				Vertex<String> v;
				// get vertices separated by space
				String[] input = inputLine.split(" ");
				String uStr = input[0];
				String vStr = input[1];
				u = inputVertices.get(uStr);
				if (u == null) {
					u = graph.insertVertex(uStr);
					if (uStr.equals(sourceVertex)) {
						src = u;
					} else if (uStr.equals(destinationVertex)) {
						dest = u;
					}
					inputVertices.put(uStr, u);

				}
				v = inputVertices.get(vStr);
				if (v == null) {
					v = graph.insertVertex(vStr);
					if (vStr.equals(sourceVertex)) {
						src = v;
					} else if (vStr.equals(destinationVertex)) {
						dest = v;
					}
					inputVertices.put(vStr, v);
				}
				Integer weight = Integer.parseInt(input[2]);
				graph.insertEdge(weight, u, v);
			}

			System.out.println("You created following Graph");
			System.out.println(graph);

			if (src != null && dest != null) {
				Object[] shortestPathoutput = DijkstraShortestPathAlgo.getShortestPath(graph, src, dest);
				if (shortestPathoutput[0] != null) {
					Integer shortestPathLength = (Integer) shortestPathoutput[0];
					if (Integer.MAX_VALUE != shortestPathLength) {
						System.out.println("DijkstraShortestPathAlgo >> Shortest Path length between " + sourceVertex
								+ " and " + destinationVertex + " >> " + shortestPathoutput[0]);

						System.out.println("DijkstraShortestPathAlgo >> Shortest Path>> ");

						List<Vertex<String>> shortestPath = (List<Vertex<String>>) shortestPathoutput[1];
						if (shortestPath != null && shortestPath.size() > 0) {
							for (int i = shortestPath.size(); i > 0; i--) {
								Vertex<String> vertex = shortestPath.get(i - 1);
								System.out.print(vertex.getElement());
								if (i > 1)
									System.out.print(" --> ");
							}
							System.out.println("");
						} else {
							System.out.print("Destination vertex is not reachable");
						}
					} else {
						System.out.print("Destination vertex is not reachable");
					}
				} else {
					System.out.print("Destination vertex is not reachable");
				}
			} else {
				System.out.print("Source or Destination vertex is not present in Graph you entered");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
