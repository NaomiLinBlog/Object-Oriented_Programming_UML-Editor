package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import UI.MyMenuBar;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	public MyFrame frame;
	public MyMenuBar menubar;  
	public MyCanvas canvas;
	public MyToolBar toolbar;
	public Main () {

		frame = new MyFrame();
		menubar = MyMenuBar.getMenuBar();
		toolbar = new MyToolBar();
		canvas =MyCanvas.getCurrentCanvas();
		frame.add(menubar, BorderLayout.NORTH);
		frame.add(toolbar, BorderLayout.WEST);
		frame.add(canvas, BorderLayout.CENTER);
        frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		Main main = new Main();
	}

}
