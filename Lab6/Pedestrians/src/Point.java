import java.util.ArrayList;

public class Point {

	public ArrayList<Point> neighbors = new ArrayList<>();
	public static Integer []types ={0,1,2,3};
	public int type;
	public int staticField;
	public boolean isPedestrian;
    public boolean blocked;

	public Point() {
		type=0;
		staticField = 100000;
		neighbors= new ArrayList<Point>();
	}
	
	public void clear() {
		staticField = 100000;
		
	}

	public boolean calcStaticField() {
        int newPotentialField = 100001;
        for (Point neighbour : this.neighbors) {
            newPotentialField = Math.min(neighbour.staticField, newPotentialField);
        }
        if(this.staticField > newPotentialField + 1) {
            this.staticField = newPotentialField + 1;
            return true;
        }
        return false;
	}
	
	public void move(){
        if(this.isPedestrian){
            Point nextStep = findNextStep();
            //System.out.println("asd " + nextStep.staticField + " " + this.neighbors.get(0).staticField);
            if(nextStep.staticField != 100000) {
                this.isPedestrian = false;
                //this.type = 0;
                if(nextStep.type != 2)
                    nextStep.isPedestrian = true;
                nextStep.blocked = true;
                //nextStep.type = 3;
            }
        }
	}

    private Point findNextStep() {
        Point nextStep = new Point();
        for(Point neighbour : this.neighbors) {
            if (neighbour.staticField < nextStep.staticField && !neighbour.isPedestrian)
                nextStep = neighbour;
        }
        return nextStep;
    }
	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}
}