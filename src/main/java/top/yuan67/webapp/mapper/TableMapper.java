/**
 * @Author: NieQiang
 * @User: CAPTAIN
 * @CreateTime: 2022-11-20
 * @Desc: 描述信息
 **/
package top.yuan67.webapp.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface TableMapper {
  /**
   * 建表
   * @param sql
   */
  @Insert("${sql}")
  void createTable(String sql);
  
  /**
   * 新增表字段
   * @param name
   * @param col
   * @param type
   */
  @Insert("ALTER TABLE ${name} ADD ${col} ${type}")
  void addColumn(String name, String col, String type);
  
  /**
   * 删表
   * @param name
   */
  @Delete("DROP TABLE IF EXISTS ${name}")
  void delByTableName(String name);
  
  /**
   * 删除表中的某个字段
   * @param name
   * @param column
   */
  @Delete("ALTER TABLE ${name} DROP COLUMN ${column}")
  void delByTableColumn(String name, String column);
  
  /**
   * 获取所有的表
   * @return
   */
  @Select("SELECT TABLE_NAME FROM information_schema.`TABLES` WHERE TABLE_SCHEMA=(SELECT DATABASE())")
  List<Map<String, Object>> findAllTable();
  
  /**
   * 获取某个表中所有的字段信息
   * @param name
   * @return
   */
  @Select("SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = (SELECT DATABASE()) AND TABLE_NAME=#{name}")
  List<Map<String, Object>> findAllTableColumn(String name);
  
  /**
   * 修改表名
   * @param oldName
   * @param newName
   */
  @Update("RENAME TABLE ${oldName} TO ${newName}")
  void updateTableName(String oldName, String newName);
  
  /**
   * 修改表字段
   * @param name
   * @param oldCol
   * @param newCol
   * @param type
   */
  @Update("ALTER TABLE ${name} CHANGE ${oldCol} ${newCol} ${type}")
  void updateTableNameColumn(String name, String oldCol, String newCol, String type);
}
