package hh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @GetMapping("/practice")
    public ModelAndView toInteraction(ModelAndView view) {
        view = new ModelAndView("/hello");
        return view;
    }


    @GetMapping("/scmTest")
    @ResponseBody
    public String scmTest(ModelAndView view) {
        return  "scmT测试";
    }
    @GetMapping("/string")
    @ResponseBody
    public String toT(ModelAndView view) {
        return  "hello";
    }
    @GetMapping("/judge")
    @ResponseBody
    public String judge(ModelAndView view,
                        @RequestParam(value = "string",required = false,defaultValue = " ") String s) {
        System.out.println(s);
        if(this.backspaceCompare(s,"abc")){

            return "和abc相同";
        }else{
            return "不等于abc";
        }
    }
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
}
