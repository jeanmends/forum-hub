package br.com.forum.forum.repository;

import br.com.forum.forum.model.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepository extends JpaRepository <Forum, Long> {
}
