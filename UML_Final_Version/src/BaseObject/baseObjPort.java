package BaseObject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class baseObjPort{
	
	private Point startPoint = new Point();
	private int height;
	public boolean isSelected = false;

	public int portWidth, portHeight;
    public baseObjPort(Point point) {
        this.setStartPoint(point);
        this.portWidth = 8;
        this.portHeight = 8;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.fillRect(getStartPoint().x - 4, getStartPoint().y - 4, portWidth, portHeight);
        
    }

    public void moveToNew(int gapX, int gapY) {
        this.getStartPoint().setLocation(getStartPoint().x +gapX, getStartPoint().y +gapY);
    }

//	public Point getStartPoint() {
//		return startPoint;
//	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getStartPoint() {
		// TODO Auto-generated method stub
		return startPoint;
	}



}

