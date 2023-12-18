package rca.exam.devops.t1.calculator_backend.controllers;

import rca.exam.devops.t1.calculator_backend.dtos.DoMathRequestDto;
import rca.exam.devops.t1.calculator_backend.exceptions.InvalidOperationException;
import rca.exam.devops.t1.calculator_backend.payload.ApiResponse;
import rca.exam.devops.t1.calculator_backend.serviceImpl.MathOperationImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/doMath_calculations")
public class MathController {
    private final MathOperationImpl mathOperationImpl;

    public MathController(MathOperationImpl mathOperationImpl) {
        this.mathOperationImpl = mathOperationImpl;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody DoMathRequestDto dto) throws InvalidOperationException {
        return ResponseEntity.ok(ApiResponse.success(mathOperationImpl.doMath(dto.getOperand1(), dto.getOperand2(), dto.getOperation())));
    }
}
