package forum1.demo.controller.mapper;

import forum1.demo.controller.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user (account_Id,name,token,gmt_Creat,gmt_Modified,avatar_Url) values (#{accountId},#{name},#{token},#{gmtCreat},#{gmtModified},#{avatarUrl})")
    public void  insert(User user);

    @Select("select *from user where token=#{token}")
    public User findToken(@Param("token") String token);

    @Select("select * from user where id=#{id}")
    public User find(@Param("id") Integer id);
}
