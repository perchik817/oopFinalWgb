package service;

import model.ComplexNum;

public class Calculator {
    private OperationStrategy operation;

    public Calculator(OperationStrategy operation) {
        this.operation = operation;
    }

    public ComplexNum calculate(ComplexNum num1, ComplexNum num2) {
        return operation.commandExecution(num1, num2);
    }

    public void setOperation(OperationStrategy operation) {
        this.operation = operation;
    }
}
