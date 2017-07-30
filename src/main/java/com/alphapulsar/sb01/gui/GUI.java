package com.alphapulsar.sb01.gui;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

@Component
public class GUI {

    private static final Insets INSETS = new Insets(2, 2, 2, 2);

    private JFrame frame;
    private JLabel lblPrompt;
    private JTextField txtText;
    private JButton btnExit;

    private IGUIDOM guiDOM;

    public GUI() {
    }

    public IGUIDOM getGuiDOM() {
        return guiDOM;
    }

    public void createAndShowGUI(final IGUIActions guiActions) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Sb01: " + new Date().toString());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            GridBagLayout gbl = new GridBagLayout();
            frame.getContentPane().setLayout(gbl);

            lblPrompt = new JLabel("TEXT1:");
            txtText = new JTextField();
            btnExit = new JButton("Exit");

            GridBagConstraints gbc;
            gbc = new GridBagConstraints(0, 0, 1, 1, 0.01, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, INSETS, 1, 1);
            frame.getContentPane().add(lblPrompt, gbc);
            gbc = new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, INSETS, 1, 1);
            frame.getContentPane().add(txtText, gbc);
            gbc = new GridBagConstraints(0, 1, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, INSETS, 1, 1);
            frame.getContentPane().add(btnExit, gbc);
            frame.pack();
            frame.setVisible(true);
            frame.setMinimumSize(new Dimension(400,0));
            //txtText.setMinimumSize(new Dimension(200,0));

            btnExit.addActionListener((ActionEvent actionEvent) -> {
                guiActions.exit();
            });

            txtText.addActionListener((ActionEvent actionEvent) -> {
                guiActions.text1(txtText.getText());
            });

            guiDOM = new IGUIDOM() {
                @Override
                public String getText() {
                    return txtText.getText();
                }

                @Override
                public void setText(String text) {
                    txtText.setText(text);
                }

                @Override
                public String getPrompt() {
                    return lblPrompt.getText();
                }

                @Override
                public void setPrompt(String prompt) {
                    lblPrompt.setText(prompt);
                }
            };
        });
    }
}

