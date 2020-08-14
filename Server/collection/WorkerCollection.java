/**
 * @author Veronika Volokitina
 * @version 2
 * @since 1
 *
 * Преобразует входящую строку в команду и аргумент
 */

package collection;

import aboutWorker.Worker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.LinkedList;

public class WorkerCollection {

    /** Коллекция с работниками */
    private LinkedList<Worker> workers;

    /** Дата создания коллекции */
    private Date date;

    public WorkerCollection() {
    }

    /**
     * @param fileName - файл, в котором хранится коллекция
     * @throws IOException
     */
    public void createCollection(String fileName) throws IOException {
        Gson gson = new Gson();
        Type founderListType = new TypeToken<LinkedList<Worker>>(){}.getType();
        LinkedList<Worker> workers = gson.fromJson(new FileReader(fileName), founderListType);

        this.workers = workers;
        this.date = new Date();
    }

    public LinkedList<Worker> getCollection() {
        return this.workers;
    }

    public Date getDate(Date date) {
        return date;
    }

    @Override
    public String toString() {
        return "Тип коллекции: " + workers.getClass() +
                "\nДата инициализации: " + this.date +
                "\nКоличество элементов: " + workers.size();
    }

}
