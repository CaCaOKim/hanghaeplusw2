package hhplusw2.lecture.regLecture;

import hhplusw2.lecture.manage.lecture.controller.LectureController;
import hhplusw2.lecture.manage.lecture.domain.Lecture;
import hhplusw2.lecture.manage.lecture.repository.LectureRepository;
import hhplusw2.lecture.manage.lecture.repositoryImpl.LectureRepositoryFakeDb;
import hhplusw2.lecture.manage.lecture.service.LectureService;
import hhplusw2.lecture.regLecture.controller.RegLectureController;
import hhplusw2.lecture.regLecture.repository.RegLectureRepository;
import hhplusw2.lecture.regLecture.repositoryImpl.RegLectureRepositoryFakeDb;
import hhplusw2.lecture.regLecture.service.RegLectureService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RegLectureTest {

    RegLectureController regLectureController;
    RegLectureService regLectureService;
    RegLectureRepository regLectureRepository;
    LectureRepository lectureRepository;
    LectureController lectureController;
    LectureService lectureService;

    RegLectureTest() {
        this.regLectureRepository = new RegLectureRepositoryFakeDb();
        this.lectureRepository = new LectureRepositoryFakeDb();
        this.regLectureService = new RegLectureService(this.regLectureRepository, this.lectureRepository);
        this.regLectureController = new RegLectureController(this.regLectureService);
        this.lectureService = new LectureService(this.lectureRepository);
        this.lectureController = new LectureController(this.lectureService);
    }

    long managerNo = 1234;
    long registerNo = 1112;

    @Test
    void 성공_Controller() throws InterruptedException {
        // 강의 정보 입력
        Lecture lectureInfo = new Lecture(0, "Backend특강", 1111, "2024-03-30", 10, "N", managerNo, System.currentTimeMillis());

        // 수강 생성
        Lecture backendLecture = this.lectureController.saveLecture(lectureInfo);

        // 수강신청
        Lecture regedLecture = this.regLectureController.regLecture(backendLecture.lectureNo(), registerNo);

        assertThat(regedLecture).isEqualTo(backendLecture);

        // 수강신청한 강의 정보 조회
        Lecture myLecture = this.regLectureController.getLectureByUserAndLecture(backendLecture.lectureNo(), registerNo);

        assertThat(myLecture).isEqualTo(regedLecture);
    }

    @Test
    void 성공_Service() throws InterruptedException {
        // 강의 정보 입력
        Lecture lectureInfo = new Lecture(0, "Backend특강", 1111, "2024-03-30", 10, "N", managerNo, System.currentTimeMillis());

        // 수강 생성
        Lecture backendLecture = this.lectureService.saveLecture(lectureInfo);

        // 수강신청
        Lecture regedLecture = this.regLectureService.regLecture(backendLecture.lectureNo(), registerNo);

        assertThat(regedLecture).isEqualTo(backendLecture);

        // 수강신청한 강의 정보 조회
        Lecture myLecture = this.regLectureService.getLectureByUserAndLecture(backendLecture.lectureNo(), registerNo);

        assertThat(myLecture).isEqualTo(regedLecture);
    }

    @Test
    void 유저_번호_유실_시_수강신청_실패() throws InterruptedException {
        // 강의 정보 입력
        Lecture lectureInfo = new Lecture(0, "Backend특강", 1111, "2024-03-30", 30, "N", managerNo, System.currentTimeMillis());

        // 수강 생성
        Lecture backendLecture = this.lectureService.saveLecture(lectureInfo);

        assertThatThrownBy(() -> {
            // 수강신청
            this.regLectureService.regLecture(backendLecture.lectureNo(), 0);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 유저_번호_유실_시_신청한_강의_조회_실패() throws InterruptedException {
        // 강의 정보 입력
        Lecture lectureInfo = new Lecture(0, "Backend특강", 1111, "2024-03-30", 30, "N", managerNo, System.currentTimeMillis());

        // 수강 생성
        Lecture backendLecture = this.lectureService.saveLecture(lectureInfo);

        // 수강신청
        this.regLectureService.regLecture(backendLecture.lectureNo(), registerNo);

        assertThatThrownBy(() -> {
            // 수강신청한 강의 정보 조회
            this.regLectureService.getLectureByUserAndLecture(backendLecture.lectureNo(), 0);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 수강인원_초과_시_수강신청_실패() throws InterruptedException {
        // 강의 정보 입력
        Lecture lectureInfo = new Lecture(0, "Backend특강", 1111, "2024-03-30", 5, "N", managerNo, System.currentTimeMillis());

        // 수강 생성
        Lecture backendLecture = this.lectureService.saveLecture(lectureInfo);

        // 최대 수강 인원까지 수강신청
        this.regLectureService.regLecture(backendLecture.lectureNo(), 10001);
        this.regLectureService.regLecture(backendLecture.lectureNo(), 10002);
        this.regLectureService.regLecture(backendLecture.lectureNo(), 10003);
        this.regLectureService.regLecture(backendLecture.lectureNo(), 10004);
        this.regLectureService.regLecture(backendLecture.lectureNo(), 10005);

        assertThatThrownBy(() -> {
            // 초과 수강신청
            this.regLectureService.regLecture(backendLecture.lectureNo(), 10006);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 한_사람이_동일한_강의를_중복하여_수강신청_시_실패() throws InterruptedException {
        // 강의 정보 입력
        Lecture lectureInfo = new Lecture(0, "Backend특강", 1111, "2024-03-30", 30, "N", managerNo, System.currentTimeMillis());

        // 수강 생성
        Lecture backendLecture = this.lectureService.saveLecture(lectureInfo);

        // 여러 인원 수강신청
        this.regLectureService.regLecture(backendLecture.lectureNo(), 10001);
        this.regLectureService.regLecture(backendLecture.lectureNo(), 10002);
        this.regLectureService.regLecture(backendLecture.lectureNo(), 10003);
        this.regLectureService.regLecture(backendLecture.lectureNo(), 10004);
        this.regLectureService.regLecture(backendLecture.lectureNo(), 10005);

        assertThatThrownBy(() -> {
            // 이미 신청한 인원이 수강신청
            this.regLectureService.regLecture(backendLecture.lectureNo(), 10002);
        }).isInstanceOf(RuntimeException.class);
    }
}
