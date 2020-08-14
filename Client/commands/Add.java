/**
 * @author Veronika Volokitina
 * @version 2
 * @since 1
 *
 * Добавляет новый элемент в коллекцию
 */

package commands;

import aboutWorker.Worker;
import collection.WorkerCollection;

public class Add extends AbstractCommand{

    private Worker worker;
    public Add(Worker worker){
        this.worker = worker;
    }

    @Override
    public String execute(WorkerCollection workerCollection) {
        workerCollection.getCollection().add(worker);
        return "Новый элемент добавлен в коллекцию";
    }
}
