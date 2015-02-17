

public class KruskalEdge<E extends Edge> implements Comparable<ComparableEdge<E>>{

	private double weight;
	
	public KruskalEdge (Edge edge){
		super();
		this.weight = edge.getWeight();
	}
	
	public double getWeight(){
		return weight;
	}
	@Override
	public int compareTo(ComparableEdge<E> e) {
		return Double.compare(this.weight, e.getWeight());
	}
	
}
