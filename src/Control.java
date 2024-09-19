/**
 * @(#)CircleOrSquare.java
 *
 *
 * @author 
 * @version 1.00 2024/3/27
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Control implements ActionListener
{	
	static String name;
	static String bg;
	static int time;
	static JButton b1;
    static JButton b2;
	static JPanel mainPanel;
	static JFrame frame;
	static ViewPanel screen;
	static DrawPanel shapes;
	static FirstPanel introPanel;
	static int score;
    public static void main(String[] args) 
    {
		Control to = new Control();
		frame = new JFrame();
		frame.setTitle("Noel Varghese");
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));			
		mainPanel.setBackground(Color.BLACK);
		JToolBar tb = new JToolBar();
		b1 = new JButton("Setup");
        b2 = new JButton("Game");
        b1.addActionListener(to);
        b2.addActionListener(to);
        JPanel panel = new JPanel();
        panel.add(b1);
        panel.add(b2);
        tb.add(panel);
        frame.add(tb, BorderLayout.NORTH);
		//## add the mainPanel to your Frame
		frame.add(mainPanel);
		//### add the two panels just created to the mainPanel
		introPanel = new FirstPanel();
		//mainPanel.add(introPanel);
		introPanel.setLayout(new GridLayout(3, 2));
		frame.setResizable(true);
		frame.setSize(1200,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//##make the frame that holds everything visible
		frame.setVisible(true);
		name = introPanel.getName();
		bg = introPanel.getBg();
		time = introPanel.getTime();
		
    }
	public void actionPerformed(ActionEvent e)
    {
     	if (e.getSource() == b2)
     	{
			time = introPanel.getTime();
			bg = introPanel.getBg();
			name = introPanel.getName();
    		mainPanel.removeAll();
			shapes = new DrawPanel(name, 0);
			screen = new ViewPanel((DrawPanel)shapes);
			screen.setTime(time);
  			mainPanel.add(screen);
			mainPanel.add(shapes);
  			frame.add(mainPanel, BorderLayout.CENTER);
			frame.repaint();
  			frame.setVisible(true);

     	}
        else if(e.getSource()==b1)
        {
        	mainPanel.removeAll();
  			mainPanel.add(introPanel);
  			frame.add(mainPanel, BorderLayout.CENTER);
			frame.repaint();
  			frame.setVisible(true);
        	       	
        }
    }
}

