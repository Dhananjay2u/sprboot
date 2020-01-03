package com.dj.boot.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dj.boot.student.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
