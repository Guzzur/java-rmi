package io.github.guzzur.stateholder;

import io.github.guzzur.rmiinterface.RMIInterface;
import io.github.guzzur.sharedclasses.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

public class StateHolder extends UnicastRemoteObject implements RMIInterface {
    private static final long serialVersionUID = 1L;
    static ArrayList<State> state = new ArrayList<>();

    protected StateHolder() throws RemoteException {
        super();
    }

    public String setState(Date creationTime, State state) {
        return "Added " + state.getUser().getName() + " with " + state.getColor().getHexa() + " color";
    }
}
