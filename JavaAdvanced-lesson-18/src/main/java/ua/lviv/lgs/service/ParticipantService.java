package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.ParticipantRepo;
import ua.lviv.lgs.domain.Participant;

@Service
public class ParticipantService {

	@Autowired
	private ParticipantRepo repo;

	public List<Participant> findAllParticipants() {
		return repo.findAllParticipants();
	}

	public Participant getOne(int id) {
		return repo.getOne(id);
	}

	public void save(Participant participant) {
		repo.save(participant);
	}

	public void delete(int id) {
		repo.delete(id);
	}

}
