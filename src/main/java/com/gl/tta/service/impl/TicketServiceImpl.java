package com.gl.tta.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.tta.entity.TicketTracker;
import com.gl.tta.repository.TicketTrackerRepository;
import com.gl.tta.service.TicketService;
@Service
public class TicketServiceImpl implements TicketService {
	
	private TicketTrackerRepository tickettrackerrepository;

	public TicketServiceImpl(TicketTrackerRepository tickettrackerrepository) {
	
		this.tickettrackerrepository = tickettrackerrepository;
	}

	@Override
	public List<TicketTracker> listTickets() {
		return tickettrackerrepository.findAll();
	}

	@Override
	public TicketTracker saveTicket(TicketTracker tickettracker) {
		
		return tickettrackerrepository.save(tickettracker);
	}

	@Override
	public TicketTracker updateTicket(TicketTracker tickettracker) {
		
		return tickettrackerrepository.save(tickettracker);
	}

	@Override
	public TicketTracker getTicketById(Long id) {
		
		return tickettrackerrepository.findById(id).get();
	}

	@Override
	public void deleteById(Long id) {
		tickettrackerrepository.deleteById(id);
		
	}

    @Override
	public List<TicketTracker> searchTickets(String query) {
		
    	return   tickettrackerrepository.searchTickets(query);
	   
	}


}
