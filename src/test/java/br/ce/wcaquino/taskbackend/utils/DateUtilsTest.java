package br.ce.wcaquino.taskbackend.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class DateUtilsTest {

	@Test
	public void deveRetornarTrueParaDatasFuturas() {
		
		LocalDate date = LocalDate.of(2030, 01, 01);
		System.out.println(DateUtils.isEqualOrFutureDate(date));
		DateUtils.isEqualOrFutureDate(date);
	
		assertFalse(DateUtils.isEqualOrFutureDate(date));
	
	}
	
	@Test
	public void deveRetornarFalseParaDatasFalse() {
		
		LocalDate date = LocalDate.of(2010, 01, 01);
		System.out.println(DateUtils.isEqualOrFutureDate(date));
		DateUtils.isEqualOrFutureDate(date);
	
		assertFalse(DateUtils.isEqualOrFutureDate(date));
	
	}
	
	@Test
	public void deveRetornarTrueParaDataAtual() {
		
		LocalDate date = LocalDate.now();
		System.out.println(DateUtils.isEqualOrFutureDate(date));
		DateUtils.isEqualOrFutureDate(date);
	
		assertTrue(DateUtils.isEqualOrFutureDate(date));
	
	}
	
}
