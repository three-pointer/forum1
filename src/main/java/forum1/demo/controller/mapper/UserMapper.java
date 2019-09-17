package forum1.demo.controller.mapper;

import forum1.demo.controller.Model.User;
import jdk.nashorn.internal.parser.Token;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {

    @Insert("insert into user (account_Id,name,token,gmt_Creat,gmt_Modified) values (#{account_Id},#{name},#{token},#{gmt_Creat},#{gmt_Modified})")
    public void  insert(User user);

    @Select("select *from user where token=#{token}")
    public User findToken(@Param("token") String token);

}
