package ru.mirea;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Comparator;


public class Main {

    public static void main(String[] args) {
        //тесты ArrayList
        ArrayList<String> states = new ArrayList<String>();
// добавим в список ряд элементов
        states.add("Германия");
        states.add("Франция");
        states.add("Великобритания");
        states.add("Испания");
        states.add(1, "Италия"); // добавляем элемент по индексу 1
        System.out.println(states.get(1));// получаем 2-й объект
        states.set(1, "Дания"); // установка нового значения для 2-го объекта
        System.out.printf("В списке %d элементов \n", states.size());
        for (String state : states) {
            System.out.println(state);
        }
        if (states.contains("Германия")) {
            System.out.println("Список содержит государство Германия");
        }
// удалим несколько объектов
        states.remove("Германия");
        states.remove(0);
        Object[] countries = states.toArray();
        for (Object country : countries) {
            System.out.println(country);
        }

        //тест LinkedList
        LinkedList<String> statess = new LinkedList<String>();
// добавим в список ряд элементов
        statess.add("Германия");
        statess.add("Франция");
        statess.addLast("Великобритания"); // добавляем на последнее место
        statess.addFirst("Испания"); // добавляем на первое место
        statess.add(1, "Италия"); // добавляем элемент по индексу 1
        System.out.printf("В списке %d элементов \n", states.size());
        System.out.println(statess.get(1));
        statess.set(1, "Дания");
        for (String state : statess) {
            System.out.println(state);
        }
// проверка на наличие элемента в списке
        if (statess.contains("Германия")) {
            System.out.println("Список содержит государство Германия");
        }
        statess.remove("Германия");
        statess.removeFirst(); // удаление первого элемента
        statess.removeLast(); // удаление последнего элемента

        //тест своей коллекции ArrayList

        System.out.println("Коллекция ArrayListN");
        ArrayListN<Integer> numbers = new ArrayListN<Integer>();
        // добавим ряд элементов
        for (int i = 0; i < 20; i++)
            numbers.add(i);
        System.out.println(numbers);

        //удаление элемента по индексу
        numbers.remove(5);
        System.out.println(numbers);

        //возвращает элемент по индексу 3
        System.out.println(numbers.get(3));
        System.out.println();

        ArrayListN<String> strs = new ArrayListN<>();
        System.out.println(strs);
        for (int i = 0; i < 10; i++) {
            strs.add("String number " + (i + 1));
        }
        System.out.println(strs);
        System.out.println();

        ArrayListN<String> strs2 = new ArrayListN<>(strs);
        System.out.println(strs2);
        strs2.remove(5);
        System.out.println(strs2.get(5));
        System.out.println(strs.get(5));

        ArrayListN<String> sub = strs.subList(4, 8);
        System.out.println(sub);
        System.out.println(strs2);
        strs2.addAll(strs2.getCount()-5, sub);
        System.out.println(strs2);

        //сортировка
        strs2.sort(String::compareTo);
        System.out.println(strs2);
    }
}
