package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.math.SimplesMath;
import br.com.erudio.utils.MathUtils;

@RestController
public class MathController {

	private static AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return SimplesMath.sum(MathUtils.convertToDouble(numberOne), MathUtils.convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return SimplesMath.subtraction(MathUtils.convertToDouble(numberOne), MathUtils.convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		if (MathUtils.convertToDouble(numberTwo) == 0D) {
			throw new UnsupportedMathOperationException("Second number has to be greater than 0");
		}

		return SimplesMath.division(MathUtils.convertToDouble(numberOne), MathUtils.convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return SimplesMath.multiplication(MathUtils.convertToDouble(numberOne), MathUtils.convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/sqrt/{numberOne}", method = RequestMethod.GET)
	public Double sqrt(@PathVariable(value = "numberOne") String numberOne) throws Exception {

		if (!MathUtils.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return SimplesMath.sqrt(MathUtils.convertToDouble(numberOne));
	}

	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mean(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!MathUtils.isNumeric(numberOne) || !MathUtils.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return SimplesMath.mean(MathUtils.convertToDouble(numberOne), MathUtils.convertToDouble(numberTwo));
	}

}
