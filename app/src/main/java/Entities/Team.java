package Entities;

import java.util.ArrayList;

/**
 * Created by Xavier on 11.05.16.
 */
public class Team extends Participant
{
    //=========================================== Attributes =======================================
    private Person captain;
    private ArrayList<Person> roster; // Players of the team, without the captain

    //=========================================== Constructors =====================================

    public Team(String pseudo, Person captain)
    {
        super.setPseudo(pseudo);
        this.captain = captain;
        roster = new ArrayList<Person>();
    }

    //=========================================== Methods ==========================================

    /** ............................................................................................
     * Replace the captain by another teammate. The former captain remains in the team
     * @param newCaptain must be one of the team members
     */
    public boolean swapCaptain (Person newCaptain)
    {
        if (roster.contains(newCaptain)) // ok for swap
        {
            roster.add(captain); // put the current captain back into the team
            captain = newCaptain;
            roster.remove(captain); // withdraw the captain from the mass
            return true;
        }
        return false;
    }

    /** ............................................................................................
     * Returns a full description of the team
     * @return
     */
    @Override
    public String dump() {
        String res = "Equipe: "+getPseudo()+"\nCapitaine: "+getCaptain().dump()+"\nJoueurs:";
        int n=0;
        for (Person teammate: roster)
        {
            n++;
            res += ("\n"+ n + ": "+ teammate.dump());
        }
        return res;
    }

    /** ............................................................................................
     * Add a new player to the team
     * @param player
     */
    public void newPlayer(Person player)
    {
        roster.add(player);
    }

    /** ............................................................................................
     * Removes a player from the team. Can't be the captain
     * @param player
     */
    public void removePlayer (Person player)
    {
        if (roster.contains(player))
            roster.remove(player);
    }
    //=========================================== Getter/Setter ====================================

    public Person getCaptain()
    {
        return captain;
    }

    public ArrayList<Person> getRoster()
    {
        return roster;
    }

}
