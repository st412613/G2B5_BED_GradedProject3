package com.gl.tta.service;

import java.util.List;

import com.gl.tta.entity.TicketTracker;

public interface TicketService {

	// -------------------------------------------------------------List Of Ticket-------------------------------------------------------------------------------------------------
	List<TicketTracker> listTickets();

	// --------------------------------------------------------------Save-Ticket---------------------------------------------------------------------------------------------------
	TicketTracker saveTicket(TicketTracker tickettracker);

	// ------------------------------------------------------------Edit-Start---------------------------------------------------------------------------------------------------

	TicketTracker updateTicket(TicketTracker tickettracker);

	TicketTracker getTicketById(Long id);

	// --------------------------------------------------------------Edit-End----------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------Delete- Ticket-------------------------------------------------------------------------------------------------
	void deleteById(Long id);

	// ---------------------------------------------------------------Search-Ticket------------------------------------------------------------------------------------------------
	List<TicketTracker> searchTickets(String query);

}