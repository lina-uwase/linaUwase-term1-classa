package rca.exam.devops.t1.calculator_backend.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import rca.exam.devops.t1.calculator_backend.exceptions.InvalidOperationException;
import rca.exam.devops.t1.calculator_backend.serviceImpl.MathOperationImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MathOperatorServiceTest {

    @InjectMocks
    private MathOperationImpl mathOperatorService;

    @Test
    public void should_add_numbers_success() throws InvalidOperationException {
        double operand1 = 4;
        double operand2 = 9;
        String operation = "+";

        double result = mathOperatorService.doMath(operand1, operand2, operation);

        assertThat(result).isEqualTo(operand1 + operand2);
    }

    @Test
    public void should_subtract_numbers_success() throws InvalidOperationException {
        double operand1 = 10;
        double operand2 = 5;
        String operation = "-";

        double result = mathOperatorService.doMath(operand1, operand2, operation);

        assertThat(result).isEqualTo(operand1 - operand2);
    }

    @Test
    public void should_multiply_numbers_success() throws InvalidOperationException {
        double operand1 = 6;
        double operand2 = 8;
        String operation = "*";

        double result = mathOperatorService.doMath(operand1, operand2, operation);

        assertThat(result).isEqualTo(operand1 * operand2);
    }

    @Test
    public void should_divide_numbers_success() throws InvalidOperationException {
        double operand1 = 15;
        double operand2 = 3;
        String operation = "/";

        double result = mathOperatorService.doMath(operand1, operand2, operation);

        assertThat(result).isEqualTo(operand1 / operand2);
    }

    @Test(expected = InvalidOperationException.class)
    public void should_throw_exception_on_divide_by_zero() throws InvalidOperationException {
        double operand1 = 10;
        double operand2 = 0;
        String operation = "/";

        mathOperatorService.doMath(operand1, operand2, operation);
    }
}
