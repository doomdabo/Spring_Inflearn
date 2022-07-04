package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/hello-basic", method = RequestMethod.GET) //url들어오면 아래 메소드 실행.
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET) //url들어오면 아래 메소드 실행.
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }
    @RequestMapping(value = "/mapping-get-v2") //url들어오면 아래 메소드 실행.
    public String mappingGetV2() {
        log.info("mappingGetV2");
        return "ok";
    }
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mappingPath userId = {}",data);
        return "ok";

    }
}
