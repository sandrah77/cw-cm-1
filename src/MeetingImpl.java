import java.util.Calendar;
import java.util.Set;

/**
 * Created by Alexander on 24/12/2015.
 */
public abstract class MeetingImpl implements Meeting, java.io.Serializable {
    private int Id;
    private Calendar date;
    private Set<? extends Contact> contacts;

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
    public MeetingImpl(int Id, Calendar date, Set<Contact> contacts) throws IllegalArgumentException {
        if ((date == null) || (contacts == null)) {
            throw new NullPointerException("Invalid id, name and notes. Please enter values again");
        } else if (Id <= 0) {
            throw new IllegalArgumentException("Contact ID must be greater than 0");
        } else if (contacts.isEmpty()) {
            throw new IllegalArgumentException("At least one person must be attending the meeting");
        } else {
            this.Id = Id;
            this.date = date;
            this.contacts = contacts;
        }
    }

    /**
     * Returns the id of the meeting.
     *
     * @return the id of the meeting.
     */
    public int getId() {
        return this.Id;
    }


    /**
     * Return the date of the meeting.
     *
     * @return the date of the meeting.
     */
    public Calendar getDate() {
        return this.date;
    }

    /**
     * Return the details of people that attended the meeting.
     *
     * The list contains a minimum of one contact (if there were
     * just two people: the user and the contact) and may contain an
     * arbitrary number of them.
     *
     * @return the details of people that attended the meeting.
     */
    public Set<Contact> getContacts(){
        return (Set<Contact>) contacts;
    }
}
