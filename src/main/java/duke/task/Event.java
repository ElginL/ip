package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Event Class that encapsulates details of an Event Task.
 *
 * @author Elgin Lee
 */
public class Event extends Task {
    /** The date and time of the event. */
    private LocalDate date;

    /**
     * Constructor of Event.
     *
     * @param taskName The name of the Event.
     * @param date The date and time when the Event will happen.
     * @throws DateTimeParseException If date cannot be casted to LocalDate.
     */
    public Event(String taskName, String date) throws DateTimeParseException {
        super(taskName);
        this.date = LocalDate.parse(date);
    }

    /**
     * Constructor of Event.
     *
     * @param taskName The name of the event.
     * @param date The date and time when the Event will happen.
     * @param isDone True if the event is done, false otherwise.
     */
    public Event(String taskName, String date, boolean isDone) throws DateTimeParseException {
        super(taskName, isDone);
        this.date = LocalDate.parse(date);
    }

    /**
     * Gets the date of the event.
     *
     * @return The date of the event.
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * String representation of an Event.
     *
     * @return Event string representation.
     */
    @Override
    public String toString() {
        String formattedDate = this.date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));

        // Basic task representation, mark status and task description (e.g. [X] sleep).
        String basicDescription = super.toString();

        return "[E]" + basicDescription + " (at: " + formattedDate + ")";
    }
}
