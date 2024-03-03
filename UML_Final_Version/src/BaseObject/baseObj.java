package BaseObject;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import UI.MyCanvas;



public class baseObj extends Object{
	protected String name="default name";
	protected Point startPoint = new Point(), endPoint = new Point();
	//public int depth;
	public static int objDepth = 100;
	protected int height;
	protected boolean isSelected = false;
	protected List<baseObjPort> portList = new ArrayList<>();


	public void draw(Graphics2D graphics2d) throws IOException {
		// TODO Auto-generated method stub

	}

	public Boolean isInObjects(Point point) {

		if (point.x >= startPoint.x && point.x <= startPoint.x + 100 && point.y >= startPoint.y && point.y <= startPoint.y + height ) 
			return true;
		else
			return false;
	}

    public void moveToNew(int gapX, int gapY) {
        Point newPoint = new Point(startPoint.x+gapX, startPoint.y+gapY);
        this.setStartPoint(newPoint);
        for (baseObjPort tmpObj: this.getPortsPosition()) {
        	tmpObj.moveToNew(gapX, gapY);
        }
    }
    
    public List<baseObjPort> getPortsPosition() {
		// TODO Auto-generated method stub
		return portList;
	}

	public void updatePortPosition() {
        baseObjPort rightPort = new baseObjPort(new Point(startPoint.x+100, startPoint.y+height/2));
        baseObjPort leftPort = new baseObjPort(new Point(startPoint.x, startPoint.y+height/2));
        baseObjPort bottomPort = new baseObjPort(new Point(startPoint.x + 50,  startPoint.y + height));
        baseObjPort topPort = new baseObjPort(new Point(startPoint.x + 50,  startPoint.y));
        portList.add(rightPort);
        portList.add(leftPort);
        portList.add(bottomPort);
        portList.add(topPort);
    }

	private void setStartPoint(Point newPoint) {
		this.startPoint=newPoint;
		// TODO Auto-generated method stub
		
	}

	public void setSelected(boolean b) {
		// TODO Auto-generated method stub
		this.isSelected=b;
	}

	public baseObjPort findConnectPort(Point tmpPoint) {
		double distance = 99999;
		baseObjPort tmpPort = null;
		for (int chosenPort = 0; chosenPort < 4; chosenPort++) {
			if (distance > getDistance(this.portList.get(chosenPort).getStartPoint(), tmpPoint)) {
				distance = getDistance(this.portList.get(chosenPort).getStartPoint(), tmpPoint);
				tmpPort = this.portList.get(chosenPort);
			}
		}
		return tmpPort;

	}

	private double getDistance(Point startPoint, Point tmpPoint) {
		// TODO Auto-generated method stub
		return Math.sqrt((startPoint.x-tmpPoint.x)*(startPoint.x-tmpPoint.x)+(startPoint.y-tmpPoint.y)*(startPoint.y-tmpPoint.y));
	}

	public List<baseObj> getObjList() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isInDragRect(Rectangle dragRect) {
		// TODO Auto-generated method stub
        Rectangle objRectSize = new Rectangle(this.startPoint.x, this.startPoint.y, 100, this.height);
        return dragRect.contains(objRectSize);
	}

	public void changeObjName(String newName) {
		// TODO Auto-generated method stub
		this.name = newName;
	}
}
