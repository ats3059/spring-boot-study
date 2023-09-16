package hello.controller.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class TrafficController {

    @GetMapping("/cpu")
    public String cpu() {
        log.info("cpu");
        long value = 0;
        // 그라파나 차트를 위해서 cpu 사용량 올리기
        for (long i = 0; i < 10000000000L; i++) {
            value++;
        }
        return "ok value =" + value;
    }

    private List<String> list = new ArrayList<>();

    @GetMapping("/jvm")
    public String jvm(){
        log.info("jvm");
        for (int i = 0; i < 1000000L; i++) {
            list.add("hello jvm" + i);
        }
        return "ok";
    }

    @Autowired
    DataSource dataSource;

    @GetMapping("/jdbc")
    public String jdbc() throws Exception{
        log.info("jdbc");
        Connection connection = dataSource.getConnection();
        log.info("connection info = {}" , connection);
        // 커넥션 고갈을 위한 테스트기 떄문에 커넥션을 닫지 않는다.
//        connection.close();
        return "ok";
    }


}
