package com.sorkehdcjf.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sorkehdcjf.webservice.domain.posts.PostRepository;
import com.sorkehdcjf.webservice.domain.posts.PostsMainResponseDto;
import com.sorkehdcjf.webservice.domain.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	private PostRepository postRepository;
	
	@Transactional
	public long save(PostsSaveRequestDto dto) {
		return postRepository.save(dto.toEntity()).getId();
	}
	
	@Transactional(readOnly = true)
	public List<PostsMainResponseDto> findAllDesc() {
		return postRepository.findAllDesc()
				.map(PostsMainResponseDto::new)
				.collect(Collectors.toList());
	}
}
