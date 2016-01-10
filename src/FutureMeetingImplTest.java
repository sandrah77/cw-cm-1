import static org.junit.Assert.*;
import org.junit.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;

/**
 * Future meeting implementation tests.
 *
 * @author sfarme01
 */
public class FutureMeetingImplTest {
    private Set<Contact> contacts;


    @BeforeClass
    public static void runningNotification() {
        System.out.println("Running FutureMeetingImpl tests...");
    }

    @Before
    public void init() {
        contacts = new HashSet<Contact>();
        Contact contact1 = new MockContact();
        Contact contact2 = new MockContact();
        Contact contact3 = new MockContact();
        Calendar date = new GregorianCalendar(2015, 5, 14);
    }

    @Test
    public void testIdAccessorMethod() {
        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        Calendar date = new GregorianCalendar(2015, 5, 14);
        FutureMeeting futureMeet = new FutureMeetingImpl(4, date, contacts, "Let's get started at noon");
        assertEquals(4, futureMeet.getId());
    }


}
