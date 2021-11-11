import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {

    //Constants
    private static final Dimension area = new Dimension(25,25);
    private static final Color playArea = new Color(0,0,75);
    private static final Color borderArea = new Color(0,0,0);
    private static final Color playAreaBorder = new Color(0,0,255);
    private static final Color borderAreaBorder = new Color(0,0,75);
    private static final Color colorItem = new Color(100,100,0);
    private static final Color colorPACMAN = new Color(100,100,0);
    private static Point PACMANPosition = new Point (11, 11);

    //Object storage
    private static ArrayList<JF_Panel> fields = new ArrayList<>();
    private static final byte[] map = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0,
        0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0,
        0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0,
        0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0,
        0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0,
        0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0,
        0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0,
        0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0,
        0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0,
        0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0,
        0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0,
        0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0,
        0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0,
        0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0,
        0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0,
        0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0,
        0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0,
        0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0,
        0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0,
        0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0,
        0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0,
        0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    //Objects
    private static JF_Frame window;


    public static void main(String[] args) throws InterruptedException {

        // create game window
        window = new JF_Frame("PAC MAN", (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 3, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2, new Color(0,0,0));

        // create all areas
        for (int i = 0; i < area.height; ++i) {
            for (int h = 0; h < area.width; ++h) {

                if (map[area.width * h + i] == 0) {
                    JF_Panel panel = new JF_Panel(window ,i, h, (double)1 / area.width,  (double)1 / area.height, borderArea, borderAreaBorder, "BORDER", colorItem, colorPACMAN);
                    fields.add(panel);
                } else {
                    if (h == PACMANPosition.x && i == PACMANPosition.y ) {
                        JF_Panel panel = new JF_Panel(window ,i, h, (double)1 / area.width,  (double)1 / area.height, playArea, playAreaBorder, "PACMAN", colorItem, colorPACMAN);
                        fields.add(panel);
                    } else {
                        JF_Panel panel = new JF_Panel(window ,i, h, (double)1 / area.width,  (double)1 / area.height, playArea, playAreaBorder, "ITEM", colorItem, colorPACMAN);
                        fields.add(panel);
                        window.setItemsToCollect(window.getItemsToCollect() + 1);
                    }
                }
            }
        }


        // make window visible after init
        window.finish();


        // game loop
        for (;;) {
            TimeUnit.MILLISECONDS.sleep(150);
            JF_KeyListener.updatePositon();

            if (window.getItemsToCollect() == 0) {
                break;
            }
        }
    }

    private static class JF_Panel extends JPanel {
        private Color colorBorder;
        private Color colorBackground;
        private Color colorItem;
        private Color colorPACMAN;
        private JF_Frame parent;
        private String type;
        private String direction;

        public JF_Panel(JF_Frame parent, int gridX, int gridY, double weightX, double weightY, Color color, Color colorBorder, String type, Color colorItem, Color colorPACMAN) {
            this.parent = parent;
            this.parent.getGridBagConstraints().gridx = gridX;
            this.parent.getGridBagConstraints().gridy = gridY;
            this.parent.getGridBagConstraints().weightx = weightX;
            this.parent.getGridBagConstraints().weighty = weightY;
            this.colorBackground = color;
            this.colorBorder = colorBorder;
            this.parent.add(this, parent.getGridBagConstraints());
            this.type = type;
            this.colorItem = colorItem;
            this.colorPACMAN = colorPACMAN;
            this.direction = "RIGHT";
        }

        public String getType() {
            return this.type;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public void paintComponent(Graphics g) {
            g.setColor(colorBackground);
            g.fillRect(0,0, getWidth() - 1, getHeight() - 1);
            g.setColor(colorBorder);
            g.drawRect(0,0, getWidth() - 1, getHeight() - 1);

            if (this.type == "ITEM") {
                g.setColor(colorItem);
                g.fillOval(getWidth() / 2 - getWidth() / 5 / 2, getHeight() / 2 - getHeight() / 5 / 2, getWidth() / 5, getHeight() / 5);
            }
            if (this.type == "PACMAN") {
                g.setColor(colorPACMAN);
                if (this.direction == "RIGHT") {
                    g.fillArc(getWidth() / 2 - (int)(getWidth() * .75) / 2, getHeight() / 2 - (int)(getHeight() * .75) / 2, (int)(getWidth() * .75), (int)(getHeight() * .75), 30, 300);
                }
                if (this.direction == "LEFT") {
                    g.fillArc(getWidth() / 2 - (int)(getWidth() * .75) / 2, getHeight() / 2 - (int)(getHeight() * .75) / 2, (int)(getWidth() * .75), (int)(getHeight() * .75), 210, 300);
                }
                if (this.direction == "UP") {
                    g.fillArc(getWidth() / 2 - (int)(getWidth() * .75) / 2, getHeight() / 2 - (int)(getHeight() * .75) / 2, (int)(getWidth() * .75), (int)(getHeight() * .75), 300, 300);
                }
                if (this.direction == "DOWN") {
                    g.fillArc(getWidth() / 2 - (int)(getWidth() * .75) / 2, getHeight() / 2 - (int)(getHeight() * .75) / 2, (int)(getWidth() * .75), (int)(getHeight() * .75), 120, 300);
                }
            }
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    private static class JF_Frame extends JFrame {
        private GridBagConstraints gridBagConstraints;
        private Color color;
        private int itemsToCollect;

        public JF_Frame(String name, int width, int height, Color color) {
            this.setTitle(name);
            this.setPreferredSize(new Dimension(width, height));
            this.setLocation((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - width / 2, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - height / 2);
            this.setAlwaysOnTop(true);
            this.setLayout(new GridBagLayout());
            this.gridBagConstraints = new GridBagConstraints();
            this.gridBagConstraints.fill = GridBagConstraints.BOTH;
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.color = color;
            this.getContentPane().setBackground(this.color);
            this.addKeyListener(new JF_KeyListener());
            this.itemsToCollect = 0;
        }

        public void setItemsToCollect(int itemsToCollect) {
            this.itemsToCollect = itemsToCollect;
        }

        public int getItemsToCollect() {
            return this.itemsToCollect;
        }

        public void finish() {
            this.pack();
            this.setVisible(true);
        }

        public GridBagConstraints getGridBagConstraints() {
            return this.gridBagConstraints;
        }

    }

    private static class JF_KeyListener implements KeyListener {
        protected static Point direction = new Point(0,0);

        @Override
        public void keyTyped(KeyEvent e) {
            switch (e.getKeyChar()) {
                case 'w':
                    direction.x = 0;
                    direction.y = -1;
                    break;
                case 'a':
                    direction.x = -1;
                    direction.y = 0;
                    break;
                case 's':
                    direction.x = 0;
                    direction.y = 1;
                    break;
                case 'd':
                    direction.x = 1;
                    direction.y = 0;
                    break;
            }
        }
        @Override
        public void keyPressed(KeyEvent e) {}
        @Override
        public void keyReleased(KeyEvent e) {}

        protected static void updatePositon() {
            fields.get(area.width * PACMANPosition.y + PACMANPosition.x).setType("NORMAL");

            Point testPoint = new Point(PACMANPosition.x + direction.y, PACMANPosition.y + direction.x);

            if (fields.get(area.width * testPoint.y + testPoint.x).getType() != "BORDER") {
                if (fields.get(area.width * testPoint.y + testPoint.x).getType() == "ITEM") {
                    window.setItemsToCollect(window.getItemsToCollect() - 1);
                }
                PACMANPosition = testPoint;
            }

            fields.get(area.width * PACMANPosition.y + PACMANPosition.x).setType("PACMAN");

            if (direction.x == 1) {
                fields.get(area.width * PACMANPosition.y + PACMANPosition.x).setDirection("RIGHT");
            }
            if (direction.x == -1) {
                fields.get(area.width * PACMANPosition.y + PACMANPosition.x).setDirection("LEFT");
            }
            if (direction.y == 1) {
                fields.get(area.width * PACMANPosition.y + PACMANPosition.x).setDirection("UP");
            }
            if (direction.y == -1) {
                fields.get(area.width * PACMANPosition.y + PACMANPosition.x).setDirection("DOWN");
            }


            window.repaint();
        }

    }
}
