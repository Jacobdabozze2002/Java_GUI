import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    protected static JFrame frame;
        private static JLabel label1;
        private static JButton button1;
        private static JButton button2;

    private static ArrayList<JPanel> panels = new ArrayList<>(); // top, middle, bottom
    private static ArrayList<JButton> buttons = new ArrayList<>(); // from left to right
    private static ArrayList<JF_Panel> fields = new ArrayList<>(); // from left to right

    private static Color gameColor = new Color(0,255,0);

    public static void main(String[] args) {

        // init frame
        frame = new JFrame("Vier gewinnt!");
        frame.setPreferredSize(new Dimension((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 5, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 3));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(0,0,0));
        GridBagConstraints gbc = new GridBagConstraints();

        // create panels
        for (int i = 0; i < 3; ++i) {
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridy = i;
            gbc.weighty = i == 1 ? .8 : .1;
            gbc.weightx = 1;
            gbc.insets = new Insets(2,2,2,2);
            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());
            panel.setBackground(new Color(0,0,0));
            frame.add(panel, gbc);
            panels.add(panel);
        }

        // gbcs for panels
        GridBagConstraints gbcPanel1 = new GridBagConstraints();
        GridBagConstraints gbcPanel2 = new GridBagConstraints();
        GridBagConstraints gbcPanel3 = new GridBagConstraints();

        // panel 1
        gbcPanel1.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        label1 = new JLabel("Spieler 1 am Zug");
        label1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        label1.setForeground(gameColor);
        panels.get(0).add(label1, gbcPanel1);

        // Panel 2
        // ...setUp for following objects
        gbcPanel2.weightx = (double) 1 / 7;
        gbcPanel2.weighty = (double) 1 / 7;
        gbcPanel2.fill = GridBagConstraints.BOTH;
        gbcPanel2.insets = new Insets(1,1,1,1);

        // ...line of buttons
        for (int i = 0; i < 7; ++i) {
            gbcPanel2.gridx = i;
            gbcPanel2.gridy = 0;
            JButton button = new JButton("Insert");
            button.setBackground(gameColor);
            button.setForeground(new Color(0,0,0));
            button.addActionListener(onButtonClick);
            button.setActionCommand("Action" + i);
            panels.get(1).add(button, gbcPanel2);
            buttons.add(button);
        }

        // ...fields
        for (int i = 0; i < 7; ++i) { // Zeilen
            for (int h = 0; h < 7; ++h) { // Spalten -> gefüllt wird jede Zeile der Reihe nach von links nach rechts
                gbcPanel2.gridx = h;
                gbcPanel2.gridy = i;
                JF_Panel panel = new JF_Panel(new Color(255,255,255));
                fields.add(panel);
                panels.get(1).add(panel, gbcPanel2);
            }
        }

        // Panel 3
        // ...setUp for following objects
        gbcPanel3.weightx = (double) 1 / 2;
        gbcPanel3.weighty = 1;
        gbcPanel3.fill = GridBagConstraints.BOTH;
        gbcPanel3.insets = new Insets(2,10,4,10);

        // button1
        button1 = new JButton("New Game");
        button1.setBackground(gameColor);
        button1.setForeground(new Color(0,0,0));
        button1.setActionCommand("New Game");
        button1.addActionListener(onButtonClick);
        panels.get(2).add(button1, gbcPanel3);

        // button2
        button2 = new JButton("Help");
        button2.setBackground(gameColor);
        button2.setForeground(new Color(0,0,0));
        button2.setActionCommand("Help");
        button2.addActionListener(onButtonClick);
        panels.get(2).add(button2, gbcPanel3);

        // show frame
        frame.pack();
        frame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - frame.getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - frame.getHeight() / 2);
        frame.setVisible(true);
    }

    private static ActionListener onButtonClick= new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == button1.getActionCommand()) {
                for (JF_Panel _x: fields) {
                    _x.setColor(new Color(255,255,255));
                }

                frame.repaint();
            }
            if (e.getActionCommand() == button2.getActionCommand()) {
                try {
                    Desktop.getDesktop().browse(new URI("https://de.wikipedia.org/wiki/Vier_gewinnt"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
            if (e.getActionCommand() == buttons.get(0).getActionCommand()) {
                if (JF_repaintOvalPlusCheck(0)) {
                    JF_repaintLook();
                }
            }
            if (e.getActionCommand() == buttons.get(1).getActionCommand()) {
                if (JF_repaintOvalPlusCheck(1)) {
                    JF_repaintLook();
                }
            }
            if (e.getActionCommand() == buttons.get(2).getActionCommand()) {
                if (JF_repaintOvalPlusCheck(2)) {
                    JF_repaintLook();
                }
            }
            if (e.getActionCommand() == buttons.get(3).getActionCommand()) {
                if (JF_repaintOvalPlusCheck(3)) {
                    JF_repaintLook();
                }
            }
            if (e.getActionCommand() == buttons.get(4).getActionCommand()) {
                if (JF_repaintOvalPlusCheck(4)) {
                    JF_repaintLook();
                }
            }
            if (e.getActionCommand() == buttons.get(5).getActionCommand()) {
                if (JF_repaintOvalPlusCheck(5)) {
                    JF_repaintLook();
                }
            }
            if (e.getActionCommand() == buttons.get(6).getActionCommand()) {
                if (JF_repaintOvalPlusCheck(6)) {
                    JF_repaintLook();
                }
            }

        }
    };

    private static boolean JF_repaintOvalPlusCheck(int btnNumber) {

        for (int i = 7; i > 0; --i) {
            int pos = 7 * (i - 1) + btnNumber;

            if (Objects.equals(fields.get(pos).getColor(), new Color(255, 255, 255))) {
                fields.get(pos).setColor(gameColor);
                frame.repaint();
                return true;
            }
        }

        return false;
    }

    private static class JF_Panel extends JPanel {
        Color color;

        public JF_Panel(Color color) {
            this.color = color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return this.color;
        }

        protected void paintComponent(Graphics g) {
            g.setColor(new Color(0,0,0));
            g.fillRect(0,0, this.getWidth() - 1, this.getHeight() - 1);

            g.setColor(gameColor);
            g.drawRect(0,0, this.getWidth() - 1, this.getHeight() - 1);

            g.setColor(this.color);
            g.fillOval(this.getWidth() / 2 - this.getWidth() / 2 / 2 - 1, this.getHeight() / 2 - this.getHeight() / 2 / 2 - 1, this.getWidth() / 2 ,this.getHeight() / 2);
        }
    }

    private static void JF_repaintLook() {
        gameColor = Objects.equals(gameColor, new Color(0, 255, 0)) ? new Color(255,0,0) : new Color (0,255,0);

        label1.setText(label1.getText() == "Spieler 1 am Zug" ? "Spieler 2 am Zug" : "Spieler 1 am Zug");
        label1.setForeground(gameColor);

        for (JButton _x: buttons) {
            _x.setBackground(gameColor);
        }

        button1.setBackground(gameColor);
        button2.setBackground(gameColor);

        frame.repaint();
    }
}

