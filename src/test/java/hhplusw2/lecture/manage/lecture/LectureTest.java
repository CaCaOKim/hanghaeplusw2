package hhplusw2.lecture.manage.lecture;

import hhplusw2.lecture.manage.lecture.controller.LectureController;
import hhplusw2.lecture.manage.lecture.repository.LectureRepository;
import hhplusw2.lecture.manage.lecture.repositoryImpl.LectureRepositoryFakeDb;
import hhplusw2.lecture.manage.lecture.repositoryImpl.LectureRepositoryImpl;
import hhplusw2.lecture.manage.lecture.service.LectureService;

import org.junit.jupiter.api.Test;

public class LectureTest {

    LectureController lectureController;
    LectureService lectureService;
    LectureRepository lectureRepository;

    LectureTest() {
        this.lectureRepository = new LectureRepositoryFakeDb();
        this.lectureService = new LectureService(this.lectureRepository);
        this.lectureController = new LectureController(this.lectureService);
    }

    @Test
    void 성공() {

    }
}
