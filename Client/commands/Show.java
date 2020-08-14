/**
 * @author Veronika Volokitina
 * @version 2
 * @since 1
 *
 * Выводит элементы коллекции
 */

package commands;

import collection.WorkerCollection;

public class Show extends AbstractCommand{

    @Override
    public String execute(WorkerCollection workerCollection){
        if(workerCollection.getCollection().size() != 0) {
            return String.valueOf(workerCollection.getCollection());
        }
        else{
            return  "Коллекция пуста";
        }
    }
}
