package org.betterbox;

public record Point(double x, double y) {
    public Point() {
        this(0.0, 0.0);
    }
    public static double calculateDistance(Point p1, Point p2) {
        double deltaX = p2.x() - p1.x();
        double deltaY = p2.y() - p1.y();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
