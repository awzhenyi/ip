package duke;

/**
 * Handles the welcome and exit portions of the chatbot
 */
public class Ui {

    private static final String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    public Ui() {

    }

    /**
     * Greets the user when the chatbot is ran
     */
    public static String greet() {
        return "Hello from\n" + logo + "Hello! I'm Duke" + "\n" + "What can I do for you?";
    }

    /**
     * Displays exit message when user exits the chatbot
     */
    public static String exit() {
        return "Bye. Hope to see you again soon!";
    }
}
