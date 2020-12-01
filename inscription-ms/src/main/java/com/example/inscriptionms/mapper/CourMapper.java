package com.example.inscriptionms.mapper;

import com.example.inscriptionms.dto.CourDto;
import com.example.inscriptionms.model.CategorieCour;
import com.example.inscriptionms.model.Cour;
import com.example.inscriptionms.model.Difficulte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class CourMapper {

    public CourDto mapToDto(Cour cour) {
        if (cour == null) return null;

        return CourDto.builder()
                .id(cour.getId())
                .categorieCour((cour.getCategorieCour()) != null ? cour.getCategorieCour().getType() : null)
                .description(cour.getDescription())
                .difficulte(cour.getDifficulte().toString())
                .enseignantID(cour.getEnseignantID())
                .nomCour(cour.getNomCour())
                .img(cour.getImg())
                .note(cour.getNote())
                .build();
    }

    public Cour map(CourDto courDto, Difficulte difficulte, CategorieCour categorieCour) {
        if (courDto == null) return null;
        return Cour.builder()
                .nomCour(courDto.getNomCour())
                .categorieCour(categorieCour)
                .description(courDto.getDescription())
                .difficulte(difficulte)
                .enseignantID(courDto.getEnseignantID())
                .img(courDto.getImg())
                .note(courDto.getNote())
                .build();
    }
}
