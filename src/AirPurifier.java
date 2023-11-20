// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Scanner;

//--------------------------------------------------
//description of AirPurifier class

//    what should be instance variables?
//      Ans: model , serialNo , fanSpeed , lightOn , temperature , dustLevel , power.

//    what should be instance methods?
//      Ans: turnOn() , turnOff() , setFanSpeed() , setTemperature() , howDustLevel() ,
//           sensorLight() , display() , set() , operator().

//    what should be class variables?
//      Ans: modelCount.

//    what should be class methods?
//      Ans: getModelCount().

//--------------------------------------------------
//overview of the computation
//    อย่างแรกเลยการทำงานของเจ้าตัวเครื่องพวกนี้คือจะมีการตรวจับความสว่างของห้อง
//    เมื่อไหร่ก็ตามที่ห้องถูกไฟเปิดเครื่องจะทำงานโดยอัตโนมัติ และเรายังสามารถที่จะตั้งค่าอุณหภูมิและความเร็วภายหลังได้อีก
//    และจะหยุดทำงานไปเองเมื่อห้องไม่มีแสงไฟ

//    what's needed as inputs? && what's to be returned?
//      Ans:
//           Constructor : AirPurifier
//               จะมีการรับค่า(inputs)ตัวแปร : Model , serialNo เพื่อกำหนดค่าให้กับตัวแปร Object(instance variables)
//               จะไม่มีการคืนค่าใดๆจาก Constructor

//            setFanSpeed
//                จะมีการรับค่า(input)ตัวแปร : speed เพื่อแสดงความเร็วที่ต้องการ
//                จะไม่มีการคืนค่าใดๆจาก setFanSpeed

//            setTemperature
//                จะมีการรับค่า(input)ตัวแปร : Tem เพื่อแสดงอุณหภูมิที่ต้องการ
//                จะไม่มีการคืนค่าใดๆจาก setTemperature

//            HowDustLevel
//                จะไม่มีการรับค่า(input)ใดๆจาก HowDustLevel
//                จะไม่มีการคืนค่าใดๆจาก HowDustLevel (แต่พิมพ์ข้อมูลเกี่ยวกับคุณภาพอากาศขึ้นมาตามค่า dustLevel)

//            sensorLight
//                จะไม่มีการรับค่า(input)ใดๆจาก sensorLight
//                จะไม่มีการคืนค่า boolean (true ถ้าไฟสว่าง , false ถ้าไฟดับ)

//            display
//                จะไม่มีการรับค่า(input)ใดๆจาก HowDustLevel
//                จะไม่มีการคืนค่าใดๆจาก display (แต่พิมพ์ข้อมูลเกี่ยวกับเครื่องฟอกอากาศ : model, serialNo , power, ความเร็วพัดลม, อุณหภูมิ, dustLevel, และคุณภาพอากาศ)

//            set
//                จะมีการรับค่า(inputs)ตัวแปร : speed , Tem เพื่อเพื่อแสดงความเร็วและอุณหภูมิที่ต้องการ
//                จะไม่มีการคืนค่าใดๆจาก set

//            getModelCount
//                จะไม่มีการรับค่า(input) เนื่องจากไม่ต้องการข้อมูลเฉพาะตัว (instance-specific) เป็น class method
//                จะมีการคืนค่าเป็นจำนวนเต็มแทนจำนวนของ object ของคลาส AirPurifier

//            operator
//                จะไม่มีการรับค่า(input) (แต่มีการสร้างอ็อบเจกต์ใหม่ของ AirPurifier ภายในเมทอด)
//                จะไม่มีการคืนค่าใดๆ (แต่มีการกระทำกับผู้ใช้ผ่านทางคอนโซล , เปิดหรือปิดเครื่องฟอกอากาศ , display , และบางครั้งอาจกำหนดความเร็วพัดลมและอุณหภูมิ)

//            main
//                จะมีการรับค่า(input) รับArrayของString (args) เป็นพารามิเตอร์เข้า
//                จะไม่มีการคืนค่าใดๆจาก main

//--------------------------------------------------
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
    static int modelCount = 0;
    public static int getModelCount(){
        return modelCount/2;
    }
    public AirPurifier(String _model,String _serialNo){
        model = _model;
        serialNo = _serialNo;
        fanSpeed = 1;
        temperature = 25;
        dustLevel = 12.0;
        power = false;
        modelCount++;
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
    public void operator(){
        AirPurifier A = new AirPurifier(model,serialNo);
        Scanner s = new Scanner(System.in);
        if (!A.sensorLight()) {
            A.turnOff();
        } else {
            System.out.println("Hello and welcome to class!");
            A.turnOn();
            A.display();
            System.out.println("Do you want to set? [ Y : N ]");
            String Ans = s.next();
            if (Ans.equals("Y")) {
                System.out.println("What temperature do you need?");
                int Tem = s.nextInt();
                System.out.println("How much speed do you want?");
                int speed = s.nextInt();
                A.set(speed, Tem);
                A.display();
            } else if (Ans.equals("N")) {
                System.out.println("Hope you enjoy with your class!!");
            } else {
                System.out.println("ERROR");
            }
        }
    }
}