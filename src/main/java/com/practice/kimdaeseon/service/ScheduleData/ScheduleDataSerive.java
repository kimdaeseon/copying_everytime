package com.practice.kimdaeseon.service.ScheduleData;

import com.practice.kimdaeseon.domain.scheduleData.ScheduleDataRepository;
import com.practice.kimdaeseon.domain.subject.Subject;
import com.practice.kimdaeseon.domain.subject.SubjectRepository;
import com.practice.kimdaeseon.web.dto.ScheduleDataListResponseDto;
import com.practice.kimdaeseon.web.dto.ScheduleDataSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ScheduleDataSerive {
    final private ScheduleDataRepository scheduleDataRepository;
    final private SubjectRepository subjectRepository;

    @Transactional
    public Long save(ScheduleDataSaveRequestDto scheduleDataSaveRequestDto){
        return scheduleDataRepository.save(scheduleDataSaveRequestDto.toEntity()).getId();
    }

    public List<ScheduleDataListResponseDto> findAllScheduleDataUseScheduleName(String scheduleName){
        List<String> list = this.scheduleDataRepository.getSubjectUseUserName(scheduleName);
        List<ScheduleDataListResponseDto> result = new ArrayList<>();
        Subject temp = new Subject();
        for(int i = 0 ; i < list.size(); i++){
            temp = this.subjectRepository.findSubjectByName(list.get(i));
            result.add(ScheduleDataListResponseDto.builder().name(temp.getName()).finishTime(temp.getFinishTime()).startTime(temp.getStartTime()).credit(temp.getCredit()).day(temp.getDay()).build());
        }
        return result;
    }
}
