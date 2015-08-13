package com.progressquest.ultra.util;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resources {

	public static final Image LOGO_IMG;

	static {
		try {
			LOGO_IMG = ImageIO.read(Resources.class.getResource("/images/logo.png"));
		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

}
