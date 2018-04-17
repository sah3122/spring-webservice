package com.sorkehdcjf.webservice.domain.posts;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
				.title("")
				.content("")
				.author("")
				.build());
		
		List<Posts> postLists = postRepository.findAll();
		
		Posts posts = postLists.get(0);
		assertThat(posts.getTitle(), is("테스트 게시글")); 
		assertThat(posts.getContent(), is("테스트 본문"));
		
	}
	
	
}
