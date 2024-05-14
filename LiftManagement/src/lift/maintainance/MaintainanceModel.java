package lift.maintainance;

import lift.datalayer.DataLayer;

public class MaintainanceModel {
    private MaintainanceView maintainanceView;
    public MaintainanceModel(MaintainanceView maintainanceView){
        this.maintainanceView=maintainanceView;
    }

    public String setMaintainance(String s){
        if (DataLayer.getInstance().getLift().keySet().contains(s)) {
            DataLayer.getInstance().getLift().put(s, Integer.MAX_VALUE);
            return "Lift under maintenance !!!";
        } else {
            return "lift not found";
        }
    }

    public String removeMaintainance(String r){
        if (DataLayer.getInstance().getLift().keySet().contains(r)) {
            if (DataLayer.getInstance().getLift().get(r) == Integer.MAX_VALUE) {
                DataLayer.getInstance().getLift().put(r, 0);
              return  "Maintenance completed !!!";
            } else {
                return "Lift not under maintenance";
            }
        } else {
            return "Lift not found";
        }
    }

}
