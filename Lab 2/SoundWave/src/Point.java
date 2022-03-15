public class Point {

    public Point nNeighbor;
    public Point wNeighbor;
    public Point eNeighbor;
    public Point sNeighbor;
    public float nVel;
    public float eVel;
    public float wVel;
    public float sVel;
    public float pressure;
    public static Integer[] types = {0, 1, 2};
    int type;
    public int sinInput = 0;

    public Point() {
        clear();
        type = 0;
    }

    public void clicked() {
        pressure = 1;
    }

    public void clear() {
        // clear velocity and pressure
        nVel = (float) 0.0;
        eVel = (float) 0.0;
        sVel = (float) 0.0;
        wVel = (float) 0.0;
        pressure = (float) 0.0;
    }

    public void updateVelocity() {
        if(type == 0) {
            // velocity update
            nVel = nVel - (nNeighbor.getPressure() - pressure);
            eVel = eVel - (eNeighbor.getPressure() - pressure);
            sVel = sVel - (sNeighbor.getPressure() - pressure);
            wVel = wVel - (wNeighbor.getPressure() - pressure);
        }
    }

    public void updatePresure() {
        // pressure update
        if (type == 0) {
            float cSquared = (float) 0.5; //maximal wave velocity
            pressure = pressure - cSquared * (nVel + eVel + sVel + wVel);
        }
        else if (type == 2) {
            double radians = Math.toRadians(sinInput);
            pressure = (float) (Math.sin(radians));
            sinInput += 60;
        }
    }

    public float getPressure() {
        return pressure;
    }
}
