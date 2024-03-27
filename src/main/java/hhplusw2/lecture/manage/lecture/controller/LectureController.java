package hhplusw2.lecture.manage.lecture.controller;

import hhplusw2.lecture.manage.lecture.domain.Lecture;
import hhplusw2.lecture.manage.lecture.service.LectureService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manage/lecture")
public class LectureController {
    LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    // 강의 생성 및 수정
    @PostMapping("/save")
    public Lecture saveLecture(@RequestBody Lecture lecture) throws InterruptedException {
        return lectureService.saveLecture(lecture);
    }

    // 강의 조회
    @GetMapping("/{lectureNo}")
    public Lecture getLecture(@PathVariable long lectureNo) throws InterruptedException {
        return lectureService.getLecture(lectureNo);
    }
}
