public class CommandProcessor {
    public CommandProcessor(){

    }
    public void activeCommand(String command, String value){
        switch (command) {
            case "SYMBOLS": setSymbols(value);break;
            case "STATES": states(value);break;
            case "INITIAL-STATE": initialState(value);break;
            case "FINAL-STATES": finalState(value);break;
            case "TRANSITIONS": transition(value);break;

            //default: System.out.println("Invalid command!");
                
        }
    }
    private void setSymbols(String value){

    }
    private void states(String value){

    }
    private void initialState(String value){

    }
    private void finalState(String value){

    }
    private void transition(String value){

    }
}
