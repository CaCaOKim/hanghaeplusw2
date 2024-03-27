package hhplusw2.lecture.manage.lecture.service;

import hhplusw2.lecture.manage.lecture.domain.Lecture;
import hhplusw2.lecture.manage.lecture.repository.LectureRepository;
import org.springframework.stereotype.Service;

@Service
public class LectureService {
    LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    // 강의 생성 및 수정
    public Lecture saveLecture(Lecture lecture) throws InterruptedException {
        Lecture savedLecture = null;
        if (lecture.createUserNo() > 0) { // 세션 에러 등으로 인한 접속 유실 시 생성 및 수정 불가
            long lectureNo = this.lectureRepository.saveLecture(lecture.lectureNo(), lecture.lectureNm(), lecture.lecturerNo(), lecture.lectureYmd(), lecture.maxNum(), lecture.completeYn(), lecture.createUserNo());
            savedLecture = this.lectureRepository.getLecture(lectureNo);
        } else {
            throw new RuntimeException("유저정보가 유실되었습니다.");
        }
        return savedLecture;
    }

    // 강의번호로 강의정보 조회
    public Lecture getLecture(long lectureNo) throws InterruptedException {
        return this.lectureRepository.getLecture(lectureNo);
    }
}
