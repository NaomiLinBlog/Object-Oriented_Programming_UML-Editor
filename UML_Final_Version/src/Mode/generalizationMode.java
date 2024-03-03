package Mode;

import java.awt.event.MouseEvent;

import Line.generalizationLine;


public class generalizationMode extends baseLineMode {
	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		super.mousePressed(mouseEvent);
	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {
		endPoint = mouseEvent.getPoint();
		if (ifAddLine(endPoint)) {
			canvas.getLineList().add(new generalizationLine(startPort, endPort,canvas.getCurrentDepth()));
		}
	}
}
