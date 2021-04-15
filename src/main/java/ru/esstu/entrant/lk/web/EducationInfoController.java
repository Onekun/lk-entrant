package ru.esstu.entrant.lk.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.esstu.entrant.lk.domain.dto.EducationInfoDto;
import ru.esstu.entrant.lk.domain.vo.EducationInfo;
import ru.esstu.entrant.lk.services.EducationInfoService;

/**
 * API Profile.
 */
@RestController
@Slf4j
public class EducationInfoController {

    /**
     * Сервис.
     */
    private final EducationInfoService educationInfoService;

    public EducationInfoController(EducationInfoService educationInfoService) {
        this.educationInfoService = educationInfoService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/EducationInfo")
    public EducationInfoDto get(final String id) {

        return educationInfoService.getEducationInfo(id);
    }
    @RequestMapping(method = RequestMethod.POST, path = "/EducationInfo")
    public EducationInfo save(@RequestBody final EducationInfoDto educationInfoDto) {
        return educationInfoService.postEducationInfo(educationInfoDto);
    }
}
