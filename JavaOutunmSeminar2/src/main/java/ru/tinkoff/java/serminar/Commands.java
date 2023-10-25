package ru.tinkoff.java.serminar;

public enum Commands {
    EXIT_CMD("exit"),
    ADD_TASK("addTask"),
    GET_HISTORY("getHistory"),
    GET_TASK("getTask");

    private String command;

    Commands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
