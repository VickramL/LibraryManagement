import java.awt.*;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    private static final Pattern authorTitle_pattern = Pattern.compile("^[a-zA-Z1-9 ]+$");
    private static final Pattern yearValidation = Pattern.compile("^\\d{4}$");
    private static final Pattern passwordValidation = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
    Scanner input = new Scanner(System.in);
    public String authorTitle(String string){
        String output;
        while(true){
            System.out.print(string +" : ");
            output = input.nextLine();
            while(output.isEmpty()){
                output = input.nextLine();
            }
            if(!authorTitle_pattern.matcher(output).matches())
                System.out.println(RED+"Invalid Title"+RESET);
            else
                break;
        }
        return output;
    }

    public String validYear(){
        String year;
        while(true){
            System.out.print("Year : ");
            year = input.next();
            if(!yearValidation.matcher(year).matches())
                System.out.println(RED+"Invalid Year"+RESET);
            else
                break;
        }
        return year;
    }

    public int validId(Map<Integer,Book> books){
        int id = 0,option;
//        outerloop:
        while (true){
//            System.out.print("Enter Book Id : ");
            id = validInt("Id");
            if(!books.containsKey(id)) {
                System.out.println(RED + "ENTER INVALID ID" + RESET);
                System.out.println(Library.CYAN+"Do you Want to Continue"+Library.RESET);
                System.out.print("1. Yes\n2. No\n");
                option = validInt("choice");
                switch (option){
                    case 1 : continue;
                    case 2 : return id;
                    default:
                        System.out.println(RED+"Enter Valid Option"+RESET);
                }
            }
            else
                break;
        }
        return id;
    }
    public int validInt(String string){
        int number = 0;
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter "+string+" : ");
                number = sc.nextInt();
            } catch (Exception e) {
                System.out.println(RED+string+" contains numbers only"+RESET);
            }

        return number;
    }

    public boolean isValidAdmin(String adminUserName,String adminPassword){
//        Scanner input = new Scanner(System.in);
        System.out.print("Enter userName : ");
        String userName = input.next();
        if(!adminUserName.equals(userName)){
            System.out.println(RED+"Invalid UserName"+RESET);
            return false;
        }
        System.out.print("Enter Password : ");
        String password = input.next();
        if(!adminPassword.equals(password)){
            System.out.println(RED+"Invalid Password"+RESET);
            return false;
        }
        return true;
    }

    public String validPassword(){
        String password;
        while (true){
            System.out.print("Enter Password : ");
            password = input.next();
            if(!passwordValidation.matcher(password).matches()){
                System.out.println(RED+"password must contains Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character:\n"+RESET);
            }
            else
                break;
        }
        return password;
    }
}

