package io.github.guzzur.rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import io.github.guzzur.sharedclasses.*;

public interface RMIInterface extends Remote {
    public int writeMsg(Message msg) throws RemoteException;
    public ArrayList<Message> readMsg(int index) throws RemoteException;
}