package hhplusw2.lecture.regLecture.repositoryImpl;

import hhplusw2.lecture.regLecture.domain.LectureUser;
import hhplusw2.lecture.regLecture.repository.RegLectureRepository;

import java.util.List;

public class RegLectureRepositoryImpl implements RegLectureRepository {
    @Override
    public long regLecture(long lectureNo, long userNo) {
        return 0;
    }

    @Override
    public LectureUser getLectureByRegNo(long regNo) {
        return null;
    }

    @Override
    public LectureUser getLectureByUserAndLecture(long lectureNo, long userNo) {
        return null;
    }

    @Override
    public List<LectureUser> getLecturesByLecture(long lectureNo) {
        return null;
    }
}
