package Entities;

/**
 * Created by Xavier on 11.05.16.
 */
public class Team extends Participant
{
    private Person captain;

    public Team(String pseudo, Person captain)
    {
        super.setPseudo(pseudo);
        this.captain = captain;
    }

    public Person getCaptain()
    {
        return captain;
    }

    public void setCaptain(Person captain)
    {
        this.captain = captain;
    }

    @Override
    public String dump() {
        String res = "Equipe: "+getPseudo()+", capitaine: "+getCaptain().dump();
        return res;
    }
}
