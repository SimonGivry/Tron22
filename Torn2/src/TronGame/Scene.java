package TronGame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Scene extends JPanel {
	
	private ImageIcon icoFond;
	private Image imgFond1;
	
	private ImageIcon icoPlayer;
	private Image imgPlayer;
	
	private int xPlayer1;
	private int dx;
	private int dy;	
	
	//**** CONSTRUCTEUR ****//
	public Scene() {
		
		super();
		
		this.xPlayer1 = -50;
		
		icoFond = new ImageIcon(getClass().getResource("/Images/black-background.jpg"));
		this.imgFond1 = this.icoFond.getImage();
		icoPlayer = new ImageIcon(getClass().getResource("/Images/lightwall_cyan.png"));
		this.imgPlayer = this.icoPlayer.getImage();
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
	}
	
	
	public int getDx() {return dx;}

	public void setDx(int dx) {this.dx = dx;}
		
	public int getDy() {return dy;}

	public void setDy(int dy) {this.dy = dy;}


	public void deplacementPlayer() {
		
		this.xPlayer1 = this.xPlayer1 - this.dx;
		/*this.xPlayer1 = this.xPlayer1 - this.dy;*/
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		this.deplacementPlayer();
		
		
		g2.drawImage(this.imgFond1,  this.xPlayer1, 0, null);
		g2.drawImage(imgPlayer, 300, 200, null);
		
	}
	

}
