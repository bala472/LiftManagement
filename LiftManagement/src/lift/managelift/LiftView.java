package lift.managelift;

import java.util.LinkedHashMap;
import java.util.Scanner;

import lift.datalayer.DataLayer;
import lift.maintainance.MaintainanceView;

public class LiftView {
    private LiftModel liftModel;
    private MaintainanceView maintainanceView;
    public LiftView() {
        this.liftModel = new LiftModel(this);
        this.maintainanceView=new MaintainanceView(this);
    }

    public void init() {
        liftModel.setup();
    }

    public void printStatus(LinkedHashMap<String, Integer> lift) {
        System.out.print("Lift : ");
        for (String s : lift.keySet()) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.print("Floor : ");
        for (int k : lift.values()) {
            if (k == Integer.MAX_VALUE) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(k + " ");
            }
        }
        System.out.println();
        initApp();
    }

    public void initApp() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Please input the current floor and destination floor in the format: 'Current floor - Destination floor' (e.g., '0 2').\nEnter '-1' to toggle maintenance mode or '-2' to exit maintenance.");
            int currentFloor = in.nextInt();
            if (currentFloor == -1) {
                maintainanceView.underMaintainance();
            }
            if (currentFloor == -2) {
            maintainanceView.removeMaintainance();
            }
            int destination = in.nextInt();
            boolean flag = true;
            if (currentFloor >= 0 && currentFloor <= 5 && destination <= 5 && destination >= 0) {
                int lift1 = Math.abs(DataLayer.getInstance().getLift().get("L1") - currentFloor);
                int lift2 = Math.abs(DataLayer.getInstance().getLift().get("L2") - currentFloor);
                int allLift = Math.abs(DataLayer.getInstance().getLift().get("L5") - currentFloor);
                if (allLift < lift1 && allLift < lift2) {
                    flag = true;
                } else if (lift1 == lift2) {
                    if (lift1 >= currentFloor) {
                        DataLayer.getInstance().getLift().put("L1", destination);
                        flag = false;
                    } else {
                        DataLayer.getInstance().getLift().put("L2", destination);
                        flag = false;
                    }
                } else if (lift1 < lift2) {
                    DataLayer.getInstance().getLift().put("L1", destination);
                    flag = false;
                } else {
                    DataLayer.getInstance().getLift().put("L2", destination);
                    flag = false;
                }
            } else if ((currentFloor >= 6 && currentFloor <= 10) || currentFloor == 0) {
                if ((destination >= 6 && destination <= 10) || destination == 0) {
                    if (destination <= 10) {
                        int lift3 = Math.abs(DataLayer.getInstance().getLift().get("L3") - currentFloor);
                        int lift4 = Math.abs(DataLayer.getInstance().getLift().get("L4") - currentFloor);
                        int allLift = Math.abs(DataLayer.getInstance().getLift().get("L5") - currentFloor);
                        if (allLift < lift3 && allLift < lift4) {
                            flag = true;
                        } else if (lift3 == lift4) {
                            if (lift3 >= currentFloor) {
                                DataLayer.getInstance().getLift().put("L3", destination);
                                flag = false;
                            } else {
                                DataLayer.getInstance().getLift().put("L4", destination);
                                flag = false;
                            }
                        } else if (lift3 < lift4) {
                            DataLayer.getInstance().getLift().put("L3", destination);
                            flag = false;
                        } else {
                            DataLayer.getInstance().getLift().put("L4", destination);
                            flag = false;
                        }
                    }
                }
            }
            if (flag) {
                if ((currentFloor >= 0 && currentFloor <= 10) || (destination >= 0 && destination <= 10)) {
                    DataLayer.getInstance().getLift().put("L5", destination);
                }
            }
            printStatus(DataLayer.getInstance().getLift());
        } catch (Exception e) {
            System.out.println("Input must be number ");
            initApp();
        }
    }

}
