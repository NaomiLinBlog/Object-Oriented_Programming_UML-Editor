package Mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import BaseObject.baseObj;
import UI.MyCanvas;


public class baseMode {
	protected Point startPoint, endPoint;
	protected MyCanvas canvas = MyCanvas.getCurrentCanvas();

	public void mousePressed(MouseEvent mouseEvent) {

	}

	public void mouseReleased(MouseEvent mouseEvent) {
		
	}

	public int isInObjList(Point point) {
		int upperObj = 100, indexOfUpper=0;
		boolean isIn = false;
		for (int i = 0; i < canvas.getObjList().size(); i++) {
			if (canvas.getObjList().get(i).isInObjects(point) && upperObj > canvas.getObjList().get(i).getDepth()) {
				upperObj = canvas.getObjList().get(i).getDepth();
				indexOfUpper = i;
				isIn = true;
			}
		}
		if (isIn)
			return indexOfUpper;
		else
			return -1;
	}
    public void removeOldPort() {
        for (baseObj tmpObj: canvas.getSelectedObj()) {
        	tmpObj.setSelected(false);
        }
        canvas.getSelectedObj().clear();
        canvas.dragRectangle=null;
    }



}
