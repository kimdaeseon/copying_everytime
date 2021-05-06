package com.practice.kimdaeseon.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.practice.kimdaeseon.service.ScheduleData.ScheduleDataSerive;
import com.practice.kimdaeseon.service.schedule.ScheduleService;
import com.practice.kimdaeseon.web.dto.ScheduleDataListResponseDto;
import com.practice.kimdaeseon.web.dto.ScheduleDataSaveRequestDto;
import com.practice.kimdaeseon.web.dto.ScheduleSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleDataSerive scheduleDataSerive;
    @PostMapping("/api/v1/schedule/save")
    public Long save(@RequestBody ScheduleSaveRequestDto scheduleSaveRequestDto){
        return scheduleService.save(scheduleSaveRequestDto);
    }

    @PostMapping("/api/v1/schedule/addSubject")
    public void add(@RequestBody List<ScheduleDataSaveRequestDto> listOfScheduleDataSaveRequestDto){
        System.out.print("여기까지는 옴 킹무튼 옴");
        for(int i = 0 ; i < listOfScheduleDataSaveRequestDto.size(); i++){
            scheduleDataSerive.save(listOfScheduleDataSaveRequestDto.get(i));
        }
    }

    @RequestMapping(value="/api/v1/schedule/initialize", method=RequestMethod.POST)
    public void initialize_schedule(HttpServletResponse rs, @RequestBody String ScheduleName){
        System.out.print(ScheduleName);
        List<ScheduleDataListResponseDto> list = scheduleDataSerive.findAllScheduleDataUseScheduleName(ScheduleName);
        Gson gson = new Gson();
        String jso = gson.toJson(list);
        System.out.println(jso);
        rs.setContentType("text/html;charset=UTF-8");
        try{
            rs.getWriter().print(jso);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
