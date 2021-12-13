package org.firstinspires.ftc.teamcode.v2.advent.field;

import static org.firstinspires.ftc.teamcode.v2.advent.field.Vector.intersect;

public class SquareArea{
    private Point corner1;
    private Point corner2;
    private Point corner3, corner4;

    private double xMax, xMin;
    private double yMax, yMin;

    Vector v1, v2, v3, v4;


    /*
    1               4
     _______________
    |               |
    |               |
    |               |
    |               |
    |_______________|
    3               2
     */
    public SquareArea(Point corner1, Point corner2) {
        this.corner1 = corner1;
        this.corner2 = corner2;
        corner3 = new Point(corner1.x, corner2.y);
        corner4 = new Point(corner2.x, corner1.y);

        this.xMax = Math.max(corner1.x, corner2.x);
        this.xMin = Math.min(corner1.x, corner2.x);

        this.yMax = Math.max(corner1.y, corner2.y);
        this.yMin = Math.min(corner1.y, corner2.y);

        v1 = new Vector(this.corner1, this.corner3);
        v2 = new Vector(this.corner3, this.corner2);
        v3 = new Vector(this.corner2, this.corner4);
        v4 = new Vector(this.corner4, this.corner1);

    }

    public boolean inArea(Point p){
        if ((p.x<=this.xMax && p.x>=this.xMin)&&(p.y<=this.yMax && p.y>=this.yMin)){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean inArea(Point p, SquareArea a){
        if ((p.x<=a.xMax && p.x>=a.xMin)&&(p.y<=a.yMax && p.y>=a.yMin)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean inArea(Vector v){
        if(intersect(v, v1) || intersect(v, v2) || intersect(v, v3) || intersect(v, v4)){
            return true;
        }

        return false;
    }


}
