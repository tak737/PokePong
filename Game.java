import java.awt.event.KeyEvent;

public class Game {

    public static void main(String[] args) {
        // creation of symbol table that keeps track of player lives
        ST<Double, String> playersLives = Scoring.createGame(4);
        // creating symbol table targets and putting .png files as values
        ST<Double, String> targets = new ST<Double, String>();
        targets.put(1.1, "abra.png");
        targets.put(1.2, "gastly.png");
        targets.put(1.3, "duskull.png");
        targets.put(2.1, "staryu.png");
        targets.put(2.2, "psyduck.png");
        targets.put(2.3, "marill.png");
        targets.put(3.1, "pidgey.png");
        targets.put(3.2, "rattata.png");
        targets.put(3.3, "zubat.png");
        targets.put(4.1, "bellsprout.png");
        targets.put(4.2, "chikorita.png");
        targets.put(4.3, "exeggcute.png");
        targets.put(5.0, "0.0");
        // initial coordinates for pokeball and paddles
        double px = 0.0;
        double py = 0.0;
        double p1x = 0.0;
        double P1_Y = -5.0;
        double P2_X = 5.0;
        double p2y = 0.0;
        double p3x = 0.0;
        double P3_Y = 5.0;
        double P4_X = -5.0;
        double p4y = 0.0;
        // pokeball movement and calculation of distances from objects were
        // informed by BouncingBallDeluxe.java (https://edstem.org/us/courses/
        // 18194/lessons/29233/slides/167347)
        // setting ball velocity (random at the beginning of each match, points
        // generally to one of the corners of the map)
        double vx = Scoring.randomize();
        double vy = Scoring.randomize();
        // variable for the radius of the ball
        double BALL_RADIUS = 0.4;
        // creating bounds for board, also influenced by BouncingBallDeluxe.java
        StdDraw.setCanvasSize(700, 700);
        StdDraw.setXscale(-7.0, 7.0);
        StdDraw.setYscale(-7.0, 7.0);
        StdDraw.enableDoubleBuffering();
        // animation loop
        while (playersLives.size() > 2) {
            // ratio of velocity vectors
            double ratio = Math.abs(vy / vx);
            // changing position of paddles based on keys pressed, informed
            // by https://introcs.cs.princeton.edu/java/15inout/MouseFollower.java.html
            // received help on this from Tara Shankar
            if (StdDraw.isKeyPressed(KeyEvent.VK_Z)) {
                if (playersLives.contains(1.0)) {
                    p1x = p1x - 0.3;
                    if (p1x < -7) {
                        p1x = 7;
                    }
                }
            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_C)) {
                if (playersLives.contains(1.0)) {
                    p1x = p1x + 0.3;
                    if (p1x > 7) {
                        p1x = -7;
                    }
                }
            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_M)) {
                if (playersLives.contains(2.0)) {
                    p2y = p2y - 0.3;
                    if (p2y < -7) {
                        p2y = 7;
                    }
                }
            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_PERIOD)) {
                if (playersLives.contains(2.0)) {
                    p2y = p2y + 0.3;
                    if (p2y > 7) {
                        p2y = -7;
                    }
                }
            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_SEMICOLON)) {
                if (playersLives.contains(3.0)) {
                    p3x = p3x - 0.3;
                    if (p3x < -7) {
                        p3x = 7;
                    }
                }
            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_MINUS)) {
                if (playersLives.contains(3.0)) {
                    p3x = p3x + 0.2;
                    if (p3x > 7) {
                        p3x = -7;
                    }
                }
            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_2)) {
                if (playersLives.contains(4.0)) {
                    p4y = p4y + 0.3;
                    if (p4y > 7) {
                        p4y = -7;
                    }
                }
            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
                if (playersLives.contains(4.0)) {
                    p4y = p4y - 0.3;
                    if (p4y < -7) {
                        p4y = 7;
                    }
                }
            }
            // pokeball hitting sections of goals
            ST<Integer, ST<Double, String>> gameState = Scoring.catchPokemon(
                    px, py, playersLives, targets);
            playersLives = gameState.get(1);
            targets = gameState.get(2);
            
            // pokeball bouncing off of walls, informed by BouncingBallDeluxe.java
            if (Math.abs(px + vx) + BALL_RADIUS > 7) {
                vx = -vx;
            }
            if (Math.abs(py + vy) + BALL_RADIUS > 7) {
                vy = -vy;
            }
            // pokeball bouncing off of paddles, bouncing based on
            // BouncingBallDeluxe.java
            // bouncing off of player 1 paddle (bottom)
            if (py + vy - BALL_RADIUS < -5 && py > -5 && px < p1x + 1.4 &&
                    px > p1x - 1.4) {
                vy = -vy;
            }
            // bouncing off of player 2 paddle (right)
            if (px + vx + BALL_RADIUS > 5 && px < 5 && py < p2y + 1.4 &&
                    py > p2y - 1.4) {
                vx = -vx;
            }
            // bouncing off of player 3 paddle (top)
            if (py + vy + BALL_RADIUS > 5 && py < 5 && px < p3x + 1.4 &&
                    px > p3x - 1.4) {
                vy = -vy;
            }
            // bouncing off of player 4 paddle (left)
            if (px + vx - BALL_RADIUS < -5 && px > -5 && py < p4y + 1.4 &&
                    py > p4y - 1.4) {
                vx = -vx;
            }
            // pokeball interacting with obstacles: snorlax.png, dratini.png,
            // and ditto.png
            // snorlax.png: slowing down
            double[] velocitiesSlow = Scoring.slowDown(px, py, vx, vy, ratio);
            vx = velocitiesSlow[0];
            vy = velocitiesSlow[1];
            // dratini.png: speeding up
            double[] velocitiesSpeed = Scoring.speedUp(px, py, vx, vy, ratio);
            vx = velocitiesSpeed[0];
            vy = velocitiesSpeed[1];
            // ditto.png: randomly change direction and speed
            double[] velocitiesFling = Scoring.fling(px, py, vx, vy);
            vx = velocitiesFling[0];
            vy = velocitiesFling[1];
            // cap on velocity
            while (Math.sqrt(vx * vx + vy * vy) > 0.4) {
                vx = vx / 1.1;
                vy = vy / 1.1;
            }
            // floor on velocity
            while (Math.sqrt(vx * vx + vy * vy) < 0.075) {
                vx = vx * 1.1;
                vy = vy * 1.1;
            }
            // position update for ball
            if (Double.parseDouble(targets.get(5.0)) == 1.0) {
                // returns ball to center if one of the targets has been removed
                // (if a pokemon has been caught)
                px = 0.0;
                py = 0.0;
            }
            px = px + vx;
            py = py + vy;
            StdDraw.clear(StdDraw.BLACK);
            for (double target : targets.keys()) {
                Scoring.drawTarget(targets, target);
            }
            StdDraw.picture(px, py, "pokeball.png");
            StdDraw.picture(p1x, P1_Y, "paddleHorizontal.png");
            StdDraw.picture(P2_X, p2y, "paddleVertical.png");
            StdDraw.picture(p3x, P3_Y, "paddleHorizontal.png");
            StdDraw.picture(P4_X, p4y, "paddleVertical.png");
            StdDraw.picture(0.0, 2.0, "snorlax.png");
            StdDraw.picture(-2.0, -2.0, "dratini.png");
            StdDraw.picture(2.0, -2.0, "ditto.png");
            StdDraw.show();
            StdDraw.pause(20);
        }

        Scoring.endScreen(playersLives);
    }
}
