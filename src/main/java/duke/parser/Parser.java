package duke.parser;

import java.util.ArrayList;
import java.util.Arrays;

import duke.command.AddCommand;
import duke.command.Command;
import duke.command.DeleteCommand;
import duke.command.ExitCommand;
import duke.command.FindCommand;
import duke.command.ListCommand;
import duke.command.MarkCommand;
import duke.command.UnmarkCommand;
import duke.exception.DukeException;

/**
 * Parser class that deals with making sense of the user command.
 *
 * @author Elgin
 */
public class Parser {
    /** All valid commands. */
    private static final ArrayList<String> VALID_COMMANDS = new ArrayList<>(Arrays.asList("bye", "list", "todo",
            "event", "deadline", "mark", "unmark", "delete", "find"));

    /** All valid commands without arguments. */
    private static final ArrayList<String> VALID_COMMANDS_WITHOUT_ARGS = new ArrayList<>(Arrays.asList("bye", "list"));

    /**
     * Parses the user input and return the command that the user is demanding.
     *
     * @param userInput The user input into the CLI.
     * @return Command that the user wants to execute.
     * @throws DukeException If no matching command is found that Duke supports.
     */
    public static Command parse(String userInput) throws DukeException {
        String[] inputWords = userInput.trim().split(" ");

        if (userInput.equals("todo") || userInput.equals("deadline") || userInput.equals("event")) {
            throw new DukeException("The description of a task cannot be empty!");
        }

        if (userInput.equals("mark")) {
            throw new DukeException("Usage 'mark index'");
        }

        if (userInput.equals("unmark")) {
            throw new DukeException("Usage 'unmark index'");
        }

        if (userInput.equals("delete")) {
            throw new DukeException("Usage 'delete index'");
        }

        if (userInput.equals("find")) {
            throw new DukeException("Usage 'find title'");
        }

        String userCommand = inputWords[0];
        String arguments = Parser.canRunWithoutArgs(inputWords[0]) || !Parser.isValidCommand(inputWords[0])
                ? ""
                : userInput.substring(userCommand.length() + 1);

        switch (userCommand) {
        case "todo":
        case "deadline":
        case "event":
            return new AddCommand(userCommand, arguments);
        case "delete":
            return new DeleteCommand(arguments);
        case "mark":
            return new MarkCommand(arguments);
        case "unmark":
            return new UnmarkCommand(arguments);
        case "find":
            return new FindCommand(arguments);
        case "list":
            return new ListCommand();
        case "bye":
            return new ExitCommand();
        default:
            throw new DukeException("I'm sorry, I don't understand what that means :-(");
        }
    }

    /**
     * Checks whether single line command is allowed (Depends on your declaration).
     *
     * @param command The command that needs to be checked whether it is allowed to run without arguments.
     * @return True if command can run without arguments, false otherwise.
     */
    public static boolean canRunWithoutArgs(String command) {
        return Parser.VALID_COMMANDS_WITHOUT_ARGS.contains(command);
    }

    /**
     * Checks whether it is a recognized command.
     *
     * @param command The command to be checked for validity.
     * @return True if command is valid, false otherwise.
     */
    public static boolean isValidCommand(String command) {
        return Parser.VALID_COMMANDS.contains(command);
    }
}
