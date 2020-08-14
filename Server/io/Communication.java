/**
 * @author Veronika Volokitina
 * @version 2
 * @since 2
 *
 * Класс для общения с клиентом
 */

package io;

import commands.AbstractCommand;
import java.io.*;
import java.net.*;

public class Communication {

    private DatagramSocket socket;
    private InetSocketAddress address;
    private int port;
    private InetAddress clientAddress;
    private AbstractCommand command;

    public Communication(DatagramSocket socket) throws IOException {
        this.socket = socket;
    }

    /**
     * @return команда, которую отправил клиент
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public AbstractCommand receiveCommand() throws IOException, ClassNotFoundException {

        byte[] incomingData = new byte[5000];
        DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
        this.socket.receive(incomingPacket);
        this.clientAddress = incomingPacket.getAddress();
        this.port = incomingPacket.getPort();

        byte[] data = incomingPacket.getData();
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        AbstractCommand command = (AbstractCommand) is.readObject();
        in.close();
        is.close();
        this.command = command;
        return command;
    }

    public AbstractCommand getCurrentCommand(){
        return this.command;
    }

    /**
     * @param msg - сообщение, которое отправляется клиенту
     * @throws IOException
     */
    public void sendMessage(String msg) throws IOException {
        byte[] replyByte = msg.getBytes();
        DatagramPacket replyPacket = new DatagramPacket(replyByte, replyByte.length, this.clientAddress, this.port);
        this.socket.send(replyPacket);
    }

}

