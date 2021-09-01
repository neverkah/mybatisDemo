import com.wmxyggs.bean.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class BlogDao {


    public static void main(String[] args) throws  Exception {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);


        try (SqlSession session = sqlSessionFactory.openSession()) {
            Blog blog = session.selectOne(
                    "org.mybatis.example.BlogMapper.selectBlog", 101);

            System.out.println(blog);
        }

    }
}
