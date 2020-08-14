/**
 * @author Veronika Volokitina
 * @version 2
 * @since 1
 *
 * Сортирует коллекцию в порядке возратсания ID
 */

package commands;

import aboutWorker.Worker;
import collection.WorkerCollection;
import java.util.Comparator;

public class PrintAscending extends AbstractCommand{

    @Override
    public String execute(WorkerCollection workerCollection){
        Comparator<Worker> comparator = Comparator.comparing(Worker::getId);
        workerCollection.getCollection().sort(comparator);
        return "Коллекция отсортирована по возрастанию ID";
    }
}
