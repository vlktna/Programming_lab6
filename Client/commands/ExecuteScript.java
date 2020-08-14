/**
 * @author Veronika Volokitina
 * @version 2
 * @since 1
 *
 * Выполняет скрипт
 */

package commands;

import collection.WorkerCollection;

import java.io.FileNotFoundException;

public class ExecuteScript extends AbstractCommand{

    private AbstractCommand command;

    public ExecuteScript(AbstractCommand command){
        this.command = command;
    }

    @Override
    public String execute(WorkerCollection workerCollection) throws FileNotFoundException {
        String result = this.command.execute(workerCollection);
        return result;
    }
}
