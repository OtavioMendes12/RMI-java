package client;

import server.DictionaryService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DictionaryClient {

    private DictionaryService dictionaryService;

    public DictionaryClient(String serverAddress) {
        try {
            // Conectar ao servidor RMI
            Registry registry = LocateRegistry.getRegistry(serverAddress, 1099);
            dictionaryService = (DictionaryService) registry.lookup("DictionaryService");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para adicionar uma palavra
    public String addWord(String word, String meaning) {
        try {
            return dictionaryService.addWord(word, meaning);
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao adicionar palavra.";
        }
    }

    // Método para consultar o significado de uma palavra
    public String getMeaning(String word) {
        try {
            return dictionaryService.getMeaning(word);
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao consultar palavra.";
        }
    }

    // Método para remover uma palavra
    public String removeWord(String word) {
        try {
            return dictionaryService.removeWord(word);
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao remover palavra.";
        }
    }

    // Método principal para iniciar o cliente
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java DictionaryClient <endereco_do_servidor>");
            return;
        }

        // Iniciar o cliente e abrir a interface gráfica
        new DictionaryGUI(new DictionaryClient(args[0]));
    }
}