package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DictionaryServer {
    public static void main(String[] args) {
        try {
            // Criação da implementação do serviço
            DictionaryServiceImpl service = new DictionaryServiceImpl();

            // Criação do registro RMI
            Registry registry = LocateRegistry.createRegistry(1099);

            // Registro do serviço no RMI Registry
            registry.rebind("DictionaryService", service);

            System.out.println("Servidor RMI iniciado...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}