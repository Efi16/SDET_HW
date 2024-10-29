import java.util.Scanner;

class WrongLoginException extends Exception {
    public WrongLoginException() {
        super();
    }

    public WrongLoginException(String message) {
        super(message);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super();
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}

public class UserValidator {

    public static boolean validateCredentials(String login, String password, String confirmPassword) {
        try {
            if (!login.matches("^[a-zA-Z0-9_]{1,19}$")) {
                throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и знак подчеркивания и быть меньше 20 символов.");
            }

            if (!password.matches("^[a-zA-Z0-9_]{1,19}$")) {
                throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры и знак подчеркивания и быть меньше 20 символов.");
            }

            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают.");
            }

            return true;

        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        boolean isValid = validateCredentials("user_name", "password123", "password123");
        System.out.println("Тестовые данные корректны: " + isValid);

        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        String password = sc.nextLine();
        String confirmPassword = sc.nextLine();
        isValid = validateCredentials(username,password,confirmPassword);
        System.out.println("Введённые данные корректны: " + isValid);
    }
}
