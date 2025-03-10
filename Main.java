// Programın çalıştırıldığı ve girilen verilerin okunup "CommandProcessor" dosyasına
// gönderildiği yerdir.

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CommandProcessor cp = new CommandProcessor(null, null, null, null);
        Main fsm = new Main();
        Logger logger = new Logger();
        Symbol symbol = new Symbol();
        State state = new State();
        Transition transition = new Transition();
        cp.logger = logger;
        cp.symbol = symbol;
        cp.state = state;
        cp.transition = transition;

        if (args[0].length()>0) {
            fsm.displayInfo();
            fsm.startProgramWithFile(args[0], cp);
        }
        else{
            fsm.displayInfo();
            fsm.startProgram();
        }
    }
    private void displayInfo(){
        System.out.println("FSM DESIGNER "+getVersionNum()+" "+ getCurrentDate());
    }
    private String getVersionNum(){
        return "1.0";
    }
    private String getCurrentDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
    private void startProgram(){
        // ...
        System.out.println("Program Started");

    }
    private void startProgramWithFile(String fileName, CommandProcessor cp){
        System.out.println("Program Started with File");
        try(BufferedReader bf = new BufferedReader(new FileReader(fileName))){
            String line;

            String command;
            String values="";
            while ((line = bf.readLine()) != null) {
                if (line.contains(";")) {
                    if (!line.endsWith(";")) {
                        line = line.substring(0, line.lastIndexOf(";")+1);
                    }
                    String lineArr[] = line.split(";");
                    for (String string : lineArr) {
                        if (string.contains(" ")) {
                            command = string.substring(0, string.indexOf(" ")).toUpperCase();
                            values = string.substring(string.indexOf(" ") + 1);
                            if (cp.logger.isLogging) {
                                cp.logger.log(string);
                            }
                            cp.activeCommand(command, values);
                            // System.out.println(command+"-->"+values); for testing
                        }
                        else{
                            command = string.toUpperCase();
                            if (cp.logger.isLogging) {
                                cp.logger.log(string);
                            }
                            cp.activeCommand(command, values);
                            // System.out.println(command+"-->" +values); for testing 
                        }
                        values="";
                        command = null;
                    }
                }
            }
            cp.logger.log("-------------------------------------");
        }catch(IOException exception){System.out.println("File cannot readable.. " + exception.getMessage());}
    }
}