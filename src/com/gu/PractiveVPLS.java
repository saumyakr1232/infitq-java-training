package com.gu;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

enum Hand {
    ROCK('R', 'S'),
    PAPER('P', 'R'),
    SCISSOR('S', 'P'),
    JOKER('*', '*'),
    EMPTY('Z', 'Z'); // Used as Round finisher and NullObject

    private final char defeats;
    private final char id;

    Hand(char id, char defeats) {
        this.id = id;
        this.defeats = defeats;
    }

    public static Hand from(char id) {
        for (Hand hand : Hand.values()) {
            if (hand.getId() == id) {
                return hand;
            }
        }
        return EMPTY;
    }

    public Hand isDefeatedBy() {
        for (Hand hand : Hand.values()) {
            if (id == hand.defeats) {
                return hand;
            }
        }
        return EMPTY;
    }

    public boolean isARoundFinisher() {
        return this == Hand.EMPTY;
    }

    public char getDefeats() {
        return defeats;
    }

    public char getId() {
        return id;
    }

    public boolean defeats(Hand otherHand) {
        return Objects.equals(defeats, otherHand.getId()) || (id == '*');
    }
}

enum WinningPlayer {
    FIRST_WON(1),
    SECOND_WON(2),
    TIE(0);

    private final int winningPosition;

    WinningPlayer(int winningPosition) {
        this.winningPosition = winningPosition;
    }

    public int getWinningPosition() {
        return winningPosition;
    }
}
class InputParser {

    static String addJokerToFormation(int n, int a, String formations) {
        return formations.substring(0, a) + "*" + formations.substring(a, n - 1);
    }

    static Queue<Hand> parseToHand(String players) {
        Queue<Hand> tournamentPlayers = new LinkedList<>();
        for (char hand : players.toCharArray()) {
            tournamentPlayers.add(Hand.from(hand));
        }
        // This EMPTY help to distinguish where a round finish
        tournamentPlayers.add(Hand.EMPTY);
        return tournamentPlayers;
    }
}

class Judge {

    static GameResult play(Hand firstPlayer, Hand secondPlayer) {
        if (firstPlayer == secondPlayer) {
            return new GameResult(WinningPlayer.TIE, firstPlayer, secondPlayer);
        }
        return firstPlayer.defeats(secondPlayer) ?
                new GameResult(WinningPlayer.FIRST_WON, firstPlayer, secondPlayer) :
                new GameResult(WinningPlayer.SECOND_WON, secondPlayer, firstPlayer);
    }

}
class GameResult {
    private WinningPlayer winningPlayer;
    private Hand winnerHand;
    private Hand loserHand;

    GameResult(WinningPlayer winningPlayer, Hand winnerHand, Hand loserHand) {
        this.winningPlayer = winningPlayer;
        this.winnerHand = winnerHand;
        this.loserHand = loserHand;
    }

    public WinningPlayer getWinningPlayer() {
        return winningPlayer;
    }

    Hand getWinnerHand() {
        return winnerHand;
    }

    Hand getLoserHand() {
        return loserHand;
    }

    Hand loserHandIsDefeatedBy() {
        return loserHand.isDefeatedBy();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return winningPlayer == that.winningPlayer &&
                winnerHand == that.winnerHand &&
                loserHand == that.loserHand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningPlayer, winnerHand, loserHand);
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "winningPlayer=" + winningPlayer +
                ", winnerHand=" + winnerHand +
                ", loserHand=" + loserHand +
                '}';
    }
}


class Simulator {

    private Hand lastHand;

    Simulator() {
        this.lastHand = Hand.JOKER;
    }

    int play(Queue<Hand> tournamentPlayers) {

        int totalPoiChanges = -1;

        while (tournamentPlayers.size() != 2 || tournamentPlayers.peek() != Hand.JOKER) {
            Hand player1 = getNextPlayer(tournamentPlayers);

            if (isARoundFinisher(player1)) {
                addRoundFinisher(tournamentPlayers);
                continue;
            }

            Hand player2 = getNextPlayer(tournamentPlayers);

            if (isARoundFinisher(player2)) {
                requeuePlayer(tournamentPlayers, player1);
                addRoundFinisher(tournamentPlayers);
                continue;
            }

            if (!isATie(player1, player2)) {

                GameResult gameResult = Judge.play(player1, player2);
                requeuePlayer(tournamentPlayers, gameResult.getWinnerHand());

                totalPoiChanges = shouldIncrementPOIChanges(player1, player2, gameResult) ? incrementPOIChanges(gameResult, totalPoiChanges) : totalPoiChanges;
            }
        }

        return totalPoiChanges;
    }

    private boolean isARoundFinisher(Hand player) {
        return player.isARoundFinisher();
    }

    private void requeuePlayer(Queue<Hand> tournamentPlayers, Hand player) {
        tournamentPlayers.add(player);
    }

    private Hand getNextPlayer(Queue<Hand> tournamentPlayers) {
        return tournamentPlayers.poll();
    }

    private void addRoundFinisher(Queue<Hand> tournamentPlayers) {
        tournamentPlayers.add(Hand.EMPTY);
    }

    private boolean shouldIncrementPOIChanges(Hand player1, Hand player2, GameResult gameResult) {
        return isAnyPlayerAJoker(player1, player2) && (!lastHand.defeats(gameResult.getLoserHand()) || lastHand == Hand.JOKER);
    }

    private int incrementPOIChanges(GameResult gameResult, int totalPoiChanges) {
        lastHand = gameResult.loserHandIsDefeatedBy();
        return totalPoiChanges + 1;
    }

    private boolean isAnyPlayerAJoker(Hand player1, Hand player2) {
        return player1 == Hand.JOKER || player2 == Hand.JOKER;
    }

    private boolean isATie(Hand player1, Hand player2) {
        return player1 == player2;
    }
}
