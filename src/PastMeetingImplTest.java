/**
 * Created by Alexander on 08/01/2016.
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;


public class PastMeetingImplTest {

    private Set<Contact> contacts;
    private Contact contact1;
    private Contact contact2;
    private Contact contact3;


    @BeforeClass
    public static void runningNotification() {
        System.out.println("Running PastMeetingImpl tests...");
    }

    @Before
    public void init() {
      //contacts = new HashSet<ContactImpl>();
      //contacts.add(new ContactImpl(1, "Matthew"));
      //contacts.add(new ContactImpl(3, "Philip"));
      //contacts.add(new ContactImpl(5, "James, the elder"));
      contact1 = new MockContact();
      contact2 = new MockContact();
      contact3 = new MockContact();
      contacts = new HashSet<Contact>();

    }

    @Test
    public void testIdAccessorMethod() {
        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        Calendar date = new GregorianCalendar(2015, 5, 14);
        PastMeeting pastMeet = new PastMeetingImpl(3, date, contacts, "Let's get started at noon");
        assertEquals(3, pastMeet.getId());
    }

    @Test
    public void testDateAccessorMethod() {
        contacts.add(contact1);
        contacts.add(contact2);
        Calendar date = new GregorianCalendar(2015, 5, 45);
        PastMeeting pastMeet = new PastMeetingImpl(2, null, contacts, "See you then");
        assertEquals(date, pastMeet.getDate());

    }
}
