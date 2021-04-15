package com.practice.kimdaeseon.service.schedule;

import com.practice.kimdaeseon.domain.schedule.ScheduleRepository;
import com.practice.kimdaeseon.web.dto.ScheduleSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ScheduleService {
    final private ScheduleRepository scheduleRepository;

    @Transactional
    public Long save(ScheduleSaveRequestDto scheduleSaveRequestDto){
        return scheduleRepository.save(scheduleSaveRequestDto.toEntity()).getId();
    }
}
