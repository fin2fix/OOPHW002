/*
 * Если в методе main() создать объекты этих классов, то можно узнать информацию о тарелке и
вызвать пустой метод eat() у кота. Эти объекты пока никак не могут взаимодействовать между собой.
Можно добавить в классы геттеры и сеттеры и получить код вроде.

ЗАДАНИЕ

1. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды 
(например, в миске 10 еды, а кот пытается покушать 15-20).
2. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). 
Если коту удалось покушать (хватило еды), сытость = true. Считаем, что если коту мало еды в тарелке, 
то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
3. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки 
и потом вывести информацию о сытости котов в консоль.
4. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
Достаточно выполнить первые 2 подпункта задачи.
 */

import java.util.Arrays;
import java.util.Random;

public class MainClass {

  public static void feedingCats(Cat[] cats, Plate plate) {
    int hungryCats = cats.length;

    for (Cat cat : cats) {
      if (!cat.isSatiety()) {
        cat.eat(plate.getFood());
        plate.setFood(plate.getFood() - cat.getAppetite());
        plate.info();
      }

      if (cat.isSatiety()) { // не могу здесь использовать else, так как мне нужно проверить сытость именно
                             // после попытки кормежки - сытый ли теперь кот
        hungryCats--;
      }
    }
    if (hungryCats == 0)
      System.out.println("\nВсе коты накормлены. УРА !!!\n");
  }

  public static void main(String[] args) {
    Random rand = new Random();
    Plate plate = new Plate(150);

    Cat[] cats = new Cat[] {
        new Cat("Barsik", rand.nextInt(10, 20)),
        new Cat("Shurik", rand.nextInt(10, 20)),
        new Cat("Pushok", rand.nextInt(10, 20)),
        new Cat("Pirat", rand.nextInt(10, 20)),
        new Cat("Snejok", rand.nextInt(10, 20)),
        new Cat("Leopold", rand.nextInt(10, 20)),
        new Cat("Vasiliy", rand.nextInt(10, 20)),
        new Cat("Chernysh", rand.nextInt(10, 20)),
        new Cat("Tom", rand.nextInt(10, 20)),
        new Cat("Garfield", rand.nextInt(10, 20)),
        new Cat("Goodwin", rand.nextInt(10, 20)),
        new Cat("Rocky", rand.nextInt(10, 20)),
        new Cat("Gamlet", rand.nextInt(10, 20)), };

    System.out.print("\nУ нас есть тарелка с едой   ");
    plate.info();

    System.out.println("\nУ НАС ЕСТЬ КОТЫ:");
    System.out.println(Arrays.toString(cats));

    System.out.println("\nДАВАЙТЕ ИХ ПОКОРМИМ:");
    feedingCats(cats, plate);

    System.out.println("\nРЕЗУЛЬТАТ КОРМЕЖКИ КОТОВ (ИНФОРМАЦИЯ О СЫТОСТИ):");
    System.out.println(Arrays.toString(cats));

    plate.addFood(50);
    plate.info();

    System.out.println("\nДОКОРМИМ КОТОВ, ОСТАВШИХСЯ ГОЛОДНЫМИ РАНЕЕ ");
    feedingCats(cats, plate);
  }
}
