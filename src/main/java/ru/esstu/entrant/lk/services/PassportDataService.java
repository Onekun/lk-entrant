package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.PassportDataDto;
import ru.esstu.entrant.lk.domain.dto.PassportDataDto;
import ru.esstu.entrant.lk.domain.mappers.PassportDataMapper;
import ru.esstu.entrant.lk.domain.vo.PassportData;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.domain.vo.PassportData;
import ru.esstu.entrant.lk.repositories.PassportDataRepository;

@Service
@Slf4j
public class PassportDataService {

    private final PassportDataRepository passportDataRepository;
    private final PassportDataMapper passportDataMapper;
    private final AccessService accessService;

    public PassportDataService(PassportDataRepository passportDataRepository,
                               PassportDataMapper passportDataMapper,
                               AccessService accessService) {
        this.passportDataRepository = passportDataRepository;
        this.passportDataMapper = passportDataMapper;
        this.accessService = accessService;
    }

    public PassportDataDto getPassportData(final int id) {
        accessService.commonAccessCheck(id);
        PassportDataDto temp= passportDataMapper.toDto(passportDataRepository.getPassportData(id));
        if(temp==null){
            temp=new PassportDataDto();
            return temp;
        }
        return temp;
    }
    public PassportDataDto save(final PassportDataDto passportDataDto) {
        accessService.commonAccessCheck(passportDataDto.getEntrantId());
        PassportData entity= passportDataMapper.toVO(passportDataDto);
        passportDataRepository.save(entity);
        return passportDataMapper.toDto(entity);
    }
    public PassportDataDto update(final PassportDataDto passportDataDto) {
        accessService.commonAccessCheck(passportDataDto.getEntrantId());
        PassportData entity= passportDataMapper.toVO(passportDataDto);
        passportDataRepository.update(entity);
        return passportDataMapper.toDto(entity);
    }
}
