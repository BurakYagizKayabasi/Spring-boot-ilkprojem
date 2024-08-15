package com.example.authdemo.repository;

import com.example.authdemo.entity.UsersInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersInformationRepository extends JpaRepository<UsersInformation, Integer> {
}
