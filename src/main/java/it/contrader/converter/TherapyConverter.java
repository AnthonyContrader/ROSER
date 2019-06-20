package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TherapyDTO;
import it.contrader.model.Therapy;

@Component
public class TherapyConverter extends AbstractConverter<Therapy,TherapyDTO> {

		@Override
		public Therapy toEntity(TherapyDTO therapyDTO) {
			Therapy therapy = null;
			if (therapyDTO != null) {
				therapy = new Therapy(therapyDTO.getId(),therapyDTO.getEndDate(),therapyDTO.getStartDate(),therapyDTO.getMedicineName(),therapyDTO.getMedicineNumber(),therapyDTO.getMedicineType());			
			}
			return therapy;
		}

		@Override
		public TherapyDTO toDTO(Therapy therapy) {
			TherapyDTO therapyDTO = null;
			if (therapy != null) {
				therapyDTO = new TherapyDTO(therapy.getId(),therapy.getEndDate(),therapy.getStartDate(),therapy.getMedicineName(),therapy.getMedicineNumber(),therapy.getMedicineType());
				
			}
			return therapyDTO;
		}
}
