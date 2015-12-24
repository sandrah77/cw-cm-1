import java.util.Calendar;

/**
 * Created by Alexander on 24/12/2015.
 */
public abstract class MeetingImpl implements Meeting {
    private int ID;
    private String date;
    private Calendar date;
    private Set<? extends Contact> contacts;

    /**
     * Adding default constructor for brevity
     *
     */
    MeetingImpl(){
    }

    /**
     * Constructor
     *
     */
    MeetingImpl(int id, Calendar date, Set<Contact> contacts){
        this.id = id;
        this.date = date;
        this.contacts = contacts;

    }





}
