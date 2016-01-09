
/**
 * Created by Alexander on 24/12/2015.
 */

import java.util.Calendar;
import java.util.Set;

public class PastMeetingImpl extends MeetingImpl implements PastMeeting {
    private String notes;

    /**
     * Constructor with three parameters.
     * The set of contacts must be non-empty or an IllegalArgumentException will be thrown.
     * An IllegalArgumentException will be thrown in the case of the id being non-positive or zero.
     * If any of the references/pointers passed as parameters is null, a NullPointerException is thrown.
     *
     * @param Id the contact id
     * @param date the date of the meeting
     * @param contacts the list of people that attended the meeting
     */
    public PastMeetingImpl(int Id, Calendar date, Set<Contact> contacts, String notes) {
        super(Id, date, contacts);

    }

    /**
     * Returns the notes from the meeting.
     *
     * If there are no notes, the empty string is returned.
     *
     * @return the notes from the meeting.
     */
    public String getNotes() {
        return notes;
    }
}
