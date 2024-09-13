package service.operations;

import model.ComplexNum;

public class MultiplicationOperation extends BaseOperation{

    @Override
    public ComplexNum commandExecution(ComplexNum num1, ComplexNum num2) {
        validate(num1, num2);
        double realPart = num1.getReal() * num2.getReal() - num1.getImaginary() * num2.getImaginary();
        double imaginaryPart = num1.getReal() * num2.getImaginary() + num1.getImaginary() * num2.getReal();
        ComplexNum result = new ComplexNum(realPart, imaginaryPart);
        logger.log("Результат умножения: " + result);
        return result;
    }
}
