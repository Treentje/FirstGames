import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay2 extends JPanel implements KeyListener, ActionListener {
	// extend is for extending the class and implements for impementing an interface
	
	private int[] snakexlength = new int[750];
	private int[] snakeylength = new int[750];
			
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon rightmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	private ImageIcon leftmouth;
	
	private int lengthofsnake = 3;
	
	private Timer timer;
	//class for the timer
	private int delay = 100;
	//variable delay
	private ImageIcon ygmouths;
	// body snake
	
	private int [] talentxpose = {75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 450, 475, 500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850}; 
	private int [] talentypose = {125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 450, 475, 500, 525, 550, 575, 600, 625};
	
	private ImageIcon talentimage;
	
	private Random random= new Random();

	private int xpose = random.nextInt(32);
	//33 is the number of x positions in talentxpose
	private int ypose = random.nextInt(20);
	
	private int score = 0;
	
	private int moves = 0;
	
	private ImageIcon titleImage;
	
	public Gameplay2() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
		
	}
	// end constructor Gameplay2
	
	public void paint(Graphics g) {
		
		if(moves == 0) {
			snakexlength[2] = 50;
			snakexlength[1] = 75;
			snakexlength[0] = 100;
			
			snakeylength[2] = 100;
			snakeylength[1] = 100;
			snakeylength[0] = 100;
			
		}
		//default position of the snake before playing Problem: body is not visable at the end of part 3
		
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);
		//title image border setting
		
		titleImage = new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		//drawing the title image
		
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		// draw border playing area
		
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
		//draw gameplay background
		
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.PLAIN, 14));
		g.drawString("Scores : "+score, 780, 30);
		// to draw the scores
		
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.PLAIN, 14));
		g.drawString("Length : "+lengthofsnake,	780, 50);
		
		//to draw the length of the snake
		
		rightmouth = new ImageIcon("rightmouth.png");
		//to define the snake
		rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
		//to draw the snake
		
		
		for(int a =0; a < lengthofsnake; a++) {
			if(a==0 && right) {
				rightmouth = new ImageIcon("rightmouth.png");
				rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				
			}
			if(a==0 && left) {
				leftmouth = new ImageIcon("leftmouth.png");
				leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				
			}
			if(a==0 && down) {
				downmouth = new ImageIcon("downmouth (1).png");
				downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				
			}
			if(a==0 && up) {
				upmouth = new ImageIcon("upmouth.png");
				upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				
			}
			if(a!=0) {
				ygmouths = new ImageIcon("ygmouths.png");
				ygmouths.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				
			}
		}
		
		talentimage = new ImageIcon("JavaTalent.png");
		
		if((talentxpose[xpose] == snakexlength[0] && talentypose[ypose] == snakeylength[0])){
			
			
			score++;
			lengthofsnake++;
			xpose = random.nextInt(31);
			ypose = random.nextInt(20);
			
		}
		
		talentimage.paintIcon(this, g, talentxpose[xpose], talentypose[ypose]);
		
		
		for(int b = 1; b < lengthofsnake; b++) {
			if(snakexlength[b] == snakexlength[0] && snakeylength[b] == snakeylength[0]) {
				right = false;
				left = false;
				up = false;
				down = false;
				
				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("GAME OVER",300, 300);
				//for printing out message game over
						
				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("Space to RESTART",350, 340);
				//for printing out the message to hit spacebar to restart the game
			}
		}
		
		//define default length of the snake
		//and make a loop
		g.dispose();
		//toegevoegd tussen part 2 en 3 zonder uitleg
		//en in part 4weer va locatie veranderd?
		
	}
	// end method paint
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub from class Gameplay2
		timer.start();
		if(right) {
			for(int r = lengthofsnake - 1; r >=0; r--) {
				snakeylength[r+1] = snakeylength[r];
			}
			for(int r = lengthofsnake; r>=0; r--){
				if(r==0) {
					snakexlength[r] = snakexlength[r] + 25;
				}else {
					snakexlength[r] = snakexlength[r-1];
				}
				if(snakexlength[r] > 850) {
					//voor als de snake bij de rand van het speelveld komt aan rechts (pixel 850)
					snakexlength[r] = 25;
					//hij aan de linkerkant van het veld weer binnen komt
				}		
			}
			repaint();
			//to run method paint
		}
		if(left) {
			for(int r = lengthofsnake - 1; r >=0; r--) {
				snakeylength[r+1] = snakeylength[r];
			}
			for(int r = lengthofsnake; r>=0; r--){
				if(r==0) {
					snakexlength[r] = snakexlength[r] -25;
				}else {
					snakexlength[r] = snakexlength[r-1];
				}
				if(snakexlength[r] < 25) {
					//voor als de snake bij de rand van het speelveld komt aan linkt (pixel 25)  
					snakexlength[r] = 850;
					//hij aan de rechterkant van het veld weer binnen komt
				}		
			}
			repaint();
			//to run method paint
		}
		if(up) {
			for(int r = lengthofsnake - 1; r >=0; r--) {
				snakexlength[r+1] = snakexlength[r];
			}
			for(int r = lengthofsnake; r>=0; r--){
				if(r==0) {
					snakeylength[r] = snakeylength[r] -25;
				}else {
					snakeylength[r] = snakeylength[r-1];
				}
				if(snakeylength[r] < 75) {
					//voor als de snake bij de rand van het speelveld komt aan linkt (pixel 25)  
					snakeylength[r] = 625;
					//hij aan de rechterkant van het veld weer binnen komt
				}		
			}
			repaint();
			//to run method paint
		}
		if(down) {
			for(int r = lengthofsnake - 1; r >=0; r--) {
				snakexlength[r+1] = snakexlength[r];
			}
			for(int r = lengthofsnake; r>=0; r--){
				if(r==0) {
					snakeylength[r] = snakeylength[r] +25;
				}else {
					snakeylength[r] = snakeylength[r-1];
				}
				if(snakeylength[r] > 625){
					//voor als de snake bij de rand van het speelveld komt aan linkt (pixel 25)  
					snakeylength[r] = 75;
					//hij aan de rechterkant van het veld weer binnen komt
				}		
			}
			repaint();
			//to run method paint
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub from implement Keylistener
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub from implement Keylistener
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			moves = 0;
			score = 0;
			lengthofsnake = 3;
			repaint();
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moves++;
			right = true;
			if(!left) {
				right = true;
			}else {
				right = false;
				left = true;
			}
			
			up = false;
			down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			moves++;
			left = true;
			if(!right) {
				left = true;
			}else {
				left = false;
				right = true;
			}
			
			up = false;
			down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			moves++;
			up = true;
			if(!down) {
				up = true;
			}else {
				up = false;
				down = true;
			}
			
			right = false;
			left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			moves++;
			down = true;
			if(!up) {
				down = true;
			}else {
				down = false;
				up = true;
			}
			
			right = false;
			left = false;
		}
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub from implement Keylistener
		
	}

}
