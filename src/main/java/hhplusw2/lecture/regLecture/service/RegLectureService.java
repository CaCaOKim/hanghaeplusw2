package hhplusw2.lecture.regLecture.service;

import hhplusw2.lecture.manage.lecture.domain.Lecture;
import hhplusw2.lecture.manage.lecture.repository.LectureRepository;
import hhplusw2.lecture.regLecture.domain.LectureUser;
import hhplusw2.lecture.regLecture.repository.RegLectureRepository;
import org.springframework.stereotype.Service;

@Service
public class RegLectureService {
    RegLectureRepository regLectureRepository;
    LectureRepository lectureRepository;

    public RegLectureService(RegLectureRepository regLectureRepository, LectureRepository lectureRepository) {
        this.regLectureRepository = regLectureRepository;
        this.lectureRepository = lectureRepository;
    }

    // 강의 신청
    public Lecture regLecture(long lectureNo, long userNo) throws InterruptedException {
        Lecture lecture = null;
        if (userNo > 0) { // 세션 에러 등으로 인한 접속 유실 시 신청 불가
            long regNo = this.regLectureRepository.regLecture(lectureNo, userNo);
            LectureUser lectureUser = this.regLectureRepository.getLectureByRegNo(regNo);
            lecture = this.lectureRepository.getLecture(lectureUser.lectureNo());
        }
        return lecture;
    }

    // 신청한 강의 조회(특강신청여부 조회)
    public Lecture getLectureByUserAndLecture(long lectureNo, long userNo) throws InterruptedException {
        Lecture lecture = null;
        if (userNo > 0) { // 세션 에러 등으로 인한 접속 유실 시 조회 불가
            LectureUser lectureUser = this.regLectureRepository.getLectureByUserAndLecture(lectureNo, userNo);
            lecture = this.lectureRepository.getLecture(lectureUser.lectureNo());
        }
        return lecture;
    }
}
