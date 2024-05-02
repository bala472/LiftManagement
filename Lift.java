import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Lift {
    static LinkedHashMap<String,Integer> lift = new LinkedHashMap<>();
    public static void main(String[] args) {
        lift.put("L1",0);
        lift.put("L2",0);
        lift.put("L3",0);
        lift.put("L4",0);
        lift.put("L5",0);
        Lift lifts = new Lift();
        lifts.printStatus();
        }
        int scannerFlag = 0;
        public void init(){
            try {
                scannerFlag = 0;
                Scanner in = new Scanner(System.in);
                System.out.println("Enter Current floor - Desitination floor [example(0 2)] , Enter -1 for maintainance and Enter -2 for remove maintainance : ");
                int currentFloor = in.nextInt();
                if (currentFloor == -1) {
                    System.out.println("Enter lift number (eg L1)");
                    if (scannerFlag == 0) {
                        in.nextLine();
                        scannerFlag = 1;
                    }
                    String s = in.nextLine();
                    if (lift.keySet().contains(s)) {
                        lift.put(s, 1000);
                        System.out.println("Lift under maintainace !!!");
                        printStatus();
                    } else {
                        System.out.println("lift not found");
                        printStatus();
                    }
                }
                if (currentFloor == -2) {
                    System.out.println("Enter remove maintanence status");
                    if (scannerFlag == 0) {
                        in.nextLine();
                        scannerFlag = 1;
                    }
                    String r = in.nextLine();
                    if (lift.keySet().contains(r)) {
                        if (lift.get(r) == 1000) {
                            lift.put(r, 0);
                            System.out.println("Maintaince completed !!!");
                            printStatus();
                        } else {
                            System.out.println("Lift not under maintainance");
                            printStatus();
                        }
                    } else {
                        System.out.println("Lift not found");
                        printStatus();
                    }
                }
                int destination = in.nextInt();
                boolean flag = true;
                if (currentFloor >= 0 && destination <= 5) {
                    int lift1 = Math.abs(lift.get("L1") - currentFloor);
                    int lift2 = Math.abs(lift.get("L2") - currentFloor);
                    int allLift = Math.abs(lift.get("L5") - currentFloor);
                    if (allLift < lift1 && allLift < lift2) {
                        flag = true;
                    } else if (lift1 == lift2) {
                        if (lift1 >= currentFloor) {
                            lift.put("L1", destination);
                            flag = false;
                        } else {
                            lift.put("L2", destination);
                            flag = false;
                        }
                    } else if (lift1 < lift2) {
                        lift.put("L1", destination);
                        flag = false;
                    } else {
                        lift.put("L2", destination);
                        flag = false;
                    }
                } else if (currentFloor >= 6 || currentFloor == 0) {
                    if (destination >= 6 || destination == 0) {
                        if (destination <= 10) {
                            int lift3 = Math.abs(lift.get("L3") - currentFloor);
                            int lift4 = Math.abs(lift.get("L4") - currentFloor);
                            int allLift = Math.abs(lift.get("L5") - currentFloor);
                            if (allLift < lift3 && allLift < lift4) {
                                flag = true;
                            } else if (lift3 == lift4) {
                                if (lift3 >= currentFloor) {
                                    lift.put("L3", destination);
                                    flag = false;
                                } else {
                                    lift.put("L4", destination);
                                    flag = false;
                                }
                            } else if (lift3 < lift4) {
                                lift.put("L3", destination);
                                flag = false;
                            } else {
                                lift.put("L4", destination);
                                flag = false;
                            }
                        }
                    }
                }
                if (flag) {
                    if ((currentFloor >= 0 && currentFloor <= 5 && destination >= 6 && destination <= 10) || (currentFloor >= 6 && currentFloor <= 10 && destination <= 5 && destination >= 0)) {
                        lift.put("L5", destination);
                    }

                }
                printStatus();
            }catch (Exception e){
                System.out.println("Input must be number ");
                init();
            }
        }
        public void printStatus(){
            System.out.print("Lift : ");
            for(String s : lift.keySet()){
                System.out.print(s +" ");
            }
            System.out.println();
            System.out.print("Floor : ");
            for(int k : lift.values()){
                if(k==1000){
                    System.out.print(-1+" ");
                }else{
                    System.out.print(k+" ");
                }
            }
            System.out.println();
            init();
        }
}
