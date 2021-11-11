import javax.swing.*;
import java.awt.*;

public class Main {

    private static JFrame form1;
        private static JLabel label1;
        private static JPanel panel1;
            private static JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonAC, buttonCE;
        private static JButton buttonCalc;


    public static void main(String str[]) {

        // create layout for Frame
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.fill = GridBagConstraints.BOTH;
        gbc1.insets.top = 3;
        gbc1.insets.bottom = 3;
        gbc1.insets.left = 5;
        gbc1.insets.right = 5;
        gbc1.weightx = 1;

        // create layout for Frame
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill= GridBagConstraints.BOTH;
        gbc2.insets.top = 1;
        gbc2.insets.bottom = 1;
        gbc2.insets.left = 1;
        gbc2.insets.right = 1;
        gbc2.weightx = 1;
        gbc2.weighty = 1;

        // create frame
        form1 = new JFrame("Calculator");
        form1.setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 8, Toolkit.getDefaultToolkit().getScreenSize().height / 5);
        form1.setLocation(form1.getWidth() * 7 / 2 - form1.getWidth() / 2, form1.getHeight() * 3 / 2 - form1.getHeight() / 2);
        form1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        form1.setLayout(new GridBagLayout());
        form1.getContentPane().setBackground(new Color(0,0,0));

        // create output label
        gbc1.weighty = .15;
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        label1 = new JLabel("0");
        label1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        form1.add(label1, gbc1);


        // create main panel
        gbc1.weighty = .7;
        gbc1.gridx = 0;
        gbc1.gridy = 1;
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel1.setBackground(new Color(0,0,0));
        form1.add(panel1, gbc1);


        // draw buttons
        button1 = new JButton("1");
        button1.setBackground(new Color(0,0,0));
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        panel1.add(button1, gbc2);

        button2 = new JButton("2");
        button2.setBackground(new Color(0,0,0));
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        panel1.add(button2, gbc2);

        button3 = new JButton("3");
        button3.setBackground(new Color(0,0,0));
        gbc2.gridx = 2;
        gbc2.gridy = 0;
        panel1.add(button3, gbc2);

        button4 = new JButton("4");
        button4.setBackground(new Color(0,0,0));
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        panel1.add(button4, gbc2);

        button5 = new JButton("5");
        button5.setBackground(new Color(0,0,0));
        gbc2.gridx = 1;
        gbc2.gridy = 1;
        panel1.add(button5, gbc2);

        button6 = new JButton("6");
        button6.setBackground(new Color(0,0,0));
        gbc2.gridx = 2;
        gbc2.gridy = 1;
        panel1.add(button6, gbc2);

        button7 = new JButton("7");
        button7.setBackground(new Color(0,0,0));
        gbc2.gridx = 0;
        gbc2.gridy = 2;
        panel1.add(button7, gbc2);

        button8 = new JButton("8");
        button8.setBackground(new Color(0,0,0));
        gbc2.gridx = 1;
        gbc2.gridy = 2;
        panel1.add(button8, gbc2);

        button9 = new JButton("9");
        button9.setBackground(new Color(0,0,0));
        gbc2.gridx = 2;
        gbc2.gridy = 2;
        panel1.add(button9, gbc2);

        button0 = new JButton("0");
        button0.setBackground(new Color(0,0,0));
        gbc2.gridx = 0;
        gbc2.gridy = 3;
        panel1.add(button0, gbc2);

        buttonAC = new JButton("AC");
        buttonAC.setBackground(new Color(0,0,0));
        gbc2.gridx = 1;
        gbc2.gridy = 3;
        panel1.add(buttonAC, gbc2);

        buttonCE = new JButton("CE");
        buttonCE.setBackground(new Color(0,0,0));
        gbc2.gridx = 2;
        gbc2.gridy = 3;
        panel1.add(buttonCE, gbc2);


        // create calc button
        gbc1.weighty = .15;
        gbc1.gridx = 0;
        gbc1.gridy = 4;
        buttonCalc = new JButton("Calculate");
        buttonCalc.setBackground(new Color(0,0,0));
        form1.add(buttonCalc, gbc1);

        // end init
        form1.setVisible(true);

    }
}
