import java.util.*;

public class DirectedGraph<E extends Edge> {

	private List<E>[] neighbours;
	
    public DirectedGraph(int noOfNodes) {
           neighbours = (List<E>[]) new List[noOfNodes];
           for(int i=0; i < neighbours.length; i++){
        	   neighbours[i]= new ArrayList<E>();
           }
    }

	public void addEdge(E e) {
		neighbours[e.getSource()].add(e);
	}

	public Iterator<E> shortestPath(int from, int to) {
		PriorityQueue<ComparableEdge<E>> priorityQueue = new PriorityQueue<ComparableEdge<E>>();
		priorityQueue.add(new ComparableEdge<E>(from, 0 ,null));
		boolean [] isVisited = new boolean[neighbours.length];
		while(!priorityQueue.isEmpty()){
			ComparableEdge<E> shortestEdge = priorityQueue.poll();
			if(!isVisited[shortestEdge.getTo()]){
				if(shortestEdge.getTo() == to){
					return shortestEdge.getPath().iterator();
				}else{
					isVisited[shortestEdge.getTo()]=true;
					for(int i = 0; i < neighbours[shortestEdge.getTo()].size(); i++){
						E edge = neighbours[shortestEdge.getTo()].get(i);
						if(!isVisited[edge.getDest()]){
							List<E> path = new ArrayList<E>(shortestEdge.getPath());
							path.add(edge);
							priorityQueue.add(new ComparableEdge<E>(edge.getDest(), shortestEdge.getWeight()+edge.getWeight(), path));
						}
					}
				}
			}
		}
		return null;
	}
		
	public Iterator<E> minimumSpanningTree() {
		PriorityQueue<KruskalEdge<E>> priorityQueue = new PriorityQueue<KruskalEdge<E>>();
		List<KruskalEdge<E>> MSTlist = new ArrayList<KruskalEdge<E>>();
		boolean [] isConnected = new boolean[neighbours.length];
		for(int i = 0; i < neighbours.length; i++){
			for(int j = 0; j < neighbours[i].size(); i++){
				priorityQueue.add(new KruskalEdge<E>(neighbours[i].get(j)));
			}
			KruskalEdge<E> edge = priorityQueue.poll();
			if(!isConnected[i]){
				isConnected[i]=true;
				MSTlist.add(edge);
			}
		}
		while(!priorityQueue.isEmpty()){
			
		}
		return null;
	}

}
  
