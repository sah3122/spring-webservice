package com.sorkehdcjf.webservice.domain.posts;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {
	@Autowired
	PostRepository postRepository;
	
	@After
	public void cleanUp() {
		postRepository.deleteAll();
	}
	
	@Test
	public void 게시글저장_불러오기() {
		postRepository.save(Posts.builder()
				.title("테스트 게시글")
				.content("테스트 본문")
				.author("")
				.build());
		
		List<Posts> postLists = postRepository.findAll();
		
		Posts posts = postLists.get(0);
		assertThat(posts.getTitle(), is("테스트 게시글")); 
		assertThat(posts.getContent(), is("테스트 본문"));
		
	}
	@Test 
	public void BaseTimeEntity_등록 () { 
		LocalDateTime now = LocalDateTime.now();
		
		postRepository.save(Posts.builder()
				.title("게시글")
				.content("내용")
				.author("저자")
				.build());
		
		List<Posts> postLists = postRepository.findAll();
		
		Posts posts = postLists.get(0);
		assertTrue(posts.getCreatedDate().isAfter(now)); 
		assertTrue(posts.getModifiedDate().isAfter(now));
		
	}

		
	
	
}
