package com.gl.tta.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.tta.entity.TicketTracker;
import com.gl.tta.service.TicketService;

@Controller
public class TicketTrackerController {
	private TicketService ticketService;

	public TicketTrackerController(TicketService ticketService) {

		this.ticketService = ticketService;
	}

	// -------------------------------------------Find All Ticket
	// List------------------------------------
	@GetMapping("/tickets")
	public String ticketHomePage(Model model) {
		List<TicketTracker> tickets = ticketService.listTickets();
		model.addAttribute("tickets", tickets);
		return "tickets";

	}

	// ------------------------------------------- Add Ticket -
	// START------------------------------------
	@GetMapping("/tickets/new")
	public String addTicketButtonClicked(Model model) {

		TicketTracker ticket = new TicketTracker();
		model.addAttribute("ticket", ticket);

		return "create_ticket";
	}

	@PostMapping(value = "/tickets")

	public String submitButtonClicked(

			@ModelAttribute("ticket") TicketTracker ticket) {

		ticketService.saveTicket(ticket);
		return "redirect:/tickets";
	}
	// ----------------------------------------- Add ticket -
	// END---------------------------------------

	// ----------------------------------------Update Ticket -
	// Start-----------------------------------
	@GetMapping("/tickets/edit/{id}")
	public String updateTicketTrackerButtonClicked(@PathVariable Long id, Model model) {

		TicketTracker selectedTicket = ticketService.getTicketById(id);

		model.addAttribute("ticket", selectedTicket);

		return "edit_ticket";
	}

	@PostMapping("/tickets/{id}")
	public String submitButtonClickedForUpdateTicket(@PathVariable Long id,
			@ModelAttribute("ticket") TicketTracker ticket) {

		// Update the ticket object
		TicketTracker existingTicketObj = ticketService.getTicketById(id);

		existingTicketObj.setTitle(ticket.getTitle());
		existingTicketObj.setSortDescription(ticket.getSortDescription());
		// existingTicketObj.setCreated_date(ticket.getCreated_date());

		ticketService.updateTicket(ticket);

		return "redirect:/tickets";
	}

	// ------------------------------------- Update ticket -
	// End----------------------------------

	@GetMapping("/tickets/{id}")
	public String deleteTicket(@PathVariable Long id) {

		ticketService.deleteById(id);
		return "redirect:/tickets";
	}

	// -------------------------------------- view
	// ticket-----------------------------------------
	@GetMapping("tickets/view/{id}")
	public String viewTicket(@PathVariable Long id, Model model) {
		TicketTracker ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		// ticketService.getTicketById(id);
		return "view_ticket";
	}

	// ---------------------------------search
	// product--------------------------------------
	@GetMapping("/search")

	public String searchProducts(@RequestParam("query") String query, Model model) {
		if (query != null) {
			List<TicketTracker> ticket = ticketService.searchTickets(query);
			model.addAttribute("query", query);
			model.addAttribute("ticket", ticket);
		} else {
			List<TicketTracker> ticket = ticketService.listTickets();
			model.addAttribute("ticket", ticket);

		}
		return "search_t";
	}

}
