import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.awt.Dimension;
import javax.swing.JPanel;

class PacManPanel extends JPanel implements Runnable, KeyListener{
	
	public static int height = 400; 
	public static int width = 400;
	Maze pacMaze = new Maze();	
	PacMan pacMan = new PacMan();

	public PacManPanel(){
		this.setPreferredSize(new Dimension(height,width));
		this.setFocusable(true);
		setDoubleBuffered(true);
		addKeyListener(this);
		new Thread(this).start();
	}	

	protected void paintComponent(Graphics g)
	{	
		Image image = createImage(height, width);
		Graphics g2 = image.getGraphics();
		
		g2.setColor(Color.BLACK);
		g2.fillRect(0,0,height,width);
		
		for(int y=0; y<pacMaze.getMaze().length; y++){
			for(int x=0; x < pacMaze.getMaze()[y].length; x++){
				if(pacMaze.getMaze()[y][x] == 1){
					g2.setColor(Color.BLUE);
					g2.drawRect(x*20,y*20,20,20);
				} else if(pacMaze.getMaze()[y][x] == 2){
					g2.setColor(Color.ORANGE);
					g2.fillOval(((x*20)+7),((y*20)+7),5,5);
				}
			}
		}

		
		
		g2.setColor(Color.YELLOW);
		g2.fillRect(pacMan.getPacManX(), pacMan.getPacManY(),20,20);
		g2.dispose();
		g.drawImage(image, 0, 0, null);
	}

	public void run()
	{
		while(true)
		{
			repaint();
			pacMan.move();
			try
			{
				Thread.sleep(20);
			}
			catch(Exception e)
			{
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e){

		int key = e.getKeyCode();
		boolean[] keys = new boolean[KeyEvent.KEY_TYPED];
		keys[e.getKeyCode()] = true;
		
		if (key == KeyEvent.VK_LEFT) {
			pacMan.setUp(false);
			pacMan.setDown(false);
			pacMan.setRight(false);
			pacMan.setLeft(true);	
		}

		else if (key == KeyEvent.VK_RIGHT){
			pacMan.setUp(false);
			pacMan.setDown(false);
			pacMan.setRight(true);
			pacMan.setLeft(false);
		}

		else if (key == KeyEvent.VK_UP){
			pacMan.setUp(true);
			pacMan.setDown(false);
			pacMan.setRight(false);
			pacMan.setLeft(false);
		}	

		else if (key == KeyEvent.VK_DOWN){
			pacMan.setUp(false);
			pacMan.setDown(true);
			pacMan.setRight(false);
			pacMan.setLeft(false);
		}
	}

	@Override
	public void keyReleased(KeyEvent e){
		//
	}
	
	@Override
	public void keyTyped(KeyEvent e){
		//
	}
	
}

	
