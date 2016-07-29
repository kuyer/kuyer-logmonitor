package io.github.kuyer.logmonitor.repository;

import io.github.kuyer.logmonitor.entity.DogEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DogRepository extends JpaRepository<DogEntity, Long> {
	
	public DogEntity findByName(String name);

	@Query("from DogEntity d where d.name=:name")
	public DogEntity findDog(@Param("name") String name);
	
}
