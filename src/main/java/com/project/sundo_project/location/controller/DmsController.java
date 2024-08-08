package com.project.sundo_project.location.controller;

import com.project.sundo_project.location.dto.DmsDto;
import com.project.sundo_project.location.service.DmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class DmsController {

    @Autowired
    private DmsService dmsService;

    @PostMapping
    public ResponseEntity<?> registerLocation(@RequestBody DmsDto dmsDto) {
        dmsService.saveDmsLocation(dmsDto);
        return ResponseEntity.ok("좌표가 등록되었습니다.");
    }
}
