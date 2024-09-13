package service;

import model.ComplexNum;

public interface OperationStrategy {
    ComplexNum commandExecution(ComplexNum num1, ComplexNum num2);
}
