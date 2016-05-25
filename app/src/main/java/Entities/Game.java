package Entities;

/**
 * Created by Xavier on 17.05.16.
 */
public class Game implements TextUI
{
    //=========================================== Attributes ==================================

    private Participant contender1;
    private Participant contender2;
    private Integer score1;
    private Integer score2;

    //=========================================== Constructors ==================================

    /**
     * Constructor. Sets the contenders to null if parameters are of different types
     * @param contender1
     * @param contender2
     */
    public Game(Participant contender1, Participant contender2)
    {
        this.contender1=contender1;
        this.contender2=contender2;
    }

    //=========================================== Methods ==================================

    /**
     * Returns the winner of the game or null if it was a tie
     * @return a Participant object
     */
    public Participant winner()
    {
        if (score1 > score2)
            return contender1;
        else
            if (score2 > score1)
                return contender2;
            else
                return null;
    }

    /**
     * Textual representation of a game
     * @return
     */
    public String dump()
    {
        String res = contender1.getPseudo()+" - "+contender2.getPseudo()+": "+score1+"-"+score2;
        return res;
    }

    //=========================================== Getter / Setters =================================

    /**
     * Sets the score of the game, both teams simultaneaously
     * @param score1 Score of contender 1
     * @param score2 Score of contender 2
     */
    public void setScore (Integer score1, Integer score2)
    {
        this.score1=score1;
        this.score2=score2;
    }
}
