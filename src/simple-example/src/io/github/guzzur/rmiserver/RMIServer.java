package io.github.guzzur.rmiserver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import io.github.guzzur.rmiinterface.RMIInterface;

public class RMIServer extends UnicastRemoteObject implements RMIInterface {
    private static final long serialVersionUID = 1L;

    protected RMIServer() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(int times) throws RemoteException {
        for (int i=0; i < times; i++)
            System.out.println(i+1 + ") Hello!");
        System.out.println("Server said hello " + times + " times");
        return "Server said hello " + times + " times";
    }

    public static void main(String[] args){
        try {
            // In that example the registry runs within the server app
            Registry reg = LocateRegistry.createRegistry(1099);

            Naming.rebind("//localhost/RMIServer", new RMIServer());
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}