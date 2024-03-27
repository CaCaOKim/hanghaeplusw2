package hhplusw2.lecture.regLecture.repository;

import hhplusw2.lecture.regLecture.domain.LectureUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegLectureRepository {
    // 강의 신청
    long regLecture(long lectureNo, long userNo);

    // 신청번호로 강의 신청 조회
    LectureUser getLectureByRegNo(long regNo);

    // 강의신청 확인 조회 조회(강의신청여부 조회)
    LectureUser getLectureByUserAndLecture(long lectureNo, long userNo);

    // 강의 신청한 인원 조회
    List<LectureUser> getLecturesByLecture(long lectureNo);
}
