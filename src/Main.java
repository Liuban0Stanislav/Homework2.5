import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {


    public static void main(String[] args) {
        String login = "Dub_Koldun_007";
        String password = "D_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_9";


        try {
            task1(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Длина логина или пароля более 20 символов");
        } catch (WrongPasswordException e) {
            System.out.println("Проверьте правильность написания пароля");
        } finally {
            System.out.println("Game over");
        }

    }

    private static boolean task1(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {

        int maxLoginLength = 20;
        int maxPassLength = 20;

        if (login.length() >= maxLoginLength) {
            throw new WrongLoginException();
        }
        if (password.length() >= maxPassLength) {
                throw new WrongLoginException();
        }
        if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException();
        }
        return true;
    }
}