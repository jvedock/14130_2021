package org.firstinspires.ftc.teamcode.v2.advent.pathing;

import org.firstinspires.ftc.teamcode.v2.advent.field.Vector;

public class PathGenerator {

    /**
     *
     * @param vectors an array of vectors denoting the path wanted to take
     * @param points the number of distinct points desired on the path, the number of segments
     *               can be expresses ad points - 1
     * @return
     */
    public static PathSegment[] getPath(Vector[] vectors, int points){
        PathSegment[] paths = new PathSegment[points-1];
        int currentIndex = 0;
        double totalLength = 0;
        for (Vector v : vectors){
            totalLength += v.magnitude;
        }




        return paths;
    }
}
