package org.firstinspires.ftc.teamcode.v2;

public class TestData {
    public enum State {
        WHAT,
        CRAZY,
        HIGH,
        MED,
        LOW,
        MINIMAL
    }

    private static final State currentState = State.HIGH;

    public static int getStandardRuns(){
        State state = currentState;
        switch (state){
            case MINIMAL:
                return 10;
            case LOW:
                return 1000;
            case MED:
                return 5000;
            case HIGH:
                return 10000;
            case CRAZY:
                return 50000;
            case WHAT:
                return 100000;
        }
        return 1;
    }

    public static int getStandardRuns(TestData.State state){
        switch (state){
            case MINIMAL:
                return 10;
            case LOW:
                return 1000;
            case MED:
                return 10000;
            case HIGH:
                return 100000;
            case CRAZY:
                return 500000;
            case WHAT:
                return 1000000;
        }
        return 1;
    }

}
