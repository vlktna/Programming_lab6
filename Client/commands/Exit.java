/**
 * @author Veronika Volokitina
 * @version 2
 * @since 2
 *
 * Завершение клиентского приложения
 */

package commands;

import collection.WorkerCollection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Exit extends AbstractCommand{

    @Override
    public String execute(WorkerCollection workerCollection) throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PrintWriter out = new PrintWriter(new File("collection.json").getAbsoluteFile());
        out.print(gson.toJson(workerCollection.getCollection()));
        out.close();
        return "Завершение работы, сохранение коллекции";
    }
}
