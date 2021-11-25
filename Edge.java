

public class Edge{
    
    private int stepCost;
    private City city;
    
    
    
    public int getStepCost() {
		return stepCost;
	}



	public void setStepCost(int stepCost) {
		this.stepCost = stepCost;
	}



	public City getCity() {
		return city;
	}



	public void setCity(City city) {
		this.city = city;
	}



	Edge(int stepCost,City city){
        this.stepCost = stepCost;
        this.city = city;
    }
    
}
