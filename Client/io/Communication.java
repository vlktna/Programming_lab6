/**
 * @author Veronika Volokitina
 * @version 2
 * @since 2
 * Класс для общения с сервером
 */
package io;

import commands.AbstractCommand;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class Communication {

    private InetAddress hostIP;
    private int port;
    private DatagramSocket socket;

    public Communication(String host, int port, DatagramSocket socket) throws IOException {
        this.hostIP = InetAddress.getByName(host);
        this.port = port;
        this.socket = socket;
    }

    /**
     * @param command - команда, которая отправляется серверу
     * @throws IOException
     */
    public void sendCommand(AbstractCommand command) throws IOException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(outputStream);
        os.writeObject(command);

        byte[] data = outputStream.toByteArray();
        DatagramPacket sendPacket = new DatagramPacket(data, data.length, this.hostIP, this.port);
        socket.send(sendPacket);

        System.out.println("Запрос отправлен серверу");
        outputStream.close();
        os.close();
    }

    /**
     * @throws IOException
     */
    public void receiveMessage() throws IOException {
        byte[] incomingData = new byte[5000];
        DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
        this.socket.receive(incomingPacket);
        String response = new String(incomingPacket.getData());
        System.out.println("Получен ответ от сервера:\n" + response);
    }

}

