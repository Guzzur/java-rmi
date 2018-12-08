package io.github.guzzur.rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

import io.github.guzzur.sharedclasses.*;

public interface RMIInterface extends Remote {
    public String setState(Date creationTime, State state) throws RemoteException;
}