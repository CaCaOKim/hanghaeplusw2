package hhplusw2.lecture.regLecture.controller;

import hhplusw2.lecture.manage.lecture.domain.Lecture;
import hhplusw2.lecture.regLecture.service.RegLectureService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reglecture")
public class RegLectureController {
    RegLectureService regLectureService;

    public RegLectureController(RegLectureService regLectureService) {
        this.regLectureService = regLectureService;
    }

    // 수강신청
    @PostMapping("/register/{lectureNo}/{userNo}")
    public Lecture regLecture(@PathVariable long lectureNo, @PathVariable long userNo) throws InterruptedException {
        return this.regLectureService.regLecture(lectureNo, userNo);
    }

    // 신청한 강의 조회(수강신청여부 조회)
    @GetMapping("/getuserlecture/{lectureNo}/{userNo}")
    public Lecture getLectureByUserAndLecture(@PathVariable long lectureNo, @PathVariable long userNo) throws InterruptedException {
        return this.regLectureService.getLectureByUserAndLecture(lectureNo, userNo);
    }
}
