package com.practice.kimdaeseon.service.subject;

import com.practice.kimdaeseon.domain.subject.Subject;
import com.practice.kimdaeseon.domain.subject.SubjectRepository;
import com.practice.kimdaeseon.web.dto.SubjectListResponseDto;
import com.practice.kimdaeseon.web.dto.SubjectSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SubjectService {
    final private SubjectRepository subjectRepository;

    @Transactional
    public Long save(SubjectSaveRequestDto subjectSaveRequestDto){
        return this.subjectRepository.save(subjectSaveRequestDto.toEntity()).getId();
    }

    public List<SubjectListResponseDto> findAllSubject(){
        return this.subjectRepository.findAll().stream().map(SubjectListResponseDto::new).collect(Collectors.toList());
    }
}
