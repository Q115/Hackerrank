/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/botcleanv2
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
#include < iostream > 
#include < vector >
using namespace std;

/* Head ends here */
void next_move(int posx, int posy, vector < string > board) {
    if (board[posx][posy] == 'd') {
        cout << "CLEAN";
        return;
    }
    if (posx == board.size() - 1 && posy == board[0].length() - 1)
        return;

    if (posx % 2 == 0) {
        if (posy != board[posx].length() - 1) {
            cout << "RIGHT";
        } else
            cout << "DOWN";
    } else {
        if (posy != 0) {
            cout << "LEFT";
        } else
            cout << "DOWN";
    }
}

/* Tail starts here */
int main() {
    int pos[2];
    vector < string > board;
    cin >> pos[0] >> pos[1];
    for (int i = 0; i < 5; i++) {
        string s;
        cin >> s;
        board.push_back(s);
    }
    next_move(pos[0], pos[1], board);
    return 0;
}