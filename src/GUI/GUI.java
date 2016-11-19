/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author chance
 */
public class GUI {

    private JFrame mainFrame;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public GUI() {
        prepareWindow(500, 500, "Clear Billing System");
    }

    private void prepareWindow(int width, int height, String displayHeader) {
        mainFrame = new JFrame();
        mainFrame.setSize(width, height);
        mainFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Window Closed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                JLabel headerLabel = new JLabel();
                String banner = "Clear Billing System";
                headerLabel.setText(banner);
                mainFrame.add(headerLabel);
                mainFrame.setVisible(true);
            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });

    }

}
