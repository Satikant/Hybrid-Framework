package utils;

import com.jcraft.jsch.JSch;
import propertyManagement.ProjectProperties;

import static java.lang.Integer.parseInt;

public class ServerConnection {
     private String username, host, password, destinationHost;
     private int port, sourcePort, destinationPort;

    public ServerConnection() {
        username = ProjectProperties.getProperty("server.username");
        host = ProjectProperties.getProperty("server.host");
        password = ProjectProperties.getProperty("server.password");
        destinationHost = ProjectProperties.getProperty("server.destination.host");
        port = parseInt(ProjectProperties.getProperty("server.port"));
        sourcePort = parseInt(ProjectProperties.getProperty("server.source.port"));
        destinationPort = parseInt(ProjectProperties.getProperty("server.destination.port"));
    }

    public  void connectToServerAndMakeTunnel() {
        try {
            int assigned_port;
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            //System.out.println(username + host +password);
            com.jcraft.jsch.Session session = jsch.getSession(username, host, port);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            assigned_port = session.setPortForwardingL(sourcePort, destinationHost, destinationPort);
            if (assigned_port == 0) {
                System.out.println("Port forwarding failed!");
                return;
            } else {
                System.out.println("Connection Successful, Current User is :  " + session.getUserName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void connectToServer() {
        try {
            int assigned_port;
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            com.jcraft.jsch.Session session = jsch.getSession(username, host, port);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            System.out.println("Connection Successful, Current User is :  " + session.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
