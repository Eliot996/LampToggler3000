public class Lamp {
    // class variables
    private static int lampsMade;

    // attributes
    private boolean isLampOn;
    private int stateChanges;
    private String name;

    // constructor
    public Lamp(String name){
        this.name = name;
        isLampOn = false;
        lampsMade++;
    }

    // functions
    public Lamp(String name, boolean state){
        this.name = name;
        isLampOn = state;
        lampsMade++;
    }

    //toggles isLampOn
    public void pushButton(){
        isLampOn = !isLampOn;
        stateChanges++;
    }

    @Override
    public String toString(){
        if (isLampOn){
            return name + " er tændt";
        }else{
            return name + " er slukket";
        }
    }

    // get functions
    public static int getLampsMade() {
        return lampsMade;
    }

    public int getStateChanges() {
        return stateChanges;
    }

    public boolean isLampOn() {
        return isLampOn;
    }

    public String getName() {
        return name;
    }
}