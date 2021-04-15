package com.practice.kimdaeseon.service.subject;

import com.practice.kimdaeseon.domain.subject.SubjectRepository;
import com.practice.kimdaeseon.web.dto.SubjectSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SubjectService {
    final private SubjectRepository subjectRepository;

    @Transactional
    public Long save(SubjectSaveRequestDto subjectSaveRequestDto){
        return this.subjectRepository.save(subjectSaveRequestDto.toEntity()).getId();
    }
}
