package BaseObject;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import UI.Main;
import UI.MyCanvas;
import UI.MyMenuBar;


public class compositeObj extends baseObj{
    private List<baseObj> compositeObjList;
    
    public compositeObj(List<baseObj> compositeObjList) {
    	this.depth=MyCanvas.getCurrentDepth();
        this.compositeObjList = new ArrayList<>();
        this.compositeObjList.addAll(compositeObjList);
    }

    @Override
    public List<baseObj> getObjList() {
        return compositeObjList;
    }

    @Override
    public void draw(Graphics2D graphics2D) throws IOException {
        if (this.isSelected) {
            for (baseObj tmpObj : compositeObjList) {
            	tmpObj.setSelected(true);
            	tmpObj.draw(graphics2D);
            }
        } else {
            for (baseObj tmpObj : compositeObjList) {
            	tmpObj.setSelected(false);
            	tmpObj.draw(graphics2D);
            }
        }
    }

    @Override
    public List<baseObjPort> getPortsPosition() {
        List<baseObjPort> compositePortPosition = new ArrayList<>();
        for (baseObj tmpObj : compositeObjList) {
        	compositePortPosition.addAll(tmpObj.getPortsPosition());
        }
        return compositePortPosition;
    }

    @Override
    public void moveToNew(int gapX, int gapY) {
        for (baseObj tmpObj : compositeObjList) {
        	tmpObj.moveToNew(gapX, gapY);
        }
    }

    @Override
    public Boolean isInObjects(Point point) {
        for (baseObj tmpObj : compositeObjList) {
            if (tmpObj.isInObjects(point)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean isInDragRect(Rectangle dragRect) {
        for (baseObj tmpObj : compositeObjList) {
            if (tmpObj.isInDragRect(dragRect)) {
                return true;
            }
        }
        return false;
    }
}

