package Line;

import java.awt.Graphics2D;
import java.awt.Point;

import BaseObject.baseObjPort;

public class associationLine extends baseLine{

	public associationLine(baseObjPort sourcePort, baseObjPort destinationPort,int depth) {
		super(sourcePort, destinationPort, depth);
		this.height=8;
		this.width=8;
		this.depth=depth;
		// TODO Auto-generated constructor stub
	}
	
    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        Point startPoint = sourcePort.getStartPoint();
        Point endPoint =  destinationPort.getStartPoint(); 
        graphics2D.drawLine(startPoint.x, startPoint.y, endPos.x, endPos.y);

        graphics2D.drawLine(endPos.x, endPos.y, x3, y3);
        graphics2D.drawLine(endPos.x, endPos.y, x4, y4);
        // draw the arrowhead and the line
        graphics2D.fillRect(startPos.x-4, startPos.y-4, 8, 8);
        graphics2D.fillRect(endPos.x-4, endPos.y-4, 8, 8);
    }

}
