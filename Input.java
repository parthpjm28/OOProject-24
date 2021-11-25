
public class Input {
	
	String a_star;
	String dijkstra;
    Input(int n, int m, City[] c,int temp1, int temp2)
    {

        AstarAlgo Astar = new AstarAlgo();
		Dijkstra djk = new Dijkstra();
		
		for(int k =0; k<n;k++){
			if(c[k].getCityNo()== temp1) {
				Astar.setSt(k);
			}
			if(c[k].getCityNo()== temp2) {
				Astar.setGl(k);			
			}
		}
        
		for(int i=0;i<n;i++) {
			c[i].setH(c[i].heuristic(c[Astar.getGl()]));
		}
		
		Astar.traverse(c[Astar.getSt()],c[Astar.getGl()]);
		
		a_star = ""+ c[Astar.getGl()].getF();
		
		
		djk.setSt(Astar.getSt());
		djk.setGl(Astar.getGl());
		djk.traverse(c[djk.getSt()],c[djk.getGl()]);

		dijkstra = ""+c[djk.getGl()].getF();
		
	    }

}
