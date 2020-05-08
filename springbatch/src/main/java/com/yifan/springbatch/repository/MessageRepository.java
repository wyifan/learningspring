package com.yifan.springbatch.repository;

import com.yifan.springbatch.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
