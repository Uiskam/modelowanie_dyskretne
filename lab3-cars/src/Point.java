public class Point {
    public int type; //0 - empty space 1 - car
    public Point next; //neigh point
    public boolean moved; //if point was changed in current iteration


    public void move() {
        if (type == 1 && next.type == 0 && !moved) {
            next.type = 1;
            moved = true;
            next.moved = true;
            type = 0;
        }
    }

    public void clicked() {
        type = 1;
    }

    public void clear() {
        type = 0;
    }
}