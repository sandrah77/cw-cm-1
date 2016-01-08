

/**
 * Created by Alexander on 24/12/2015.
 * This class implements the Contact interface
 */
public class ContactImpl implements Contact {
   private int Id;
   private String name;
   private String notes;

    /**
     * Another more restricted constructor which take only two parameters (ID and name)
     *
     * If the ID provided is zero or negative, an IllegalArgumentException will be thrown.
     *
     * If any of the references/pointers passed as parameters to the constructor are null,
     * a NullPointerException will be thrown.
     *
     * @param Id the contact id
     * @param name the contact name
     */
    public ContactImpl(int Id, String name){
        this.Id = Id;
        this.name = name;
        notes = "";
    }

    /**
     *
     * @param Id
     * @param name
     * @param notes
     * @throws IllegalArgumentException
     */
    public ContactImpl(int Id, String name, String notes)  throws IllegalArgumentException {
        if ((name == null) || (notes == null)) {
            throw new NullPointerException("Invalid id, name and notes. Please enter values again");
        } else if (Id <= 0) {
            throw new IllegalArgumentException("Contact ID must be greater than 0");
        } else {
            this.Id = Id;
            this.name = name;
            this.notes = notes;
        }
    }


    @Override
    public int getId() {
        return this.Id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getNotes() {
        return this.notes;
    }

    @Override
    public void addNotes(String note) {
        if (note != null) {
            this.notes += '\n';
        }
        this.notes += note; // new note is appended to the earlier note.
    }

}
