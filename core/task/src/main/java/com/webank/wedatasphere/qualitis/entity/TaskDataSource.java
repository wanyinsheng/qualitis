/*
 * Copyright 2019 WeBank
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webank.wedatasphere.qualitis.entity;

import com.webank.wedatasphere.qualitis.bean.TaskRuleDataSource;

import com.webank.wedatasphere.qualitis.constant.SpecCharEnum;
import com.webank.wedatasphere.qualitis.rule.entity.RuleDataSource;
import javax.persistence.*;
import java.util.Objects;
import org.apache.commons.lang.StringUtils;

/**
 * @author howeye
 */
@Entity
@Table(name = "qualitis_application_task_datasource")
public class TaskDataSource {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "project_id")
  private Long projectId;
  @Column(name = "rule_id")
  private Long ruleId;
  @Column(length = 100, name = "cluster_name")
  private String clusterName;
  @Column(length = 100, name = "database_name")
  private String databaseName;
  @Column(length = 100, name = "table_name")
  private String tableName;
  @Column(name = "col_name", columnDefinition = "MEDIUMTEXT")
  private String colName;
  @Column(name = "execute_user", length = 150)
  private String executeUser;
  @Column(name = "create_user", length = 150)
  private String createUser;

  @ManyToOne
  private Task task;

  @Column(name = "datasource_index")
  private Integer datasourceIndex;
  /**
   * datasource type, such as hive, mysql, kafka
   */
  @Column(name = "datasource_type")
  private Integer datasourceType;

  public TaskDataSource() {
  }

  public TaskDataSource(RuleDataSource ruleDataSource, Task task) {
    this.clusterName = ruleDataSource.getClusterName();
    this.databaseName = ruleDataSource.getDbName();
    this.tableName = ruleDataSource.getTableName();
    this.colName = ruleDataSource.getFilter();
    this.projectId = ruleDataSource.getRule().getProject().getId();
    this.ruleId = ruleDataSource.getRule().getId();
    this.task = task;
    this.executeUser = task.getApplication().getExecuteUser();
    this.createUser = task.getApplication().getCreateUser();
    this.datasourceType = ruleDataSource.getDatasourceType();
    this.datasourceIndex = ruleDataSource.getDatasourceIndex();
  }

  public TaskDataSource(TaskRuleDataSource ruleDataSource, Task task) {
    this.clusterName = ruleDataSource.getClusterName();
    this.databaseName = ruleDataSource.getDatabaseName();
    this.tableName = ruleDataSource.getTableName();
    this.colName = ruleDataSource.getColName();
    this.projectId = ruleDataSource.getProjectId();
    this.ruleId = ruleDataSource.getRuleId();
    this.datasourceIndex = ruleDataSource.getDatasourceIndex();
    this.task = task;
    this.executeUser = task.getApplication().getExecuteUser();
    this.createUser = task.getApplication().getCreateUser();
    this.datasourceType = ruleDataSource.getDatasourceType();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getRuleId() {
    return ruleId;
  }

  public void setRuleId(Long ruleId) {
    this.ruleId = ruleId;
  }

  public Long getProjectId() {
    return projectId;
  }

  public void setProjectId(Long projectId) {
    this.projectId = projectId;
  }

  public String getClusterName() {
    return clusterName;
  }

  public void setClusterName(String clusterName) {
    this.clusterName = clusterName;
  }

  public String getDatabaseName() {
    return databaseName;
  }

  public void setDatabaseName(String databaseName) {
    this.databaseName = databaseName;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public String getColName() {
    return colName;
  }

  public void setColName(String colName) {
    this.colName = colName;
  }

  public String getExecuteUser() {
    return executeUser;
  }

  public void setExecuteUser(String executeUser) {
    this.executeUser = executeUser;
  }

  public Task getTask() {
    return task;
  }

  public void setTask(Task task) {
    this.task = task;
  }

  public Integer getDatasourceIndex() {
    return datasourceIndex;
  }

  public void setDatasourceIndex(Integer datasourceIndex) {
    this.datasourceIndex = datasourceIndex;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public Integer getDatasourceType() {
    return datasourceType;
  }

  public void setDatasourceType(Integer datasourceType) {
    this.datasourceType = datasourceType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskDataSource that = (TaskDataSource) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
