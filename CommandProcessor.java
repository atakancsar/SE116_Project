// Bu class okunan komutları alıp o komut hangi class ile alakalıysa o class metodlarını
// çağırıp işlem yapıyor.

public class CommandProcessor {
    Logger logger;
    Symbol symbol;
    State state;
    Transition transition;

    public CommandProcessor(Logger logger, Symbol symbol, State state, Transition transition) {
        this.logger = logger;
        this.symbol = symbol;
        this.state = state;
        this.transition = transition;
    }

    public void activeCommand(String command, String value){
        switch (command) {
            case "SYMBOLS": setSymbols(value);break;
            case "STATES": states(value);break;
            case "INITIAL-STATE": initialState(value);break;
            case "FINAL-STATES": finalState(value);break;
            case "TRANSITIONS": transition(value);break;
            case "LOG": log(value);break;
            case "PRINT": print(value);break;
            case "EXECUTE":execute(value);break;
            case "LOAD":load(value);break;
            case "EXIT":exit(value); break;
            case "COMPILE":compile(value); break;
            case "CLEAR":clear(value); break;

            default: System.out.println("Invalid command! "+ command);break;
                
        }
    }
    private void setSymbols(String value){
        if (value.equals("")) {
            symbol.getSymbols();
        }
        else{symbol.setSymbols(value);}
    }
    private void states(String value){
        if (value.equals("")) {
            System.out.println(state.getStates());
        }
    }
    private void initialState(String value){
        if ((value.split(" ")).length>1) {
            System.out.println("Initial state must contain only 1 value.");}
        else if(value.equals("")){System.out.println(state.getInitialState());}
        else{state.setInitialState(value);state.setStates(value);}
    }
    private void finalState(String value){
        if (value.equals("")) {
            System.out.println(state.getFinalState());
        }
        else{
            String[] finalStates = value.split(" ");
            for (String string : finalStates) {
                if (!state.getFinalState().contains(string)) {
                    state.setFinalState(string);
                    state.setStates(string);
                }
            }
        }
    }
    private void transition(String value){
        if (value.equals("")) {
            System.out.println(transition.getTransitions());
        }
        // Burada önce transition verisinin doğruluğu analiz edilecek sonra tanımlancak.
        else{

        }
    }
    private void log(String value){
        logger.changeLogStatus();
    }
    private void print(String value){

    }
    private void execute(String value){

    }
    private void load(String value){

    }
    private void exit(String value){

    }
    private void clear(String value){

    }
    private void compile(String value){

    }
}
