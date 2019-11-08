package jonas.guiFirst;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartDrawDemo {
    private JPanel ContentPane;

    // Buttons
    private JButton startDrawDemoButton;
    private JButton drawSquareButton;
    private JButton drawTriangleButton;
    private JButton clearButton;
    private JButton closeDrawWindow;

    private DrawDemo drawDemo = null;

    public StartDrawDemo() {

        // Listener for button to start the demo
        startDrawDemoButton.addActionListener(new StartDemoActionListener());

        // Listener for button to draw a square
        drawSquareButton.addActionListener(new DrawSquareActionListener());

        // Listener for button to draw a triangle
        drawTriangleButton.addActionListener(new DrawTriangleActionListener());

        // Listener for clear button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (drawDemo != null) {
                    drawDemo.clear();
                }
            }
        });

        // Close the demo-window
        closeDrawWindow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (drawDemo != null) {
                    drawDemo.closeFrame();
                    drawDemo = null;
                }
            }
        });
    }

    class StartDemoActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (drawDemo == null) {
                drawDemo = new DrawDemo();
            }
        }
    }

    class DrawSquareActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (drawDemo != null) {
                drawDemo.drawSquare();
            }
        }
    }

    class DrawTriangleActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (drawDemo != null) {
                drawDemo.drawTriangle();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Demo program to draw shapes");
        frame.setContentPane(new StartDrawDemo().ContentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
