package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.SensordataDTO;
import it.contrader.model.Sensordata;

public class ConverterSensordata {

	public static SensordataDTO toDTO(Sensordata sensordata) {
		SensordataDTO sensordataDTO = null;
		if (sensordata != null) {
			sensordataDTO = new SensordataDTO();
			sensordataDTO.setDataId(sensordata.getDataId());
			sensordataDTO.setRobotModel(sensordata.getRobotModel());
			sensordataDTO.setPatientName(sensordata.getPatientName());
			sensordataDTO.setPatientSurname(sensordata.getPatientSurname());
			sensordataDTO.setDecibel(sensordata.getDecibel());
			sensordataDTO.setFaceExpress(sensordata.getFaceExpress());
			sensordataDTO.setHumidity(sensordata.getHumidity());
			sensordataDTO.setDataDate(sensordata.getDataDate());
		}
		return sensordataDTO;
	}
	
	public static Sensordata toEntity(SensordataDTO sensordataDTO) {
		Sensordata sensordata = null;
		if (sensordataDTO != null) {
			sensordata = new Sensordata();
			sensordata.setDataId(sensordataDTO.getDataId());
			sensordata.setRobotModel(sensordataDTO.getRobotModel());
			sensordata.setPatientName(sensordataDTO.getPatientName());
			sensordata.setPatientSurname(sensordataDTO.getPatientSurname());
			sensordata.setDecibel(sensordataDTO.getDecibel());
			sensordata.setFaceExpress(sensordataDTO.getFaceExpress());
			sensordata.setHumidity(sensordataDTO.getHumidity());
			sensordata.setDataDate(sensordataDTO.getDataDate());
		}
		return sensordata;
	}

	public static List<SensordataDTO> toListDTO(List<Sensordata> list) {
		List<SensordataDTO> listSensordataDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Sensordata sensordata : list) {
				listSensordataDTO.add(ConverterSensordata.toDTO(sensordata));
			}
		}
		return listSensordataDTO;
	}

	public static List<Sensordata> toListEntity(List<SensordataDTO> listSensordataDTO) {
		List<Sensordata> list = new ArrayList<>();
		if (!listSensordataDTO.isEmpty()) {
			for (SensordataDTO sensordataDTO : listSensordataDTO) {
				list.add(ConverterSensordata.toEntity(sensordataDTO));
			}
		}
		return list;
	}
}
