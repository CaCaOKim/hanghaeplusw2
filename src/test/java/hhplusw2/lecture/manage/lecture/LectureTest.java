package hhplusw2.lecture.manage.lecture;

import hhplusw2.lecture.manage.lecture.controller.LectureController;
import hhplusw2.lecture.manage.lecture.domain.Lecture;
import hhplusw2.lecture.manage.lecture.repository.LectureRepository;
import hhplusw2.lecture.manage.lecture.repositoryImpl.LectureRepositoryFakeDb;
import hhplusw2.lecture.manage.lecture.service.LectureService;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LectureTest {

    LectureController lectureController;
    LectureService lectureService;
    LectureRepository lectureRepository;

    LectureTest() {
        this.lectureRepository = new LectureRepositoryFakeDb();
        this.lectureService = new LectureService(this.lectureRepository);
        this.lectureController = new LectureController(this.lectureService);
    }

    long managerNo = 1234;

    @Test
    void 성공_Controller() throws InterruptedException {
        // 강의 정보 입력
        Lecture lectureInfo = new Lecture(0, "Backend특강", 1111, "2024-03-30", 10, "N", managerNo, System.currentTimeMillis());

        // 강의 생성
        Lecture saveLecture = this.lectureController.saveLecture(lectureInfo);

        assertThat(saveLecture.lectureNm()).isEqualTo(lectureInfo.lectureNm());
        assertThat(saveLecture.lecturerNo()).isEqualTo(lectureInfo.lecturerNo());
        assertThat(saveLecture.lectureYmd()).isEqualTo(lectureInfo.lectureYmd());
        assertThat(saveLecture.maxNum()).isEqualTo(lectureInfo.maxNum());
        assertThat(saveLecture.completeYn()).isEqualTo(lectureInfo.completeYn());
        assertThat(saveLecture.createUserNo()).isEqualTo(lectureInfo.createUserNo());

        // 강의 조회
        Lecture getLecture = this.lectureController.getLecture(saveLecture.lectureNo());

        assertThat(getLecture).isEqualTo(saveLecture);
    }

    @Test
    void 성공_Service() throws InterruptedException {
        // 강의 정보 입력
        Lecture lectureInfo = new Lecture(0, "Backend특강", 1111, "2024-03-30", 10, "N", managerNo, System.currentTimeMillis());

        // 강의 생성
        Lecture saveLecture = this.lectureService.saveLecture(lectureInfo);

        assertThat(saveLecture.lectureNm()).isEqualTo(lectureInfo.lectureNm());
        assertThat(saveLecture.lecturerNo()).isEqualTo(lectureInfo.lecturerNo());
        assertThat(saveLecture.lectureYmd()).isEqualTo(lectureInfo.lectureYmd());
        assertThat(saveLecture.maxNum()).isEqualTo(lectureInfo.maxNum());
        assertThat(saveLecture.completeYn()).isEqualTo(lectureInfo.completeYn());
        assertThat(saveLecture.createUserNo()).isEqualTo(lectureInfo.createUserNo());

        // 강의 조회
        Lecture getLecture = this.lectureService.getLecture(saveLecture.lectureNo());

        assertThat(getLecture).isEqualTo(saveLecture);
    }

    @Test
    void 유저_번호_유실_시_강의_저장_실패() throws InterruptedException {
        // 강의 정보 입력
        Lecture lectureInfo = new Lecture(0, "Backend특강", 1111, "2024-03-30", 10, "N", 0, System.currentTimeMillis());

        assertThatThrownBy(() -> {
            // 강의 생성
            this.lectureService.saveLecture(lectureInfo);
        }).isInstanceOf(RuntimeException.class);
    }
}
