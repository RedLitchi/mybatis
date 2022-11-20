/**
 * @Author: NieQiang
 * @User: CAPTAIN
 * @CreateTime: 2022-11-20
 * @Desc: 描述信息
 **/
package top.yuan67.webapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "top.yuan67.webapp.mapper")
public class MyBatisApplication {
  public static void main(String[] args) {
    SpringApplication.run(MyBatisApplication.class, args);
  }
}