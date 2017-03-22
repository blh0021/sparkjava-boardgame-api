let request = require('request');
let url = "http://boardgame-api.herokuapp.com/tictactoe/next-move"

function alternate(p) {
    if (p == "x") {
        return "o"
    } else {
        return "x";
    }
}

function printBoard(b) {
    console.log(b.slice(0, 3));
    console.log(b.slice(3, 6));
    console.log(b.slice(6, 9));
    console.log();
}

function winner(b) {
    return b[0] == b[1] && b[0] == b[2] && b[0] != "*" ||
        b[3] == b[4] && b[3] == b[5] && b[3] != "*" ||
        b[6] == b[7] && b[6] == b[8] && b[6] != "*" ||
        b[0] == b[3] && b[0] == b[6] && b[0] != "*" ||
        b[1] == b[4] && b[1] == b[7] && b[1] != "*" ||
        b[2] == b[5] && b[2] == b[8] && b[2] != "*" ||
        b[0] == b[4] && b[0] == b[8] && b[0] != "*" ||
        b[2] == b[4] && b[2] == b[6] && b[2] != "*"
}

function play(data) {
    request({
        url: url,
        method: "POST",
        json: data
    }, (e, r, b) => {
        printBoard(b);
        data.board = b;
        data.piece = alternate(data.piece);
        if (winner(b)) {
            Console.log("Winner");
            return;
        }
        if (b.includes("*")) {
            play(data);
        }
    });
}

let data = {
    board: "*********",
    piece: "x"
}

play(data);
