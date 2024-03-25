package hhplusw2.lecture.regLecture.service;

import hhplusw2.lecture.regLecture.repository.RegLectureRepository;
import org.springframework.stereotype.Service;

@Service
public class RegLectureService {
    RegLectureRepository regLectureRepository;

    public RegLectureService(RegLectureRepository regLectureRepository) {
        this.regLectureRepository = regLectureRepository;
    }
}
