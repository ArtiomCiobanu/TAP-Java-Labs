package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Имеется файл query4.
//
//В файле query4 выбрать все строки, в которых N заказа заканчивается цифрой '4'.
//В файле query3 выбрать все строки, в которых в названии есть слово 'TENNIS', а цена установлена в 1990 г.
//В файле query2 выбрать все строки, в которых номер дома не меньше 1000.
//Создать и отсортировать коллекцию на основе информации (по вашему выбору) из данного файла.
public class Main
{
    private final static Order[] Query4Orders =
            {
                    new Order(128474, 1900, 25, "Artiom", "Ciobanu", "SOMETHING"),
                    new Order(124112, 2000, 14, "Darth", "Vader", "DarkSide"),
                    new Order(812746, 2001, 22, "Daria", "Vasilenko", "TENNIS"),
                    new Order(912847, 1921, 15, "Elon", "Musk", "SpaceX")
            };

    private final static Order[] Query3Orders =
            {
                    new Order(123455, 1872, 10, "Daria", "Vasilenko", "TENNIS"),
                    new Order(323223, 55, 1283, "Anakin", "Skywalker", "TENNISANDNOTJUSTTIT"),
                    new Order(812691, 15, 5233, "Vasily", "Pupkin", "OHMYGOD!")
            };

    private final static Order[] Query2Orders =
            {
                    new Order(123455, 1872, 10, "Daria", "Vasilenko", "TENNIS"),
                    new Order(223, 55, 1283, "Anakin", "Skywalker", "TENNISANDNOTJUSTTIT"),
                    new Order(999, 15, 5233, "Vasily", "Pupkin", "OHMYGOD!"),
                    new Order(1000, 15, 5233, "Stanislav", "Vasiliev", "Wowowow"),
            };

    public static void main(String[] args)
    {
        System.out.println("1. В файле query4 выбрать все строки, в которых N заказа заканчивается цифрой '4'.");
        PrintAllMatching(Query4Orders, "[0-9]*4", order -> order.Number);

        System.out.println("2. В файле query3 выбрать все строки, в которых в названии есть слово 'TENNIS', а цена установлена в 1990 г.");
        PrintAllMatching(Query3Orders, "\\w*TENNIS\\w*", order -> order.Description);

        System.out.println("3. В файле query2 выбрать все строки, в которых номер дома не меньше 1000.");
        PrintAllMatching(Query2Orders, "0*\\d{0,3}$", order -> order.HouseNumber);
    }

    /*private Order[] GetOrdersFromFile(String filePath) throws IOException
    {
        var fileText = Files.readString(Path.of(filePath));


        Order[] result =
    }*/

    private static void PrintAllMatching(Order[] orders, String regex, Function<Order, Object> fieldToCompare)
    {
        Pattern pattern = Pattern.compile(regex);
        for (var order : orders)
        {
            var field = fieldToCompare.apply(order);

            Matcher matcher = pattern.matcher(field.toString());
            if (matcher.matches())
            {
                System.out.println(order);
            }
        }
    }
}
