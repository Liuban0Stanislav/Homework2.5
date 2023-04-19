import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {


    public static void main(String[] args) {
        String login = "Dub_Koldun_007";
        String password = "D_1hWiKjjT_9";
        String confirmPassword = "D_1hWiKjjT_9";


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

    public static boolean task1(String login, String password, String confirmPassword)
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
        /**
         * Стандатный метод matches почему-то все время выдавал false, хотя все символы соответствуют
         * устойчивому выражению. Не разобрался почему так, решил написать свой метод.
         */
//        System.out.println(password.matches("[a-zA-Z0-9_]"));
//        if(!password.matches("[a-zA-Z0-9_]")){
//            throw new WrongPasswordException();
//        }
        System.out.println(compare(password));
        if (!compare(password)) {
            throw new WrongPasswordException();
        }
        return true;
    }

    public static boolean compare(String password) {
        char[] allowedCharacters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B',
                'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', '_'};
        char[] passArr = password.toCharArray();
        int counter = 0;
        for (int i = 0; i < passArr.length; i++) {
            for (int j = 0; j < allowedCharacters.length; j++) {
                if (passArr[i] == allowedCharacters[j]) {
                    counter++;
                }
            }
        }
        if (counter != passArr.length) {
            return false;
        }
        return true;
    }
}