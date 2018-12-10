package io.github.guzzur.server;

import io.github.guzzur.rmiinterface.RMIInterface;
import io.github.guzzur.sharedclasses.Message;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements RMIInterface {
    private static final long serialVersionUID = 1L;
    private static ArrayList<Message> msgList = new ArrayList<>();

    private Server() throws RemoteException {
        super();
    }

    @Override
    public int writeMsg(Message msg) {
        System.out.println("Got message: " + msg);
        if(msg.getContent().length() > 0)
            msgList.add(msg);

        return msgList.size();
    }

    @Override
    public ArrayList<Message> readMsg(int index) {
        return new ArrayList<Message>(msgList.subList(index, msgList.size()));
    }

    public static void main(String[] args){
        try {
            // In that example the registry runs within the server app
            Registry reg = LocateRegistry.createRegistry(1099);

            Naming.rebind("//localhost/RMIServer", new Server());
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
