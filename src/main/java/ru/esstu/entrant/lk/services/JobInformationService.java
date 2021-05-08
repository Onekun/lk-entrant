package ru.esstu.entrant.lk.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.esstu.entrant.lk.domain.dto.JobInformationDto;
import ru.esstu.entrant.lk.domain.dto.JobInformationDto;
import ru.esstu.entrant.lk.domain.mappers.JobInformationMapper;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.repositories.JobInformationRepository;

@Service
@Slf4j
public class JobInformationService {

    private final JobInformationRepository jobInformationRepository;
    private final JobInformationMapper jobInformationMapper;

    public JobInformationService(JobInformationRepository jobInformationRepository,
                                JobInformationMapper jobInformationMapper) {
        this.jobInformationRepository = jobInformationRepository;
        this.jobInformationMapper = jobInformationMapper;
    }
    public JobInformationDto getJobInformation(final int id) {
        return jobInformationMapper.toDto(jobInformationRepository.getJobInformation(id));
    }
    public JobInformationDto save(final JobInformationDto jobInformationDto) {
        JobInformation entity= jobInformationMapper.toVO(jobInformationDto);
        jobInformationRepository.save(entity);
        return jobInformationMapper.toDto(entity);
    }
    public JobInformationDto update(final JobInformationDto jobInformationDto) {
        JobInformation entity= jobInformationMapper.toVO(jobInformationDto);
        jobInformationRepository.update(entity);
        return jobInformationMapper.toDto(entity);
    }
}