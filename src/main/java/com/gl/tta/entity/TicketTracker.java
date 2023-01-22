package com.gl.tta.entity;

import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "tickettracker")
public class TicketTracker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Ticket_title")
	private String title;

	@Column(name = "short_description")
	private String sortDescription;

	@Column(name = "content")
	private String content;

	@UpdateTimestamp // For auto-update
	@Column(nullable = false)
	private Date created_date;

	// ----------------------------------------------------- No
	// Arg-Constructor-----------------------------------------------------------------------------------------------------
	public TicketTracker() {

	}

	// -----------------------------------------------------ALL Arg
	// Constructor----------------------------------------------------------------------------------------------------
	public TicketTracker(Long id, String title, String sortDescription, String content, Date created_date) {
		// super();
		this.id = id;
		this.title = title;
		this.sortDescription = sortDescription;
		this.content = content;
		this.created_date = created_date;
	}
// ----------------------------------------------------------Getter And Setter---------------------------------------------------------------------------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSortDescription() {
		return sortDescription;
	}

	public void setSortDescription(String sortDescription) {
		this.sortDescription = sortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

}
