package duke.ui;

import duke.task.Task;

/**
 * Ui class that handles showing the user texts.
 *
 * @author Elgin
 */
public class Ui {
    /**
     * Bye to user (End process message).
     *
     * @return String representation of Bye message.
     */
    public String getByeMsg() {
        return "Bye. Hope to see you again soon!\n" + "Application closing in 3 seconds...";
    }

    /**
     * Formats a task added message for Duke.
     *
     * @return Message conveying that task has successfully been added, and the current number of tasks.
     */
    public String getTaskAddedMsg(int newTaskCount, Task task) {
        return "Got it. I've added this task:\n" + "  " + task + "\n" + "Now you have "
                + newTaskCount + " tasks in the list.";
    }

    /**
     * Formats a task deleted message for Duke.
     *
     * @return Message conveying that user that has successfully deleted a task, and the number of tasks left
     */
    public String getTaskDeletedMsg(int newTaskCount, String taskDescription) {
        return "Noted. I've removed this task:\n  " + taskDescription + "\n" + "Now you have "
                + newTaskCount + " tasks in the list";
    }

    /**
     * Formats a message signaling a task has been successfully marked.
     *
     * @param taskDescription The description of the task marked.
     */
    public String getTaskMarkedMsg(String taskDescription) {
        return "Nice! I've marked this task as done:\n" + taskDescription;
    }

    /**
     * Formats a message signaling a task has been successfully unmarked.
     *
     * @param taskDescription The description of the task unmarked.
     */
    public String getTaskUnmarkedMsg(String taskDescription) {
        return "OK, I've marked this task as not done yet:\n" + taskDescription;
    }

    /**
     * Formats a message that lists all tasks for Duke.
     *
     * @param allTasks String representation of allTasks.
     * @return A formatted string representation of all tasks.
     */
    public String getAllTasksMsg(String allTasks) {
        if (allTasks.trim().isEmpty()) {
            return "There are no tasks yet...";
        }

        return "Here are the tasks in your list\n" + allTasks;
    }

    /**
     * File Loading Tasks Error.
     *
     * @return String representation of loading error.
     */
    public String getLoadingErrorMsg() {
        return "OOPS!!! Failed to load tasks because file cannot be opened!";
    }

    /**
     * Formats a Duke error message.
     *
     * @param error Error message.
     * @return Formatted duke error message.
     */
    public String formatDukeErrorMsg(String error) {
        return "OOPS!!! " + error;
    }

    /**
     * Formats a date parsing error message (Invalid date format).
     *
     * @return Formatted invalid date error message.
     */
    public String getDateErrorMsg() {
        return "OOPS!!! Your date format has to be in the form 'yyyy-mm-dd'";
    }

    /**
     * Formats String to Number cast error message (because user did not input a number).
     *
     * @return Formatted invalid number error message.
     */
    public String getNumberCastErrorMsg() {
        return "OOPS!!! Please input a valid index (i.e. a number)";
    }

    /**
     * Formats all search results message for Duke.
     *
     * @param searchResults String representation of all string results.
     * @return String representation of all search results.
     */
    public static String getSearchResultsMsg(String searchResults) {
        return "Here are the matching tasks in your list:\n" + searchResults;
    }
}
