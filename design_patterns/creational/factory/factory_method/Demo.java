package design_patterns.creational.factory.factory_method;

enum CoordinateSystem {
    CARTESIAN,
    POLAR
}

class Point {
    private double x, y;

    private Point(double x, double y) {

        this.x = x;
        this.y =y ;
    }

    static class Factory {    
        public static Point newCartesianPoint(double x, double y) {
            return new Point(x, y);
        }
    
        public static Point newPolarPoint(double rho, double theta) {
            return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
        }
    }
}


public class Demo { 
    public static void main(String[] args) {
        Point p  = Point.Factory.newPolarPoint(2, 3);
    }
}
