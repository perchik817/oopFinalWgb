package service.operations;

import log.Logger;
import model.ComplexNum;
import service.OperationStrategy;


public abstract class BaseOperation implements OperationStrategy {
    protected Logger logger = Logger.getInstance();

    public void validate(ComplexNum num1, ComplexNum num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Операнды должны быть комплексными числами");
        }
        logger.log("Числа для операции: " + num1 + " и " + num2);
    }
}
