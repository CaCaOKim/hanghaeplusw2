package hhplusw2.lecture.manage.lecture.controller;

import hhplusw2.lecture.manage.lecture.service.LectureService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage/lecture")
public class LectureController {
    LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    // 강의 생성 및 수정
//    @GetMapping("/save")
//    public Lecture saveLecture(@RequestBody Lecture lecture) throws InterruptedException {
//        return lectureService.getPoint(id);
//    }

    // 강의 조회
}
