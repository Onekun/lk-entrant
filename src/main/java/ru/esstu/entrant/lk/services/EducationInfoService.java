package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.EducationInfoDto;
import ru.esstu.entrant.lk.domain.mappers.EducationInfoMapper;
import ru.esstu.entrant.lk.domain.vo.EducationInfo;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.repositories.EducationInfoRepository;

@Service
@Slf4j
public class EducationInfoService {

    private final EducationInfoRepository educationInfoRepository;
    private final EducationInfoMapper educationInfoMapper;

    public EducationInfoService(EducationInfoRepository educationInfoRepository,
                                    EducationInfoMapper educationInfoMapper) {
        this.educationInfoRepository = educationInfoRepository;
        this.educationInfoMapper = educationInfoMapper;
    }


    public EducationInfoDto getEducationInfo(final String id) {
        return educationInfoMapper.toDto(educationInfoRepository.getEducationInfo(id));
//        return new TestTableDto(1, "NTCN");
    }
    public EducationInfo postEducationInfo(final EducationInfoDto educationInfoDto) {
        return educationInfoMapper.toVO(educationInfoRepository.postEducationInfo(educationInfoMapper.toVO(educationInfoDto)));
    }
}