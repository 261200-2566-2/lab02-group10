public class Lab02 {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
//        Scanner s = new Scanner(System.in);
//        System.out.println("What model do you want to use?");
//        String model = s.nextLine();
//        System.out.println("What serialNo do you want to use?");
//        String serialNo = s.nextLine();
        AirPurifier myAir1 = new AirPurifier("Xiaomi Smart Air Purifier 4 Pro","1234");
            myAir1.operator();

        AirPurifier myAir2 = new AirPurifier("Xiaomi Smart Air Purifier 4","5678");
            myAir2.operator();

        AirPurifier myAir3 = new AirPurifier("Xiaomi Smart Air Purifier 3 Pro","1357");
            myAir3.operator();

        AirPurifier myAir4 = new AirPurifier("Xiaomi Smart Air Purifier 3","2468");
            myAir4.operator();

        System.out.println("Number of AirPurifier model : " + AirPurifier.getModelCount());
        }
        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
}

