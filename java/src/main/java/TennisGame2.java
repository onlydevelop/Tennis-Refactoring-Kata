
public class TennisGame2 implements TennisGame
{
    public int p1point = 0;
    public int p2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (p1point == p2point && p1point < 4)
        {
            score = getScore(p1point);
            score += "-All";
        }
        if (p1point == p2point && p1point >=3)
            score = "Deuce";
        
        if (p1point > 0 && p2point ==0)
        {
            if (p1point ==1)
                P1res = "Fifteen";
            if (p1point ==2)
                P1res = "Thirty";
            if (p1point ==3)
                P1res = "Forty";
            
            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (p2point > 0 && p1point ==0)
        {
            if (p2point ==1)
                P2res = "Fifteen";
            if (p2point ==2)
                P2res = "Thirty";
            if (p2point ==3)
                P2res = "Forty";
            
            P1res = "Love";
            score = P1res + "-" + P2res;
        }
        
        if (p1point > p2point && p1point < 4)
        {
            if (p1point ==2)
                P1res="Thirty";
            if (p1point ==3)
                P1res="Forty";
            if (p2point ==1)
                P2res="Fifteen";
            if (p2point ==2)
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
        if (p2point > p1point && p2point < 4)
        {
            if (p2point ==2)
                P2res="Thirty";
            if (p2point ==3)
                P2res="Forty";
            if (p1point ==1)
                P1res="Fifteen";
            if (p1point ==2)
                P1res="Thirty";
            score = P1res + "-" + P2res;
        }
        
        if (p1point > p2point && p2point >= 3)
        {
            score = "Advantage " + player1Name;
        }
        
        if (p2point > p1point && p1point >= 3)
        {
            score = "Advantage " + player2Name;
        }
        
        if (p1point >=4 && p2point >=0 && (p1point - p2point)>=2)
        {
            score = "Win for " + player1Name;
        }
        if (p2point >=4 && p1point >=0 && (p2point - p1point)>=2)
        {
            score = "Win for " + player2Name;
        }
        return score;
    }

    private String getScore(int point) {
        String score = "";
        if (point == 0)
            score = "Love";
        if (point == 1)
            score = "Fifteen";
        if (point == 2)
            score = "Thirty";
        return score;
    }

    public void wonPoint(String player) {
        if (player == player1Name)
            p1point++;
        else
            p2point++;
    }
}