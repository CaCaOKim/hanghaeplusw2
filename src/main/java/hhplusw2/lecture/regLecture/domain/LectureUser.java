package hhplusw2.lecture.regLecture.domain;

public record LectureUser(
        long regNo,
        long lectureNo,
        long userNo,
        String attendYn, // 출석여부
        long regDt
) {
}
