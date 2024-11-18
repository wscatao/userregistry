package com.paybridge.userregistry.infrastructure.database.datasources;

import com.paybridge.userregistry.infrastructure.database.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepositoryDatasource extends JpaRepository<UserModel, UUID> {
}
