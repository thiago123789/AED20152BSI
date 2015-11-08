
import javax.swing.*;

import java.awt.Image;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Teste {
	static ImageIcon CIRCULO(){
		
		BufferedImage buffer = new BufferedImage(50, 50, BufferedImage.TRANSLUCENT);
		Graphics g = buffer.createGraphics();
		g.setColor(Color.GREEN);
		g.fillOval(0, 0, 15, 15);
		
		return new ImageIcon(buffer);
		
		
	}
	
	
	public static void main(String[] args) {
//		ImageTool it = new ImageTool(CIRCULO());
		System.out.println(CIRCULO());
	}
}
