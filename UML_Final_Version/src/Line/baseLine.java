package Line;

import java.awt.Graphics2D;
import java.awt.Point;

import BaseObject.Object;
import BaseObject.baseObjPort;



public class baseLine extends Object{
    //public Point point1;
    protected Point startPos, endPos;
    protected baseObjPort sourcePort, destinationPort;
    protected int width, height; 
    protected int x3, y3, x4, y4 = 0; 

    public baseLine(baseObjPort sourcePort, baseObjPort destinationPort,int depth) {
        this.startPos = sourcePort.getStartPoint();
        this.endPos = destinationPort.getStartPoint();
        this.sourcePort = sourcePort;
        this.destinationPort = destinationPort;
    
    }
    
    @Override
    public void draw(Graphics2D graphics2D) {
        Point startPoint = sourcePort.getStartPoint();
        Point endPoint =  destinationPort.getStartPoint(); 
        double arrowheadAngle = Math.atan(width / height); // angle of arrowhead
        double arrowheadLength = Math.sqrt(width * width + height * height); // length of arrowhead
        double[] arrXY_1 = rotateVec(endPoint.x - startPoint.x, endPoint.y - startPoint.y, arrowheadAngle, true, arrowheadLength);
        double[] arrXY_2 = rotateVec(endPoint.x - startPoint.x, endPoint.y - startPoint.y, -arrowheadAngle, true, arrowheadLength);
        
        x3 = (int) (endPoint.x - arrXY_1[0]);
        y3 = (int) (endPoint.y - arrXY_1[1]);
       
        x4 = (int) (endPoint.x - arrXY_2[0]);
        y4 = (int) (endPoint.y - arrXY_2[1]);
    
        graphics2D.fillRect(startPoint.x - 4, startPoint.y - 4, 8, 8);
        graphics2D.fillRect(endPoint.x - 4, endPoint.y - 4, 8, 8);
    }

    public static double[] rotateVec(int px, int py, double ang, boolean isChLen, double newLen) {
        double mathsstr[] = new double[2];
        
        double vx = px * Math.cos(ang) - py * Math.sin(ang);
        double vy = px * Math.sin(ang) + py * Math.cos(ang);
        if (isChLen) {
            double d = Math.sqrt(vx * vx + vy * vy);
            vx = vx / d * newLen;
            vy = vy / d * newLen;
            mathsstr[0] = vx;
            mathsstr[1] = vy;
        }
        return mathsstr;
    }

}
