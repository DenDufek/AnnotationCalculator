import java.lang.annotation.*;

// Анотація для позначення полів, методів та конструкторів, які слід документувати
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface DocumentedAnnotation {
    String value() default "";
}

class Calculator {
    @DocumentedAnnotation("Поле для зберігання першого числа")
    private double operand1;

    @DocumentedAnnotation("Поле для зберігання другого числа")
    private double operand2;

    public Calculator(double operand1, double operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @DocumentedAnnotation("Метод для додавання чисел")
    public double add() {
        return operand1 + operand2;
    }

    @DocumentedAnnotation("Метод для віднімання чисел")
    public double subtract() {
        return operand1 - operand2;
    }

    @DocumentedAnnotation("Метод для множення чисел")
    public double multiply() {
        return operand1 * operand2;
    }

    @DocumentedAnnotation("Метод для ділення чисел")
    public double divide() {
        if (operand2 != 0) {
            return operand1 / operand2;
        } else {
            throw new ArithmeticException("Ділення на нуль неможливе");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Створення об'єкта класу Calculator
        Calculator calculator = new Calculator(10, 2);

        // Виклик методів та вивід результатів
        System.out.println("Додавання: " + calculator.add());
        System.out.println("Віднімання: " + calculator.subtract());
        System.out.println("Множення: " + calculator.multiply());
        System.out.println("Ділення: " + calculator.divide());
    }
}
