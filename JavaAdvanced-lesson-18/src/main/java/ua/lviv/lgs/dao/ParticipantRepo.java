package ua.lviv.lgs.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Level;
import ua.lviv.lgs.domain.Participant;

@Repository
public class ParticipantRepo {

	List<Participant> participants = new ArrayList<>();

	public List<Participant> findAllParticipants() {
		return participants;
	}

	public Participant getOne(int id) {
		return participants.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	}

	public void save(Participant participant) {
		Participant participantToUpdate = null;

		if (participant.getId() != null) {
			participantToUpdate = getOne(participant.getId());
			int participantIndex = participants.indexOf(participantToUpdate);
			participantToUpdate.setName(participant.getName());
			participantToUpdate.setEmail(participant.getEmail());
			participantToUpdate.setPrimarySkill(participant.getPrimarySkill());
			participantToUpdate.setLevel(participant.getLevel());
			participants.set(participantIndex, participantToUpdate);
		} else {
			participant.setId(participants.size() + 1);
			participants.add(participant);
		}
	}

	public void delete(int id) {
		Iterator<Participant> iter = participants.iterator();
		while (iter.hasNext()) {
			if (iter.next().getId() == id) {
				iter.remove();
			}
		}
	}

	@PostConstruct
	public void init() {
		Participant participant1 = new Participant(1, "some name 1", "some email 1", "some skills 1", Level.L1);
		Participant participant2 = new Participant(2, "some name 2", "some email 2", "some skills 2", Level.L2);

		participants.add(participant1);
		participants.add(participant2);
	}

}
