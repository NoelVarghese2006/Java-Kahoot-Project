/**
 * @(#)ViewPanel.java
 *
 *
 * @author 
 * @version 1.00 2024/3/27
 */
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Graphics2D;
import  javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;



public class ViewPanel extends JPanel implements MouseListener, ActionListener
{  //Create two instance fields - a Timer and a ShapesPanel
	Timer stopwatch;
	DrawPanel shapesPanel;
	int origTime;
	int time;
	String[] questions;
	String[] answers;
	String[] options;
	int current = 0;

    public ViewPanel(DrawPanel shapes) 
    {
		questions = new String[5];
		questions[0] = "What is 1 + 1";
		questions[1] = "What class period is it";
		questions[2] = "Name the capital of texas";
		questions[3] = "What is the most popular AP class";
		questions[4] = "";
		options = new String[20];
		options[0] = "3";
		options[1] = "2";
		options[2] = "1";
		options[3] = "4";

		options[4] = "5 Period";
		options[5] = "6 Period";
		options[6] = "7 Period";
		options[7] = "0 Period";

		options[8] = "Dallas";
		options[9] = "Houstin";
		options[10] = "Austin";
		options[11] = "Galveston";

		options[12] = "Literature";
		options[13] = "Calculus AB";
		options[14] = "World History";
		options[15] = "Language";

		options[16] = "Thank";
		options[17] = "You";
		options[18] = "For";
		options[19] = "Playing";

		answers = new String[5];
		answers[0] = "b";
		answers[1] = "a";
		answers[2] = "c";
		answers[3] = "d";
		answers[4] = "temp";

	

    	this.setBackground(Color.BLACK);
    	shapesPanel = shapes;
    	stopwatch = new Timer(1000, new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
				time--;
    			repaint();
    		}
    	});
    	stopwatch.start();
    	addMouseListener(this);

    }
    public void mousePressed(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}	
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("submit")) {
            // set the text of the label to the text of the field

 
            // set the text of field to blank
            //t.setText("  ");
        }
    }
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Font customFont = new Font("Arial", Font.PLAIN, 50);
		g.setFont(customFont);
		g.setColor(Color.WHITE);
		g.drawString(questions[current], 400, 110);
		shapesPanel.SetButtons(options[current*4],options[current*4+1],options[current*4+2],options[current*4+3]);
		if(current == 4)
		{
			g.drawString("Final Score: " + shapesPanel.score+"/4000", 400, 110);
		}
		if(time<0)
		{
			current++;
			time = origTime+1;
		}
		else if(shapesPanel.DetectSelect())
		{
			String choice = shapesPanel.OptionSelect();
			System.out.println(choice);
			System.out.println(answers[current]);
			if(choice.equals(answers[current]))
			{
				shapesPanel.ScoreAdder((int)(1000*(double)time/(double)origTime));
			}
			current++;
			time = origTime+1;
			shapesPanel.unselect();
			
		}
		g.drawString(""+time, 100, 110);
		
	}
	public void setTime(int t)
	{
		origTime = t;
		time = origTime;
	}
}