package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TherapyDTO;
import it.contrader.model.Therapy;

public class ConverterTherapy {

	public static TherapyDTO toDTO(Therapy therapy) {
		TherapyDTO therapyDTO = null;
		if (therapy != null) {
			therapyDTO = new TherapyDTO();
			therapyDTO.setTherapyId(therapy.getTherapyId());
			therapyDTO.setMedicinesType(therapy.getMedicinesType());
			therapyDTO.setMedicinesName(therapy.getMedicinesName());
			therapyDTO.setMedicinesNumber(therapy.getMedicinesNumber());
			therapyDTO.setStartDate(therapy.getStartDate());
			therapyDTO.setEndDate(therapy.getEndDate());
		}
		return therapyDTO;
	}
	
	public static Therapy toEntity(TherapyDTO therapyDTO) {
		Therapy therapy = null;
		if (therapyDTO != null) {
			therapy = new Therapy();
			therapy.setTherapyId(therapyDTO.getTherapyId());
			therapy.setMedicinesType(therapyDTO.getMedicinesType());
			therapy.setMedicinesName(therapyDTO.getMedicinesName());
			therapy.setMedicinesNumber(therapyDTO.getMedicinesNumber());
			therapy.setStartDate(therapyDTO.getStartDate());
			therapy.setEndDate(therapyDTO.getEndDate());
		}
		return therapy;
	}

	public static List<TherapyDTO> toListDTO(List<Therapy> list) {
		List<TherapyDTO> listTherapyDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Therapy therapy : list) {
				listTherapyDTO.add(ConverterTherapy.toDTO(therapy));
			}
		}
		return listTherapyDTO;
	}

	public static List<Therapy> toListEntity(List<TherapyDTO> listTherapyDTO) {
		List<Therapy> list = new ArrayList<>();
		if (!listTherapyDTO.isEmpty()) {
			for (TherapyDTO therapyDTO : listTherapyDTO) {
				list.add(ConverterTherapy.toEntity(therapyDTO));
			}
		}
		return list;
	}
}
