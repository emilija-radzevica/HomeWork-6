import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Some sketchy window that might be a virus");
        frame.setSize(500,180);
        frame.setResizable(false);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JPanel dashboard = new JPanel();
        dashboard.setLayout(null);

        JLabel email = new JLabel("Tavs e-pasts: ");
        email.setBounds(90, 35, 80, 25 );
        panel.add(email);

        JTextField emailField = new JTextField();
        emailField.setBounds(210, 35, 200, 25);
        panel.add(emailField);

        JButton login = new JButton("Ienākt");
        login.setBounds(270, 85, 80, 25);
        panel.add(login);

        JLabel error = new JLabel();
        error.setBounds(115, 85, 120, 25);
        error.setForeground(Color.RED);
        panel.add(error);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = emailField.getText();

                if (input.isEmpty()) {
                    error.setText("Neaizpildīts lauks");
                } else if (input.equals("koala@rcs.lv")) {
                    frame.remove(panel);
                    frame.add(dashboard);
                    frame.setSize(600, 560);
                    frame.setTitle("Sveiki, " + input);
                    emailField.setText("");
                    error.setText("");
                } else {
                    error.setText("Nepareizs e-pasts");
                    emailField.setText("");
                }
            }
        });

        emailField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    String input = emailField.getText();

                    if (input.isEmpty()) {
                        error.setText("Neaizpildīts lauks");
                    } else if (input.equals("koala@rcs.lv")) {
                        frame.remove(panel);
                        frame.add(dashboard);
                        frame.setSize(600, 560);
                        frame.setTitle("Sveiki, " + input);
                        emailField.setText("");
                        error.setText("");
                    } else {
                        error.setText("Nepareizs e-pasts");
                        emailField.setText("");
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });

        JButton logout = new JButton("IZIET");
        logout.setBounds(200, 200, 200, 100);
        logout.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        dashboard.add(logout);

        JLabel instructions = new JLabel("Tagad vari iet atpakaļ, nospiežot to lielo pogu šī loga centrā.");
        instructions.setBounds(60, 30, 500, 50);
        instructions.setFont(new Font("Times New Roman", Font.BOLD, 18));
        dashboard.add(instructions);

        JLabel sass = new JLabel("Tici man, garām nepašausi!");
        sass.setBounds(220, 90, 200, 30);
        sass.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        dashboard.add(sass);

        // ARROWS

        JLabel arrowLeft = new JLabel("\u2192");
        arrowLeft.setBounds(40, 195, 200, 100);
        arrowLeft.setFont(new Font("Times New Roman", Font.BOLD, 100));
        arrowLeft.setForeground(Color.RED);
        arrowLeft.setVisible(false);
        dashboard.add(arrowLeft);

        JLabel arrowRight = new JLabel("\u2190");
        arrowRight.setBounds(450, 195, 200, 100);
        arrowRight.setFont(new Font("Times New Roman", Font.BOLD, 100));
        arrowRight.setForeground(Color.RED);
        arrowRight.setVisible(false);
        dashboard.add(arrowRight);

        // END ARROWS

        JLabel red = new JLabel("Jap, šī ir tā īstā poga!");
        red.setBounds(150, 350, 400, 100);
        red.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        red.setForeground(Color.RED);
        red.setVisible(false);
        dashboard.add(red);

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arrowLeft.setVisible(false);
                arrowRight.setVisible(false);
                red.setVisible(false);
                frame.remove(dashboard);
                frame.add(panel);
                frame.setSize(500, 180);
                frame.setTitle("OK, this is not a virus but it is still sketchy looking");
            }
        });

        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               arrowLeft.setVisible(true);
               arrowRight.setVisible(true);
               red.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                arrowLeft.setVisible(false);
                arrowRight.setVisible(false);
                red.setVisible(false);
            }
        });
    }
}