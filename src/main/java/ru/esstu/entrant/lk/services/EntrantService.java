package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.EntrantDto;
import ru.esstu.entrant.lk.domain.dto.EntrantDto;
import ru.esstu.entrant.lk.domain.mappers.EntrantMapper;
import ru.esstu.entrant.lk.domain.vo.Entrant;
import ru.esstu.entrant.lk.domain.vo.Entrant;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.repositories.EntrantRepository;

@Service
@Slf4j
public class EntrantService {

    private final EntrantRepository entrantRepository;
    private final EntrantMapper entrantMapper;

    public EntrantService(EntrantRepository entrantRepository,
                          EntrantMapper entrantMapper) {
        this.entrantRepository = entrantRepository;
        this.entrantMapper = entrantMapper;
    }

    public EntrantDto getEntrant(final int id) {
        return entrantMapper.toDto(entrantRepository.getEntrant(id));
    }

    public EntrantDto update(final EntrantDto entrantDto) {
        Entrant entity = entrantMapper.toVO(entrantDto);
        entrantRepository.update(entity);
        return entrantMapper.toDto(entity);
    }

    public Entrant getOrCreateEntrantByKeycloakGuid(final String guid) {
        Entrant entrant = entrantRepository.getEntrantByKeycloakGuid(guid);
        if (entrant == null) {
            Entrant newEntrant = new Entrant();
            newEntrant.setLogin("keycloak"); //пока не используется
            newEntrant.setPassword("keycloak"); //пока не используется
            entrantRepository.save(newEntrant, guid);
            return newEntrant;
        }
        return entrant;
    }
    /*public EntrantDto updateStatus(final EntrantDto entrantDto) {
        Entrant entity= entrantRepository.getEntrant(entrantDto.id);
        entrantRepository.update(entity);
        return entrantMapper.toDto(entity);
    }*/
}
