package com.example.mariage;

import com.example.mariage.entity.Invite;
import com.example.mariage.entity.Mariage;
import com.example.mariage.entity.Personne;
import com.example.mariage.entity.Salle;
import com.example.mariage.repo.InviteRepository;
import com.example.mariage.repo.MariageRepository;
import com.example.mariage.repo.PersonneRepository;
import com.example.mariage.repo.SalleRepository;
import com.example.mariage.service.PersonneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class MariageApplication implements CommandLineRunner {
	private final PersonneRepository personneRepository;
	private final InviteRepository inviteRepository;
	private final SalleRepository salleRepository;
	private final MariageRepository mariageRepository;
	private final PersonneService personneService;

	public MariageApplication(PersonneRepository personneRepository,
							  InviteRepository inviteRepository,
							  SalleRepository salleRepository,
							  MariageRepository mariageRepository, PersonneService personneService) {
		this.personneRepository = personneRepository;
		this.inviteRepository = inviteRepository;
		this.salleRepository = salleRepository;
		this.mariageRepository = mariageRepository;
		this.personneService = personneService;
	}


	public static void main(String[] args) {
		SpringApplication.run(MariageApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Personne fjwi = new Personne("123", "fjwi", "anas");
		personneRepository.save(fjwi);
		Invite chakir = new Invite("321", "chakir", "makir", StatutInvite.TEMOIN);
		inviteRepository.save(chakir);
		Personne mzabi = new Personne("123456", "mzabi", "chaoui");
		personneRepository.save(mzabi);
		Salle salle = new Salle("ss", "ss", "ss", 10);
		salleRepository.save(salle);

		Mariage zwaj = new Mariage(LocalDate.now(), 4, 4, 4, 4);

		/*zwaj.setPersonneHomme(fjwi);
		fjwi.getMariagesHomme().add(zwaj);*/

		zwaj.getInvites().add(chakir);
		chakir.getMariages().add(zwaj);

		mariageRepository.save(zwaj);
		inviteRepository.save(chakir);

		System.out.println(fjwi);
		System.out.println(zwaj);

		personneService.reserver(fjwi, mzabi, zwaj);

		zwaj.getInvites().remove(chakir);
		mariageRepository.save(zwaj);

		chakir.getMariages().remove(zwaj);
		inviteRepository.save(chakir);

//		inviteRepository.delete(chakir);
//		mariageRepository.delete(zwaj);

	}
}
