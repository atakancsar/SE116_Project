import java.io.FileWriter;
import java.io.BufferedWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    protected boolean isLogging;
    
    public Logger() {
        this.isLogging = false;
    }
    public void changeLogStatus(){
        this.isLogging = !this.isLogging;
        if (isLogging==true) {
            LocalTime currentTime = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String timeString = currentTime.format(formatter);
            log("----> " + timeString + " <----");
        }

    }
    public void log(String message){
        if (isLogging) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true))){
                bw.write(message);
                bw.newLine();
            } catch (Exception e) {
            }
        }
    }
}
