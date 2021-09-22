package org.firstinspires.ftc.teamcode.lib.nav;

public class StandardTrajectory {
    public Point origin, destination;
    public Field field;
    public double angle, distance;

    /**
     *
     * @param origin the origin point where the object in question starts
     * @param destination the point where the object in question wants to go
     * @param field the field that this trajectory is on
     */
    public StandardTrajectory(Point origin, Point destination, Field field) {
        this.origin = origin;
        this.destination = destination;
        this.field = field;
        this.angle = Point.getAngle(origin, destination);
        this.distance = Point.getDistance(origin, destination);
    }
}
