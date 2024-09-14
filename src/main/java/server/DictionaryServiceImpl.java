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

    @Override
    public synchronized String getMeaning(String word) throws RemoteException {
        return dictionary.getOrDefault(word, "Palavra não encontrada");
    }

    @Override
    public synchronized String addWord(String word, String meaning) throws RemoteException {
        if (dictionary.containsKey(word)) {
            return "Palavra já existe!";
        }
        dictionary.put(word, meaning);

        return "Palavra adicionada com sucesso!";
    }

    @Override
    public synchronized String removeWord(String word) throws RemoteException {
        if (dictionary.remove(word) != null) {

            return "Palavra removida com sucesso!";
        }
        return "Palavra não encontrada!";
    }
}