package Exceptions.Task4;

import java.io.File;
import java.io.FileNotFoundException;

//Задание № 3
//        1. Создайте класс исключения, который будет выбрасываться при делении на
//        0. Исключение должно отображать понятное для пользователя сообщение
//        об ошибке.
//        2. Создайте класс исключений, которое будет возникать при обращении к
//        пустому элементу в массиве ссылочного типа. Исключение должно
//        отображать понятное для пользователя сообщение об ошибке
//        3. Создайте класс исключения, которое будет возникать при попытке открыть
//        несуществующий файл. Исключение должно отображать понятное для
//        пользователя сообщение об ошибке.
public class Task4 {
    public static void main(String[] args) throws OurFileNotFoundException { //добавили throws для stacktrace
        try{
            divisionByZero(2,0);
        } catch (DivisionByZeroException e){
            System.out.println(e.getMessage());
        }
        try{
            String [] stringArray = new String[5];
            nullArray(stringArray);
        } catch (IsArrayElementNullException e){
            System.out.println(e.getMessage());
        }
        DoesFileExist(new File("tex"));
    }

    public static int divisionByZero(int num1, int num2) {
        if (num2 == 0){
            throw new DivisionByZeroException();
        }
        return num1 / num2;
    }

    public static String[] nullArray(String[] array){
        for (String el:array) {
            if (el == null){
                throw new IsArrayElementNullException();
            }
        }
        return array;
    }

    public static boolean DoesFileExist(File file) throws OurFileNotFoundException {
        if (file.exists()){
            return true;
        }
        throw new OurFileNotFoundException();
    }
}


class DivisionByZeroException extends ArithmeticException{
    private String detailedMessage = "Деление на ноль";

    public DivisionByZeroException() {
        super();
        this.detailedMessage = detailedMessage;
    }

    @Override
    public String getMessage(){
        return detailedMessage;
    }
}
class IsArrayElementNullException extends NullPointerException{
    private String detailedMessage = "Элемент массива является null";

    public IsArrayElementNullException() {
        super();
        this.detailedMessage = detailedMessage;
    }

    @Override
    public String getMessage() {
        return detailedMessage;
    }
}

class OurFileNotFoundException extends FileNotFoundException{
    private String detailedMessage = "Файла не существует";
    public OurFileNotFoundException() {
        super();
        this.detailedMessage = detailedMessage;
    }

    @Override
    public String getMessage() {
        return detailedMessage;
    }
}

//try {
//        ans.divisionByZero();
//        } catch (ArithmeticException e) {
//        System.out.println("Деление на ноль");