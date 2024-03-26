package hhplusw2.lecture.manage.lecture.domain;

public record Lecture(
        long lectureNo,
        String lectureNm,
        long lecturerNo, // 강사 번호 -> 강사도 유저로 등록하여 관리한다고 가정
        String lectureYmd, // 강의일 -> 시, 분, 초는 제외
        long maxNum, // 수강 신청 제한 인원
        String completeYn, // 강의 완료 여부
        long createUserNo,
        long createDt
) {
}
