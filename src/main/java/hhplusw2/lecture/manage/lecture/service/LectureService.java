package hhplusw2.lecture.manage.lecture.service;

import hhplusw2.lecture.manage.lecture.repository.LectureRepository;
import org.springframework.stereotype.Service;

@Service
public class LectureService {
    LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }
}
