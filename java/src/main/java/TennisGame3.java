
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
        if (player1Point < 4 && player2Point < 4 && !(player1Point + player2Point == 6)) {
            return formatScore();
        } else if (player1Point != player2Point) {
            return formatAdvantageWinScore();
        }
        else {
            return "Deuce";
        }
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            this.player1Point += 1;
        else
            this.player2Point += 1;
    }

    private String formatAdvantageWinScore() {
        String player = player1Point > player2Point ? player1Name : player2Name;
        String prefix = Math.abs(player1Point - player2Point) == 1 ? "Advantage " : "Win for ";
        return prefix + player;
    }

    private String formatScore() {
        String[] scoreLabel = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        String player1 = scoreLabel[player1Point];
        String player2 = (player1Point == player2Point) ? "All" : scoreLabel[player2Point];
        return player1 + "-" + player2;
    }
}
