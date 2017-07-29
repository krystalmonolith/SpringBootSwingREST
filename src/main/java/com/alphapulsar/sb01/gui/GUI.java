package com.alphapulsar.sb01.gui;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.Date;

@Component
public class GUI {

    private String label;
    private JFrame frame;
    private JLabel label1;

    public GUI() {
        this.label = new Date().toString();
    }

    public void createAndShowGUI() {
        javax.swing.SwingUtilities.invokeLater(() -> {
            frame = new JFrame(label);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            label1 = new JLabel(label);
            frame.getContentPane().add(label1);
            frame.pack();
            frame.setVisible(true);
        });
    }
}

