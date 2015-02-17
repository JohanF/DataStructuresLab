
import java.util.*;

public class ComparableEdge<E extends Edge> implements Comparable<ComparableEdge<E>>{
    
    private int to;
    private double weight;
    private List<E> path;
     
    public ComparableEdge(int to, double weight, List<E> path){
    	this.to=to;
    	this.weight=weight;
    	if(path == null){
    		this.path = new ArrayList<E>();
    	}
    	else
    		this.path=path;
    }

    
    public List<E> getPath() {
        return path;
    }
    
    public double getWeight(){
    	return weight;
    }
    
    public int getTo(){
    	return to;
    }

	@Override
	public int compareTo(ComparableEdge<E> e) {
        return Double.compare(this.weight, e.getWeight());
	}
}
