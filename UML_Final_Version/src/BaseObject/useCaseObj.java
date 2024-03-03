package BaseObject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class useCaseObj extends baseObj {
	public useCaseObj(Point point, int currentDepth) {

		this.depth = currentDepth;
		this.startPoint = point;
		this.name = "Case Name";
		this.height = 67;
		System.out.println(this.depth);
		updatePortPosition();
	}

	@Override
	public void draw(Graphics2D graphics2D) throws IOException {
		BufferedImage image = ImageIO.read(new File("src/image/canvasUsecase.png"));
		Font font = new Font("Arial", Font.BOLD, 14);
		graphics2D.setFont(font);
		graphics2D.setColor(Color.WHITE);
		graphics2D.fillOval(startPoint.x, startPoint.y, 100, 67);
		graphics2D.setColor(Color.BLACK);
		graphics2D.drawImage(image, startPoint.x, startPoint.y, 100, 67,null, null);
		graphics2D.drawString(this.name, startPoint.x + 12, startPoint.y + 38);
		
		if (this.isSelected) {
			for (baseObjPort port : portList) {
				port.draw(graphics2D);
			}
		}
	}

}