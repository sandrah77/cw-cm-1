import org.junit.BeforeClass;

import java.util.*;
import java.util.Set;
import java.util.HashSet;
import org.junit.*;
import static org.junit.Assert.*;
import java.io.File;

/**
 * Created by Alexander on 08/01/2016.
 */
public class ContactManagerImplTest {
    private ContactManagerImpl cm;
    private Calendar futureDate;
    private Calendar pastDate;
    private Set<Contact> contacts;
    private static final String FILENAME = "contacts.txt";

    @BeforeClass
    public static void runningNotification() {
        System.out.println("Running ContactManager tests...");
    }

    @Before
    public void init() {
        cm = new ContactManagerImpl();
    }

    @After
    public void tearDown() {
        File contactsFile = new File(FILENAME);
        try {
            if (contactsFile.exists()) {
                    contactsFile.delete();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestConstructorContactParameters() {
        assertEquals(1, cm.addNewContact("Simon", "Welcome"));
    }

}
