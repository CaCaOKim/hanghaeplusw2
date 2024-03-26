package hhplusw2.lecture.manage.lecture.repositoryImpl;

import hhplusw2.lecture.manage.lecture.domain.Lecture;
import hhplusw2.lecture.manage.lecture.repository.LectureRepository;

public class LectureRepositoryImpl implements LectureRepository {
    @Override
    public long saveLecture(long lectureNo, String lectureNm, long lecturerNo, String lectureYmd, long maxNum, String completeYn, long createUserNo) {
        return 0;
    }

    @Override
    public Lecture getLecture(long lectureNo) {
        return null;
    }
}
