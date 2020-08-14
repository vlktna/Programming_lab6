/**
 * @author Veronika Volokitina
 * @version 2
 * @since 1
 *
 * Добавляет новый элемент в коллекцию, если его ID превышает значение наибольшего элемента этой коллекции
 */

package commands;

import aboutWorker.Worker;
import collection.WorkerCollection;

public class AddIfMax extends AbstractCommand{

    private Worker worker;
    public AddIfMax(Worker worker){
        this.worker = worker;
    }

    @Override
    public String execute(WorkerCollection workerCollection) throws NumberFormatException{
        int maxId = -1;
        int size = workerCollection.getCollection().size();

        for (int i = 0; i < size; i++){
            if (workerCollection.getCollection().get(i).getId() > maxId){
                maxId = workerCollection.getCollection().get(i).getId();
            }
        }
        if (this.worker.getId() > maxId){
            workerCollection.getCollection().add(this.worker);
            return "Добавлен новый элемент в коллекцию";
        }
        else {
            return "ID нового элемента не превышает значение наибольшего элемента этой коллекции, элемент не добавлен";
        }
    }
}
