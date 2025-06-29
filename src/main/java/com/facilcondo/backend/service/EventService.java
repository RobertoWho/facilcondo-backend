package com.facilcondo.backend.service;

import com.facilcondo.backend.advice.exception.NotFoundException;
import com.facilcondo.backend.model.Event;
import com.facilcondo.backend.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public List<Event> getAll() {
        return repository.findAll();
    }

    public Event getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Event not found at this ID:" + id));
    }

    public Event create(Event event) {
        return repository.save(event);
    }

    public Event update(Long id, Event updated) {
        Event existing = getById(id);
        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setDateTime(updated.getDateTime());
        existing.setCondominium(updated.getCondominium());
        existing.setCreatedBy(updated.getCreatedBy());
        existing.setInvitedUserIds(updated.getInvitedUserIds());
        existing.setNotes(updated.getNotes());
        existing.setAttachments(updated.getAttachments());
        existing.setIsActive(updated.getIsActive());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("Event not found at this ID:" + id));
        repository.deleteById(id);
    }
}
