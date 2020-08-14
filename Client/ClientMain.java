/**
 * @author Veronika Volokitina
 * @version 2
 * @since 2
 *
 */

import commands.AbstractCommand;
import commands.Exit;
import io.Communication;
import io.CreateObject;
import io.TerminalRead;
import java.io.*;
import java.net.*;

public class ClientMain {
//    static int port = 8080;
//    static String host = "localhost";

    public static void main(String[] args) throws IOException {

        try {
            int port = Integer.parseInt(args[0]);
            String host = args[1];

            DatagramSocket socket = new DatagramSocket();
            TerminalRead terminalRead = new TerminalRead();
            CreateObject createObject = new CreateObject();
            AbstractCommand command = new AbstractCommand();
            Communication communication = new Communication(host, port, socket);

            System.out.println("Напиши help");
            while (true) {
                socket.setSoTimeout(1000);
                command = createObject.commandChoice(terminalRead.getNextInput());
                communication.sendCommand(command);
                communication.receiveMessage();

                if (command instanceof Exit) {
                    socket.close();
                    break;
                }
            }
        } catch (SocketTimeoutException e) {
            System.out.println("Сервер умер");
        } catch (StackOverflowError e) {
            System.out.println("Ты умер");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Напиши <port> <host>");
        } catch (UnknownHostException e) {
            System.out.println("Хост не найден");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Неверно указан порт");
        }
    }
}
