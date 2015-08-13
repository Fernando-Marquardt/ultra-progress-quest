package com.progressquest.ultra.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * A panel used to show an image as component.
 *
 * @author fernando-marquardt
 */
public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Image image;

	public ImagePanel(Image image) {
		this.image = image;

		Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));

		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}

}
