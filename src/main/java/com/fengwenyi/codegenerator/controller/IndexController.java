package com.fengwenyi.codegenerator.controller;

import com.fengwenyi.api.result.ResponseTemplate;
import com.fengwenyi.apistarter.annotation.IgnoreResponseAdvice;
import com.fengwenyi.codegenerator.config.ErwinProperties;
import com.fengwenyi.codegenerator.service.IIndexService;
import com.fengwenyi.codegenerator.vo.CodeGeneratorRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-07-12
 */
@Controller
public class IndexController {

    private IIndexService indexService;
    private ErwinProperties erwinProperties;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("version", erwinProperties.getApp().getVersion());
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

    @Autowired
    public void setErwinProperties(ErwinProperties erwinProperties) {
        this.erwinProperties = erwinProperties;
    }

    @GetMapping("/upgrade")
    @ResponseBody
    @IgnoreResponseAdvice
    private String upgrade() {
        return indexService.upgrade(erwinProperties.getApp().getVersion());
    }
}
