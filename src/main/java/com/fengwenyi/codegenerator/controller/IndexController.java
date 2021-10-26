package com.fengwenyi.codegenerator.controller;

import com.fengwenyi.api.result.ResponseTemplate;
import com.fengwenyi.codegenerator.service.IIndexService;
import com.fengwenyi.codegenerator.vo.CodeGeneratorRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-12
 */
@Controller
public class IndexController {

    private IIndexService indexService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/code-generator")
    @ResponseBody
    public ResponseTemplate<Void> codeGenerator(@RequestBody @Validated CodeGeneratorRequestVo requestVo) {
        return indexService.codeGenerator(requestVo);
    }

    @Autowired
    public void setIndexService(IIndexService indexService) {
        this.indexService = indexService;
    }

}
