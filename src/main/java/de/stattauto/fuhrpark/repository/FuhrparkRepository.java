package de.stattauto.fuhrpark.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.stattauto.fuhrpark.entity.Auto;

@Repository
public interface FuhrparkRepository extends JpaRepository<Auto, Long>{
	Collection<Auto> findByKennzeichen(String kennzeichen);
}
