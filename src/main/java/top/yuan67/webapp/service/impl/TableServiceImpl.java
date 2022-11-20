/**
 * @Author: NieQiang
 * @User: CAPTAIN
 * @CreateTime: 2022-11-20
 * @Desc: 描述信息
 **/
package top.yuan67.webapp.service.impl;

import org.springframework.stereotype.Service;
import top.yuan67.webapp.mapper.TableMapper;
import top.yuan67.webapp.service.TableService;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class TableServiceImpl implements TableService {
  
  @Resource
  private TableMapper tableMapper;
  
  @Override
  public String create(String name) {
    try {
      String sql = "CREATE TABLE (" + name + "`id` bigint NOT NULL AUTO_INCREMENT," +
          "`role_EN` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL," +
          "`role_ZH` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL," +
          "`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP," +
          "PRIMARY KEY (`id`)" +
          ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci";
      
      tableMapper.createTable(sql);
    } catch (RuntimeException e){
      System.out.println("RuntimeException:创建["+ name + "]表失败!" + e);
      return "创建["+ name + "]表失败!";
    }catch (Exception e){
      System.out.println("Exception:创建["+ name + "]表失败!" + e);
      return "创建["+ name + "]表失败!";
    }
    return "创建["+ name + "]表成功!";
  }
  
  @Override
  public List<Map<String, Object>> findAllTable() {
    return tableMapper.findAllTable();
  }
  
  @Override
  public List<Map<String, Object>> findAllTableColumn(String name) {
    return tableMapper.findAllTableColumn(name);
  }
  
  @Override
  public String delByTableName(String name) {
    try {
      tableMapper.delByTableName(name);
    }catch (Exception e){
      System.out.println("Exception:删除["+ name + "]表失败!" + e);
      return "删除["+ name + "]表失败!";
    }
    return "删除["+ name + "]表成功!";
  }
  
  @Override
  public String update(String name) {
    return null;
  }
  
  @Override
  public String updateTableName(String oldName, String newName) {
    try {
      tableMapper.updateTableName(oldName,newName);
    }catch (Exception e){
      System.out.println("Exception:将["+ oldName + "]表名称修改为"+newName+"失败!" + e);
      return "将["+ oldName + "]表名称修改为"+newName+"失败!";
    }
    return "将["+ oldName + "]表名称修改为"+newName+"成功!";
  }
  
  @Override
  public Map<String, Object> updateTableNameColumn(String name, String oldCol, String newCol, String type) {
    Map<String, Object> result = new LinkedHashMap<>();
    result.put("结果", "成功！");
    result.put("修改的表明", name);
    result.put("修改前的字段", oldCol);
    result.put("修改后的字段", newCol);
    result.put("字段类型", type);
  
    try {
      tableMapper.updateTableNameColumn(name, oldCol, newCol, type);
    }catch (Exception e){
      System.out.println("Exception:将["+ name + "]表中的"+oldCol+"修改为"+newCol+"失败!" + e);
      result.put("结果", "失败！");
    }
    return result;
  }
  
  @Override
  public String delByTableColumn(String name, String column) {
    try {
      tableMapper.delByTableColumn(name, column);
    }catch (Exception e){
      System.out.println("Exception:将["+ name + "]表中的"+column+"字段删除失败!" + e);
      return "将["+ name + "]表中的"+column+"字段删除失败!";
    }
    return "将["+ name + "]表中的"+column+"字段删除成功!";
  }
}
