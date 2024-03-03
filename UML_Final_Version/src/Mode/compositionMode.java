package Mode;

import java.awt.event.MouseEvent;

import Line.compositionLine;


public class compositionMode extends baseLineMode{
	  @Override
	    public void mousePressed(MouseEvent mouseEvent) {
	        super.mousePressed(mouseEvent);
	    }

	    @Override
	    public void mouseReleased(MouseEvent mouseEvent) {
	        endPoint = mouseEvent.getPoint();
	        if (ifAddLine(endPoint)) {
	            canvas.getLineList().add(new compositionLine(startPort, endPort,canvas.getCurrentDepth()));
	        }
	    }
}
