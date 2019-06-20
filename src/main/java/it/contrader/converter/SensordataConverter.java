package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.SensordataDTO;
import it.contrader.model.Sensordata;

@Component
public class SensordataConverter extends AbstractConverter<Sensordata,SensordataDTO> {

		@Override
		public Sensordata toEntity(SensordataDTO sensordataDTO) {
			Sensordata sensordata = null;
			if (sensordataDTO != null) {
				sensordata = new Sensordata(sensordataDTO.getId(),sensordataDTO.getDataDate(),sensordataDTO.getDecibel(),sensordataDTO.getHumidity(),sensordataDTO.getFaceExpress() , sensordataDTO.getPatientName(),sensordataDTO.getPatientSurname(),sensordataDTO.getRobotModel());			
			}
			return sensordata;
		}

		@Override
		public SensordataDTO toDTO(Sensordata sensordata) {
			SensordataDTO sensordataDTO = null;
			if (sensordata != null) {
				sensordataDTO = new SensordataDTO(sensordata.getId(),sensordata.getDataDate(),sensordata.getDecibel(),sensordata.getHumidity(),sensordata.getFaceExpress(),sensordata.getPatientName(),sensordata.getPatientSurname(), sensordata.getRobotModel());
				
			}
			return sensordataDTO;
		}
}
