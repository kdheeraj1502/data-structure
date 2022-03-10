package com.thread;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class RedImage {
	public final static String SOURCE_FILE = "./resources/many-flowers.jpg";
	public final static String DESTINATION_FILE = "./resources/output/many-flowers.jpg";

	public static void main(String args[]) throws IOException {
		File f = new File(SOURCE_FILE);
		BufferedImage img = ImageIO.read(f);
		int width = img.getWidth();
		int height = img.getHeight();
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int p = img.getRGB(x, y);

				int a = (p >> 24) & 0xff;
				int r = (p >> 16) & 0xff;

				// set new RGB
				// keeping the r value same as in original
				// image and setting g and b as 0.
				p = (a << 24) | (r << 16) | (0 << 8) | 0;

				img.setRGB(x, y, p);
			}
		}
		
		f = new File(DESTINATION_FILE);
		ImageIO.write(img, "jpg", f);
	}
}