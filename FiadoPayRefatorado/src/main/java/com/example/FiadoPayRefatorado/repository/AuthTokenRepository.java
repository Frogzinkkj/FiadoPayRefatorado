package com.example.FiadoPayRefatorado.repository;

import com.example.FiadoPayRefatorado.domain.model.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthTokenRepository extends JpaRepository<AuthToken, String> {
}