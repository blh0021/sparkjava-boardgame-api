import static spark.Spark.*;

public class BoardGame {
    public static void main(String[] args) {

        String gamePort = System.getenv("PORT");
        port((gamePort != null ) ? Integer.parseInt(gamePort) : 8080);

        String gameIP = System.getenv("GAME_IP");
        ipAddress((gameIP != null) ? gameIP : "0.0.0.0");

        get("/", (req, res) -> "Board Game API");

        TicTacToeRoutes ticTacToeRoutes = new TicTacToeRoutes();
        ticTacToeRoutes.createRoutes();

    }
}
