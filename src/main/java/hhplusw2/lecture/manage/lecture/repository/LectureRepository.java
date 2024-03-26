package hhplusw2.lecture.manage.lecture.repository;

import hhplusw2.lecture.manage.lecture.domain.Lecture;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository {
    // 강의 생성 및 수정
    public long saveLecture(long lectureNo, String lectureNm, long lecturerNo, String lectureYmd, long maxNum, String completeYn, long createUserNo);

    // 강의번호로 강의정보 조회
    public Lecture getLecture(long lectureNo);
}
