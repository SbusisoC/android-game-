package luckyBox;

import java.util.*;
import java.util.Timer;
import java.awt.event.*;

import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.*;
import java.util.TimerTask;
import java.util.List;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private Image[] images;
    private Image[] images2;
    private Image[] images3;
    private Image[] images4; //for the bright light bulb
    private Image[] images5; // for the empty light bulb
    private Image[] images6; //for the check image
    
    private Image[] images7; //for the full life bar
    private Image[] images8; //for a half life bar
    private Image[] images9; //for an empty life bar
    
    private Image[] images10;
    private Image[] images11;
    
    
    private int[] xCoordinates;
    private int[] xCoordinates2;
    private int[] xCoordinates3;
    private int[] xCoordinates4;
    private int[] xCoordinates5;
    private int[] xCoordinates6;
    private int[] xCoordinates7;
    private int[] xCoordinates8;
    private int[] xCoordinates9;
    private int[] xCoordinates10;
    private int[] xCoordinates11;
    
    private boolean[] isDragging;
    
    private int clickCount = 0;//counter for the number of clicks
    private int clickCount2 = 0;
    private int clickCount3 = 0;
    private int boxCount = 0;
    private int lifebarCount = 0;
    private int draggedIndex = -1;
    private int correctMatches = 0;
 
    
    private Timer timer;
    private int seconds = 0;
    private List<ConfettiParticle> confettiParticles;
    private Timer confettiTimer;
	private Graphics g;
	private boolean gameWon = false;
	private boolean gameOver = false;
	
	private Timer resetTimer;
    
    private static Font FONT_L = new Font("Montserrat", Font.BOLD, 150);
    private static Font FONT_M_ITALIC = new Font("Montserrat", Font.ITALIC, 40);

    public Game() {
        super("Lucky Box");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        confettiParticles = new ArrayList<>();
        
      
        

        // Define and load multiple images using ImageIcon
        ImageIcon[] imageIcons = new ImageIcon[5]; // Replace 3 with the number of images you have

        imageIcons[0] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\coin.png");
        imageIcons[1] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\honeypot.png");
        imageIcons[2] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\moneystack.png");
        imageIcons[3] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\peach.png");
        imageIcons[4] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\star.png");

        // Convert ImageIcon objects to Image objects
        images = new Image[imageIcons.length];
        for (int i = 0; i < imageIcons.length; i++) {
            images[i] = imageIcons[i].getImage();
           
        }
        
        // Define and load multiple images using ImageIcon
        ImageIcon[] imageIcons3 = new ImageIcon[5]; // Replace 3 with the number of images you have

        imageIcons3[0] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\box1.png");
        imageIcons3[1] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\box1.png");
        imageIcons3[2] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\box1.png");
        imageIcons3[3] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\box1.png");
        imageIcons3[4] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\box1.png");

        // Convert ImageIcon objects to Image objects
        images3 = new Image[imageIcons3.length];
        for (int c = 0; c < imageIcons3.length; c++) {
            images3[c] = imageIcons3[c].getImage();
        }       
            
            ImageIcon[] imageIcons2 = new ImageIcon[5]; // Replace 3 with the number of images you have

            imageIcons2[0] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\coin1.png");
            imageIcons2[1] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\honeypot1.png");
            imageIcons2[2] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\moneystack1.png");
            imageIcons2[3] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\peach1.png");
            imageIcons2[4] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\star1.png");

            // Convert ImageIcon objects to Image objects
            images2 = new Image[imageIcons2.length];
            for (int a = 0; a < imageIcons2.length; a++) {
                images2[a] = imageIcons2[a].getImage();
                
                
        }
            
            ImageIcon[] imageIcons4 = new ImageIcon[1]; // Replace 3 with the number of images you have

            imageIcons4[0] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\bulb.png");
           

            // Convert ImageIcon objects to Image objects
            images4 = new Image[imageIcons4.length];
            for (int f = 0; f < imageIcons4.length; f++) {
                images4[f] = imageIcons4[f].getImage();
        }
            
            ImageIcon[] imageIcons5 = new ImageIcon[1]; // Replace 3 with the number of images you have

            imageIcons5[0] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\bulb2.png");
           

            // Convert ImageIcon objects to Image objects
            images5 = new Image[imageIcons5.length];
            for (int h = 0; h < imageIcons5.length; h++) {
                images5[h] = imageIcons5[h].getImage();
                
                
        }
            
            ImageIcon[] imageIcons6 = new ImageIcon[1]; // Replace 3 with the number of images you have

            imageIcons6[0] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\check3.png");
           

            // Convert ImageIcon objects to Image objects
            images6 = new Image[imageIcons6.length];
            for (int j = 0; j < imageIcons6.length; j++) {
                images6[j] = imageIcons6[j].getImage();
                
                
        }
            
            ImageIcon[] imageIcons7 = new ImageIcon[1]; // Replace 3 with the number of images you have

            imageIcons7[0] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\lifebar3.png");
           

            // Convert ImageIcon objects to Image objects
            images7 = new Image[imageIcons7.length];
            for (int k = 0; k < imageIcons7.length; k++) {
                images7[k] = imageIcons7[k].getImage();
                
                
        }
            
            ImageIcon[] imageIcons8 = new ImageIcon[1]; // Replace 3 with the number of images you have

            imageIcons8[0] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\lifebar2.png");
           

            // Convert ImageIcon objects to Image objects
            images8 = new Image[imageIcons8.length];
            for (int l = 0; l < imageIcons8.length; l++) {
                images8[l] = imageIcons8[l].getImage();
                
                
        }
            
            ImageIcon[] imageIcons9 = new ImageIcon[1]; // Replace 3 with the number of images you have

            imageIcons9[0] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\lifebar1.png");
           

            // Convert ImageIcon objects to Image objects
            images9 = new Image[imageIcons9.length];
            for (int m = 0; m < imageIcons9.length; m++) {
                images9[m] = imageIcons9[m].getImage();
                
                
        }
            
            ImageIcon[] imageIcons10 = new ImageIcon[1]; // Replace 3 with the number of images you have

            imageIcons10[0] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\front.png");
           

            // Convert ImageIcon objects to Image objects
            images10 = new Image[imageIcons10.length];
            for (int r = 0; r < imageIcons10.length; r++) {
                images10[r] = imageIcons10[r].getImage();
                
                
        }
            ImageIcon[] imageIcons11 = new ImageIcon[1]; // Replace 3 with the number of images you have

            imageIcons11[0] = new ImageIcon("C:\\Users\\sbusi\\OneDrive\\Desktop\\Lucky Box\\src\\luckyBox\\play.png");
           

            // Convert ImageIcon objects to Image objects
            images11 = new Image[imageIcons11.length];
            for (int t = 0; t < imageIcons11.length; t++) {
                images11[t] = imageIcons11[t].getImage();
                
                
        }
  
        setBackground(new Color(137, 207, 240));
    
    
        
        xCoordinates = new int[images.length];
        xCoordinates[0] = -400;
        xCoordinates[1] = -170;
        xCoordinates[2] = 100;
        xCoordinates[3] = 400;
        xCoordinates[4] = 650;
        
        
        shuffleXCoordinates();
        

        
        xCoordinates3 = new int[images3.length];
        xCoordinates3[0] = -400;
        xCoordinates3[1] = -170;
        xCoordinates3[2] = 100;
        xCoordinates3[3] = 400;
        xCoordinates3[4] = 650;
        
        xCoordinates2 = new int[images2.length];
        xCoordinates2[0] = 800;
        xCoordinates2[1] = 800;
        xCoordinates2[2] = 800;
        xCoordinates2[3] = 800;
        xCoordinates2[4] = 800;
        
        xCoordinates4 = new int[images4.length];
        xCoordinates4[0] = 1100;
        
        xCoordinates5 = new int[images5.length];
        xCoordinates5[0] = 1100;
        
        xCoordinates6 = new int[images6.length];
        xCoordinates6[0] = 520;
        
        xCoordinates7 = new int[images7.length];
        xCoordinates7[0] = 532;
        
        xCoordinates8 = new int[images8.length];
        xCoordinates8[0] = 532;
        
        xCoordinates9 = new int[images9.length];
        xCoordinates9[0] = 532;
        
        xCoordinates10 = new int[images10.length];
        xCoordinates10[0] = -200;
        
        xCoordinates11 = new int[images11.length];
        xCoordinates11[0] = 465;
        
       
        
        isDragging = new boolean[images2.length];
        Arrays.fill(isDragging, false);
        
    
        

       JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                render(g);
                
                Toolkit.getDefaultToolkit().sync();
            }
            
            private void render(Graphics g) {
                
                
                //Set background color
                g.setColor(new Color(10, 207, 240));
                g.fillRect(0, 0, getWidth(), getHeight());
                
                
                
                // Draw the loaded images on the panel
                for (int i = 0; i < images.length; i++) {
                    int y = 200; // Adjust the x-coordinate for each image
                    g.drawImage(images[i], xCoordinates[i], y, this);
                   /* g.drawImage(images[i], i * 150, y, this);*/
                }
                
              //box images
                for (int c = 0; c < images3.length; c++) {
                    int y = 200; // Adjust the x-coordinate for each image
                    g.drawImage(images3[c], xCoordinates3[c], y, this);
                }
                    
                    //second images 
                for (int a = 0; a < images2.length; a++){
                	g.drawImage(images2[a], xCoordinates2[a], a * -100, this);
                }
                
               // Plain bulb for clues
                for(int h = 0; h< images5.length; h++){
                	int y = 400;
                	g.drawImage(images5[h], xCoordinates5[h], y, this);
                }
                
                //bulb for clues
                for(int f = 0; f< images4.length; f++){
                	int y = 400;
                	g.drawImage(images4[f], xCoordinates4[f], y, this);
                }
                
              //check drawing
                for(int j = 0; j< images6.length; j++){
                	int y = 480;
                	g.drawImage(images6[j], xCoordinates6[j], y, this);
                	
                }
                
              //empty life bar drawing
                for(int m = 0; m< images9.length; m++){
                	int y = 435;
                	g.drawImage(images9[m], xCoordinates9[m], y, this);
              }
                
              //half life bar drawing
                for(int l = 0; l< images8.length; l++){
                	int y = 435;
                	g.drawImage(images8[l], xCoordinates8[l], y, this);
              }
                
                //full life bar drawing
                  for(int k = 0; k< images7.length; k++){
                  	int y = 435;
                  	g.drawImage(images7[k], xCoordinates7[k], y, this);
                }
                  //home drawing
                  for(int r = 0; r< images10.length; r++){
                    	int y = -250;
                    	g.drawImage(images10[r], xCoordinates10[r], y, this);
                  }
                  
                //play button
                  for(int t = 0; t< images11.length; t++){
                    	int y = 250;
                    	g.drawImage(images11[t], xCoordinates11[t], y, this);
                  }
                
                //Confetti drawing
                for(int s = confettiParticles.size() - 1; s>= 0; s--){
                	ConfettiParticle particle = confettiParticles.get(s);
                	particle.move();
                	particle.draw(g);
                	
                	//Remove particles that have gone off the screen
                	if(particle.getY() > getHeight()){
                		confettiParticles.remove(s);
                		
                	}
                	if(gameWon){
                		drawCenteredString(g, "YOU WON", FONT_L, 500);
                		drawCenteredString(g, "Press enter to start again", FONT_M_ITALIC, 540);
                		
                	}
                }
             
                if(gameOver) {
                	drawCenteredString(g, "GAME OVER", FONT_L, 500);
                	drawCenteredString(g, "Press enter to start again", FONT_M_ITALIC, 540);
                	
                }
            }
        };
        
        panel.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mousePressed(MouseEvent e){
        		
        		Point mousePoint = e.getPoint();
        		
        		
        		Rectangle imageRect6 = new Rectangle(xCoordinates6[0], 600, images6[0].getWidth(null), images6[0].getHeight(null));
                if (imageRect6.contains(mousePoint)) {
                	if(clickCount2 < 3) {
                		
                		
                		clickCount2++;
                		lifebarCount++;
                		
                		if(clickCount2 == 1) {
                			checkMatch();
                			handleGameWin();
                		}
                		
                		if(clickCount2 == 2) {
                			checkMatch();
                			handleGameWin();
                		}
                		
                		if(clickCount2 == 3) {
                			xCoordinates6[0] = 8000; //Move off-screen
                			checkMatch();
                			handleGameWin();
                		}
                		
                		if(lifebarCount == 1) { //removing the boxes
                         	xCoordinates7[0]= 8000;
                         	/*repaint();*/
                        }
                		 
                		if(lifebarCount == 2) { //removing the boxes
                          	xCoordinates8[0]= 8000;
                          	/*repaint();*/
                        }
                		if(lifebarCount == 3) { //removing the boxes
                           	xCoordinates9[0]= 8000;
                           	repaint();
                        }
                	}
                }
        
        		
        		// Check if the click is within the bounds of image4
                Rectangle imageRect4 = new Rectangle(xCoordinates4[0], 600, images4[0].getWidth(null), images4[0].getHeight(null));
                if (imageRect4.contains(mousePoint)) {
                    if (clickCount < 2) { // Allow only 2 clicks
                    	
                        clickCount++;
                        boxCount++;
                        
                        if (clickCount == 2) {
                            // Remove image4 after 2 clicks
                            xCoordinates4[0] = 8000; // Move it off-screen
                        }
                        
                        if(boxCount == 1 || boxCount == 2) { //removing the boxes
                        	xCoordinates3[boxCount - 1]= 8000;
                        	repaint();
                        }
                    }
                }
                Rectangle imageRect11 = new Rectangle(xCoordinates11[0], 465, images11[0].getWidth(null), images11[0].getHeight(null));
                if (imageRect11.contains(mousePoint)) {
                    if (clickCount3 < 2) { // Allow only 2 clicks
                    	clickCount3++;
                    	
                        if(clickCount3 == 1)	{
                    	   xCoordinates10[0] = 8000;
                    	   xCoordinates11[0] = 8000;
                        }
                    	
                    }
                }
                
        		
        		for(int a = 0; a< images2.length; a++){
        			Rectangle imageRect = new Rectangle(xCoordinates2[a], -100 * a -600, images2[a].getWidth(null),
                            images2[a].getHeight(null));
                    if (imageRect.contains(mousePoint)) {
                        isDragging[a] = true;
                        draggedIndex = a;
                    }
        		}
        	}	
        	
        	@Override
        	public void mouseReleased(MouseEvent e){
        		if(draggedIndex != -1){
        			isDragging[draggedIndex] = false;
        			checkMatch();
        			draggedIndex = -1;
        		}
        	}
        });
        
        panel.addMouseMotionListener(new MouseMotionAdapter(){
        	@Override
        	public void mouseDragged(MouseEvent e){
        		if(draggedIndex != -1){
        			xCoordinates2[draggedIndex] = e.getX() - images2[draggedIndex].getWidth(null) / 2;
                    repaint();
        		}
        	}
        });
        
        panel.addKeyListener(new KeyAdapter(){
        	@Override
        	public void keyPressed(KeyEvent e) {
        		int key = e.getKeyCode();
        		
        		if(gameOver && key == KeyEvent.VK_ENTER){
        			resetGame();
        		}else if (gameWon && key == KeyEvent.VK_ENTER) {
                    resetGame();
                }
        		
        		
        	}
        });
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        
        add(panel);
        setVisible(true);
        
        confettiTimer = new Timer();
        confettiTimer.scheduleAtFixedRate(new TimerTask() {
        	@Override
        	public void run(){
        		updateConfetti();
        		repaint();
        		seconds++;
        		System.out.println("Time elapsed: " + seconds + " seconds");
        	}
        },0, 400);
    }
    
    public void drawCenteredString(Graphics g, String text, Font font, int y){
    	FontMetrics metrics = g.getFontMetrics(font);
    	int x = (getWidth()-metrics.stringWidth(text))/2;
    	
    	g.setFont(font);
    	g.setColor(Color.BLACK);
    	g.drawString(text, x, y);
    }
    
    private void shuffleXCoordinates() {
        Random random = new Random();
        for (int i = xCoordinates.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Swap xCoordinates[i] and xCoordinates[index]
            int temp = xCoordinates[i];
            xCoordinates[i] = xCoordinates[index];
            xCoordinates[index] = temp;
        }
    }
    
    private void checkMatch(){
    	int tolerance = 70; 
    	int correctMatches1 = 0;
    	int correctMatches2 = 0;

    	
    	for(int a = 0; a < images2.length; a++){
    		if(Math.abs(xCoordinates[a] - xCoordinates2[a]) <= tolerance) {
                correctMatches1++;
                isDragging[a] = false;
    		}
    	}
    	
    	for (int a = 0; a < images.length; a++) {
            if (Math.abs(xCoordinates[a] - xCoordinates2[a]) <= tolerance) {
                correctMatches2++;
                isDragging[a] = false;
            }
        }
    	

    	if(correctMatches1 == images2.length && correctMatches2 == images.length){
    		gameWon = true;
   
    	}else {
    		
    		//check if number of tries has been reached
    		if(clickCount2 == 3) {
    			gameOver = true;
    			
    			return;
    		}
    	}
    	
    	repaint();
    }
    
    private void handleGameWin() {
        if (gameWon) {
            addConfetti(getWidth() / 2, getHeight() / 2, 100);
            /*images3 = new Image[images3.length];//empty array*/
            xCoordinates3[0] = 8000;
            xCoordinates3[1] = 8000;
            xCoordinates3[2] = 8000;
            xCoordinates3[3] = 8000;
            xCoordinates3[4] = 8000;
            repaint();
            timer.cancel();
          
        }
    }
    
    private void addConfetti(int x, int y, int count) {
        SwingUtilities.invokeLater(() -> {
            for (int s = 0; s < count; s++) {
                ConfettiParticle particle = new ConfettiParticle(x, y, 5);
                confettiParticles.add(particle);
            }
        });
    }
    
    private void updateConfetti() {
        for (int s = confettiParticles.size() - 1; s >= 0; s--) {
            ConfettiParticle particle = confettiParticles.get(s);
            particle.move();

            // Remove particles that have gone off the screen
            if (particle.getY() > getHeight()) {
                confettiParticles.remove(s);
            }
        }
    }
    private void resetGame() {
        // Reset game state variables
        gameWon = false;
        gameOver = false;
        clickCount = 0;
        clickCount2 = 0;
        boxCount = 0;
        lifebarCount = 0;
        
        
        xCoordinates = new int[images.length];
        xCoordinates[0] = -400;
        xCoordinates[1] = -170;
        xCoordinates[2] = 100;
        xCoordinates[3] = 400;
        xCoordinates[4] = 650;
        
        
        shuffleXCoordinates();
        

        
        xCoordinates3 = new int[images3.length];
        xCoordinates3[0] = -400;
        xCoordinates3[1] = -170;
        xCoordinates3[2] = 100;
        xCoordinates3[3] = 400;
        xCoordinates3[4] = 650;
        
        xCoordinates2 = new int[images2.length];
        xCoordinates2[0] = 800;
        xCoordinates2[1] = 800;
        xCoordinates2[2] = 800;
        xCoordinates2[3] = 800;
        xCoordinates2[4] = 800;
        
        xCoordinates4 = new int[images4.length];
        xCoordinates4[0] = 1100;
        
        xCoordinates5 = new int[images5.length];
        xCoordinates5[0] = 1100;
        
        xCoordinates6 = new int[images6.length];
        xCoordinates6[0] = 520;
        
        xCoordinates7 = new int[images7.length];
        xCoordinates7[0] = 532;
        
        xCoordinates8 = new int[images8.length];
        xCoordinates8[0] = 532;
        
        xCoordinates9 = new int[images9.length];
        xCoordinates9[0] = 532;
        
        
        //clear confetti
        confettiParticles.clear();

        // Reset other necessary variables or game elements

        // Repaint to update the game screen
        repaint();
    }
    
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Game();
        });
    }
}
