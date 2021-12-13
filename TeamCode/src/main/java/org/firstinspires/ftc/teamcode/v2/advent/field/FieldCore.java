package org.firstinspires.ftc.teamcode.v2.advent.field;

public class FieldCore {
    private SquareArea[] forbiddenAreas;
    private double xDim;
    private double yDim;



    private boolean isSafe(Point p){
        for (SquareArea i : forbiddenAreas){
            if (i.inArea(p)){
                return false;
            }
        }
        if (p.x>xDim ||p.x<0){
            return false;
        }
        if (p.y>yDim || p.y<0){
            return false;
        }
        return true;
    }


}
