package lift.managelift;

import lift.datalayer.DataLayer;

public class LiftModel {

    private LiftView liftView;

    public LiftModel(LiftView liftView){
        this.liftView = new LiftView();
    }
    public void setup(){
        DataLayer.getInstance().getLift().put("L1",0);
        DataLayer.getInstance().getLift().put("L2",0);
        DataLayer.getInstance().getLift().put("L3",0);
        DataLayer.getInstance().getLift().put("L4",0);
        DataLayer.getInstance().getLift().put("L5",0);
        liftView.printStatus(DataLayer.getInstance().getLift());
    }
}
