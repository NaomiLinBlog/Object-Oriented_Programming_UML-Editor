package UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BaseObject.Object;
import BaseObject.baseObj;
import BaseObject.classObj;
import BaseObject.compositeObj;
import Line.baseLine;
import Mode.baseMode;




public class MyCanvas extends JPanel {
	public static baseMode currentMode;
	public static MyCanvas canvas;
	public static int objDepth=100;
	private List<baseLine> lineList  = new ArrayList<>();
	private List<baseObj> objList = new ArrayList<>();
	private List<Object> allObjList = new ArrayList<>();
	private List<baseObj> selectedObjList = new ArrayList<>();
	public Rectangle dragRectangle=null;
	MyCanvas() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
                if (currentMode !=  null) {
                    currentMode.mousePressed(e);
                    repaint();
                }
			}

			@Override
			public void mouseReleased(MouseEvent e) {

				if (currentMode != null) {
					currentMode.mouseReleased(e);

					revalidate();
					repaint();
				}
			}

		});

	}
  
	public static MyCanvas getCurrentCanvas() {
		if (canvas == null) {
			canvas = new MyCanvas();
		}
		return canvas;
	}

	public void setCurrentMode(baseMode mode) {
		currentMode = mode;
		removeOldPort();
		repaint();
		System.out.println(currentMode);

	}

    public static void removeOldPort() {
        for (baseObj tmpObj: canvas.getSelectedObj()) {
        	tmpObj.setSelected(false);
        }
        canvas.getSelectedObj().clear();
        canvas.dragRectangle=null;

    }
	
	public void add(baseObj tmpObj) {
		// TODO Auto-generated method stub

		objList.add(tmpObj);
	}
	
	public static int getCurrentDepth() {
		// TODO Auto-generated method stub
		objDepth=objDepth-1;
		return objDepth;
	}
	
 
	
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.setStroke(new BasicStroke(2.0f));
        
		//System.out.println("paint");
		for (Object obj : objList)
			allObjList.add(obj);
		for (Object line : lineList)
			allObjList.add(line);
		allObjList.sort(Comparator.comparing(Object::getDepth).reversed());

		for (Object obj : allObjList) {
			try {
				obj.draw(graphics2D);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(dragRectangle!=null)
        	graphics2D.drawRect(dragRectangle.x, dragRectangle.y, dragRectangle.width, dragRectangle.height);
		allObjList.clear();

    }

	public List<baseObj> getObjList() {
		// TODO Auto-generated method stub
		return objList;
	}

	public List<baseObj> getSelectedObj() {
		// TODO Auto-generated method stub
		return selectedObjList;
	}
    public List<baseLine> getLineList() {
        return lineList;
    }

	public void setGroupList() {
		// TODO Auto-generated method stub
		compositeObj tmpComposite=new compositeObj(selectedObjList);
		objList.add(tmpComposite);
		objList.removeIf(baseObj -> selectedObjList.contains(baseObj));
		selectedObjList.clear();
		selectedObjList.add(0,tmpComposite);
		MyMenuBar.getMenuBar().setGroup(false);
		//Main.getCurrentMenuBar().setUnGroup(true);
		repaint();
	}
    public void setUnGroupObj() {
    	List<baseObj> selectedGroup = selectedObjList.get(0).getObjList();
    	objList.remove(selectedObjList.get(0));
        for (baseObj tmpObj: selectedGroup) {
        	objList.add(tmpObj);
            tmpObj.setSelected(false);
        }
        MyMenuBar.getMenuBar().setUnGroup(false);
        repaint();
    }
    public void changeName() {
        String newName;
        newName = JOptionPane.showInputDialog("Input your new object name");
        if (newName != null && !newName.equals(""))
        	selectedObjList.get(0).changeObjName(newName);
        repaint();
    }


}