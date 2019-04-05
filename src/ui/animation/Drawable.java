package ui.animation;



import java.awt.Graphics;

/**
 *  Purpose:	The Drawable interface allows objects to register
 *    		with the animator.  It defines one method, a draw
 *		method, that takes a single parameter, a Graphics
 *		object.
 */
interface Drawable {
    public void draw(Graphics g);
}