
public class TennisGame2 implements TennisGame
{
    public int p1point = 0;
    public int p2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;
    private final String[] scoreLabels = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "Deuce";
        if (p1point == p2point && p1point < 3) {
            score = getScore(p1point) + "-All";
        }
        if ((p1point == 0 || p2point == 0) && p1point != p2point && (p1point < 4 && p2point < 4))
        {
            score = formatScore();
        }

        if (p1point > p2point && p1point < 4 && p2point > 0)
        {
            score = formatScore();
        }
        if (p2point > p1point && p2point < 4 && p1point > 0)
        {
            score = formatScore();
        }
        
        if (p1point >= 3 && p2point >= 3 && p1point != p2point)
        {
            if (p1point > p2point) {
                score = "Advantage " + player1Name;
            } else {
                score = "Advantage " + player2Name;
            }
        }


        if (p1point >= 4 || p2point >= 4)
        {
            if ((p1point - p2point) >= 2) {
                score = "Win for " + player1Name;
            }

            if ((p2point - p1point) >= 2) {
                score = "Win for " + player2Name;
            }
        }
        return score;
    }

    private String formatScore() {
        return getScore(p1point) + "-" + getScore(p2point);
    }

    private String getScore(int point) {
        return scoreLabels[point];
    }

    public void wonPoint(String player) {
        if (player == player1Name)
            p1point++;
        else
            p2point++;
    }
}