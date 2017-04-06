# TicTacToe

## API

```
<HOSTNAME>/tictactoe/next-move
```

POST Request

```json
{
    "board": "*********",
    "piece": "x"
}
```

Board will contain 9 characters in a row '*', 'x', or 'o'.
Piece will contain either a 'x' or an 'o'
