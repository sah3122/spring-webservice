package com.sorkehdcjf.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sorkehdcjf.webservice.domain.posts.PostsMainResponseDto;
import com.sorkehdcjf.webservice.domain.posts.PostsRepository;
import com.sorkehdcjf.webservice.domain.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	@Autowired
	private PostsRepository postsRepository;
	
	@Transactional
	public long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
	
	@Transactional(readOnly = true)
	public List<PostsMainResponseDto> findAllDesc() {
		return postsRepository.findAllDesc()
				.map(PostsMainResponseDto::new)
				.collect(Collectors.toList());
	}
}
