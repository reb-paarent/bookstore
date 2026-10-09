package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.web.BookController;

@SpringBootTest
class BookstoreApplicationTests {

	private final BookController controller;

    @Autowired
    public BookstoreApplicationTests(BookController controller) {
        this.controller = controller;
    }

	@Test
	void contextLoads() {
	}

    @Test
    public void controllerLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
