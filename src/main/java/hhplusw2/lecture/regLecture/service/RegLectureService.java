package hhplusw2.lecture.regLecture.service;

import hhplusw2.lecture.manage.lecture.domain.Lecture;
import hhplusw2.lecture.manage.lecture.repository.LectureRepository;
import hhplusw2.lecture.regLecture.domain.LectureUser;
import hhplusw2.lecture.regLecture.repository.RegLectureRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

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
            List<LectureUser> lectureUsers = this.getLecturesByLecture(lectureNo);
            if (!CollectionUtils.isEmpty(lectureUsers) && lectureUsers.size() >= this.getMaxNum(lectureNo)) {
                throw new RuntimeException("해당 강의에 대한 빈 자리가 없습니다.");
            }
            LectureUser dupleLectureUser = this.regLectureRepository.getLectureByUserAndLecture(lectureNo, userNo);
            if (dupleLectureUser != null) {
                throw new RuntimeException("이미 강의를 신청하셨습니다.");
            }
            long regNo = this.regLectureRepository.regLecture(lectureNo, userNo);
            LectureUser lectureUser = this.regLectureRepository.getLectureByRegNo(regNo);
            lecture = this.lectureRepository.getLecture(lectureUser.lectureNo());
        } else {
            throw new RuntimeException("유저정보가 유실되었습니다.");
        }
        return lecture;
    }

    public long getMaxNum(long lectureNo) {
        Lecture lecture = this.lectureRepository.getLecture(lectureNo);
        return lecture.maxNum();
    }

    // 신청한 강의 조회(특강신청여부 조회)
    public Lecture getLectureByUserAndLecture(long lectureNo, long userNo) throws InterruptedException {
        Lecture lecture = null;
        if (userNo > 0) { // 세션 에러 등으로 인한 접속 유실 시 조회 불가
            LectureUser lectureUser = this.regLectureRepository.getLectureByUserAndLecture(lectureNo, userNo);
            lecture = this.lectureRepository.getLecture(lectureUser.lectureNo());
        } else {
            throw new RuntimeException("유저정보가 유실되었습니다.");
        }
        return lecture;
    }

    // 강의 신청한 인원 조회
    public List<LectureUser> getLecturesByLecture(long lectureNo) throws InterruptedException {
        return this.regLectureRepository.getLecturesByLecture(lectureNo);
    }
}
