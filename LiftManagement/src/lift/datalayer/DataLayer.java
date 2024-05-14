package lift.datalayer;

import java.util.LinkedHashMap;

public class DataLayer {

    private static DataLayer dataLayer;

    public static DataLayer getInstance(){
        if(dataLayer==null){
            dataLayer= new DataLayer();
        }
        return dataLayer;
    }
   
    private LinkedHashMap<String,Integer> lift = new LinkedHashMap<>();

    public LinkedHashMap<String, Integer> getLift() {
        return lift;
    }

    public void setLift(LinkedHashMap<String, Integer> lift) {
        this.lift = lift;
    }
}
