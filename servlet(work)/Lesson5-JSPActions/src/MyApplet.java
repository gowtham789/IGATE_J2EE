import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;


public class MyApplet extends Applet{
	
	public void paint(Graphics g)
	{
	   g.drawString("This is how an Applet looks like", 20, 20);
	   setBackground(Color.gray);
	   setForeground(Color.BLUE);
	}

}
