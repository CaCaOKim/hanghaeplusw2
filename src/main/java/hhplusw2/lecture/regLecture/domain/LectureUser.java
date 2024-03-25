package hhplusw2.lecture.regLecture.domain;

public record LectureUser(
        long lectureNo,
        long userNo,
        String attendYn // 출석여부
) {
}
