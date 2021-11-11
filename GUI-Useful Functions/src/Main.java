import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends JPanel {

    public static void main(String[] args)  {

        JFrame frame = new JFrame("Test");
        frame.setPreferredSize(new Dimension(2000,2000));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setAlwaysOnTop(true);

        GridBagConstraints gbc = new GridBagConstraints();
        Dimension size = new Dimension(200,200);
        ArrayList<Main> dataStorage = new ArrayList<>();

        for (int i = 0; i < size.height; ++i) {
            for (int h = 0; h < size.width; ++h) {
                gbc.fill = GridBagConstraints.BOTH;
                gbc.weightx = 1.0 / size.width;
                gbc.weighty = 1.0 / size.height;
                gbc.gridx = h;
                gbc.gridy = i;
                Main panel = new Main();
                dataStorage.add(panel);
                frame.add(panel, gbc);
            }
        }

        // show frame
        frame.pack();
        frame.setVisible(true);

        System.out.println("Start-Koordinaten = (0,0)");
        Point p = new Point(0,0);

        for (;;) {
            Scanner scanner = new Scanner(System.in);

            frame.repaint();

            System.out.println("Bitte gib die Bewegungsrichtung x an");
            int x = scanner.nextInt();
            System.out.println("Bitte gib die Bewegungsrichtung y an");
            int y = scanner.nextInt();
            System.out.println("Bitte gib den Location Modifier an");
            int type = scanner.nextInt();

            int index = JF_GuiTools.pointToStorageIndex(p, size, type);
            dataStorage.get(index).color = new Color(0, 0, 0);

            p.x = p.x + x;
            p.y = p.y + y;


            index = JF_GuiTools.pointToStorageIndex(p, size, type);
            System.out.println(index);
            dataStorage.get(index).color = new Color(255, 0, 0);
            frame.repaint();
        }
    }

    Color color = new Color(0,0,0);

    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRect(0,0, getWidth() - 1, getHeight() - 1);

        g.setColor(new Color(255,255,255));
        g.drawRect(0,0, getWidth() - 1, getHeight() - 1);
    }

}
