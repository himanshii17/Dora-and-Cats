package com.gamedevelopment.gaming;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.gamedevelopment.gaming.sprites.Enemy;
import com.gamedevelopment.gaming.sprites.Player;

public class Board extends JPanel {
	Timer timer;
	BufferedImage backgroundImage;
	Player player;
	Enemy enemies[] = new Enemy[3];
	private boolean isgameover;
      // jPanel used to paint
	public Board() {
		setSize(1530,820);
		loadbackgroundimage();
		player = new Player();
		loadEnemies();
		gameloop();
		bindEvents();
		setFocusable(true);
	}
	
	private void gameOver(Graphics pen) {
		if(player.outOfscreen()) {
			setBackground(Color.black);
			pen.setFont(new Font("cursive",Font.BOLD,100) );
			pen.setColor(Color.black);
			pen.drawString(" huraah..! You Win",1200/2,650/2);
			timer.stop();
			return;
		}
		for(Enemy enemy:enemies) {
			if(isCollide(enemy)) {
				pen.setFont(new Font("cursive",Font.BOLD,100) );
				pen.setColor(Color.white);
				pen.drawString("OOps..! You Lose",1200/2,650/2);
				timer.stop();
				 isgameover = true;
				 repaint();
			}
		}
	}
	private boolean isCollide(Enemy enemy) {
		int xdistance=Math.abs(player.x-enemy.x);
		int ydistance=Math.abs(player.y-enemy.y);
		int maxh=Math.max(player.h, enemy.h);
		int maxw=Math.max(player.w, enemy.w);
		return xdistance <= maxw-139 && ydistance <=maxh-139;
	}
	private void bindEvents() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_RIGHT)
				player.speed=10;
				else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					player.speed = -10;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				player.speed=0;
			}
			
		});
	}
	private void loadEnemies() {
		int x=400;
		int gap=450;
		int speed = 5;
		for(int i=0;i<enemies.length;i++) {
			enemies[i]=new Enemy(x,speed);
			x=x+gap;
			speed=speed+5;
		}
	}
	
	private void gameloop() {
		timer = new Timer(50,(e)->repaint());
		timer.start();
	}
	//to specify colours and paint it
	private void loadbackgroundimage() {
		try {
			backgroundImage=ImageIO.read(Board.class.getResource("game-bg.jpg"));
		} catch (IOException e) {
			System.out.println("background image not found...");
			System.exit(1);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void printEnemies(Graphics pen) {
		for(Enemy enemy:enemies) {
			enemy.draw(pen);
			enemy.move();
		}
	}
	@Override
	public void paintComponent(Graphics pen){
		super.paintComponent(pen); //cleanup
		//all printing logic
		if(isgameover) {
			setBackground(Color.black);
		}
		else {
		pen.drawImage(backgroundImage,0,0,1530,920,null);
		player.draw(pen);
		player.move();
		printEnemies(pen);
		}
		gameOver(pen);
	}
}
