package Exceptions.Task3;
//Создайте класс Счетчик, у которого есть метод add(), увеличивающий
//        значение внутренней int переменной на 1. Сделайте так, чтобы с объектом
//        такого типа можно было работать в блоке try-with-resources. Нужно бросить
//        исключение, если работа с объектом типа счетчик была не в ресурсном try
//        и/или ресурс остался открыт.Подумайте какой тип исключения подойдет
//        лучше всего
public class Task3 {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        try (counter){
            System.out.println(counter.getCount());
            counter.add();
            System.out.println(counter.getCount());
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(counter.getCount()); //уже null
    }
}

class Counter implements AutoCloseable{
    private Integer count = 0;
    public void add(){
        count++;
    }

    @Override
    public void close() throws Exception {
        count = null;
    }

    public int getCount() {
        if (count == null) {
            throw new RuntimeException("Объект уже закрыт");
        }
        return count;
    }
}
