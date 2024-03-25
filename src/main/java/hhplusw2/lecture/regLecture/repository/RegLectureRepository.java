package hhplusw2.lecture.regLecture.repository;

import hhplusw2.lecture.regLecture.domain.LectureUser;
import org.springframework.stereotype.Repository;

@Repository
public interface RegLectureRepository {
    // 강의 신청
    LectureUser regLecture(long lectureNo, long userNo);

    // 강의신청 확인 조회 조회(강의신청여부 조회)
    LectureUser getLecturebyUser(long lectureNo, long userNo);
}
