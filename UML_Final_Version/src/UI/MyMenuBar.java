package UI;

//Trying to copy as the same as JAVAFX menuBar
import javax.swing.*;



import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Is Menubar a JmenuBar? Yes
public class MyMenuBar extends JMenuBar {
	public static MyMenuBar menuBar = null;
	private JMenuItem group, ungroup, changeObjectName;
	private JMenu file, edit;
	private MyCanvas canvas = MyCanvas.getCurrentCanvas();
	
    public static MyMenuBar getMenuBar() {
        if (menuBar == null) {
            menuBar =  new MyMenuBar();
        }
        return menuBar;
    }
	
	public MyMenuBar() {
		//this.setPreferredSize(new Dimension(width, 30));
		
		file = new JMenu("File");
		this.add(file);

		edit = new JMenu("Edit");
		this.add(edit);

		group = new JMenuItem("Group");
		group.addActionListener(e ->{ 
			canvas.setGroupList();
		});
		group.setEnabled(false);
		edit.add(group);

		ungroup = new JMenuItem("UnGroup");
		ungroup.addActionListener(e ->{ 
			canvas.setUnGroupObj();
		});
		ungroup.setEnabled(false);
		edit.add(ungroup);

		changeObjectName = new JMenuItem("Change Object Name");
		changeObjectName.addActionListener(e ->{ 
			canvas.changeName();
		});
		changeObjectName.setEnabled(false);
		edit.add(changeObjectName);
		


	}

	public void setGroup(boolean on) {
		// TODO Auto-generated method stub
        group.setEnabled(on);
	}
	public void setUnGroup(boolean on) {
		// TODO Auto-generated method stub
        ungroup.setEnabled(on);
	}

	public void changeName(boolean on) {
		// TODO Auto-generated method stub
		changeObjectName.setEnabled(on);
	}
	
	public void resetMenuBar() {
		// TODO Auto-generated method stub
		group.setEnabled(false);
        ungroup.setEnabled(false);
        changeObjectName.setEnabled(false);
	}


}
