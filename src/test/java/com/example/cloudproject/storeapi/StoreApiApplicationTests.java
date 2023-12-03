package com.example.cloudproject.storeapi;

import com.example.cloudproject.storeapi.entity.Category;
import com.example.cloudproject.storeapi.entity.StoreStatic;
import com.example.cloudproject.storeapi.repository.StoreStaticRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StoreApiApplicationTests {

	@Autowired
	private StoreStaticRepository storeStaticRepository;
	@Test
	void testJpa() {
		/*String searchWord = "경희";
		List<StoreStatic> sList = this.storeStaticRepository.findByStoreNameLike("%" + searchWord + "%");
		StoreStatic s = sList.get(0);
		assertEquals(0, s.getStoreId());*/
	}


}
