package io.github.guzzur.client;

import io.github.guzzur.sharedclasses.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class UI extends JPanel implements Runnable {
    Connector connector = new Connector();

    int count = 0;

    JFrame uiFrame = new JFrame();
    JPanel pnlMain = new JPanel();
    JPanel pnlOutput = new JPanel(new GridBagLayout());
    JPanel pnlInput = new JPanel(new GridLayout(1, 3));
    JTextField userNameField = new JTextField();
    JTextField messageField = new JTextField();
    JButton btnSend = new JButton("Send");
    TextArea ta = new TextArea();

    public UI(){


        //make sure the program exits when the frame closes
        uiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        uiFrame.setTitle("RMI Chatting System");
        uiFrame.setSize(500,250);

        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.PAGE_AXIS));

        pnlOutput.setSize(500, 220);
        pnlInput.setSize(500, 30);

        ta.setSize(480, 200);

        userNameField.setSize(50, 30);
        messageField.setSize(350, 30);
        btnSend.setSize(100, 30);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connector.setUserName(userNameField.getText());
                connector.sendMsg(messageField.getText());
                messageField.setText("");
            }
        });

        pnlOutput.add(ta);

        pnlInput.add(userNameField);
        pnlInput.add(messageField);
        pnlInput.add(btnSend);

        pnlMain.add(pnlOutput);
        pnlMain.add(pnlInput);

        uiFrame.add(pnlMain);
        uiFrame.setVisible(true);
    }

    @Override
    public void run(){
        while (true) {
            ArrayList<Message> msgList = connector.getMsgs(count);
            count += msgList.size();

            for (Message msg : msgList) {
                System.out.println(msg);
                ta.append(msg.toString() + '\n');
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {

            }
        }
    }

    public static void main(String[] args) {
        UI ui = new UI();
        Thread t = new Thread(ui);
        t.start();

    }
}
