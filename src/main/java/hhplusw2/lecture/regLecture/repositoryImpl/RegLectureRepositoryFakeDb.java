package hhplusw2.lecture.regLecture.repositoryImpl;

import hhplusw2.lecture.regLecture.domain.LectureUser;
import hhplusw2.lecture.regLecture.repository.RegLectureRepository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegLectureRepositoryFakeDb implements RegLectureRepository {
    private final List<LectureUser> table = new ArrayList<>();
    private long seqRegNo = 0;

    @Override
    public long regLecture(long lectureNo, long userNo) {
        throttle(300L);
        long regNo = ++seqRegNo;
        LectureUser lectureUser = new LectureUser(seqRegNo++, lectureNo, userNo, "N", System.currentTimeMillis());
        table.add(lectureUser);
        return regNo;
    }

    @Override
    public LectureUser getLectureByRegNo(long regNo) {
        LectureUser lectureUser = null;
        List<LectureUser> lectureUsers = table.stream().filter(lu -> lu.regNo() == regNo).toList();
        if (!CollectionUtils.isEmpty(lectureUsers) && lectureUsers.size() == 1) lectureUser = lectureUsers.get(0);
        return lectureUser;
    }

    @Override
    public LectureUser getLectureByUserAndLecture(long lectureNo, long userNo) {
        LectureUser lectureUser = null;
        List<LectureUser> lectureUsers = table.stream().filter(lu -> lu.userNo() == userNo && lu.lectureNo() == lectureNo).toList();
        if (!CollectionUtils.isEmpty(lectureUsers) && lectureUsers.size() == 1) lectureUser = lectureUsers.get(0);
        return lectureUser;
    }

    @Override
    public List<LectureUser> getLecturesByLecture(long lectureNo) {
        return table.stream().filter(lu -> lu.lectureNo() == lectureNo).toList();
    }

    private void throttle(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep((long) (Math.random() * millis));
        } catch (InterruptedException ignored) {

        }
    }
}
