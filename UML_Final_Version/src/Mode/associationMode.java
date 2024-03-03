package Mode;


import java.awt.event.MouseEvent;

import Line.associationLine;

public class associationMode extends baseLineMode{
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    	System.out.println("assocation clicked");
        super.mousePressed(mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        endPoint = mouseEvent.getPoint();
        if (ifAddLine(endPoint)) {
            canvas.getLineList().add(new associationLine(startPort, endPort,canvas.getCurrentDepth()));
        }
    }
}

