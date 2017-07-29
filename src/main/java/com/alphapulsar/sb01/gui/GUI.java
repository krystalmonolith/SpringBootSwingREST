package com.alphapulsar.sb01.gui;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

@Component
public class GUI {

    private static final Insets INSETS = new Insets(2,2,2,2);

    private String label;
    private JFrame frame;
    private JLabel label1;
    private JTextField text1;
    private JButton btnExit;

    private IGUIDOM guiDOM;

    public GUI() {
        this.label = new Date().toString();
    }

    public IGUIDOM getGuiDOM() {
        return guiDOM;
    }

    public void createAndShowGUI(final IGUIActions guiActions) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Sb01");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            GridBagLayout gbl = new GridBagLayout();
            frame.getContentPane().setLayout(gbl);

            label1 = new JLabel(label);
            text1 = new JTextField();
            btnExit = new JButton("Exit");

            GridBagConstraints gbc;
            gbc = new GridBagConstraints(0,0,1,1,1.0,1.0,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, INSETS, 1, 1);
            frame.getContentPane().add(label1, gbc);
            gbc = new GridBagConstraints(0,1,1,1,1.0,1.0,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, INSETS, 1, 1);
            frame.getContentPane().add(text1, gbc);
            gbc = new GridBagConstraints(0,2,1,1,1.0,1.0,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, INSETS, 1, 1);
            frame.getContentPane().add(btnExit, gbc);
            frame.pack();
            frame.setVisible(true);

            btnExit.addActionListener((ActionEvent actionEvent) -> {
                guiActions.exit();
            });

            text1.addActionListener((ActionEvent actionEvent) -> {
                guiActions.text1(text1.getText());
            });

            guiDOM = new IGUIDOM() {
                @Override
                public String getText1() {
                    return text1.getText();
                }

                @Override
                public void setText1(String text) {
                    text1.setText(text);
                }
            };
        });
    }
}

