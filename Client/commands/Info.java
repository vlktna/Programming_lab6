/**
 * @author Veronika Volokitina
 * @version 2
 * @since 1
 *
 * Выводит справку по коллекции
 */

package commands;

import collection.WorkerCollection;

public class Info extends AbstractCommand{

    @Override
    public String execute(WorkerCollection workerCollection){
        return workerCollection.toString();
    }
}
