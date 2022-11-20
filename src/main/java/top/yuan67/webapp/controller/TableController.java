/**
 * @Author: NieQiang
 * @User: CAPTAIN
 * @CreateTime: 2022-11-20
 * @Desc: 描述信息
 **/
package top.yuan67.webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.yuan67.webapp.service.TableService;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
public class TableController {
  
  @Resource
  private TableService tableService;
  
  /**
   * 新增表
   * @param name 表名
   * @return
   */
  @GetMapping("/create")
  public String create(String name){
    return tableService.create(name);
  }
  
  /**
   * 新增表字段
   * @param name 表名
   * @param col 新增的字段名
   * @param type 新增字段名的类型
   * @return
   */
  @GetMapping("/addColumn")
  public String addColumn(String name, String col, String type){
    return tableService.addColumn(name, col, type);
  }
  
  /**
   * 删表
   * @param name 表名
   * @return
   */
  @GetMapping("/delByTableName")
  public String delByTableName(String name){
    return tableService.delByTableName(name);
  }
  
  /**
   * 删表中的字段
   * @param name 表名
   * @param column 字段名
   * @return
   */
  @GetMapping("/delByTableColumn")
  public String delByTableColumn(String name, String column){
    return tableService.delByTableColumn(name, column);
  }
  
  /**
   * 修改表名
   * @param oldName 原表名
   * @param newName 新表名
   * @return
   */
  @GetMapping("/updateTableName")
  public String updateTableName(String oldName, String newName){
    return tableService.updateTableName(oldName, newName);
  }
  
  /**
   * 修改表字段
   * @param name 表名
   * @param oldCol 原字段名
   * @param newCol 新字段名
   * @return
   */
  @GetMapping("/updateTableNameColumn")
  public Map<String, Object> updateTableNameColumn(String name, String oldCol, String newCol,
    String type){
    return tableService.updateTableNameColumn(name, oldCol, newCol, type);
  }
  
  /**
   * 获取所有的表
   * @return
   */
  @GetMapping("/findAllTable")
  public List<Map<String, Object>> findAllTable(){
    return tableService.findAllTable();
  }
  
  /**
   * 获取某个表中所有的字段信息
   * @param name 表名
   * @return
   */
  @GetMapping("/findAllTableColumn/{name}")
  public List<Map<String, Object>> findAllTableColumn(@PathVariable String name){
    return tableService.findAllTableColumn(name);
  }
}