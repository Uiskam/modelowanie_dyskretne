import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Point {
    private ArrayList<Point> neighbors;
    private int currentState;
    private int nextState;
    private int numStates = 6;
    private Set<Integer> toRemainAlive = new HashSet<>();
    private Set<Integer> toBecomeAlive = new HashSet<>();

    public Point() {
        currentState = 0;
        nextState = 0;
        neighbors = new ArrayList<Point>();
        int[] toRemainAliveConfig = {4,5,6,7,8};
        int[] toBecomeAliveConfig = {3};
        for (int j : toRemainAliveConfig) {
            toRemainAlive.add(j);
        }
        for (int j : toBecomeAliveConfig) {
            toBecomeAlive.add(j);
        }
    }

    public void clicked() {
        currentState = (++currentState) % numStates;
    }

    public int getState() {
        return currentState;
    }

    public void setState(int s) {
        currentState = s;
    }

    public void calculateNewState() {
        if (this.getState() != 0) {
            if (this.toRemainAlive.contains(countAliveNeighbors())) {
                this.nextState = 1;
            } else {
                this.nextState = 0;
            }
        } else {
            if (this.toBecomeAlive.contains(countAliveNeighbors())) {
                this.nextState = 1;
            } else {
                this.nextState = 0;
            }
        }
    }

    public void changeState() {
        currentState = nextState;
    }

    public void addNeighbor(Point nei) {
        neighbors.add(nei);
    }

    //write method counting all active neighbors of THIS point
    public int countAliveNeighbors() {
        int counter = 0;
        for (Point neighbor : this.neighbors) {
            if (neighbor.getState() != 0) {
                counter++;
            }
        }
        return counter;
    }
}
