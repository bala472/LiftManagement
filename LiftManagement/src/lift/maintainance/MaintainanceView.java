package lift.maintainance;

import lift.datalayer.DataLayer;
import lift.managelift.LiftView;

import java.util.Scanner;

public class MaintainanceView {
    private MaintainanceModel maintainanceModel;
    private LiftView liftView;
    public MaintainanceView(LiftView liftView){
        this.maintainanceModel=new MaintainanceModel(this);
        this.liftView=liftView;
    }
    Scanner in = new Scanner(System.in);
    public void underMaintainance(){
        System.out.println("Enter lift number (eg L1)");
       // in.nextLine();
        String s = in.nextLine();
        System.out.println(maintainanceModel.setMaintainance(s));
        liftView.printStatus(DataLayer.getInstance().getLift());
    }

    public void removeMaintainance(){
        System.out.println("Enter remove maintenance status");
       // in.nextLine();
        String r = in.nextLine();
        System.out.println(maintainanceModel.removeMaintainance(r));
        liftView.printStatus(DataLayer.getInstance().getLift());
    }
}
