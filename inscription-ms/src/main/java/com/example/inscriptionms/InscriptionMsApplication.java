package com.example.inscriptionms;

import com.example.inscriptionms.model.CategorieCour;
import com.example.inscriptionms.model.Cour;
import com.example.inscriptionms.model.Difficulte;
import com.example.inscriptionms.proxy.Enseignant;
import com.example.inscriptionms.proxy.EnseignantProxy;
import com.example.inscriptionms.repository.CategorieCourRepository;
import com.example.inscriptionms.repository.CourRepository;
import com.example.inscriptionms.service.CourServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@SpringBootApplication
@EnableFeignClients
public class InscriptionMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InscriptionMsApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CourRepository courRepository, CategorieCourRepository categorieCourRepository, EnseignantProxy enseignantProxy, CourServiceImpl courService){
		return args -> {
//			Enseignant enseignant = enseignantProxy.findEnseignantById(1L);
//			System.out.println(enseignant);

//			HttpServletRequest request = ( (ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
//			System.out.println(request);
			categorieCourRepository.save(new CategorieCour(null,"Computer Science", null ));
			categorieCourRepository.save(new CategorieCour(null,"Data Science", null ));
			categorieCourRepository.save(new CategorieCour(null,"Business", null ));
			categorieCourRepository.save(new CategorieCour(null,"Physics", null ));
			CategorieCour categorieCourCS = categorieCourRepository.findByType("Computer Science").get();
			CategorieCour categorieCourBs = categorieCourRepository.findByType("Business").get();
			CategorieCour categorieCourPh = categorieCourRepository.findByType("Physics").get();
			courRepository.save(new Cour(null,"c'est une description du cour", Difficulte.FACILE, "Advanced NodeJS", 4, 4L ,null, categorieCourCS, null ,"/work-2.jpg"));
			courRepository.save(new Cour(null,"c'est une description du cour", Difficulte.DIFFICILE, "Introduction to React", 4, 4L ,null, categorieCourCS, null, "/work-1.jpg" ));
			courRepository.save(new Cour(null,"c'est une description du cour", Difficulte.MOYEN, "Angular", 4, 4L ,null, categorieCourCS, null, "/work-3.jpg" ));
			courRepository.save(new Cour(null,"c'est une description du cour", Difficulte.FACILE, "Spring Boot", 4, 4L ,null, categorieCourCS, null, "/work-4.jpg" ));
			courRepository.save(new Cour(null,"c'est une description du cour", Difficulte.MOYEN, "Physics For Babies", 4, 4L ,null, categorieCourPh, null, "/work-5.jpg" ));
			courRepository.save(new Cour(null,"c'est une description du cour", Difficulte.MOYEN, "Quantum Physics", 4, 4L ,null, categorieCourPh, null, "/work-2.jpg" ));
			courRepository.save(new Cour(null,"c'est une description du cour", Difficulte.FACILE, "A Successful Business Man", 4, 4L ,null, categorieCourBs, null, "/work-6.jpg" ));
			courRepository.save(new Cour(null,"c'est une description du cour", Difficulte.FACILE, "Founding A new bUSINESS", 4, 4L ,null, categorieCourBs, null, "/work-3.jpg" ));

//			courService.getAllCoursContains("s").forEach(cour -> {
//				System.out.println(cour);
//			});
		};
	}

}
