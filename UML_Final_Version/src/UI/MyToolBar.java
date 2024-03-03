package UI;

import javax.swing.*;

import Mode.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// 6 buttons
public class MyToolBar extends JToolBar {
	private ArrayList<MyToolBtn> btnList = new ArrayList<>();
	private MyMenuBar menuBar = MyMenuBar.getMenuBar();

	private MyCanvas canvas;
	public MyToolBar() {
		canvas = MyCanvas.getCurrentCanvas();
		this.setLayout(new GridLayout(6, 1));

		MyToolBtn selectBtn = new MyToolBtn("src/image/select.png", this, new selectMode());
		MyToolBtn associationBtn = new MyToolBtn("src/image/association.png", this, new associationMode());
		MyToolBtn genaralizationBtn = new MyToolBtn("src/image/generalization.png", this, new generalizationMode());
		MyToolBtn compositionBtn = new MyToolBtn("src/image/composition.png", this, new compositionMode());
		MyToolBtn classBtn = new MyToolBtn("src/image/class.png", this, new classMode());
		MyToolBtn usecastBtn = new MyToolBtn("src/image/usecase.png", this, new usecaseMode());

	}

	// https://stackoverflow.com/questions/2536873/how-can-i-set-size-of-a-button
	public class MyToolBtn extends JButton {
			baseMode mode;
		MyToolBtn(String iconPath, MyToolBar toolBar,baseMode currentMode) {
			ImageIcon icon = new ImageIcon(iconPath);
			this.setIcon(icon);
			this.setPreferredSize(new Dimension(100, 40));
			this.addActionListener(e ->{ 
				resetBtn();
				this.mode=currentMode;
				canvas.getCurrentCanvas().setCurrentMode(currentMode);
				((JButton) e.getSource()).setBackground(Color.LIGHT_GRAY);
				menuBar.resetMenuBar();
			});
			toolBar.add(this);
			btnList.add(this);
		}
		public void resetBtn() {
			 for (MyToolBtn btn : btnList) {
                 btn.setBackground(null);
             }
			
		}
		
	}

}
