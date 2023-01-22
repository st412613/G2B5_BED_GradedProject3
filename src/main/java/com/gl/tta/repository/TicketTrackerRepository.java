package com.gl.tta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gl.tta.entity.TicketTracker;

public interface TicketTrackerRepository extends JpaRepository<TicketTracker, Long> {
	@Query("SELECT p FROM TicketTracker p WHERE " + "p.title LIKE CONCAT('%',:query, '%')")

	List<TicketTracker> searchTickets(@Param("query") String query);

}
