//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        //из за того что min и max не могут быть больше 100 решил использовать byte
        int best_result = 999; // Переменная для лучшего результата
        int Kol_vo = 1;        // Переменная  для количество попыток
        final byte min = 1;    // Минимальное число рандома
        final byte max = 100;  // Максимальное число рандома
        int enter_int = 0;     // Вводимое число
        boolean Exit = true;   // Переменная для завершение работы проги
        while (Exit==true) {
            int rnd = rnd(min, max);
            //System.out.println("Число "+rnd);
            do {
                System.out.println("Введи число от 1 до 100, либо команду RESULT");
                Scanner sc = new Scanner(System.in);
                if (sc.hasNextInt()) {// проверка что тип данных не строка
                    enter_int = sc.nextInt();
                    if (rnd > enter_int) {
                        Kol_vo=Kol_vo+1;
                        System.out.println("Я сам в шоке, но, загаданное число больше, брат");
                    } else if (rnd < enter_int) {
                        Kol_vo=Kol_vo+1;
                        System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
                    } else if (rnd == enter_int) {
                        System.out.println("Поздравляю, ты выиграл! Это число: "+rnd);
                        if (Kol_vo==1) {//Если угадать с 1 раза
                            best_result = Kol_vo;
                            System.out.println("Количество попыток " + Kol_vo);
                            System.out.println("Лучший результат " + best_result);
                            Kol_vo = 1;
                        }
                        else if (best_result > Kol_vo) { //Если угадал более 1 кол-во попытки
                            best_result = Kol_vo;
                            System.out.println("Лучший результат " + best_result);
                            System.out.println("Количество попыток " + Kol_vo);
                            Kol_vo = 1;
                        }
                        else if (best_result<=Kol_vo){
                            System.out.println("Лучший результат " + best_result);
                            System.out.println("Количество попыток " + Kol_vo);
                            Kol_vo = 1;
                        }}
                } else if(sc.hasNextInt()==false) {
                    String name = sc.nextLine();
                    switch (name) {
                        case "RESULT":
                            System.out.println("Текущее количество попыток " + Kol_vo);
                            System.out.println("Лучший результат " + best_result);
                            break;
                        default: System.out.println("Неверная команда!");
                    }
                }
            } while (rnd != enter_int); // Выход из проги
            System.out.println("Продолжить? y/n");
            Scanner strEx = new Scanner(System.in);
            String name = strEx.nextLine();
            switch (name) {
                case "y":
                    Exit = true;
                    break;
                case "Y":
                    Exit = true;
                    break;
                case "n":
                    Exit = false;
                    break;
                case "N":
                    Exit = false;
                    break;
                default:
                    System.out.println("Неверная команда!");
            }
        }
    }
    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}//1