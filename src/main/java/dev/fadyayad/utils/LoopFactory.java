package dev.fadyayad.utils;

import java.util.function.Function;


public class LoopFactory {
    public static void execute(int times, LoopFunction function){
        for (int i = 0; i < times; i++) {
            function.execute();
        }
    }
}
