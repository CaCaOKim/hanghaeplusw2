package hhplusw2.lecture.regLecture;

import hhplusw2.lecture.manage.lecture.repository.LectureRepository;
import hhplusw2.lecture.manage.lecture.repositoryImpl.LectureRepositoryFakeDb;
import hhplusw2.lecture.regLecture.controller.RegLectureController;
import hhplusw2.lecture.regLecture.repository.RegLectureRepository;
import hhplusw2.lecture.regLecture.repositoryImpl.RegLectureRepositoryFakeDb;
import hhplusw2.lecture.regLecture.repositoryImpl.RegLectureRepositoryImpl;
import hhplusw2.lecture.regLecture.service.RegLectureService;
import org.junit.jupiter.api.Test;

public class RegLectureTest {

    RegLectureController regLectureController;
    RegLectureService regLectureService;
    RegLectureRepository regLectureRepository;
    LectureRepository lectureRepository;

    RegLectureTest() {
        this.regLectureRepository = new RegLectureRepositoryFakeDb();
        this.lectureRepository = new LectureRepositoryFakeDb();
        this.regLectureService = new RegLectureService(this.regLectureRepository, this.lectureRepository);
        this.regLectureController = new RegLectureController(this.regLectureService);
    }

    @Test
    void 성공() {

    }
}
