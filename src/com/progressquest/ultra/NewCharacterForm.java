package com.progressquest.ultra;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.progressquest.ultra.model.Races;
import com.progressquest.ultra.util.ComponentUtil;

import net.miginfocom.swing.MigLayout;

/**
 * This form is responsible for creating new characters. This form will just create a new character and create the save file which should be loaded by
 * another operation.
 *
 * @author fernando-marquardt
 */
public class NewCharacterForm extends JDialog {

    private static final long serialVersionUID = 1L;

    private JPanel characterPanel;
    private JLabel nameLbl;
    private JTextField nameFld;
    private JButton randomNameBtn;

    // Races Panel
    private JPanel racesPanel;
    private ButtonGroup racesRadioGroup;

    public NewCharacterForm(Frame owner, boolean modal) {
        super(owner, modal);

        initForm();
        initComponents();
        initEvents();

        pack();
    }

    private void initForm() {
        setTitle("New Character");
        setResizable(false);

        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(new BorderLayout());
    }

    private void initComponents() {
        initCharacterPanel();
        initRacesPanel();

        JPanel traitsPanel = new JPanel(new MigLayout());
        traitsPanel.setBackground(null);

        traitsPanel.add(racesPanel);

        add(characterPanel, BorderLayout.NORTH);
        add(traitsPanel, BorderLayout.CENTER);
    }

    private void initCharacterPanel() {
        characterPanel = new JPanel(new MigLayout());
        characterPanel.setBackground(null);

        nameLbl = new JLabel("Name:");
        nameFld = new JTextField();
        nameFld.setText(generateName());
        randomNameBtn = new JButton("?");
        randomNameBtn.setBackground(null);

        characterPanel.add(nameLbl);
        characterPanel.add(nameFld, "width 200");
        characterPanel.add(randomNameBtn);
    }

    private void initRacesPanel() {
        racesPanel = new JPanel();
        racesPanel.setLayout(new BoxLayout(racesPanel, BoxLayout.Y_AXIS));
        racesPanel.setBackground(null);

        JLabel raceLbl = new JLabel("Race");
        ComponentUtil.setFontBold(raceLbl);

        Box racesRadioBox = Box.createVerticalBox();
        racesRadioBox.setBackground(null);

        racesRadioGroup = new ButtonGroup();

        for (Races race : Races.values()) {
            JRadioButton raceRadioBtn = new JRadioButton(race.getName());
            raceRadioBtn.setBackground(null);

            racesRadioGroup.add(raceRadioBtn);
            racesRadioBox.add(raceRadioBtn);
        }

        racesPanel.add(raceLbl);
        racesPanel.add(racesRadioBox);
    }

    private void initEvents() {
        randomNameBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                nameFld.setText(generateName());
            }
        });
    }

    /**
     * Generate a random name.
     *
     * @return Return the created name.
     */
    private String generateName() {
        String[] parts = new String[] {
                "br|cr|dr|fr|gr|j|kr|l|m|n|pr||||r|sh|tr|v|wh|x|y|z", "a|a|e|e|i|i|o|o|u|u|ae|ie|oo|ou", "b|ck|d|g|k|m|n|p|t|v|x|z"
        };

        StringBuilder name = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i <= 5; i++) {
            String line = parts[i % 3];
            String[] lineParts = line.split("\\|");

            name.append(lineParts[rand.nextInt(lineParts.length)]);
        }

        name.replace(0, 1, name.substring(0, 1).toUpperCase());

        return name.toString();
    }

}
