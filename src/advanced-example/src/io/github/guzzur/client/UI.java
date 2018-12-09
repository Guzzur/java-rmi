package io.github.guzzur.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class UI extends JPanel {
    public UI(){
        JFrame uiFrame = new JFrame();

        //make sure the program exits when the frame closes
        uiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        uiFrame.setTitle("Example GUI");
        uiFrame.setSize(300,500);

        Connector connector = new Connector("");
        JPanel pnlMain = new JPanel(new GridLayout(2, 1));
        JPanel pnlOutput = new JPanel(new GridBagLayout());
        JPanel pnlInput = new JPanel(new GridLayout(1, 3));

        pnlOutput.setSize(300, 350);
        pnlInput.setSize(300, 150);

        JTextField userNameField = new JTextField();
        JTextField messageField = new JTextField();
        JButton btnSend = new JButton("Send");

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connector.setUserName(userNameField.getText());
                connector.sendMsg(messageField.getText());
                messageField.setText("");
            }
        });

        pnlInput.add(userNameField);
        pnlInput.add(messageField);
        pnlInput.add(btnSend);

        pnlMain.add(pnlOutput);
        pnlMain.add(pnlInput);

        uiFrame.add(pnlMain);
        uiFrame.setVisible(true);
    }
}
