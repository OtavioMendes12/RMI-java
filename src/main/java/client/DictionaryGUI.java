package client;

import javax.swing.*;

public class DictionaryGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Dicionário Distribuído");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Palavra:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField wordText = new JTextField(20);
        wordText.setBounds(100, 20, 165, 25);
        panel.add(wordText);


    }
}