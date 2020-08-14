/**
 * @author Veronika Volokitina
 * @version 2
 * @since 2
 *
 * Неизвестная команда
 */
package commands;

import collection.WorkerCollection;

public class UnknownCommand extends AbstractCommand{

    @Override
    public String execute(WorkerCollection workerCollection){
        return "Команда не найдена";
    }
}
