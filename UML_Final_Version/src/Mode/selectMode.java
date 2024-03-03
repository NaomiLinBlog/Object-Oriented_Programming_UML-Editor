package Mode;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import BaseObject.baseObj;
import UI.Main;
import UI.MyMenuBar;

public class selectMode extends baseMode {
	private int isInObject;
	private MyMenuBar menuBar = MyMenuBar.getMenuBar();

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		startPoint = mouseEvent.getPoint();
		isInObject = isInObjList(startPoint);
		//System.out.println(isInObject);
		removeOldPort();
	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {
		menuBar.resetMenuBar();
		endPoint = mouseEvent.getPoint();
		// drag the rectangle select bound
		if (!endPoint.equals(startPoint)) {
			int gapX = endPoint.x - startPoint.x;
			int gapY = endPoint.y - startPoint.y;
			if (isInObject != -1) {
				baseObj selectedObj = canvas.getObjList().get(isInObject);
				selectedObj.moveToNew(gapX, gapY);
				//System.out.println(mouseEvent.getPoint());
				//selectedObj.setDepth(canvas.objDepth);
			} else if (isInObject == -1) {
				canvas.dragRectangle=selectObj(gapX, gapY);
				
				for (baseObj tmpObj : canvas.getSelectedObj()) {
					tmpObj.setSelected(true);
				}
			}
			if (canvas.getSelectedObj().size() >= 2) {
				menuBar.setGroup(true);
			}
		} else {
			if (isInObject != -1) {
				//System.out.println("isInObject");
				baseObj tmpObj = canvas.getObjList().get(isInObject);
				tmpObj.setSelected(true);
				//tmpObj.setDepth(canvas.getCurrentDepth());
				canvas.getSelectedObj().add(tmpObj);
				System.out.println("Obj single selected "+canvas.getSelectedObj().size());
				
			}
		}

	        if (canvas.getSelectedObj().size() == 1 && canvas.getSelectedObj().get(0).getObjList() != null) {
	            menuBar.setUnGroup(true);
	        }

	        if (canvas.getSelectedObj().size() == 1 && canvas.getSelectedObj().get(0).getObjList() == null) {
	            menuBar.changeName(true);
	        }
	        else
	        	menuBar.changeName(false);
	        	

	}

	
	public Rectangle selectObj(int gapX, int gapY) {
		Rectangle dragRect; // dragRect of the dragged area
//	         right bottom -> left top
//	         right top -> left down
//	         left bottom -> right top
//	         left top -> right bottom
		if (gapX < 0) {
			if (gapY < 0)
				dragRect = new Rectangle(endPoint.x, endPoint.y, -gapX, -gapY);
			else
				dragRect = new Rectangle(endPoint.x, startPoint.y, -gapX, gapY);

		} else {
			if (gapY < 0)
				dragRect = new Rectangle(startPoint.x, endPoint.y, gapX, -gapY);
			else
				dragRect = new Rectangle(startPoint.x, startPoint.y, gapX, gapY);

		}
		for (baseObj tmpObj : canvas.getObjList()) {
			if (tmpObj.isInDragRect(dragRect)) {
				if(tmpObj.getObjList()==null)
					canvas.getSelectedObj().add(tmpObj);
				else {
					Boolean compositeObjectAllInRect=true;
					for (baseObj comObj : tmpObj.getObjList()) 
					{
						if (comObj.isInDragRect(dragRect)==false)
						{
							compositeObjectAllInRect=false;
						}
							
					}
					if(compositeObjectAllInRect)
						canvas.getSelectedObj().add(tmpObj);
				}
					
				System.out.println("Obj draging selected "+canvas.getSelectedObj().size());
				//System.out.println(canvas.getSelectedObj().size());
				//System.out.println(canvas.getSelectedObj().get(0).getObjList());
			}
		}
		return dragRect;
	}
}
