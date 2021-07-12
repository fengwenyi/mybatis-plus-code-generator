package com.fengwenyi.codegenerator.service;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.codegenerator.vo.CodeGeneratorRequestVo;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-12
 */
public interface IIndexService {

    /**
     * 生成代码
     * @param requestVo
     * @return
     */
    ResultTemplate<Void> codeGenerator(CodeGeneratorRequestVo requestVo);

}
