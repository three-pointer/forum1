package forum1.demo.controller.controller;

import forum1.demo.controller.Model.User;
import forum1.demo.controller.dto.AccessTokenDTO;
import forum1.demo.controller.dto.GithubUser;
import forum1.demo.controller.mapper.UserMapper;
import forum1.demo.controller.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
@Service
public class AuthorizeController {

    @Autowired
      GithubProvider githubProvider;

    @Autowired
    private  UserMapper userMapper;

    @Value("${github.client.id}")
    String id;
    @Value("${github.client.secret}")
    String secret;
    @Value("${github.redirect.uri}")
    String uri;
    @GetMapping("/callback")
    public  String callback(@RequestParam(name="code") String code,
                            @RequestParam(name = "state") String state,
                            HttpServletRequest request,
                            Model model,
                            HttpServletResponse response
    ){
        User user=new User();
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(uri);
        accessTokenDTO.setClient_id(id);
        accessTokenDTO.setClient_secret(secret);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if(githubUser!=null){
            user.setName(githubUser.getName());
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setAccount_Id(String.valueOf(githubUser.getId()));
            user.setGmt_Creat(System.currentTimeMillis());
            user.setGmt_Modified(user.getGmt_Creat());
            user.setAvatar_Url(githubUser.getAvatar_Url());
            request.getSession().setAttribute("user",githubUser);
            userMapper.insert(user);
            response.addCookie(new Cookie("token",token));
            return "redirect:/";
        }else
        {
            return "redirect:/";
        }
    }
}
