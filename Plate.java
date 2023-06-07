/*
 * Чтобы можно было хранить еду, создадим класс Тарелка с полем food (еда измеряется в целых
числах и не важно, что это за единицы измерения). При создании тарелки мы можем указать
начальное значение food. В процессе работы с помощью метода info() можно вывести в консоль
информацию о тарелке. 
 */

public class Plate {
  private int food;

  public Plate(int food) {
    this.food = food;
  }

  public int getFood() {
    return food;
  }

  public void setFood(int food) {
    if (food >= 0) {
      this.food = food;
    } else {
      System.out.print(" Еды в тарелке недостаточно!  ");
    }
  }

  public void info() {
    System.out.println("  plate: " + food);
  }

  public void addFood(int addFood) {
    this.food = this.food + addFood;
    System.out.printf("\nВ тарелку добавили %d еды  ", addFood);
  }
}