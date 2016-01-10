import static org.junit.Assert.*;
import org.junit.*;

import java.util.*;
import java.util.concurrent.Future;

/**
 * Future meeting implementation tests.
 *
 * @author sfarme01
 */
public class FutureMeetingImplTest {
    private Set<Contact> contacts;
    private Contact contact1;
    private Contact contact2;
    private Contact contact3;


    @BeforeClass
    public static void runningNotification() {
        System.out.println("Running FutureMeetingImpl tests...");
    }

    @Before
    public void init() {
        contacts = new HashSet<Contact>();
        contact1 = new MockContact();
        contact2 = new MockContact();
        contact3 = new MockContact();
        Calendar date = new GregorianCalendar(2015, 5, 14);
    }

    @Test
    public void testIdAccessorMethod() {
        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        Calendar date = new GregorianCalendar(2015, 5, 14);
        FutureMeeting futureMeet = new FutureMeetingImpl(4, date, contacts);
        assertEquals(4, futureMeet.getId());
    }

    @Test
    public void testDateAccessorMethod() {
        contacts.add(contact1);
        contacts.add(contact2);
        Calendar date = new GregorianCalendar(2015, 5, 14);
        FutureMeeting futureMeet = new FutureMeetingImpl(4, date, contacts);
        assertEquals(date, futureMeet.getDate());
    }

    @Test
    public void testContactsAccessorMethod() {
        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        Calendar date = new GregorianCalendar(2015, 5, 14);
        FutureMeeting futureMeet = new FutureMeetingImpl(4, date, contacts);
        for (Contact contacts : futureMeet.getContacts()) {
            System.out.println("\n\t\t" + contacts.getId() + "\t" + contacts.getName());
        }
        assertEquals(3, futureMeet.getContacts().size());
        assertTrue(futureMeet.getContacts().containsAll(contacts));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIAENegativeId() {
        Calendar date = new GregorianCalendar(2015, 5, 14);
        FutureMeetingImpl futureMeet = new FutureMeetingImpl(-1, date, contacts);
    }

    @Ignore(expected = NullPointerException.class)
    public void testNPENullDate() {
        Calendar date = new GregorianCalendar(2015, 5, 14);
        FutureMeeting futureMeet = new FutureMeetingImpl(9, null, contacts);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIAEEmptySetOfContacts() {
        Calendar date = new GregorianCalendar(2015, 5, 14);
        FutureMeeting futureMeet = new FutureMeetingImpl(9, date, contacts);
    }


    @Ignore(expected = NullPointerException.class)
    public void testNPEAllNull() {
        Calendar date = new GregorianCalendar(2015, 5, 14);
        FutureMeeting futureMeet = new FutureMeetingImpl(1, null, null);
    }
}
