package client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DictionaryGUI {

    private DictionaryClient client;  // Referência ao cliente que se conecta ao servidor

    public DictionaryGUI(DictionaryClient client) {
        this.client = client;  // Passa o cliente para a GUI para realizar as operações
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        // Criar o JFrame (janela principal)
        JFrame frame = new JFrame("Dicionário Distribuído");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Criar o painel principal
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Exibir a janela
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Campo de texto para a palavra
        JLabel wordLabel = new JLabel("Palavra:");
        wordLabel.setBounds(10, 20, 80, 25);
        panel.add(wordLabel);

        JTextField wordText = new JTextField(20);
        wordText.setBounds(100, 20, 165, 25);
        panel.add(wordText);

        // Campo de texto para o significado
        JLabel meaningLabel = new JLabel("Significado:");
        meaningLabel.setBounds(10, 50, 80, 25);
        panel.add(meaningLabel);

        JTextField meaningText = new JTextField(20);
        meaningText.setBounds(100, 50, 165, 25);
        panel.add(meaningText);

        // Botão para adicionar uma palavra
        JButton addButton = new JButton("Adicionar");
        addButton.setBounds(10, 80, 150, 25);
        panel.add(addButton);

        // Botão para consultar o significado de uma palavra
        JButton queryButton = new JButton("Consultar");
        queryButton.setBounds(10, 110, 150, 25);
        panel.add(queryButton);

        // Botão para remover uma palavra
        JButton removeButton = new JButton("Remover");
        removeButton.setBounds(10, 140, 150, 25);
        panel.add(removeButton);

        // Área de texto para exibir o resultado
        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(10, 170, 350, 80);
        resultArea.setEditable(false);
        panel.add(resultArea);

        // Ação do botão Adicionar
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word = wordText.getText();
                String meaning = meaningText.getText();
                String result = client.addWord(word, meaning);
                resultArea.setText(result);
            }
        });

        // Ação do botão Consultar
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word = wordText.getText();
                String result = client.getMeaning(word);
                resultArea.setText(result);
            }
        });

        // Ação do botão Remover
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word = wordText.getText();
                String result = client.removeWord(word);
                resultArea.setText(result);
            }
        });
    }
}