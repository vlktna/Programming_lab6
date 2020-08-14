/**
 * @author Veronika Volokitina
 * @version 2
 * @since 1
 *
 */

package io;

import aboutWorker.Position;
import commands.*;
import exceptions.NoArgumentException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.LinkedList;

public class CreateObject {

    /**
     * Коллекция для хранения введенных команд
     */
    LinkedList<String> historyList = new LinkedList<>();

    /**
     * @param inputCommand запрос клиента
     * @return команда для выполнение
     * @throws IOException
     * @throws NullPointerException
     */
    public AbstractCommand commandChoice(String inputCommand) throws IOException, NullPointerException {
        String[] line = inputCommand.trim().toLowerCase().split(" ", 2);
        ReadElement newWorker = new ReadElement();

        switch (line[0]) {
            case "help":
                this.historyList.add("help");
                return new Help();

            case "info":
                this.historyList.add("info");
                return new Info();

            case "show":
                this.historyList.add("show");
                return new Show();

            case "add":
                this.historyList.add("add");
                return new Add(newWorker.readElement());

            case "update":
                try {
                    if (line.length < 2) throw new NoArgumentException();
                    int id = Integer.parseInt(line[1]);
                    this.historyList.add("update");
                    return new Update(newWorker.readElement(), id);
                } catch (NoArgumentException | NumberFormatException e) {
                    return new MessageCommand("Введи значение id");
                }

            case "remove_by_id":
                try {
                    if (line.length < 2) throw new NoArgumentException();
                    int id = Integer.parseInt(line[1]);
                    this.historyList.add("remove_by_id");
                    return new RemoveById(id);
                } catch (NoArgumentException | NumberFormatException e) {
                    return new MessageCommand("Введи значение id");
                }

            case "clear":
                this.historyList.add("clear");
                return new Clear();

            case "execute_script":
                try {
                    if (line.length < 2) throw new NoArgumentException();

                    FileRead fileRead = new FileRead();
                    String[] file = fileRead.getFile(line[1]).split("\n");
                    this.historyList.add("execute_script");

                    for (int i = 0; i < file.length; i++) {
                        AbstractCommand command = commandChoice(file[i]);
                        return new ExecuteScript(command);
                    }
                } catch (NoArgumentException e) {
                    return new MessageCommand("Файл не указан");
                } catch (NoSuchFileException e) {
                    return new MessageCommand("Файл не найден");
                }

            case "add_if_max":
                this.historyList.add("add_if_max");
                return new AddIfMax(newWorker.readElement());


            case "remove_lower":
                try {
                    if (line.length < 2) throw new NoArgumentException();
                    int id = Integer.parseInt(line[1]);
                    this.historyList.add("remove_lower");
                    return new RemoveLower(id);
                } catch (NumberFormatException | NoArgumentException e) {
                    System.out.println("Введи значение ID");
                }


            case "history":
                if (this.historyList.size() > 10) {
                    for (int i = 0; i < this.historyList.size() - 11; i++) {
                        this.historyList.remove(i);
                    }
                }
                this.historyList.add("history");
                return new MessageCommand (String.valueOf(this.historyList));



            case "filter_by_position":
                try {
                    if (line.length < 2) throw new NoArgumentException();
                    Position positionStatus = Position.valueOf(line[1].toUpperCase());
                    this.historyList.add("filter_by_position");
                    return new FilterByPosition(positionStatus);

                } catch (NoArgumentException e) {
                    return new MessageCommand("Не введено значение должности");
                } catch (IllegalArgumentException e) {
                    return new MessageCommand("Такой должности нет");
                }

            case "print_ascending":
                this.historyList.add("print_ascending");
                return new PrintAscending();

            case "print_field_descending_start_date":
                this.historyList.add("print_field_descending_start_date");
                return new PrintFieldDescendingStartDate();

            case "exit":
                return new Exit();

            default:
                return new UnknownCommand();
        }
    }
}




