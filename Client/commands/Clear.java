/**
 * @author Veronika Volokitina
 * @version 2
 * @since 1
 *
 * Очищает коллекцию
 */

package commands;

import collection.WorkerCollection;

public class Clear extends AbstractCommand{

    @Override
    public String execute(WorkerCollection workerCollection){
        workerCollection.getCollection().clear();
        return "Коллекция очищена";
    }
}
