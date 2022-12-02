package com.mockito;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class TestCalculator {
	Calculator calculator = null;
	
	CalculatorService service = Mockito.mock(CalculatorService.class);
	
	@Before
	public void setup() {
		calculator = new Calculator(service);
	}
	
	@Test
	public void testAdd() {
		when(service.add(10, 5)).thenReturn(15);
		assertEquals(15, calculator.add(10, 5));
	}
	
	@Test
	public void testSub() {
		assertEquals(5, calculator.sub(10, 5));
	}
	
	@Test
	public void testDiv() {
		assertEquals(2, calculator.div(10, 5));
	}
	
	@Test
	public void testMultiply() {
		assertEquals(50, calculator.multiply(10, 5));
	}

}
