package no.hiof.larsmra.Examples.GUITest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUITest {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(500, 500));

        JButton btn1 = new JButton("Test");
        btn1.setBounds(10, 10, 100, 40);
        panel.add(btn1);

        JButton btn2 = new JButton("Test 2");
        btn2.setBounds(10, 70, 100, 40);
        panel.add(btn2);

        btn1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hei");
            }
        });

        frame.add(panel);

        frame.pack();

        frame.setVisible(true);
    }

    static class Panel extends JPanel {

        JButton btn1;
        JButton btn2;

        public Panel() {
            setPreferredSize(new Dimension(500, 500));

            JButton btn1 = new JButton("Test");
            //btn1.setBounds(10, 10, 100, 40);
            add(btn1);

            JButton btn2 = new JButton("Test 2");
            //btn2.setBounds(10, 70, 100, 40);
            add(btn2);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

        }

    }

}
