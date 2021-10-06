
public class TennisGame3 implements TennisGame {
    
    private int player1Point;
    private int player2Point;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score;
        if (player1Point < 4 && player2Point < 4 && !(player1Point + player2Point == 6)) {
            String[] scoreLabel = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            String player1 = scoreLabel[player1Point];
            String player2 = (player1Point == player2Point) ? "All" : scoreLabel[player2Point];
            return player1 + "-" + player2;
        } else {
            if (player1Point == player2Point)
                return "Deuce";
            score = player1Point > player2Point ? player1Name : player2Name;
            return ((player1Point - player2Point)*(player1Point - player2Point) == 1) ? "Advantage " + score : "Win for " + score;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            this.player1Point += 1;
        else
            this.player2Point += 1;
        
    }
}
