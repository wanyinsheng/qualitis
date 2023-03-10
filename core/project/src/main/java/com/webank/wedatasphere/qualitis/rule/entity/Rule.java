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

package com.webank.wedatasphere.qualitis.rule.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.webank.wedatasphere.qualitis.project.entity.Project;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.NotFound;

/**
 * @author howeye
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Table(name = "qualitis_rule", uniqueConstraints = @UniqueConstraint(columnNames = {"project_id", "name"}))
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cs_id", length = 512)
    private String csId;

    @ManyToOne
    @JsonIgnore
    private Template template;

    @Column(length = 128)
    private String name;

    @Column(name = "cn_name", length = 128)
    private String cnName;

    @Column(length = 340)
    private String detail;

    @OneToMany(mappedBy = "rule", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonIgnore
    @NotFound(action= NotFoundAction.IGNORE)
    private Set<RuleDataSource> ruleDataSources;

    @OneToMany(mappedBy = "rule", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonIgnore
    @NotFound(action= NotFoundAction.IGNORE)
    private Set<RuleDataSourceMapping> ruleDataSourceMappings;

    @Column(name = "alarm")
    private Boolean alarm;

    @Column(name = "rule_type")
    private Integer ruleType;

    @OneToMany(mappedBy = "rule", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonIgnore
    @NotFound(action= NotFoundAction.IGNORE)
    private Set<AlarmConfig> alarmConfigs;

    @OneToMany(mappedBy = "rule", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonIgnore
    @NotFound(action= NotFoundAction.IGNORE)
    private Set<RuleVariable> ruleVariables;

    @OneToOne(mappedBy = "parentRule", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Rule childRule;

    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Rule parentRule;

    @ManyToOne
    @JsonIgnore
    private Project project;

    @Column(name = "rule_template_name", length = 180, updatable = false)
    private String ruleTemplateName;

    @Column(name = "function_type")
    private Integer functionType;
    @Column(name = "function_content", length = 3010)
    private String functionContent;
    @Column(name = "from_content", length = 3010)
    private String fromContent;
    @Column(name = "where_content", length = 3010)
    private String whereContent;
    @Column(name = "output_name", length = 170)
    private String outputName;

    @Column(name = "abort_on_failure")
    private Boolean abortOnFailure;

    @Column(name = "create_user", length = 50)
    private String createUser;
    @Column(name = "create_time", length = 25)
    private String createTime;
    @Column(name = "modify_user", length = 50)
    private String modifyUser;
    @Column(name = "modify_time", length = 25)
    private String modifyTime;
    @Column(name = "delete_fail_check_result")
    private Boolean deleteFailCheckResult;

    @Column(name = "specify_static_startup_param")
    private Boolean specifyStaticStartupParam;
    @Column(name = "static_startup_param")
    private String staticStartupParam;

    @ManyToOne
    @JsonIgnore
    private RuleGroup ruleGroup;

    public Rule() {
        // Default Constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCsId() { return csId; }

    public void setCsId(String csId) { this.csId = csId; }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Set<RuleDataSource> getRuleDataSources() {
        return ruleDataSources;
    }

    public void setRuleDataSources(Set<RuleDataSource> ruleDataSources) {
        this.ruleDataSources = ruleDataSources;
    }

    public Boolean getAlarm() {
        return alarm;
    }

    public void setAlarm(Boolean alarm) {
        this.alarm = alarm;
    }

    public Integer getRuleType() {
        return ruleType;
    }

    public void setRuleType(Integer ruleType) {
        this.ruleType = ruleType;
    }

    public Set<AlarmConfig> getAlarmConfigs() {
        return alarmConfigs;
    }

    public void setAlarmConfigs(Set<AlarmConfig> alarmConfigs) {
        this.alarmConfigs = alarmConfigs;
    }

    public Set<RuleVariable> getRuleVariables() {
        return ruleVariables;
    }

    public void setRuleVariables(Set<RuleVariable> ruleVariables) {
        this.ruleVariables = ruleVariables;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getRuleTemplateName() {
        return ruleTemplateName;
    }

    public void setRuleTemplateName(String ruleTemplateName) {
        this.ruleTemplateName = ruleTemplateName;
    }

    public Integer getFunctionType() {
        return functionType;
    }

    public void setFunctionType(Integer functionType) {
        this.functionType = functionType;
    }

    public String getFunctionContent() {
        return functionContent;
    }

    public void setFunctionContent(String functionContent) {
        this.functionContent = functionContent;
    }

    public String getFromContent() {
        return fromContent;
    }

    public void setFromContent(String fromContent) {
        this.fromContent = fromContent;
    }

    public String getWhereContent() {
        return whereContent;
    }

    public void setWhereContent(String whereContent) {
        this.whereContent = whereContent;
    }

    public String getOutputName() {
        return outputName;
    }

    public void setOutputName(String outputName) {
        this.outputName = outputName;
    }

    public Rule getChildRule() {
        return childRule;
    }

    public void setChildRule(Rule childRule) {
        this.childRule = childRule;
    }

    public Rule getParentRule() {
        return parentRule;
    }

    public void setParentRule(Rule parentRule) {
        this.parentRule = parentRule;
    }

    public Set<RuleDataSourceMapping> getRuleDataSourceMappings() {
        return ruleDataSourceMappings;
    }

    public void setRuleDataSourceMappings(Set<RuleDataSourceMapping> ruleDataSourceMappings) {
        this.ruleDataSourceMappings = ruleDataSourceMappings;
    }

    public RuleGroup getRuleGroup() {
        return ruleGroup;
    }

    public void setRuleGroup(RuleGroup ruleGroup) {
        this.ruleGroup = ruleGroup;
    }

    public Boolean getAbortOnFailure() {
        return abortOnFailure;
    }

    public void setAbortOnFailure(Boolean abortOnFailure) {
        this.abortOnFailure = abortOnFailure;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Boolean getDeleteFailCheckResult() {
        return deleteFailCheckResult;
    }

    public void setDeleteFailCheckResult(Boolean deleteFailCheckResult) {
        this.deleteFailCheckResult = deleteFailCheckResult;
    }

    public Boolean getSpecifyStaticStartupParam() {
        return specifyStaticStartupParam;
    }

    public void setSpecifyStaticStartupParam(Boolean specifyStaticStartupParam) {
        this.specifyStaticStartupParam = specifyStaticStartupParam;
    }

    public String getStaticStartupParam() {
        return staticStartupParam;
    }

    public void setStaticStartupParam(String staticStartupParam) {
        this.staticStartupParam = staticStartupParam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Rule rule = (Rule) o;
        return Objects.equals(id, rule.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Rule{" +
            "id=" + id +
            ", csId='" + csId + '\'' +
            ", template=" + template +
            ", name='" + name + '\'' +
            ", alarm=" + alarm +
            ", ruleType=" + ruleType +
            ", project=" + project +
            ", ruleTemplateName='" + ruleTemplateName + '\'' +
            ", functionType=" + functionType +
            ", functionContent='" + functionContent + '\'' +
            ", fromContent='" + fromContent + '\'' +
            ", whereContent='" + whereContent + '\'' +
            ", outputName='" + outputName + '\'' +
            ", abortOnFailure=" + abortOnFailure +
            ", ruleGroup=" + ruleGroup +
            '}';
    }
}
