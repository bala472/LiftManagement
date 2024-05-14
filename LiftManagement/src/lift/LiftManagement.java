package lift;

import java.util.LinkedHashMap;

import lift.managelift.LiftView;

public class LiftManagement {
    static LinkedHashMap<String,Integer> lift = new LinkedHashMap<>();
    public static void main(String[] args) {
        new LiftView().init();
        }    
}
