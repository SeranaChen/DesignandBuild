package webProject.listener;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.Arrays;

import java.io.IOException;

/*
 * This class is responsible for drawing the image on the map
 */
public class drawMap {
	public static int last_x = 10;
    public static int last_y = 85;
    public static int number = 0;
    public static int fact_direction = 0;

    public static void method(String[] content) {
        try {
            File file = new File(content[0]); // the image address
            BufferedImage image = null;

            // check whether the image exists or not
            if (file.exists()) {
                image = ImageIO.read(file);
            } else {
                // if not，create a new BufferedImage
                image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_ARGB);
            }

            // obtain a Graphics2D object
            Graphics2D g2d = image.createGraphics();

            // draw a image
            g2d.setColor(Color.BLACK);
            int last_time = Integer.parseInt(content[2]);
            int current_time = Integer.parseInt(content[3]);
            int direction = Integer.parseInt((content[1]));

            int length = (current_time - last_time)/1000;
            int[] x_y = finalPoint(new int[]{last_x, last_y}, length, direction, number);
            System.out.println(Arrays.toString(x_y));
            g2d.drawLine(last_x, last_y, x_y[0], x_y[1]);
            last_x = x_y[0];
            last_y = x_y[1];
            System.out.println(last_x);
            System.out.println(last_y);
            number++;


            // release the resource
            g2d.dispose();

            // write the image into the document
            ImageIO.write(image, "png", file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //the function to find out the destination point based on the transmitted data
    public static int[] finalPoint(int[] x_y, int length, int direction, int number){//规定第一次方向为2
    	int targetX = 10;
    	int targetY = 85;
    	//the two judges are the key to realize the direction changing
    	if(direction==1) {
    		fact_direction = (fact_direction + 1)%4;
    		System.out.println("fact_direction="+fact_direction);
    		System.out.println(Arrays.toString(x_y));
    		switch(fact_direction) {
    		case 0:
    			targetX = x_y[0];
                targetY = x_y[1] - length;
                break;
    		case 1:
    			targetX = x_y[0] - length;
                targetY = x_y[1];
                break;
    		case 2:
    			targetX = x_y[0];
                targetY = x_y[1] + length;
                break;
    		case 3:
    			targetX = x_y[0] + length;
                targetY = x_y[1];
                break;
    		}
    		x_y = new int[]{targetX, targetY};
    	}
    	else if(direction==2) {
    		fact_direction = (fact_direction + 3)%4;
    		System.out.println("fact_direction="+fact_direction);
    		System.out.println(Arrays.toString(x_y));
    		switch(fact_direction) {
	    		case 0:
	    			targetX = x_y[0];
	                targetY = x_y[1] - length;
	                break;
	    		case 1:
	    			targetX = x_y[0] - length;
	                targetY = x_y[1];
	                break;
	    		case 2:
	    			targetX = x_y[0];
	                targetY = x_y[1] + length;
	                break;
	    		case 3:
	    			targetX = x_y[0] + length;
	                targetY = x_y[1];
	                break;
    		}
    		x_y = new int[]{targetX, targetY};
    	}
        return x_y;
    }
}
