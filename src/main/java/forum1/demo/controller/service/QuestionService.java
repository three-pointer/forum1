package forum1.demo.controller.service;

import forum1.demo.controller.Model.Question;
import forum1.demo.controller.Model.User;
import forum1.demo.controller.dto.QuestionDTO;
import forum1.demo.controller.mapper.QuestionMapper;
import forum1.demo.controller.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class QuestionService {

    @Autowired
   private QuestionMapper questionMapper;

    @Autowired
   private UserMapper userMapper;

    public List<QuestionDTO> list(){

        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOS=new ArrayList<>();
        for (Question question:questions) {
            User user = userMapper.find(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOS.add(questionDTO);
        }
        return questionDTOS;
    }
}
