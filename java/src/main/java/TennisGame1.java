
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private final String player1Name;
    private final String player2Name;
    private final String[] scoreLabel = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == this.player1Name)
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        if (m_score1==m_score2) {
            score = getLeveledScore();
        } else if (m_score1>=4 || m_score2>=4) {
            score = getHighScore();
        } else {
            score = getUnequalScore(score);
        }
        return score;
    }

    private String getUnequalScore(String score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = m_score1;
            else { score +="-"; tempScore = m_score2;}
            switch(tempScore)
            {
                case 0:
                    score +="Love";
                    break;
                case 1:
                    score +="Fifteen";
                    break;
                case 2:
                    score +="Thirty";
                    break;
                case 3:
                    score +="Forty";
                    break;
            }
        }
        return score;
    }

    private String getHighScore() {
        String score;
        String resultPrefix = (Math.abs(m_score1 - m_score2) == 1) ? "Advantage " : "Win for ";
        String selectedPlayer = (m_score1 > m_score2) ? player1Name : player2Name;
        score = resultPrefix + selectedPlayer;
        return score;
    }

    private String getLeveledScore() {
        String score = "Deuce";
        if (m_score1 < 3) {
            score = scoreLabel[m_score1] + "-All";
        }
        return score;
    }
}
