package Line;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import BaseObject.baseObjPort;

public class compositionLine extends baseLine{

	public compositionLine(baseObjPort sourcePort, baseObjPort destinationPort,int depth) {
		// TODO Auto-generated constructor stub
		super(sourcePort, destinationPort, depth);
        this.width = 14;
        this.height = 14;
        this.depth=depth;
	}
	@Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        Point startPoint = sourcePort.getStartPoint();
        Point endPoint =  destinationPort.getStartPoint(); 
        //endPos = new Point((int)((x3+x4)/(2)), (int)((y3+y4)/(2)));
        graphics2D.setColor(Color.magenta);
        graphics2D.drawLine(startPoint.x, startPoint.y, (int)(endPos.x-Math.sqrt(7)), (int)(endPos.y-Math.sqrt(7)));
        graphics2D.drawLine(endPos.x, endPos.y-height/2, endPos.x-width/2, endPos.y);
        graphics2D.drawLine(endPos.x, endPos.y-height/2, endPos.x+width/2, endPos.y);
        graphics2D.drawLine(endPos.x - width/2, endPos.y, endPos.x, endPos.y + height/2);
        graphics2D.drawLine(endPos.x + width/2, endPos.y, endPos.x, endPos.y + height/2);
        graphics2D.setColor(Color.black);

    }

}
