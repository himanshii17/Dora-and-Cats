package com.gamedevelopment.gaming;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    public GameFrame() {
    	Board board = new Board();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setTitle("Survivor Nobi");
    	this.setSize(1530, 820);
    	this.setResizable(false);
    	this.setLocationRelativeTo(null);
    	add(board);
    	this.setVisible(true);
//    	this is optional to write
    	
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          new GameFrame();
	}

}
