import java.util.*;


public class City implements Comparable<City>{
	private int cityNo;
	private int xCo,yCo;
	private double f, g, h;	
	private City parent = null; 
	private List<Edge> graph;
	
	public City(int cityNo,int xCo,int yCo){
		this.cityNo = cityNo;
		this.xCo = xCo;
		this.yCo = yCo;
		graph = new ArrayList<Edge>();
		h = Double.MAX_VALUE;
		f = Double.MAX_VALUE;
	    g = Double.MAX_VALUE;
	}
	
	
	
	
	
	public int getCityNo() {
		return cityNo;
	}





	public void setCityNo(int cityNo) {
		this.cityNo = cityNo;
	}





	public int getxCo() {
		return xCo;
	}





	public void setxCo(int xCo) {
		this.xCo = xCo;
	}





	public int getyCo() {
		return yCo;
	}





	public void setyCo(int yCo) {
		this.yCo = yCo;
	}





	public double getF() {
		return f;
	}





	public void setF(double f) {
		this.f = f;
	}





	public double getG() {
		return g;
	}





	public void setG(double g) {
		this.g = g;
	}





	public double getH() {
		return h;
	}





	public void setH(double h) {
		this.h = h;
	}





	public City getParent() {
		return parent;
	}





	public void setParent(City parent) {
		this.parent = parent;
	}





	public List<Edge> getGraph() {
		return graph;
	}





	public void setGraph(List<Edge> graph) {
		this.graph = graph;
	}





	public  double heuristic(City gla) {
		double dbl = Math.sqrt(Math.hypot((this.xCo - gla.xCo),(this.yCo - gla.yCo)));
		return dbl;
	}
	
	
	
	public void addEdge(int cost, City city){
        graph.add(new Edge(cost, city));
    }
	
	
	public String toString(){
		return cityNo +" "+ xCo + "," + yCo;
	}
	
	
	@Override
    public int compareTo(City city) {
		if(this.f == city.f)
			return 0;
	
		return (int)(this.f - city.f);
    }

}
