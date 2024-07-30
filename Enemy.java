package com.gamedevelopment.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Enemy extends Sprite{
	  public Enemy(int x,int speed){
		  y=30;
		  this.x=x;
		  this.speed=speed;
    	  w=100;
    	  h=100;
    	  image = new ImageIcon(Enemy.class.getResource("airian-cong-spider.gif"));
      }
      public void draw(Graphics pen) {
    	  pen.drawImage(image.getImage(),x,y,w,h,null);
      }
      public void move() {
    	  if(y>830) {
    		  y=0;
    	  }
    	  y=y+speed;
      }
}
