package com.progressquest.ultra;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.progressquest.ultra.components.ImagePanel;
import com.progressquest.ultra.util.Resources;

import net.miginfocom.swing.MigLayout;

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
        initEvents();
    }

    private void initForm() {
        setResizable(false);
        setTitle("Ultra Progress Quest");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(new BorderLayout(10, 10));
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        List<Image> icons = new ArrayList<>();
        icons.add(Resources.APP_ICON_64);
        icons.add(Resources.APP_ICON_32);
        icons.add(Resources.APP_ICON_16);

        setIconImages(icons);
    }

    private void initComponents() {
        logoPanel = new ImagePanel(Resources.LOGO_IMG);

        newSinglePlayerBtn = new JButton("New Game (Single Player)");
        newSinglePlayerBtn.setBackground(null);
        newSinglePlayerBtn.setMnemonic('N');
        newSinglePlayerBtn.setToolTipText("Start a new single player game.");

        newMultiplayerBtn = new JButton("New Game (Multiplayer)");
        newMultiplayerBtn.setBackground(null);
        newMultiplayerBtn.setMnemonic('M');
        newMultiplayerBtn.setEnabled(false);
        newMultiplayerBtn.setToolTipText("Start a new multiplayer game (There is no multiplayer support right now)");

        loadGameBtn = new JButton("Load Game");
        loadGameBtn.setBackground(null);
        loadGameBtn.setMnemonic('L');
        loadGameBtn.setToolTipText("Load a single player game");

        exitBtn = new JButton("Exit");
        exitBtn.setBackground(null);
        exitBtn.setMnemonic('x');

        JPanel buttonsPanel = new JPanel(new MigLayout("", "[grow]", "[grow]"));
        buttonsPanel.setBackground(null);
        buttonsPanel.add(newSinglePlayerBtn, "grow, wrap");
        buttonsPanel.add(newMultiplayerBtn, "grow, wrap");
        buttonsPanel.add(loadGameBtn, "grow, wrap");
        buttonsPanel.add(exitBtn, "grow");

        JLabel copyrightLbl = new JLabel("\u00a9 2015 Fernando Marquardt - v0.0.1");
        JPanel copyrightPanel = new JPanel(new MigLayout("", "[grow, align center]"));
        copyrightPanel.setBackground(null);
        copyrightPanel.add(copyrightLbl);

        add(logoPanel, BorderLayout.WEST);
        add(buttonsPanel, BorderLayout.CENTER);
        add(copyrightPanel, BorderLayout.SOUTH);

        pack();
    }

    private void initEvents() {
        newSinglePlayerBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                createNewCharacter();
            }
        });
    }

    private void createNewCharacter() {
        NewCharacterForm form = new NewCharacterForm(this, true);
        form.setLocationRelativeTo(this);
        form.setVisible(true);
    }

}
