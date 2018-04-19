package com.sorkehdcjf.webservice.domain.posts;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Posts, Long>{

	@Query("SELECT p " + 
			"from Posts p" +
			"ORDER BY p.id DESC")
	Stream<Posts> findAllDesc();
}
