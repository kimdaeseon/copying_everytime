package com.practice.kimdaeseon.service.schedule;

import com.practice.kimdaeseon.domain.schedule.ScheduleRepository;
import com.practice.kimdaeseon.web.dto.BoardListResponseDto;
import com.practice.kimdaeseon.web.dto.PostListResponseDto;
import com.practice.kimdaeseon.web.dto.ScheduleListResponseDto;
import com.practice.kimdaeseon.web.dto.ScheduleSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ScheduleService {
    final private ScheduleRepository scheduleRepository;

    @Transactional
    public Long save(ScheduleSaveRequestDto scheduleSaveRequestDto){
        return scheduleRepository.save(scheduleSaveRequestDto.toEntity()).getId();
    }

    public List<ScheduleListResponseDto> findAllScheduleAt(int number){
        List<ScheduleListResponseDto> list = scheduleRepository.findAll().stream().map(ScheduleListResponseDto::new).collect(Collectors.toList());
        List<ScheduleListResponseDto> temp = new ArrayList<>();

        int size = list.size();
        if(size >= number + 10) size = number + 10;
        for(int i = number * 10; i < size; i++){
            temp.add(list.get(i));
        }
        return temp;
    }
    public List<Integer> getScheduleSize(){
        List<ScheduleListResponseDto> list = scheduleRepository.findAll().stream().map(ScheduleListResponseDto::new).collect(Collectors.toList());
        int size = list.size() / 10 + 1;
        List<Integer> temp = new ArrayList<>();
        for(int i = 1; i <= size; i++){
            temp.add(i);
        }
        return temp;
    }
}
