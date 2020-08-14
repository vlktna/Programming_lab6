/**
 * @author Veronika Volokitina
 * @version 2
 * @since 2
 */

import collection.WorkerCollection;
import commands.AbstractCommand;
import io.Communication;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerMain {
//    static int port = 8080;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket socket = null;
        Logger logger = Logger.getLogger(ServerMain.class.getName());
        try {

            int port = Integer.parseInt(args[0]);
            WorkerCollection workerCollection = new WorkerCollection();
            workerCollection.createCollection("collection.json");
            logger.log(Level.INFO,"Начало main, создаем коллекцию");

            socket = new DatagramSocket(port);
            Communication communication = new Communication(socket);

            while (true) {
                AbstractCommand command = communication.receiveCommand();
                logger.log(Level.INFO,"Сервер получил команду: " + communication.getCurrentCommand());
                String data = command.execute(workerCollection);
                communication.sendMessage(data);
                logger.log(Level.INFO,"Ответ отправлен клиенту");
            }
        }catch (NumberFormatException e){
            logger.log(Level.WARNING,"Неверно указан порт");
        }catch (FileNotFoundException e){
            logger.log(Level.WARNING,"Не найден файл с коллекцией");
        }catch (ArrayIndexOutOfBoundsException e){
            logger.log(Level.WARNING,"Порт не указан");
        }finally {
            socket.close();
        }
    }
}


