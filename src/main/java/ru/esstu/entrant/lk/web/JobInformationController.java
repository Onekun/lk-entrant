package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.JobInformationDto;
import ru.esstu.entrant.lk.domain.vo.JobInformation;
import ru.esstu.entrant.lk.services.JobInformationService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class JobInformationController {

    /**
     * Сервис.
     */
    private final JobInformationService jobInformationService;

    public JobInformationController(JobInformationService jobInformationService) {
        this.jobInformationService = jobInformationService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/JobInformation")
    public JobInformationDto get(final String id) {
        return jobInformationService.getJobInformation(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/JobInformation")
    public JobInformation save(@RequestBody final JobInformationDto jobInformationDto) {
        return jobInformationService.postJobInformation(jobInformationDto);
    }
}
