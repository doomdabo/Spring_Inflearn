package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log = {}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);
        //위 순서로, 로그 레벨에 따라 info면 info,warn, error이렇게 세개 나옴
        return "ok";

    }
}
