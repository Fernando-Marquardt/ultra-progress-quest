package com.progressquest.ultra.util;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resources {

    public static final Image LOGO_IMG;

    public static final Image APP_ICON_64;
    public static final Image APP_ICON_32;
    public static final Image APP_ICON_16;

    static {
        try {
            LOGO_IMG = ImageIO.read(Resources.class.getResource("/images/logo.png"));

            APP_ICON_64 = ImageIO.read(Resources.class.getResource("/icons/app_icon_64.png"));
            APP_ICON_32 = ImageIO.read(Resources.class.getResource("/icons/app_icon_32.png"));
            APP_ICON_16 = ImageIO.read(Resources.class.getResource("/icons/app_icon_16.png"));
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

}
