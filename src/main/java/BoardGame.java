import static spark.Spark.*;
import static com.github.blh0021.TicTacToe.*;

public class BoardGame {
    public static void main(String[] args) {
        String gamePort = System.getenv("GAME_PORT");
        port((gamePort != null ) ? Integer.parseInt(gamePort) : 8080);

        String gameIP = System.getenv("GAME_IP");
        ipAddress((gameIP != null) ? gameIP : "0.0.0.0");

        get("/", (req, res) -> "Board Game API");

        //TicTacToe ttt = new TicTacToe();
        get("/hello", (req, res) -> hello());
    }
}
