package Entities;

/**
 * Created by Xavier on 17.05.16.
 */
public class Game
{
    //=========================================== Attributes ==================================

    private Participant contender1;
    private Participant contender2;
    private Integer score1;
    private Integer score2;

    //=========================================== Constructors ==================================

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
    //=========================================== Getter / Setters =================================

    /**
     * Sets the score of the game, both teams simultaneaously
     * @param sp1 Score of contender 1
     * @param sp2 Score of contender 2
     */
    public void setScore (Integer score1, Integer score2)
    {
        this.score1=score1;
        this.score2=score2;
    }
}
