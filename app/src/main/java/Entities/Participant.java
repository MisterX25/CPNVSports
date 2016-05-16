package Entities;

/**
 * A participant to one of the tournaments. Can be either a team or a person
 */
public abstract class Participant
{
    //=========================================== Attributes ==================================
    /**
     * The name that will appear in all displays
     */
    protected String pseudo;

    /**
     * Unique identifier
     */
    private int id;

    //=========================================== Methods ==================================

    public abstract String dump(); // Format of dump differs according to specialized type

    //=========================================== Getters/Setters ==================================
    public String getPseudo()
    {
        return pseudo;
    }

    public void setPseudo(String pseudo)
    {
        this.pseudo = pseudo;
    }
}
