/**
 * @Author: NieQiang
 * @User: CAPTAIN
 * @CreateTime: 2022-11-20
 * @Desc: 描述信息
 **/
package top.yuan67.webapp.service;

import java.util.List;
import java.util.Map;

public interface TableService {
  String create(String name);
  
  List<Map<String, Object>> findAllTable();
  
  List<Map<String, Object>> findAllTableColumn(String name);
  
  String delByTableName(String name);
  
  String update(String name);
  
  String updateTableName(String oldName, String newName);
  
  Map<String, Object> updateTableNameColumn(String name, String oldCol, String newCol, String type);
  
  String delByTableColumn(String name, String column);
  
  String addColumn(String name, String col, String type);
}
