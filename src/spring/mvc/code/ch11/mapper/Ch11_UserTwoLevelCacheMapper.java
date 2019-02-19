package spring.mvc.code.ch11.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cache.decorators.LruCache;
import spring.mvc.code.ch10.domain.UserPro;

@CacheNamespace(eviction=LruCache.class,flushInterval=60000,size=512,
        readWrite=true)
public interface Ch11_UserTwoLevelCacheMapper {
    // 根據id查詢User
    @Select("SELECT * FROM tb_ch11_user_pro WHERE id = #{id}")
    @Options(useCache=true)
    UserPro selectUserById(Integer id);

    // 根據id刪除 User
    @Delete("DELETE FROM tb_ch11_user_pro WHERE id = #{id}")
    void deleteUserById(Integer id);

}
