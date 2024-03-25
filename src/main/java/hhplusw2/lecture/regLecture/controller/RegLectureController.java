package hhplusw2.lecture.regLecture.controller;

import hhplusw2.lecture.regLecture.service.RegLectureService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage/lecture")
public class RegLectureController {
    RegLectureService regLectureService;

    public RegLectureController(RegLectureService regLectureService) {
        this.regLectureService = regLectureService;
    }

    // 수강신청
//    @GetMapping("/register")
//    public Lecture regLecture(@PathVariable long lectureNo, @PathVariable long userNo) throws InterruptedException {
//        return lectureService.regLecture(lectureNo, userNo);
//    }

    // 신청한 강의 조회(수강신청여부 조회)
}
