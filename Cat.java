/*
 * В программе есть класс Кот. У кота есть кличка и аппетит (сколько единиц еды он потребляет за приём
пищи). Эти поля мы заполняем с помощью конструктора. Также есть метод eat(), который заставляет
кота покушать, но пока что он пустой, так как неизвестно, откуда кот должен брать еду:
 */

public class Cat {
  private String name;
  private int appetite;
  private boolean satiety;

  public Cat(String name, int appetite) {
    this.name = name;
    this.appetite = appetite;
    this.satiety = false;
  }

  public String getName() {
    return name;
  }

  public int getAppetite() {
    return appetite;
  }

  public boolean isSatiety() {
    return satiety;
  }

  public void setSatiety(boolean satiety) {
    this.satiety = satiety;
  }

  public void eat(int food) {
    if (food >= this.appetite) {
      this.satiety = true;
      System.out.printf("Кот по имени %s съел %d еды из тарелки", name, appetite);

    } else {
      System.out.printf(
          "Кот %s не смог поесть, так как ему не хватило еды в тарелке. Аппетит кота %d.",
          name, appetite);

    }

  }

  @Override
  public String toString() {
    return String.format("\nКот по имени " + name + " с аппетитом " + appetite + " имеет сытость " + satiety);
  }
}