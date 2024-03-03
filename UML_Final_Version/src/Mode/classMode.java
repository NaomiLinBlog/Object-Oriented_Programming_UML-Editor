package Mode;

import java.awt.Component;
import java.awt.event.MouseEvent;

import BaseObject.baseObj;
import BaseObject.classObj;



public class classMode extends baseMode{
	 @Override
	    public void mousePressed(MouseEvent mouseEvent) {
	    }

	    @Override
	    public void mouseReleased(MouseEvent mouseEvent) {
	    	
	        baseObj tmpObj = new classObj(mouseEvent.getPoint(),canvas.getCurrentDepth());
	        canvas.add(tmpObj);
	    }
}
