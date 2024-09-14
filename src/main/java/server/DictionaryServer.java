package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DictionaryServer {
    public static void main(String[] args) {
        try {
            server.DictionaryServiceImpl service = new server.DictionaryServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("DictionaryService", service);
            System.out.println("Servidor iniciado...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}