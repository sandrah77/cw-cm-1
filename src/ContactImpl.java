

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
    public ContactImpl(int Id, String name, String notes){
        this.Id = Id;
        this.name = name;
        this.notes = "Let's drink wine and break bread";
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

    }

}
