package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService {
    private Map<String, String> dictionary;

    public DictionaryServiceImpl() throws RemoteException {
        dictionary = new HashMap<>();
    }

    // Implementação do método para adicionar uma palavra
    @Override
    public synchronized String addWord(String word, String meaning) throws RemoteException {
        if (dictionary.containsKey(word)) {
            return "Palavra já existe!";
        }
        dictionary.put(word, meaning);
        saveDictionary(dictionary); // Salvando dicionário no arquivo
        return "Palavra adicionada com sucesso!";
    }

    // Implementação do método para consultar o significado de uma palavra
    @Override
    public synchronized String getMeaning(String word) throws RemoteException {
        return dictionary.getOrDefault(word, "Palavra não encontrada");
    }

    // Implementação do método para remover uma palavra
    @Override
    public synchronized String removeWord(String word) throws RemoteException {
        if (dictionary.remove(word) != null) {
            saveDictionary(dictionary); // Salvando dicionário no arquivo
            return "Palavra removida com sucesso!";
        }
        return "Palavra não encontrada!";
    }

    // Método auxiliar para salvar o dicionário no arquivo (implementação fictícia)
    private void saveDictionary(Map<String, String> dictionary) {
        // Implementação para salvar o dicionário em JSON, XML, etc.
    }
}