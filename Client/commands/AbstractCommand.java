/***
 * @author Veronika Volokitina
 * @version 2
 * @since 2
 *
 * Супер-класс всех команж
 */

package commands;

import collection.WorkerCollection;

import java.io.FileNotFoundException;
import java.io.Serializable;

public class AbstractCommand implements Serializable {

    /**
     * @param workerCollection - коллекция с работниками
     * @return ответ клиенту c результатом выполнения команды
     */
    public String execute(WorkerCollection workerCollection) throws FileNotFoundException {
        return null;
    }
}
