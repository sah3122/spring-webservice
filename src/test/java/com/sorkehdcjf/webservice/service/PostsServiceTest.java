package com.sorkehdcjf.webservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sorkehdcjf.webservice.domain.posts.Posts;
import com.sorkehdcjf.webservice.domain.posts.PostsRepository;
import com.sorkehdcjf.webservice.dto.posts.PostsSaveRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {
	@Autowired
	private PostsService postsService;
	
	@Autowired
	private PostsRepository postsRepository;
	
	@After
	public void cleanUp() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void Dto데이터가_posts테이블에_저장() {
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
													.title("테스트1")
													.content("테스트1의 본문")
													.author("test1@gmail.com")
													.build();
		
		postsService.save(dto);
		
		Posts posts = postsRepository.findAll().get(0);
		assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor()); 
		assertThat(posts.getContent()).isEqualTo(dto.getContent()); 
		assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
	
	}
}
