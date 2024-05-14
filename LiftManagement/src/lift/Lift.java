package lift;

import java.util.LinkedHashMap;
import java.util.Scanner;

import lift.managelift.LiftView;

public class Lift {
    static LinkedHashMap<String,Integer> lift = new LinkedHashMap<>();
    public static void main(String[] args) {
        new LiftView().init();
        }    
}
