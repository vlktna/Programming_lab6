/**
 * @author Veronika Volokitina
 * @version 2
 * @since 1
 *
 * Удаляет из коллекции все элементы, ID которых меньшие, чем заданный
 */

package commands;

import collection.WorkerCollection;
import exceptions.NoArgumentException;

public class RemoveLower extends AbstractCommand{

    private int id;
    public RemoveLower(int id){
        this.id = id;
    }

    @Override
    public String execute(WorkerCollection workerCollection) throws NumberFormatException{
        int size = workerCollection.getCollection().size();
        int counter = 0;
        String output = "";
        for (int i = 0; i < size; i++) {
            if (workerCollection.getCollection().get(i).getId() < this.id) {
                output = "Элемент удален";
                workerCollection.getCollection().remove(i);
            }
            else{
                counter += 1;
            }
        }
        if (counter == size){
            output = "Такие элементы не найдены";
        }
        return output;
    }
}
