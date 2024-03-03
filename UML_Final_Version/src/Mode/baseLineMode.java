package Mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import BaseObject.baseObj;
import BaseObject.baseObjPort;

public class baseLineMode extends baseMode{
    protected baseObjPort startPort, endPort;
    protected baseObj sourceObj, destinationObj;

    public void mousePressed(MouseEvent mouseEvent) {
        startPoint = mouseEvent.getPoint();
        int isInObj = isInObjList(startPoint);
        if (isInObj != -1) {
        	sourceObj = canvas.getObjList().get(isInObj);
            if (sourceObj.getObjList() == null) {
                startPort = sourceObj.findConnectPort(startPoint);
                //System.out.println(sourceObj);
            } else {
                // no shape
            	sourceObj = null;
            }
        }
    }

    public void mouseReleased(MouseEvent mouseEvent) {}

    public boolean ifAddLine(Point endPoint) {
        int isInObj = isInObjList(endPoint);
        if (isInObj != -1 && sourceObj != null) {
        	destinationObj = canvas.getObjList().get(isInObj);
            if (destinationObj.getObjList () == null && !sourceObj.equals(destinationObj)) {
                endPort = destinationObj.findConnectPort(endPoint);
                System.out.println(destinationObj);

                return true;
            }
        }
        return false;
    }
}