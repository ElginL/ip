import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Deadline Class that encapsulates details of a task with a deadline.
 *
 * @author Elgin Lee
 */
public class Deadline extends Task {
    /** The date of deadline. */
    protected LocalDate date;

    /**
     * Constructor of Deadline.
     *
     * @param taskName The Task's Name.
     * @param date The date of deadline.
     * @throws DateTimeParseException If date cannot be casted to LocalDate.
     */
    public Deadline(String taskName, String date) throws DateTimeParseException {
        super(taskName);
        this.date = LocalDate.parse(date);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}
