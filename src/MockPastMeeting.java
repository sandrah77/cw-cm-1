import java.util.Calendar;
import java.util.Set;


public class MockPastMeeting implements PastMeeting {

    private int Id;
    private Calendar date;
    private Set<? extends Contact> contacts;
    private String notes;

    public MockPastMeeting (int Id, Calendar date, Set<? extends Contact> contacts, String notes) {
        this.Id = Id;
        this.date = date;
        this.contacts = contacts;
        this.notes = notes;
    }

    @Override
    public String getNotes() {
        return notes;
    }

    @Override
    public int getId() {
        return Id;
    }

    @Override
    public Calendar getDate() {
        return date;
    }

    @Override
    public Set<Contact> getContacts() {
        return (Set<Contact>) contacts;
    }
}
