package io.github.guzzur.rmiclient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import io.github.guzzur.rmiinterface.RMIInterface;

public class RMIClient {
    private static RMIInterface lookUp;

    public static void main(String[] args)
            throws MalformedURLException, RemoteException, NotBoundException {
        lookUp = (RMIInterface) Naming.lookup("//localhost/RMIServer");
        int times = 5;
        // Woila! Now we can use sayHello method!
        String response = lookUp.sayHello(times);
        System.out.println(response);
    }
}