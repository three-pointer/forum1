package forum1.demo.controller.controller;

import forum1.demo.controller.Model.Question;
import forum1.demo.controller.Model.User;
import forum1.demo.controller.mapper.QuestionMapper;
import forum1.demo.controller.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/publish")
    public String publish(){

        return "publish";
    }
    @PostMapping("publish")
    public String publishs(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model
            )
    {


        User user=null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String value = cookie.getValue();
                     user = userMapper.findToken(value);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                        Question question = new Question();
                        question.setTitle(title);
                        question.setDescription(description);
                        question.setTag(tag);
                        question.setCreator(user.getId());
                        question.setGmtCreate(System.currentTimeMillis());
                        question.setGmtModified(question.getGmtCreate());
                        questionMapper.create(question);
                        if ((title==null||title=="")||(description==null||description=="")||(tag==null||tag=="")){
                            model.addAttribute("error","请填写完整所有信息");
                            return "publish";
                        }
                        return "redirect:/";
                    }
                    break;
                }
            }
        }
        if (user==null){

            model.addAttribute("error","请先登录");
        }
        return "publish";
    }

}
