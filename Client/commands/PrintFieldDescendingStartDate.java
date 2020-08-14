/**
 * @author Veronika Volokitina
 * @version 2
 * @since 1
 *
 * Выводит значения поля startDate всех элементов в порядке убывания
 */
package commands;

import collection.WorkerCollection;
import java.time.LocalDate;
import java.util.PriorityQueue;

public class PrintFieldDescendingStartDate extends AbstractCommand{


    @Override
    public String execute(WorkerCollection workerCollection){
        PriorityQueue<LocalDate> StartDate = new PriorityQueue<LocalDate>();
        for (int i = 0; i < workerCollection.getCollection().size(); i++) {
            StartDate.add(workerCollection.getCollection().get(i).getStartDate());
        }
        return String.valueOf(StartDate);
    }
}
