package rca.exam.devops.t1.calculator_backend.service;

import rca.exam.devops.t1.calculator_backend.exceptions.InvalidOperationException;

public interface IMathOperation {

    double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}
