/**
 * @author Veronika Volokitina
 * @version 2
 * @since 1
 *
 * Удаляет элемент коллекции по заданному ID
 */

package commands;

import collection.WorkerCollection;

public class RemoveById extends AbstractCommand{

    private int id;

    public RemoveById(int id){
        this.id = id;
    }

    @Override
    public String execute(WorkerCollection workerCollection) throws NumberFormatException{
        int counter = 0;
        int size = workerCollection.getCollection().size();
        String output = "";

        for (int i = 0; i < size; i++){
            if(workerCollection.getCollection().get(i).getId().equals(this.id)){
                workerCollection.getCollection().remove(i);
                output = "Элемент удален";
            }
            else {
                counter += 1;
            }
        }
        if (counter == size){
            output = "Элемент с таким ID не найден";
        }
        return output;
    }
}
