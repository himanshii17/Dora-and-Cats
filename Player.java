 package com.gamedevelopment.gaming.sprites;

 import javax.swing.ImageIcon;

 public class Player extends Sprite {
       public Player(){
     	  w=200;
     	  h=200;
     	  x=50;
     	  y=550;
     	  image = new ImageIcon(Player.class.getResource("sprite.gif"));
       }
       public void move() {
     	  x=x+speed;
       }
       public boolean outOfscreen() {
     	  return x>1530;
       }
}
