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

    @After
    public void tearDown() {
        contacts = null;
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
        Calendar date = new GregorianCalendar(2015, 5, 14);
        PastMeeting pastMeet = new PastMeetingImpl(2, date, contacts, "See you then");
        assertEquals(date, pastMeet.getDate());
    }

    @Test
    public void testContactsGetterMethod() {
        contacts.add(contact1);
        contacts.add(contact2);
        Calendar date = new GregorianCalendar(2015, 5, 14);
        PastMeeting pastMeeting = new PastMeetingImpl(5, date, contacts, "Should we take the time machine?");
        for(Contact contacts: pastMeeting.getContacts()) {
            System.out.println("\n\t\t" + contacts.getId() + "\t" + contacts.getName());
        }
        assertEquals(2, pastMeeting.getContacts().size());
        assertTrue(pastMeeting.getContacts().containsAll(contacts));
    }

    @Test
    public void testNotesGetterMethod() {
        contacts.add(contact1);
        Calendar date = new GregorianCalendar(2015, 5, 14);
        PastMeeting pastMeet = new PastMeetingImpl(5, date, contacts, "All is well");
        assertEquals("All is well", pastMeet.getNotes());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIAEEmptySetOfContacts() {
        Calendar date = new GregorianCalendar(2015, 5, 14);
        PastMeeting pastMeet = new PastMeetingImpl(9, date, contacts, "Let's gather");
    }

    @Test (expected = NullPointerException.class)
    public void testNPENullDate() {
        Calendar date = new GregorianCalendar(2015, 5, 14);
        contacts.add(contact1);
        PastMeeting pastMeet = new PastMeetingImpl(9, null, contacts, "Let's gather");
    }

    @Test (expected = NullPointerException.class)
    public void testNPENullNotes() {
        contacts.add(contact1);
        Calendar date = new GregorianCalendar(2015, 5, 14);
        PastMeeting pastMeet = new PastMeetingImpl(9, date, contacts, null);
    }

    @Test(expected = NullPointerException.class)
    public void testNPEAllNull() {
        Calendar date = new GregorianCalendar(2015, 5, 14);
        PastMeeting pastMeeting = new PastMeetingImpl(1, null, null, null);
    }


}
