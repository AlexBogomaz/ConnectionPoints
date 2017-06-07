package task.alex;

import java.util.ArrayList;

public class Figure {
    private ArrayList<Line> FigureLines;

    public Figure(ArrayList<Point> points) {
        FigureFactory figureFactory= new FigureFactory(points);
        this.FigureLines = figureFactory.createFigure();
    }
    public Figure(int amountOfPoints,int min,int max){
        FigureFactory figureFactory= new FigureFactory(PointGenerator.generatePoints(amountOfPoints,min,max));
        this.FigureLines = figureFactory.createFigure();
    }

    public ArrayList<Line> getFigureLines() {
        return FigureLines;
    }

    @Override
    public String toString() {
        return "FigureLines=\n" + FigureLines +
                '}';
    }
}
