package service.operations;

import model.ComplexNum;

public class AddOperation extends BaseOperation {

    @Override
    public ComplexNum commandExecution(ComplexNum num1, ComplexNum num2) {
        validate(num1, num2);
        double realPart = num1.getReal() + num2.getReal();
        double imaginaryPart = num1.getImaginary() + num2.getImaginary();
        ComplexNum result = new ComplexNum(realPart, imaginaryPart);
        logger.log("Результат сложения: " + result);
        return result;
    }
}
