/*
 * @ (#) Server.java       1.0     21/05/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package server;
/*
 * @description:
 * @author: Nguyen Thanh Nhut
 * @date: 21/05/2024
 * @version:    1.0
 */

import jakarta.persistence.EntityManagerFactory;
import util.AppUtils;

import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = AppUtils.getEntityManager().getEntityManagerFactory();
        entityManagerFactory.close();

        try (ServerSocket serverSocket = new ServerSocket(AppUtils.PORT)) {

            System.out.println("Server is running on port " + AppUtils.PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress() + "at port: " + socket.getPort());
                Server server = new Server();
                Thread thread = new Thread(server.new Handler(socket));
                thread.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class Handler implements Runnable {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())){
                while (true) {
                    int choice = dataInputStream.readInt();
                    switch (choice) {
                        case 1:

                            break;
                        case 2:

                            break;
                        case 3:

                            break;
                        default:
                            break;
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
