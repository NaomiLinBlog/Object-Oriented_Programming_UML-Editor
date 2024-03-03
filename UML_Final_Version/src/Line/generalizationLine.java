package Line;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.GeneralPath;

import BaseObject.baseObjPort;


public class generalizationLine extends baseLine{
	  public generalizationLine(baseObjPort startPort, baseObjPort endPort,int depth) {
	        super(startPort, endPort, depth);
	        this.width = 8;
	        this.height = 8;
	        this.depth=depth;
	    }

	    @Override
	    public void draw(Graphics2D graphics2D) {
	        super.draw(graphics2D);
	        Point startPoint = sourcePort.getStartPoint();
	        Point endPoint =  destinationPort.getStartPoint(); 
	        graphics2D.setColor(Color.BLUE);
	        graphics2D.drawLine(startPoint.x, startPoint.y, (int)(endPoint.x/1.013), (int)(endPoint.y/1.013));
	        GeneralPath triangle = new GeneralPath();
	        triangle.moveTo(endPos.x, endPos.y);
	        triangle.lineTo(x3, y3);
	        triangle.lineTo(x4, y4);
	        triangle.closePath();
	        graphics2D.draw(triangle);
	        graphics2D.setColor(Color.BLACK);
	    }
}
