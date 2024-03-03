package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseObject.compositeObj;



public class groupAction implements ActionListener{
	public MyCanvas canvas = MyCanvas.getCurrentCanvas();
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		canvas.setGroupList();
	}

}
