import java.io.FileWriter;

public class Logger {
    private boolean activeLog;
    
    public Logger() {
        this.activeLog = false;
    }
    public void changeLogStatus(){
        this.activeLog = !this.activeLog;
    }
    public void log(String message){

    }
}
