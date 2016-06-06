package Entities;

/**
 * A participant to one of the tournaments. Can be either a team or a person
 */
public abstract class Participant implements Dumpable
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
