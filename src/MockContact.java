/**
 * Created by Alexander on 09/01/2016.
 */
public class MockContact implements Contact {

    @Override
    public int getId() {
        return 4;
    }

    @Override
    public String getName() {
        return "Matt";
    }

    @Override
    public String getNotes() {
        return "Meeting today";
    }

    @Override
    public void addNotes(String note) {
    }
}
