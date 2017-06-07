package task.alex;

import java.util.ArrayList;
import java.util.Random;

public class PointGenerator {

    public static ArrayList<Point> generatePoints(int points,int min,int max){
         Random generator = new Random();
         ArrayList<Point> generatedPoints = new ArrayList<Point>(points);
        for (int i=0; i<points; i++) {
            generatedPoints.add(i,new Point((max-min)*generator.nextDouble()+min,(max-min)*generator.nextDouble()+min));
        }

        return generatedPoints;
    }
}
