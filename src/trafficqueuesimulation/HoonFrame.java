/**
 * @title title
 * @packagename trafficqueuesimulation
 * @filename HoonFrame.java
 * @author yhj
 * @since 2016. 7. 27.
 * @version 1.0.0.0
 *
 * == Modification Information ==
 *
 * DATA				AUTHOR		NOTE
 * -----------		--------	---------------------------
 * 2016. 7. 27.			yhj		Create.
 *
 */
package trafficqueuesimulation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.util.Pair;

/**
 * @author yhj
 * @since 2016. 7. 27.
 *
 * It implements Runnable to call repaint() anytime.
 *
 */
class HoonPanel extends JPanel implements MouseListener{
	public Car tempCar = new Car(new Pair<Integer, Integer>(30, 70));
	public StraightLane tempSLane = new StraightLane(true,
			new Pair<Integer, Integer>(100, 100), new Pair<Integer, Integer>(100, 300) );
	
	public int[][] arrdata=new int[22][22];
	
	public HoonPanel(){
		super();
		this.addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				if (arrdata[i][j] == 1) {
					g.setColor(Color.gray);
				} else {
					g.setColor(Color.yellow);
				}
				int x = 64 * i;
				int y = 64 * j;
				g.fillRect(x, y, 64, 64);
			}
		}

		this.tempCar.paintComponent(g);
		this.tempSLane.paintComponent(g);
		

		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int x=e.getX();
		int y=e.getY();
		
		if (arrdata[x / 64][y / 64] == 0) {
			arrdata[x / 64][y / 64] = 1;
		} else {
			arrdata[x / 64][y / 64] = 0;
		}

		repaint();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
public class HoonFrame extends JFrame implements Runnable{

	JPanel downPanel = null;
	JPanel leftPanel = null;
	HoonPanel mainPanel = null;
	
	/**
	 * To Make a new HoonFrame.
	 */
	public HoonFrame(){
		this.setLayout(new BorderLayout());
			downPanel = new JPanel();
			downPanel.setBackground(Color.darkGray);
			downPanel.setVisible(true);
			this.add(downPanel, BorderLayout.SOUTH);
			
			leftPanel = new JPanel();
			leftPanel.setBackground(Color.gray);
			leftPanel.setVisible(true);
			this.add(leftPanel, BorderLayout.EAST);
			
			mainPanel = new HoonPanel();
			mainPanel.setBackground(Color.cyan);
			mainPanel.setVisible(true);
			mainPanel.addMouseListener(new HoonPanel());
			this.add(mainPanel, BorderLayout.CENTER);
			
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(768, 768);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HoonFrame myFrame = new HoonFrame();
		Thread painter = new Thread(myFrame);
		painter.start();

	}

	
	@Override
	public void run() {
		while(true){
			this.repaint();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void repaint(){
		Graphics g = this.getGraphics();
		this.downPanel.repaint();
		this.leftPanel.repaint();
		this.mainPanel.paintComponent(g);
	}
}
