package Entities;

import java.util.ArrayList;

/**
 * Created by Xavier on 11.05.16.
 */
public class Team extends Participant
{
    private Person captain;
    private ArrayList<Person> roster; // Players of the team, without the captain

    public Team(String pseudo, Person captain)
    {
        super.setPseudo(pseudo);
        this.captain = captain;
        roster = new ArrayList<Person>();
    }

    public Person getCaptain()
    {
        return captain;
    }

    public void setCaptain(Person captain)
    {
        this.captain = captain;
    }

    /**
     * Replace the captain by another teammate. The former captain remains in the team
     * @param newCaptain
     */
    public void swapCaptain (Person newCaptain)
    {

    }

    @Override
    public String dump() {
        String res = "Equipe: "+getPseudo()+", capitaine: "+getCaptain().dump();
        return res;
    }
}
