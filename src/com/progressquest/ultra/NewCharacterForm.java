package com.progressquest.ultra;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.progressquest.ultra.components.ImagePanel;
import com.progressquest.ultra.model.Classes;
import com.progressquest.ultra.model.Races;
import com.progressquest.ultra.util.AppColor;
import com.progressquest.ultra.util.ComponentUtil;
import com.progressquest.ultra.util.Resources;

import net.miginfocom.swing.MigLayout;

/**
 * This form is responsible for creating new characters. This form will just create a new character and create the save file which should be loaded by
 * another operation.
 *
 * @author fernando-marquardt
 */
public class NewCharacterForm extends JDialog {

    private static final long serialVersionUID = 1L;

    // Header Panel
    private JPanel headerPanel;
    private ImagePanel headerImage;
    private JLabel headerText;

    // Name Panel
    private JPanel namePanel;
    private JLabel nameLbl;
    private JTextField nameFld;
    private JButton randomNameBtn;

    // Races Panel
    private JPanel racesPanel;
    private ButtonGroup racesRadioGroup;

    // Classes Panel
    private JPanel classesPanel;
    private ButtonGroup classesRadioGroup;

    // Stats Panel
    private JPanel statsPanel;

    // Footer Panel
    private JPanel footerPanel;
    private JButton confirmBtn;
    private JButton cancelBtn;

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
        initHeaderPanel();
        initNamePanel();
        initRacesPanel();
        initClassesPanel();
        initStatsPanel();
        initFooterPanel();

        JPanel characterPanel = new JPanel(new MigLayout("", "[]20[]20[]", "[align top]"));
        characterPanel.setBackground(null);

        characterPanel.add(namePanel, "span 3, wrap");
        characterPanel.add(racesPanel);
        characterPanel.add(classesPanel);
        characterPanel.add(statsPanel);

        add(headerPanel, BorderLayout.NORTH);
        add(characterPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);
    }

    private void initHeaderPanel() {
        headerPanel = new JPanel(new MigLayout());
        headerPanel.setBackground(AppColor.NEW_CHARACTER_HEADER_BACKGROUND);

        headerImage = new ImagePanel(Resources.NEW_CHARACTER_IMG);
        headerText = new JLabel("Character Creation");
        headerText.setForeground(AppColor.NEW_CHARACTER_HEADER_FOREGROUND);
        ComponentUtil.setFontSize(headerText, 24f);

        headerPanel.add(headerImage);
        headerPanel.add(headerText);
    }

    private void initNamePanel() {
        namePanel = new JPanel(new MigLayout());
        namePanel.setBackground(null);

        nameLbl = new JLabel("Name:");
        nameFld = new JTextField();
        nameFld.setText(generateName());
        randomNameBtn = new JButton("?");
        randomNameBtn.setBackground(null);

        namePanel.add(nameLbl);
        namePanel.add(nameFld, "width 200");
        namePanel.add(randomNameBtn);
    }

    private void initRacesPanel() {
        racesPanel = new JPanel();
        racesPanel.setLayout(new BoxLayout(racesPanel, BoxLayout.Y_AXIS));
        racesPanel.setBackground(null);

        JLabel raceLbl = new JLabel("Race");
        ComponentUtil.setFontBold(raceLbl);

        Box racesRadioBox = Box.createVerticalBox();

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

    private void initClassesPanel() {
        classesPanel = new JPanel();
        classesPanel.setLayout(new BoxLayout(classesPanel, BoxLayout.Y_AXIS));
        classesPanel.setBackground(null);

        JLabel classLbl = new JLabel("Class");
        ComponentUtil.setFontBold(classLbl);

        Box classesRadioBox = Box.createVerticalBox();

        classesRadioGroup = new ButtonGroup();

        for (Classes classModel : Classes.values()) {
            JRadioButton classRadioBtn = new JRadioButton(classModel.getName());
            classRadioBtn.setBackground(null);

            classesRadioGroup.add(classRadioBtn);
            classesRadioBox.add(classRadioBtn);
        }

        classesPanel.add(classLbl);
        classesPanel.add(classesRadioBox);
    }

    private void initStatsPanel() {
        statsPanel = new JPanel(new MigLayout("insets 0 0 0 0"));
        statsPanel.setBackground(null);

        JLabel statsLbl = new JLabel("Stats");
        ComponentUtil.setFontBold(statsLbl);

        statsPanel.add(statsLbl);
    }

    private void initFooterPanel() {
        footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(AppColor.DEFAULT_FOOTER_BACKGROUND);
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        confirmBtn = new JButton("Sold!");
        confirmBtn.setBackground(null);
        confirmBtn.setMnemonic('S');

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBackground(null);
        cancelBtn.setMnemonic('C');

        footerPanel.add(confirmBtn);
        footerPanel.add(cancelBtn);

        getRootPane().setDefaultButton(confirmBtn);
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
