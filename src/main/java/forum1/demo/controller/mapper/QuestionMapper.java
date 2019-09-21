package forum1.demo.controller.mapper;

import forum1.demo.controller.Model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,description,gmt_creat,gmt_modified,creator,comment_count,view_count,like_count,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{commentcount},#{viewcount},#{likecount},#{tag})")
   public void create(Question  question);

    @Select("select *from question")
    public List<Question> list();

}
