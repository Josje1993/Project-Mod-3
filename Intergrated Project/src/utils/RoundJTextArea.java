package utils;

import java.awt.Shape;
import java.awt.Graphics;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextArea;

public class RoundJTextArea extends JTextArea{
	
	private static final long serialVersionUID = 1L;
	private Shape shape;

	public RoundJTextArea(int x, int y){
		super(x, y);
		setOpaque(false);
	}
	
	protected void paintComponent(Graphics g){
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
		super.paintComponent(g);
	}
	
	protected void paintBorder(Graphics g){
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
	}
	
	public boolean contains(int x, int y){
		if( shape == null || !shape.getBounds().equals(getBounds())){
			shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 20, 20);
		}
		
		return shape.contains(x, y);
	}
}
