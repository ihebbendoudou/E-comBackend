package com.project.IshopPfe;

import com.project.IshopPfe.dao.CategoryRepository;
import com.project.IshopPfe.entities.Category;
import com.project.IshopPfe.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootTest
class IshopPfeApplicationTests {

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void contextLoads() {
	}
	@Test
	public void testFindAllCategory()
	{
		List<Category> cat = categoryRepository.findAll();

		for (Category p:cat)
			System.out.println("p= "+p);

	}
}
