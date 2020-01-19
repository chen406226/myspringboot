package Demo.Hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
public class Hello {
	@RequestMapping("/hello")
	 public String index() {
        return "Hello World hello";
    }
	@RequestMapping("/getDemo")
	public Demo getDemo(){
		Demo demo = new Demo();
		demo.setId(1);
		demo.setName("陈坤");
		return demo;
	}
}
