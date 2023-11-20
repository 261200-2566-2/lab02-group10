import java.util.Scanner;

public class Main {
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
