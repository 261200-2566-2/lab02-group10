// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

//--------------------------------------------------
//description of AirPurifier class
//    what should be instance variables?
    //Ans: Xiaomi Smart Air Purifier 4 Pro
//    what should be instance methods?
    //Ans:
//    what should be class variables?
    //Ans: Xiaomi
//    what should be class methods?
    //Ans:
//--------------------------------------------------
//overview of the computation
//    what's needed as inputs?
    //Ans:
//    what's to be returned?
    //Ans:
//--------------------------------------------------
import java.util.Scanner;
public class AirPurifier {
    static String model;
    static String serialNo;
    int fanSpeed;
    boolean lightOn;
    int temperature;
    double dustLevel;
    boolean power;
    void turnOn() { power = true; }
    void turnOff() { power = false; }
    public AirPurifier(String _model,String _serialNo){
        model = _model;
        serialNo = _serialNo;
        fanSpeed = 1;
        temperature = 25;
        dustLevel = 12.0;
        power = false;
    }
    public void setFanSpeed(int speed){
        if(speed < 0){
            System.out.println("Sorry, the speed can't be lower than 1.");
            speed = 1;
        }
        else if(speed > 5){
            System.out.println("Sorry, the speed can't be higher than 5.");
            speed = 5;
        }
        fanSpeed = speed;
    }
    public void setTemperature(int Tem){
        if(Tem < 18){
            System.out.println("Sorry, the temperature can't be lower than 18 ํc.");
            Tem = 18;
        }
        else if(Tem > 30){
            System.out.println("Sorry, the temperature can't be higher than 30 ํc.");
            Tem = 30;
        }
        temperature = Tem;
    }

    public void HowDustLevel() {
        System.out.print("PM2.5 => Air Quality : ");
        if(dustLevel >= 0.0 && dustLevel <= 12.0) System.out.println("GOOD");
        else if(dustLevel >= 12.1 && dustLevel <= 35.4) System.out.println("MODERATE");
        else if(dustLevel >= 35.5 && dustLevel <= 55.4) System.out.println("UNHEALTHY FOR SENSITIVE PERSON");
        else if (dustLevel >= 55.5 && dustLevel <= 150.4) System.out.println("UNHEALTHY");
        else if(dustLevel >= 150.5 && dustLevel <= 250.4) System.out.println("VERY UNHEALTHY");
        else if(dustLevel >= 250.5 && dustLevel <= 500.4) System.out.println("HAZARDOUS");
    }
    public boolean sensorLight(){
        return !lightOn;
    }
    public void display(){
        System.out.println("------------------------------------------");
        System.out.println("Model : " + model);
        System.out.println("serialNo : " + serialNo);
        System.out.println("Power : " + (power ? "ON" : "OFF"));
        System.out.println("FanSpeed : " + fanSpeed);
        System.out.println("Temperature : " + temperature + " ํc");
        System.out.println("DustLevel : " + dustLevel);
        HowDustLevel();
        System.out.println("------------------------------------------");
    }
    public void set(int speed , int Tem){
        setFanSpeed(speed);
        setTemperature(Tem);
    }
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        Scanner s = new Scanner(System.in);
        //model สามารถชื่ออะไรได้หมดอ่ะ , เลขก็เช่นกัน
        System.out.println("What model do you want to use?");
        String model = s.nextLine();
        System.out.println("What serialNo do you want to use?");
        String serialNo = s.nextLine();
        AirPurifier myAir = new AirPurifier(model,serialNo);

        if (!myAir.sensorLight()) {
            myAir.turnOff();
        } else {
            System.out.println("Hello and welcome to class!");
            myAir.turnOn();
            myAir.display();
            System.out.println("Do you want to set? [ Y : N ]");
            String Ans = s.next();
            if(Ans.equals("Y")){
                System.out.println("What temperature do you need?");
                int Tem = s.nextInt();
                System.out.println("How much speed do you want?");
                int speed = s.nextInt();
                myAir.set(speed,Tem);
                myAir.display();
            }
            else if(Ans.equals("N")){
                System.out.println("Hope you enjoy with your class!!");
            }
            else {
                System.out.println("ERROR");
                main(args);
            }
        }
        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
    }
}