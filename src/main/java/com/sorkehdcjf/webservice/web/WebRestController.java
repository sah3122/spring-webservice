package com.sorkehdcjf.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sorkehdcjf.webservice.domain.posts.PostRepository;
import com.sorkehdcjf.webservice.domain.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
	
	private PostRepository postRepository;
	
	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}
	
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto) {
		postRepository.save(dto.toEntity());
	}
	
}
