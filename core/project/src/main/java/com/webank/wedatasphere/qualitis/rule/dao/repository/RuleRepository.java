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

package com.webank.wedatasphere.qualitis.rule.dao.repository;

import com.webank.wedatasphere.qualitis.project.entity.Project;
import com.webank.wedatasphere.qualitis.rule.entity.Rule;
import com.webank.wedatasphere.qualitis.rule.entity.RuleGroup;
import com.webank.wedatasphere.qualitis.rule.entity.Template;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author howeye
 */
public interface RuleRepository extends JpaRepository<Rule, Long> {

    /**
     * Count rule by project
     * @param project
     * @return
     */
    @Query(value = "SELECT COUNT(qr.id) from Rule qr where qr.project = ?1")
    int countByProject(Project project);

    /**
     * Find rule by project
     * @param project
     * @return
     */
    List<Rule> findByProject(Project project);

    /**
     * Find rule list by rule group
     * @param ruleGroup
     * @return
     */
    List<Rule> findByRuleGroup(RuleGroup ruleGroup);

    /**
     * Find rule by rule template
     * @param templateInDb
     * @return
     */
    List<Rule> findByTemplate(Template templateInDb);

    /**
     * Find by project with page.
     * @param project
     * @param pageable
     * @return
     */
    Page<Rule> findByProject(Project project, Pageable pageable);

}
