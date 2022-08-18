public class Scoring {

    // creates a symbol table with n players (up to 4)
    public static ST<Double, String> createGame(int n) {
        ST<Double, String> lobby = new ST<Double, String>();
        if (n > 1 && n < 5) {
            for (int j = 1; j < n + 1; j = j + 1) {
                lobby.put((double) j, "3");
            }
        }
        return lobby;
    }

    // generates a random double between
    // -0.075 and -0.15 or 0.15 and 0.075
    public static double randomize() {
        // k is the output variable
        double k = 0.0;
        // side is either 0 or 1, randomly chosen
        int side = StdRandom.uniform(0, 2);
        // 0 means negative value, 1, means positive value
        if (side == 0) {
            k = StdRandom.uniform(-0.15, -0.075);
        }
        else if (side == 1) {
            k = StdRandom.uniform(0.075, 0.15);
        }
        return k;
    }

    //
    public static ST<Integer, ST<Double, String>> catchPokemon(double a, double b,
                                                               ST<Double, String> j,
                                                               ST<Double, String> k) {
        // making symbol table with two symbols tables: one with the symbol table
        // keeping track of people's lives, and one symbol table keeping track
        // of the remaining .png files
        ST<Integer, ST<Double, String>> state =
                new ST<Integer, ST<Double, String>>();
        state.put(1, j);
        state.put(2, k);
        j.put(5.0, "0.0");
        // checking if each remaining pokemon has been 'caught' by the pokeball
        // being in the .png file's hitbox. if a pokemon has been caught, the
        // player whose pokemon got caught loses one life in symbol table j,
        // and the key for the .png file for that pokemon is removed from
        // symbol table k. the value at 5.0 in j is also changed "1".
        // if the player has no more .png files, they are removed from
        // symbol table j. influenced by https://introcs.cs.princeton.edu/java/12types/
        if (a < -1.5 && a > -2.5 && b < -5.5 && b > -6.5) { // player 1
            if (k.contains(1.1)) {
                double newLives = Double.parseDouble(j.get(1.0)) - 1.0;
                j.put(1.0, "" + newLives);
                j.put(5.0, "1.0");
                k.remove(1.1);
            }
        }
        if (a < 0.5 && a > -0.5 && b < -5.5 && b > -6.5) { // player 1
            if (k.contains(1.2)) {
                double newLives = Double.parseDouble(j.get(1.0)) - 1.0;
                j.put(1.0, "" + newLives);
                j.put(5.0, "1.0");
                k.remove(1.2);
            }
        }
        if (a < 2.5 && a > 1.5 && b < -5.5 && b > -6.5) { // player 1
            if (k.contains(1.3)) {
                double newLives = Double.parseDouble(j.get(1.0)) - 1.0;
                j.put(1.0, "" + newLives);
                j.put(5.0, "1.0");
                k.remove(1.3);
            }
        }
        // removal of player 1 if all player 1 pokemon are gone
        if (!k.contains(1.1) && !k.contains(1.2) && !k.contains(1.3)) {
            if (j.contains(1.0)) {
                j.remove(1.0);
            }
        }
        if (a < 6.5 && a > 5.5 && b < -1.5 && b > -2.5) { // player 2
            if (k.contains(2.1)) {
                double newLives = Double.parseDouble(j.get(2.0)) - 1.0;
                j.put(2.0, "" + newLives);
                j.put(5.0, "1.0");
                k.remove(2.1);
            }
        }
        if (a < 6.5 && a > 5.5 && b < 0.5 && b > -0.5) { // player 2
            if (k.contains(2.2)) {
                double newLives = Double.parseDouble(j.get(2.0)) - 1.0;
                j.put(2.0, "" + newLives);
                j.put(5.0, "1.0");
                k.remove(2.2);
            }
        }
        if (a < 6.5 && a > 5.5 && b < 2.5 && b > 1.5) { // player 2
            if (k.contains(2.3)) {
                double newLives = Double.parseDouble(j.get(2.0)) - 1.0;
                j.put(2.0, "" + newLives);
                j.put(5.0, "1.0");
                k.remove(2.3);
            }
        }
        // removal of player 2 if all player 2 pokemon are gone
        if (!k.contains(2.1) && !k.contains(2.2) && !k.contains(2.3)) {
            if (j.contains(2.0)) {
                j.remove(2.0);
            }
        }
        if (a < 2.5 && a > 1.5 && b > 5.5 && b < 6.5) { // player 3
            if (k.contains(3.1)) {
                double newLives = Double.parseDouble(j.get(3.0)) - 1.0;
                j.put(3.0, "" + newLives);
                j.put(5.0, "1.0");
                k.remove(3.1);
            }
        }
        if (a < 0.5 && a > -0.5 && b > 5.5 && b < 6.5) { // player 3
            if (k.contains(3.2)) {
                double newLives = Double.parseDouble(j.get(3.0)) - 1.0;
                j.put(3.0, "" + newLives);
                j.put(5.0, "1.0");
                k.remove(3.2);
            }
        }
        if (a < -1.5 && a > -2.5 && b > 5.5 && b < 6.5) { // player 3
            if (k.contains(3.3)) {
                double newLives = Double.parseDouble(j.get(3.0)) - 1.0;
                j.put(3.0, "" + newLives);
                j.put(5.0, "1.0");
                k.remove(3.3);
            }
        }
        // removal of player 3 if all player 3 pokemon are gone
        if (!k.contains(3.1) && !k.contains(3.2) && !k.contains(3.3)) {
            if (j.contains(3.0)) {
                j.remove(3.0);
            }
        }
        if (a > -6.5 && a < -5.5 && b < 2.5 && b > 1.5) { // player 4
            if (k.contains(4.1)) {
                double newLives = Double.parseDouble(j.get(4.0)) - 1.0;
                j.put(4.0, "" + newLives);
                j.put(5.0, "1.0");
                k.remove(4.1);
            }
        }
        if (a > -6.5 && a < -5.5 && b < 0.5 && b > -0.5) { // player 4
            if (k.contains(4.2)) {
                double newLives = Double.parseDouble(j.get(4.0)) - 1.0;
                j.put(4.0, "" + newLives);
                j.put(5.0, "1.0");
                k.remove(4.2);
            }
        }
        if (a > -6.5 && a < -5.5 && b < -1.5 && b > -2.5) { // player 4
            if (k.contains(4.3)) {
                double newLives = Double.parseDouble(j.get(4.0)) - 1.0;
                j.put(4.0, "" + newLives);
                j.put(5.0, "1.0");
                k.remove(4.3);
            }
        }
        // removal of player 4 if all player 4 pokemon are gone
        if (!k.contains(4.1) && !k.contains(4.2) && !k.contains(4.3)) {
            if (j.contains(4.0)) {
                j.remove(4.0);
            }
        }
        return state;
    }

    // takes five doubles, representing position coordinates, velocity vectors,
    // and the magnitude of the ratio between the velocity vectors and
    // creates an array with new velocity vectors (with the ratio r)
    // if the coordinates exist within a certain space on the coordinate plane.
    public static double[] slowDown(double a, double b, double x, double y,
                                    double r) {
        // array for the
        double[] vectors = new double[2];
        if (a < 0.75 && a > -0.75 && b < 2.75 && b > 1.25) {
            if (x < 0.0) {
                x = -0.09;
            }
            else {
                x = 0.09;
            }
            if (y < 0.0) {
                y = -1.0 * r * 0.09;
            }
            else {
                y = r * 0.09;
            }
        }
        vectors[0] = x;
        vectors[1] = y;
        return vectors;
    }

    // if (a, b) is within the range of coordinates, uses five doubles
    // (same types of doubles from slowDown()), increases the vectors by
    // a random, proportional amount, and puts the new velocity
    // values in an array
    public static double[] speedUp(double a, double b, double x, double y,
                                   double r) {
        double[] vectors = new double[2];
        if (a < -1.25 && a > -2.75 && b < -1.25 && b > -2.75) {
            if (x < 0.0) {
                x = x - StdRandom.uniform(0.075, 0.1);
            }
            else {
                x = x + StdRandom.uniform(0.075, 0.1);
            }
            if (y < 0.0) {
                y = y - r * StdRandom.uniform(0.075, 0.1);
            }
            else {
                y = y + r * StdRandom.uniform(0.075, 0.1);
            }
        }
        vectors[0] = x;
        vectors[1] = y;
        return vectors;
    }

    // within a set of coordinates, randomly adds a double to doubles x and y,
    // returning an array with the values of x and y
    public static double[] fling(double a, double b, double x, double y) {
        double[] vectors = new double[2];
        if (a < 2.75 && a > 1.25 && b < -1.25 && b > -2.75) {
            x = x + StdRandom.uniform(-0.1, 0.1);
            y = y + StdRandom.uniform(-0.1, 0.1);
        }
        vectors[0] = x;
        vectors[1] = y;
        return vectors;
    }

    // gives the lives of a player in a game
    public static String lives(ST<Double, String> players, double player) {
        return players.get(player);
    }

    // uses available keys and values in the symbol table of .png files
    // to use StdDraw.picture()
    public static void drawTarget(ST<Double, String> list, double t) {
        if (t == 1.1) {
            String pokemon = list.get(t);
            StdDraw.picture(-2.0, -6.0, pokemon);
        }
        else if (t == 1.2) {
            String pokemon = list.get(t);
            StdDraw.picture(0.0, -6.0, pokemon);
        }
        else if (t == 1.3) {
            String pokemon = list.get(t);
            StdDraw.picture(2.0, -6.0, pokemon);
        }
        else if (t == 2.1) {
            String pokemon = list.get(t);
            StdDraw.picture(6.0, -2.0, pokemon);
        }
        else if (t == 2.2) {
            String pokemon = list.get(t);
            StdDraw.picture(6.0, 0.0, pokemon);
        }
        else if (t == 2.3) {
            String pokemon = list.get(t);
            StdDraw.picture(6.0, 2.0, pokemon);
        }
        else if (t == 3.1) {
            String pokemon = list.get(t);
            StdDraw.picture(2.0, 6.0, pokemon);
        }
        else if (t == 3.2) {
            String pokemon = list.get(t);
            StdDraw.picture(0.0, 6.0, pokemon);
        }
        else if (t == 3.3) {
            String pokemon = list.get(t);
            StdDraw.picture(-2.0, 6.0, pokemon);
        }
        else if (t == 4.1) {
            String pokemon = list.get(t);
            StdDraw.picture(-6.0, 2.0, pokemon);
        }
        else if (t == 4.2) {
            String pokemon = list.get(t);
            StdDraw.picture(-6.0, 0.0, pokemon);
        }
        else if (t == 4.3) {
            String pokemon = list.get(t);
            StdDraw.picture(-6.0, -2.0, pokemon);
        }
    }

    // clears the screen and adds a String saying who won
    public static void endScreen(ST<Double, String> winner) {
        StdDraw.clear(StdDraw.WHITE);
        if (winner.contains(1.0)) {
            StdDraw.text(0, 0, "Player 1 wins!");
        }
        if (winner.contains(2.0)) {
            StdDraw.text(0, 0, "Player 2 wins!");
        }
        if (winner.contains(3.0)) {
            StdDraw.text(0, 0, "Player 3 wins!");
        }
        if (winner.contains(4.0)) {
            StdDraw.text(0, 0, "Player 4 wins!");
        }
        StdDraw.show();
    }

    public static void main(String[] args) {
        // testing the randomize() method - the doubles should be random
        // every time Scoring.java is run
        double test1 = randomize();
        System.out.println("test1's value is " + test1);
        double test2 = randomize();
        System.out.println("test2's value is " + test2);

        // testing the drawTarget() method - there should be a standard Draw
        // with three different pokemon drawn
        // setting scale to fit drawTarget() coordinate requirements
        StdDraw.setXscale(-7.0, 7.0);
        StdDraw.setYscale(-7.0, 7.0);

        // creating two test symbol tables with different keys and values:
        ST<Double, String> test3 = new ST<Double, String>();
        test3.put(1.1, "eevee.png");
        test3.put(3.1, "squirtle.png");
        // testing with drawTarget
        drawTarget(test3, 1.1);
        drawTarget(test3, 3.1);

        ST<Double, String> test4 = new ST<Double, String>();
        test4.put(2.2, "voltorb.png");
        test4.put(5.5, "voltorb.png");
        // testing with drawTarget
        drawTarget(test4, 2.2);
        drawTarget(test4, 5.5);


    }
}
