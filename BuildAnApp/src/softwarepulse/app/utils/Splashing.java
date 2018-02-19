/**
 * 
 */
package softwarepulse.app.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

/**
 * @author John McNeil
 * @copyright Software Pulse 2014
 *
 */
public class Splashing {

	private static SplashScreen mySplash;
	private static Double splashTextArea;
	private static Double splashProgressArea;
	private static Graphics2D splashGraphics;
	private static Font font;
	
	public static void splashInit() {
		mySplash = SplashScreen.getSplashScreen();
		if(mySplash != null) {
			Dimension ssDim = mySplash.getSize();
			int height = ssDim.height;
			int width = ssDim.width;
			
			// Stake out some area for our status information
			splashTextArea = new Rectangle2D.Double(width * 0.15, height * 0.65, width * 0.75, 14 );
			splashProgressArea = new Rectangle2D.Double( width * 0.02, height * 0.85, width * 0.97, 7 );
			
			// Create the Graphics environment for drawing status information
			splashGraphics = mySplash.createGraphics();
			font = new Font("Dialog", Font.PLAIN, 12);
			splashGraphics.setFont(font);
			
			// initialise the status info
			splashText("Starting");
			splashProgress(0);
		}
	}
	
	public static void splashText(String str) {
		if(mySplash != null && mySplash.isVisible()) {
			// Erase the last status text
			splashGraphics.setPaint(Color.RED);
			splashGraphics.fill(splashTextArea);
			
			// Get metrics from the graphics
			FontMetrics metrics = splashGraphics.getFontMetrics(font);
			// get the height of a line of text in this font and render context
			int hgt = metrics.getHeight() - metrics.getDescent();
			// Get the advance of my text in this font and render context
			int adv = metrics.stringWidth(str);
			
			// draw the text
			splashGraphics.setPaint(Color.WHITE);
			if((splashTextArea.getMaxX()) > adv) {
				// centre the text
				splashGraphics.drawString(str, (int)((splashTextArea.getMaxX()- adv)/2),
						(int) (splashTextArea.getY() + hgt - metrics.getDescent()));
			} else {
				// display text left aligned
				splashGraphics.drawString(str, (int)(splashTextArea.width + 1),
						(int) (splashTextArea.getY() + hgt - metrics.getDescent()));
			}
			
			// make sure it's displayed
			mySplash.update();
		}
	}
	
	public static void splashProgress(int pct) {
		if(mySplash != null && mySplash.isVisible()) {
			// Erase the old progress line
			splashGraphics.setPaint(Color.WHITE);
			splashGraphics.fill(splashProgressArea);
			
			// Draw an outline
			splashGraphics.setPaint(Color.BLUE);
			splashGraphics.draw(splashProgressArea);
			
			// Calculate the width corresponding to the correct percentage
			int x = (int)splashProgressArea.getMinX();
			int y = (int)splashProgressArea.getMinY();
			int wid = (int)splashProgressArea.getWidth();
			int hgt = (int)splashProgressArea.getHeight();
			
			int doneWidth = Math.round((pct * wid)/100f);
			doneWidth = Math.max(0, Math.min(doneWidth, wid - 1));
			
			// Fill the done part one pixel smaller than the outline
			splashGraphics.setPaint(Color.BLUE);
			splashGraphics.fillRect(x, y + 1, doneWidth, hgt - 1);
			
			// make sure it's displayed
			mySplash.update();
		}
	}
	
	public static void Pause(int delay) {
		try {
			Thread.sleep(delay);
		} catch(InterruptedException ex) {
			// ignore it
		}
	}
}
