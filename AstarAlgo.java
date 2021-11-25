
import java.util.*;

public class AstarAlgo {
	
	private int st,gl;
	
	public int getSt() {
		return st;
	}

	public void setSt(int st) {
		this.st = st;
	}

	public int getGl() {
		return gl;
	}

	public void setGl(int gl) {
		this.gl = gl;
	}

	public City traverse(City start, City goal){

	       PriorityQueue<City> openList = new PriorityQueue<>();
	       PriorityQueue<City> closedList = new PriorityQueue<>();
	        start.setG(0);   //base case: distance of starting point from start is zero
	        start.setF(start.getG() + start.getH()); // check this
	        
	        openList.add(start);
	        
	        while (!openList.isEmpty()) {     
	            City node = openList.peek();
	            
	            if(node == goal)
	            	return goal;
	            
	            for(Edge a: node.getGraph()){
	                City m = a.getCity();
	                double pathCost = node.getG() + a.getStepCost();
	                
	                if (!openList.contains(m) && !closedList.contains(m)) {
	                    m.setParent(node);
	                    m.setG(pathCost);
	                    m.setF(m.getG() + m.getH());
	                    openList.add(m);
	                } 
	                else if(pathCost < m.getG()){
	                    
	                        m.setParent(node);
	                        m.setG(pathCost);
	                        m.setF(m.getG() + m.getH());
	                        
	                        if(closedList.contains(m)) {
	                            closedList.remove(m);
	                            openList.add(m);
	                        }
	                }	                
                }
	            
	            openList.remove(node);
	            closedList.add(node);
	            
	        }
	        
	     return null;  
	  }
		
	
}
