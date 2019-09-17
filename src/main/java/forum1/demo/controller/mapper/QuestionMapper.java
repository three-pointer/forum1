package forum1.demo.controller.mapper;

import forum1.demo.controller.Model.Question;
import org.apache.ibatis.annotations.Insert;

public interface QuestionMapper {

    @Insert("insert into question(title,description,gmt_creat,gmt_modified,creator,comment_count,view_count,like_count,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{comment_count},#{view_count},#{like_count},#{tag})")
   public void create(Question  question);
}
