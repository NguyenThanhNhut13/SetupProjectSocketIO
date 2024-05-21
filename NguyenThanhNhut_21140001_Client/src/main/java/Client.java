/*
 * @ (#) Client.java       1.0     21/05/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

/*
 * @description:
 * @author: Nguyen Thanh Nhut
 * @date: 21/05/2024
 * @version:    1.0
 */

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("192.168.0.156", 40001);
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
             Scanner scanner = new Scanner(System.in);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {

            while(true) {
                System.out.println("-------------MENU-------------" +
                        "\n1. " +
                        "\n2. " +
                        "\n3. " +
                        "\n4. Exit" +
                        "\nEnter your choice: ");
                int choice = -1;
                while (true) {
                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                        break;
                    }else {
                        System.out.println("Invalid choice! Please enter number from 1 to .");
                        System.out.println("Enter your choice: ");
                        scanner.nextLine();
                    }
                }
                dataOutputStream.writeInt(choice);
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice! Please enter number from 1 to .");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
