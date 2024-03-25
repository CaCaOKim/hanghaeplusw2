package hhplusw2.lecture.manage.lecture.repository;

import hhplusw2.lecture.manage.lecture.domain.Lecture;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository {
    // 강의 생성 및 수정
    Lecture saveLecture(Lecture lecture);

    // 강의정보 조회
    Lecture getLecturebyUser(Lecture lecture);
}
