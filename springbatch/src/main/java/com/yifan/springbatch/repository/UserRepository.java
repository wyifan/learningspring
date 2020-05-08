package com.yifan.springbatch.repository;

import com.yifan.springbatch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
