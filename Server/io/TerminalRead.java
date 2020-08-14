/**
 * @author Veronika Volokitina
 * @version 2
 * @since 1
 *
 * Считывает комманды из терминала
 */

package io;

import java.util.Scanner;


public class TerminalRead implements io.IOInterface {
    private String currentInput;

    @Override
    public String getNextInput() {
        Scanner terminal = new Scanner(System.in);
        currentInput = terminal.nextLine();
        return currentInput;
    }

    @Override
    public String getCurrentInput() {
        return currentInput;
    }

    @Override
    public int getNextIntInput() {
        Scanner terminal = new Scanner(System.in);
        return terminal.nextInt();
    }

    @Override
    public Long getNextLongInput() {
        Scanner terminal = new Scanner(System.in);
        return terminal.nextLong();
    }
}
