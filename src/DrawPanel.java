/**
 * @(#)DrawPanel.java
 *
 *
 * @author 
 * @version 1.00 2024/3/27
 */

import java.awt.Graphics2D;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class DrawPanel extends JPanel
{
	//create button variables and group variable
	ButtonGroup group;
	JRadioButton a;
	JRadioButton b;
	JRadioButton c;
	JRadioButton d;
	JPanel options;
	Dimension size;
	Font customFont = new Font("Arial", Font.PLAIN, 50);
	ImageIcon triangle[];
	ImageIcon rhombus[];
	ImageIcon square[];
	ImageIcon circle[];
	int triTotalFrames = 18, triCurrentFrame = 0;
	int rhomTotalFrames = 16, rhomCurrentFrame = 0;
	int circTotalFrames = 13, circCurrentFrame = 0;
	int sqTotalFrames = 6, sqCurrentFrame = 0;
	String name;
	int score;
	JPanel scorePanel;
	JLabel scoreLabel;
    public DrawPanel(String n, int s) 
    {
		name = n;
		score = s;
    	//create buttons
		triangle = new ImageIcon[triTotalFrames];
		rhombus = new ImageIcon[rhomTotalFrames];
		circle = new ImageIcon[circTotalFrames];
		square = new ImageIcon[sqTotalFrames];
		size = new Dimension(550, 100);
    	this.setBackground(Color.CYAN);
    	group = new ButtonGroup();
    	a = new JRadioButton("triangle");
    	b = new JRadioButton("square");
    	c = new JRadioButton("circle");
    	d = new JRadioButton("square");
		options = new JPanel();
		options.setLayout(new GridLayout(3,2));
		a.setBackground(Color.RED);
		b.setBackground(Color.BLUE);
		c.setBackground(Color.yellow);
		d.setBackground(Color.green);


		for(int i=0; i<triangle.length; i++)
		{
			ImageIcon originalIcon = new ImageIcon("src\\tri" +i+".png");
			// Get the original image
			Image originalImage = originalIcon.getImage();
			// Define the new width and height
			int newWidth = 100; // Specify your desired width
			int newHeight = 100; // Specify your desired height
			// Create a scaled instance of the image
			Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
			// Create a new ImageIcon with the scaled image
			ImageIcon scaledIcon = new ImageIcon(scaledImage);
			triangle[i]=scaledIcon;
		}
		for(int i=0;i<rhombus.length;i++)
		{
			ImageIcon originalIcon = new ImageIcon("src\\rhom" +i+".png");
			// Get the original image
			Image originalImage = originalIcon.getImage();
			// Define the new width and height
			int newWidth = 100; // Specify your desired width
			int newHeight = 100; // Specify your desired height
			// Create a scaled instance of the image
			Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
			// Create a new ImageIcon with the scaled image
			ImageIcon scaledIcon = new ImageIcon(scaledImage);
			rhombus[i]=scaledIcon;
		}
		for(int i=0;i<circle.length;i++)
		{
			ImageIcon originalIcon = new ImageIcon("src\\circ" +i+".png");
			// Get the original image
			Image originalImage = originalIcon.getImage();
			// Define the new width and height
			int newWidth = 100; // Specify your desired width
			int newHeight = 100; // Specify your desired height
			// Create a scaled instance of the image
			Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
			// Create a new ImageIcon with the scaled image
			ImageIcon scaledIcon = new ImageIcon(scaledImage);
			circle[i]=scaledIcon;
		}
		for(int i=0;i<square.length;i++)
		{
			ImageIcon originalIcon = new ImageIcon("src\\sq" +i+".png");
			// Get the original image
			Image originalImage = originalIcon.getImage();
			// Define the new width and height
			int newWidth = 100; // Specify your desired width
			int newHeight = 100; // Specify your desired height
			// Create a scaled instance of the image
			Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
			// Create a new ImageIcon with the scaled image
			ImageIcon scaledIcon = new ImageIcon(scaledImage);
			square[i]=scaledIcon;
		}
    	a.setIcon(triangle[0]);
		b.setIcon(rhombus[0]);
		c.setIcon(circle[0]);
		d.setIcon(square[0]);
		Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Increment the frame index
                triCurrentFrame = (triCurrentFrame + 1) % triangle.length;
                // Update the label with the new frame
                a.setRolloverIcon(triangle[triCurrentFrame]);

				rhomCurrentFrame = (rhomCurrentFrame+1)%rhombus.length;
				b.setRolloverIcon(rhombus[rhomCurrentFrame]);

				circCurrentFrame = (circCurrentFrame+1)%circle.length;
				c.setRolloverIcon(circle[circCurrentFrame]);

				sqCurrentFrame = (sqCurrentFrame+1)%square.length;
				d.setRolloverIcon(square[sqCurrentFrame]);
            }
        });
        timer.start();


    	
    	group.add(a);
    	group.add(b);
		group.add(c);
		group.add(d);
    	a.setRolloverEnabled(true);
    	b.setRolloverEnabled(true);
		c.setRolloverEnabled(true);
		d.setRolloverEnabled(true);
		options.add(a);
		options.add(b);
		options.add(c);
		options.add(d);
		a.setPreferredSize(size);
		b.setPreferredSize(size);
		c.setPreferredSize(size);
		d.setPreferredSize(size);
		a.setFont(customFont);
		b.setFont(customFont);
		c.setFont(customFont);
		d.setFont(customFont);
		scoreLabel = new JLabel(name+": "+score);
		options.add(new JLabel());
		options.add(scoreLabel);
    	this.add(options);
    }
    public boolean DetectSelect() 
    {
    	if (a.isSelected()||b.isSelected()||c.isSelected()||d.isSelected())
    	{
    		return true;
    	}
    	return false;
    }
    public String OptionSelect()
    {
    	if(a.isSelected())
    	{
    		return "a";
    	}
		if(b.isSelected())
		{
			return "b";
		}
		if(c.isSelected())
		{
			return "c";
		}
		if(d.isSelected())
		{
			return "d";
		}
		return "error";
    } 
	public void SetButtons(String a, String b, String c, String d)
	{
		this.a.setText(a);
		this.b.setText(b);
		this.c.setText(c);
		this.d.setText(d);

	}
	public void ScoreAdder(int s)
	{
		score += s;
		options.remove(scoreLabel);
		scoreLabel = new JLabel(name+": "+score);
		options.add(scoreLabel);
		System.out.println(score);
	}
	public void unselect()
	{
		group.clearSelection();
	}
}