package Mode;

import java.awt.event.MouseEvent;

import BaseObject.baseObj;
import BaseObject.classObj;
import BaseObject.useCaseObj;

public class usecaseMode extends baseMode{
	@Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    	
        baseObj tmpObj = new useCaseObj(mouseEvent.getPoint(),canvas.getCurrentDepth());
        canvas.add(tmpObj);
    }
}
