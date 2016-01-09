/**
 * Created by Alexander on 08/01/2016.
 */
import org.junit.*;
import java.util.Set;
import java.util.HashSet;


public class PastMeetingImplTest {

    private Set<ContactImpl> contacts;
    private ContactImpl contact1;
    private ContactImpl contact2;
    private ContactImpl contact3;


    @BeforeClass
    public static void runningNotification() {
        System.out.println("Running PastMeetingImpl tests...");
    }

    @Before
    public void init() {
        contacts = new HashSet<ContactImpl>();
        contacts.add(new ContactImpl(1, "Matthew"));
        contacts.add(new ContactImpl(3, "Philip"));
        contacts.add(new ContactImpl(5, "James, the elder"));
    }







}
