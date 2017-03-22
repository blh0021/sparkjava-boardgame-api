import static spark.Spark.*;
import static com.github.blh0021.TicTacToe.*;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BoardGame {
    public static void main(String[] args) {
        String gamePort = System.getenv("GAME_PORT");
        port((gamePort != null ) ? Integer.parseInt(gamePort) : 8080);

        String gameIP = System.getenv("GAME_IP");
        ipAddress((gameIP != null) ? gameIP : "0.0.0.0");

        get("/", (req, res) -> "Board Game API");

        get("/hello", (req, res) -> hello());

        post("/next-move", (req, res) -> {
            ObjectMapper mapper = new ObjectMapper();
            try {
              NextMove nm = mapper.readValue(req.body(), NextMove.class);
              return nextMove(nm.getBoard(), nm.getPiece());
            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        });
    }
}
