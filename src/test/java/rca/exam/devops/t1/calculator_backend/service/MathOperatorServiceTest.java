package rca.exam.devops.t1.calculator_backend.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import rca.exam.devops.t1.calculator_backend.dtos.DoMathRequestDto;
import rca.exam.devops.t1.calculator_backend.exceptions.InvalidOperationException;
import rca.exam.devops.t1.calculator_backend.serviceImpl.MathOperationImpl;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathOperatorServiceTest {

    @InjectMocks
    private MathOperationImpl mathOperatorService;

    @Test
    public void should_create_math_operation_success() throws InvalidOperationException {
        double operator1 = 4;
        double operator2 = 9;
        String operation = "+";

        double mathOperation = mathOperatorService.doMath(operator1,operator2, operation);
        when(mathOperatorService.doMath(operator1, operator2, operation)).thenReturn(mathOperation);

        double actualMathOperator = mathOperatorService.doMath(operator1, operator2, operation);

        assertThat(mathOperation).usingRecursiveComparison().isEqualTo(actualMathOperator);
    }

}