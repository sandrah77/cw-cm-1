import org.junit.BeforeClass;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by Alexander on 08/01/2016.
 */
public class ContactManagerImplTest {
    private ContactManagerImpl contactManager = new ContactManagerImpl();
    private Calendar futureDate;
    private Calendar pastDate;

    private static final String FILENAME = "contacts.txt";


    @BeforeClass
    public static void runningNotification() {
        System.out.println("Running ContactManager tests...");
    }
    

    @After
    public void tearDown() {

    }


    }

}
