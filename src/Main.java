import java.util.Scanner;

public class Main {
    private final String adminUserName = "vikram@dmin";
    private final String password = "Maxstuart2@";
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\u001B[34m";

    public String getAdminUserName() {
        return adminUserName;
    }

    public String getPassword() {
        return password;
    }

    public static void main(String[] args) {
        Validation validation = new Validation();
        MenuPage menuPage = new MenuPage();
        Main main = new Main();

        while (true){
            System.out.println(CYAN+"\n1. ADMIN\n2. USER\n3. EXIT"+RESET);
            switch (validation.validInt("Option")){
                case 1 : if(validation.isValidAdmin(main.getAdminUserName(),main.getPassword()))
                    menuPage.adminMenu();
                    break;
                case 2 : menuPage.userPage();
                    break;
                case 3 :
                    System.out.println(CYAN+"Thank You"+RESET);
                    return;
                default:System.out.println(RED + "ENTER VALID OPTION" + RESET);
            }
        }
    }
}
