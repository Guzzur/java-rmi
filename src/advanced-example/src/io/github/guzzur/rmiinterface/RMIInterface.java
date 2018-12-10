package io.github.guzzur.rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import io.github.guzzur.sharedclasses.*;

public interface RMIInterface extends Remote {
    int writeMsg(Message msg) throws RemoteException;
    ArrayList<Message> readMsg(int index) throws RemoteException;
}