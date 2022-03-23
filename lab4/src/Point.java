import java.util.Random;

public class Point {
    public int type; //0 - empty space 1 - car
    public Point next; //neigh point
    public boolean moved; //if point was changed in current iteration
    public int velocity;
    public static Integer[] types = {0, 1, 2, 3, 5};

    public void move() {
        if (this.type == 1 && !this.moved) {
            System.out.println("v1 = "+ this.velocity);
            this.velocity = Math.min(this.velocity + 1, 5);
            System.out.println("v2 = "+ this.velocity);
            this.velocity = Math.min(this.velocity, find_next_car(this.next, 0));
            System.out.println("v3 = "+ this.velocity);
            /*if (this.velocity >= 1 && new Random().nextInt(100) >= 95) {
                this.velocity--;
            }*/
            System.out.println(this.velocity + " = V4\n");
            Point next_pos = find_next_position(this, 0, this.velocity);
            next_pos.moved = true;
            next_pos.velocity = this.velocity;
            next_pos.type = 1;
            this.moved = true;
            this.velocity = 0;
            this.type = 0;


        }
    }
    private Point find_next_position(Point curPoint, int counter, int vel) {
        if(counter == vel) {
            return curPoint;
        }
        return find_next_position(curPoint.next, counter + 1, vel);
    }
    private int find_next_car(Point curPoint, int dist){
        if(dist == 5)
            return 5;
        if (curPoint.type == 1) {
            return dist;
        }
        return find_next_car(curPoint.next,  dist + 1);
    }
    public void clicked() {
        type = 1;
        velocity = 1;
    }

    public void clear() {
        type = 0;
    }
}