/**
 * @(#)Animation.java
 *
 *
 * @author 
 * @version 1.00 2024/4/5
 */
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TriAnimate extends JPanel implements ActionListener
{
   // default constructor - will loop thru and fill an imageArray and start the timer.
   private Timer animator;
   public ImageIcon imageArray[];
   private int delay = 100, totalFrames = 31, currentFrame = 0;
   public TriAnimate()
   {
	   	imageArray = new ImageIcon[totalFrames];
	   	for(int i=0; i<imageArray.length;i++)
	   	{
	   		imageArray[i] = new ImageIcon("tri" + i + ".png");
	   	}
	   	animator = new Timer(delay, this);
	   	animator.start();
   }
   public void paintComponent(Graphics g)
   {
   		super.paintComponent(g);
   		if(currentFrame >= imageArray.length)
   			currentFrame = -1;
   		currentFrame++;
   		imageArray[currentFrame].paintIcon(this, g, 0, 0);
   }
   public void actionPerformed(ActionEvent e)
   {
   		repaint();
   }


    // write a startTimer method that has an ActionListener which will reset the frame count and repaint. 




   // use paintComponent



}