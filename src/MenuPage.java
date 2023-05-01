import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuPage {
    Scanner input = new Scanner(System.in);
    Library library = new Library();
    Map<String ,String > users = new HashMap<>();

    public void adminMenu() {
        while (true) {
            System.out.println(Library.CYAN + "\n1. ADD BOOK\n2. SHOW ALL BOOKS\n3. SHOW ALL AVAILABLE BOOKS\n4. BARROW BOOK\n" +
                    "5. RETURN BOOK\n6. BACK\n7. EXIT" + Library.RESET);
//            System.out.print("Choice : ");
            switch (new Validation().validInt("choice")) {
                case 1:
                    library.addBook();
                    break;
                case 2:
                    library.showAllBooks();
                    break;

                case 3:
                    library.showAvailableBooks();
                    break;
                case 4:
                    library.barrow();
                    break;
                case 5:
                    library.returnBook();
                    break;
                case 6: return;
                case 7:
                    System.out.println(Library.CYAN + "THANK YOU" + Library.RESET);
                    System.exit(0);
                default:
                    System.out.println(Library.RED + "ENTER VALID INPUT" + Library.RESET);
            }
        }
    }

    public void userPage(){
        Validation validation = new Validation();
        while (true) {
            System.out.println(Library.CYAN+"\n1. New User\n2. Existing User\n3. Back\n");
            switch (validation.validInt("Choice")) {
                case 1:
                    signUp();
                    break;
                case 2:
                    signIn();
                    break;
                case 3:
                    return;
                default:
                    System.out.println(Library.RED + "ENTER VALID INPUT" + Library.RESET);
            }
        }
    }

    public void signUp(){
        Validation validation = new Validation();
        String userName;
        String password;
        while (true){
            System.out.print("Enter userName : ");
            userName = input.next();
            if(!users.containsKey(userName))
                break;
            System.out.println(Library.RED+"This userName is Already Exist"+Library.RESET);
        }
        password = validation.validPassword();
        users.put(userName,password);
        System.out.println(Library.GREEN+"Sign Up Successfully\n"+Library.RESET);
    }

    public void signIn(){
        String userName;
        String password;
        int iteration = 0;
        while(iteration <3){
            System.out.print("Enter userName : ");
            userName = input.next();
            System.out.print("Enter Password : ");
            password = input.next();
            if(users.containsKey(userName) && users.get(userName).equals(password)){
                System.out.println(Library.GREEN+"SignIn successfully"+Library.RESET);
                userMenu();
                return;
            }
            System.out.println(Library.RED+"Invalid UserName or Password\n"+Library.RESET);
            iteration++;
        }
        System.out.println(Library.RED + "Limit exceeded, try after some times" + Library.RESET);
        System.exit(0);
    }

    public void userMenu() {
        while (true) {
            System.out.println(Library.CYAN + "\n1. SHOW ALL BOOKS\n2. SHOW ALL AVAILABLE BOOKS\n3. BARROW BOOK\n" +
                    "4. RETURN BOOK\n5. BACK\n6. EXIT\n" + Library.RESET);
//            System.out.print("Choice : ");
            switch (new Validation().validInt("choice")) {
                case 1:
                    library.showAllBooks();
                    break;

                case 2:
                    library.showAvailableBooks();
                    break;
                case 3:
                    library.barrow();
                    break;
                case 4:
                    library.returnBook();
                    break;
                case 5 : return;
                case 6:
                    System.out.println(Library.CYAN + "THANK YOU" + Library.RESET);
                    System.exit(0);
                default:
                    System.out.println(Library.RED + "ENTER VALID INPUT" + Library.RESET);
            }
        }
    }
}
