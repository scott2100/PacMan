import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

class PacManFrame{
	
	public PacManFrame(){
		JFrame frame = new JFrame();
		PacManPanel pacPanel = new PacManPanel();
		Maze mazePanel = new Maze();
		frame.add(pacPanel);
		frame.pack();
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String [] args){
		new PacManFrame();
	}
}
