/**
 * @(#)FirstPanel.java
 *
 *
 * @author 
 * @version 1.00 2024/4/19
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

public class FirstPanel extends JPanel{
	JTextField askName;
	JSlider askTime;
	JList<String> askBg;
	JLabel n;

	
        
    /**
     * Creates a new instance of <code>FirstPanel</code>.
     */
    public FirstPanel() {
    	String bg[] = {"Summer", "Winter"};
    	askBg = new JList<String>(bg);
    	this.add(new JLabel("<html>Background</html>"));
    	this.add(askBg);
    	this.add(new JLabel("<html>Enter your name</html>"));
    	askName = new JTextField(16);
    	this.add(askName);
    	this.add(new JLabel("<html>Time</html>"));
    	askTime = new JSlider(10, 60);
    	this.add(askTime);
    }
    /*public void actionPerformed(ActionEvent e)
    {
    	String s = e.getActionCommand();
    	if(s.equals("submit"))
    	{
    		name = askName.getText();
			background = (String)askBg.getSelectedValue();
			time = askTime.getValue();

    	}
    }*/
    public String getBg()
    {
    	return (String)askBg.getSelectedValue();
    }
    public String getName()
    {
    	return askName.getText();
    }
    public int getTime()
    {
    	return askTime.getValue();
    }
    
}
