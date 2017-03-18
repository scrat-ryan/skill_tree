package com.test.impl;

import com.jointstarc.ssm.first.dto.AppointExecutionDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.BaseTest;
import com.jointstarc.ssm.first.service.BookService;

public class BookServiceImplTest extends BaseTest {

	@Autowired
	private BookService bookService;

	@Test
	public void testAppoint() throws Exception {
		long bookId = 1001;
		long studentId = 12345678910L;
		AppointExecutionDto execution = bookService.appoint(bookId, studentId);
		System.out.println("==================");
		System.out.println(execution);
	}

}
