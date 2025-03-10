import java.util.HashMap;

public class Transition {
    private HashMap<String, String[]> transitions = new HashMap<>();

    public String getTransitions() {
        return "Transitions: "+transitions;
    }
    public void setTransitions(String key, String[] values) {
        transitions.put(key, values);
    }
}
