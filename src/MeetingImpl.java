import java.util.Calendar;
import java.util.Set;

/**
 * Created by Alexander on 24/12/2015.
 */
public abstract class MeetingImpl implements Meeting {
    private int id;
    private Calendar date;
    private Set<? extends Contact> contacts;

    /**
     * Adding default constructor for brevity
     */
    MeetingImpl(){
    }

    /**
     * Constructor with three parameters.
     * The set of contacts must be non-empty or an IllegalArgumentException will be thrown.
     * An IllegalArgumentException will be thrown in the case of the id being non-positive or zero.
     * If any of the references/pointers passed as parameters is null, a NullPointerException is thrown.
     *
     * @param id the contact id
     * @param date the date of the meeting
     * @param contacts the list of people that attended the meeting
     */
    MeetingImpl(int id, Calendar date, Set<Contact> contacts){
        this.id = id;
        this.date = date;
        this.contacts = contacts;

    }





}
