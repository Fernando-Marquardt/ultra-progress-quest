package com.progressquest.ultra;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.progressquest.ultra.components.ImagePanel;
import com.progressquest.ultra.util.Resources;

/**
 *
 * @author fernando-marquardt
 */
public class FrontForm extends JFrame {

	private static final long serialVersionUID = 1L;

	private ImagePanel logoPanel;
	private JButton newSinglePlayerBtn;
	private JButton newMultiplayerBtn;
	private JButton loadGameBtn;
	private JButton exitBtn;

	public FrontForm() {
		initForm();
		initComponents();
	}

	private void initForm() {
		setResizable(false);
		setTitle("Ultra ProgressQuest");

		setLayout(new BorderLayout(10, 0));
		((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	private void initComponents() {
		logoPanel = new ImagePanel(Resources.LOGO_IMG);

		newSinglePlayerBtn = new JButton("New Game (Single Player)");
		newSinglePlayerBtn.setMnemonic('N');
		newSinglePlayerBtn.setToolTipText("Start a new single player game.");

		newMultiplayerBtn = new JButton("New Game (Multiplayer)");
		newMultiplayerBtn.setMnemonic('M');
		newMultiplayerBtn.setEnabled(false);
		newMultiplayerBtn.setToolTipText("Start a new multiplayer game (There is no multiplayer support right now)");

		loadGameBtn = new JButton("Load Game");
		loadGameBtn.setMnemonic('L');
		loadGameBtn.setToolTipText("Load a single player game");

		exitBtn = new JButton("Exit");
		exitBtn.setMnemonic('x');

		Box buttonsPanel = Box.createVerticalBox();
		buttonsPanel.add(newSinglePlayerBtn);
		buttonsPanel.add(Box.createVerticalGlue());
		buttonsPanel.add(newMultiplayerBtn);
		buttonsPanel.add(Box.createVerticalGlue());
		buttonsPanel.add(loadGameBtn);
		buttonsPanel.add(Box.createVerticalGlue());
		buttonsPanel.add(exitBtn);

		add(logoPanel, BorderLayout.WEST);
		add(buttonsPanel, BorderLayout.CENTER);

		pack();
	}

}
