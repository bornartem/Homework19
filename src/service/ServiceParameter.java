package service;

import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class ServiceParameter {


    public static void checkParameter(Parameter parameter) {

        if (parameter.getLogin().length() > 20 || !parameter.getLogin().matches("[a-zA-Z0-9_] {1,20}$")) {
            throw new WrongLoginException("Попробуйте ввести другой логин");
        }
        if (parameter.getPassword().length() > 20 || !parameter.getPassword().matches("[a-zA-Z0-9_] {1,20}$")) {
            throw new WrongPasswordException("Попробуйте другой пароль");
        }
        if (!parameter.getPassword().equals(parameter.getConfirmPassword())) {
            throw new WrongPasswordException("Пароли не равны");
        }
    }

    public static void getParameter() throws WrongLoginException, WrongPasswordException {
        Parameter parameter = new Parameter("Rocky_5657", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        try {
            checkParameter(parameter);
        } catch (WrongLoginException e) {
            System.out.println("Попробуйте ввести другой логин");
        } catch (WrongPasswordException e) {
            System.out.println("Попробуйте другой пароль");
            System.out.println("Пароли не равны");
        } finally {
            System.out.println("Проверка завершена");
        }
    }
}
