package client;

import server.DictionaryService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DictionaryClient {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java DictionaryClient <endereco_do_servidor>");
            return;
        }

        try {
            String serverAddress = args[0];
            Registry registry = LocateRegistry.getRegistry(serverAddress, 1099);
            DictionaryService service = (DictionaryService) registry.lookup("DictionaryService");


            System.out.println(service.addWord("computador", "Máquina de calcular"));
            System.out.println(service.getMeaning("computador"));
            System.out.println(service.removeWord("computador"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}