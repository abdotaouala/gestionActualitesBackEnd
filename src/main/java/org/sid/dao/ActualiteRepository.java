package org.sid.dao;

import org.sid.entities.Actualite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActualiteRepository extends JpaRepository<Actualite, Long> {
	
	@Query("select a from Actualite a where a.titre like :x")
	public Page<Actualite> rechercher(@Param("x") String x,Pageable pageable);
}
