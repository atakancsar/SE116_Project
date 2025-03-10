import java.util.HashSet;

public class State {
    private String initialState;
    private HashSet<String> finalState = new HashSet<>();
    private HashSet<String> states = new HashSet<>();
    
    public String getInitialState() {
        return "Initial State: "+ initialState;
    }
    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }
    public String getFinalState() {
        return "Final State: " + finalState;
    }
    public void setFinalState(String value) {
        finalState.add(value);
    }
    public String getStates() {
        return "States: "+ states;
    }
    public void setStates(String value) {
        states.add(value);
    }

    
}
