package hhplusw2.lecture.manage.lecture.repositoryImpl;

import hhplusw2.lecture.manage.lecture.domain.Lecture;
import hhplusw2.lecture.manage.lecture.repository.LectureRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LectureRepositoryFakeDb implements LectureRepository {
    private final Map<Long, Lecture> table = new HashMap<>();
    private long seqLecture = 0;

    @Override
    public long saveLecture(long lectureNo, String lectureNm, long lecturerNo, String lectureYmd, long maxNum, String completeYn, long createUserNo) {
        throttle(300L);
        lectureNo = lectureNo > 0 ? lectureNo : ++seqLecture;
        Lecture lecture = new Lecture(lectureNo, lectureNm, lecturerNo, lectureYmd, maxNum, completeYn, createUserNo, System.currentTimeMillis());
        table.put(lectureNo, lecture);
        return lectureNo;
    }

    @Override
    public Lecture getLecture(long lectureNo) {
        throttle(200);
        return table.containsKey(lectureNo) ? table.get(lectureNo) : null;
    }

    private void throttle(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep((long) (Math.random() * millis));
        } catch (InterruptedException ignored) {

        }
    }
}
