package BaseObject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class classObj extends baseObj {
	public classObj(Point point, int currentDepth) {

		this.depth = currentDepth;
		this.startPoint = point;
		this.name = "Class Name";
		this.height = 100;
		updatePortPosition();
	}

	@Override
	public void draw(Graphics2D graphics2D) throws IOException {
		BufferedImage image = ImageIO.read(new File("src/image/canvasClass.png"));
		Font font = new Font("Arial", Font.BOLD, 14);
		graphics2D.setFont(font);
		graphics2D.drawImage(image, startPoint.x, startPoint.y, 100, 100, Color.WHITE, null);
		graphics2D.drawString(this.name, startPoint.x + 10, startPoint.y + 22);
		
		if (this.isSelected) {
			for (baseObjPort port : portList) {
				port.draw(graphics2D);
			}
		}
	}

}
