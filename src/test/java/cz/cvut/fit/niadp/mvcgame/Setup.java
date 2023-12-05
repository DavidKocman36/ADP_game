package cz.cvut.fit.niadp.mvcgame;

import javafx.application.Platform;

// For the javafx elements to work.
public class Setup {
    private static boolean running;
    public static void setup(){
        Platform.startup(() -> {});
        running = true;
    }
    public static void teardown(){
        Platform.exit();
    }
    public static boolean isRunning(){
        return running;
    }
}