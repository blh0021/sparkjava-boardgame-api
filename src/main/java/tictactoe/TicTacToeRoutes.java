import static spark.Spark.*;
import static com.github.blh0021.TicTacToe.*;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TicTacToeRoutes {
    public void createRoutes() {
        get("/tictactoe/hello", (req, res) -> hello());

        post("/tictactoe/next-move", (req, res) -> {
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
