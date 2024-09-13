package service.operations;

import model.ComplexNum;

public class DivOperation extends BaseOperation{
    @Override
    public ComplexNum commandExecution(ComplexNum num1, ComplexNum num2) {
        validate(num1, num2);
        if (num2.getReal() == 0 && num2.getImaginary() == 0) {
            throw new ArithmeticException("Деление на ноль недопустимо");
        }
        double denominator = num2.getReal() * num2.getReal() + num2.getImaginary() * num2.getImaginary();
        double realPart = (num1.getReal() * num2.getReal() + num1.getImaginary() * num2.getImaginary()) / denominator;
        double imaginaryPart = (num1.getImaginary() * num2.getReal() - num1.getReal() * num2.getImaginary()) / denominator;
        ComplexNum result = new ComplexNum(realPart, imaginaryPart);
        logger.log("Результат деления: " + result);
        return result;
    }
}
