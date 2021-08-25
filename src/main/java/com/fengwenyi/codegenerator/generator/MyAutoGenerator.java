package com.fengwenyi.codegenerator.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.SimpleAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.fengwenyi.codegenerator.Config;
import com.fengwenyi.codegenerator.bo.CodeGeneratorBo;
import org.springframework.util.StringUtils;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-08-23
 */
public class MyAutoGenerator extends SimpleAutoGenerator {

    private final CodeGeneratorBo bo;

    public MyAutoGenerator(CodeGeneratorBo bo) {
        this.bo = bo;
    }

    @Override
    public IConfigBuilder<DataSourceConfig> dataSourceConfigBuilder() {
        return new DataSourceConfig
                .Builder(bo.getDbUrl(), bo.getUsername(), bo.getPassword());
    }

    @Override
    public IConfigBuilder<GlobalConfig> globalConfigBuilder() {
        GlobalConfig.Builder builder = new GlobalConfig.Builder();
        builder
                .fileOverride()
                .enableSwagger()
                .outputDir(bo.getOutDir())
                .author(bo.getAuthor())
                //.dateType(DateType.TIME_PACK)
        ;

        String outDir = bo.getOutDir();
        if (!StringUtils.hasText(outDir)) {
            outDir = Config.OUTPUT_DIR;
        }
        builder.outputDir(outDir);

        DateType dateType = DateType.TIME_PACK;
        if (!"8".equalsIgnoreCase(bo.getJdkVersion())) {
            dateType = DateType.ONLY_DATE;
        }
        builder.dateType(dateType);

        return builder;
    }

    @Override
    public IConfigBuilder<PackageConfig> packageConfigBuilder() {
        return new PackageConfig.Builder()
                .parent(bo.getPackageName())
                // builder.moduleName("");
                .controller(bo.getPackageController())
                .entity(bo.getPackageEntity())
                .mapper(bo.getPackageMapper())
                .xml(bo.getPackageMapperXml())
                .service(bo.getPackageService())
                .serviceImpl(bo.getPackageServiceImpl());
    }

    @Override
    public IConfigBuilder<StrategyConfig> strategyConfigBuilder() {
        StrategyConfig.Builder builder = new StrategyConfig.Builder();


        builder.addInclude(bo.getTableNames())
                .entityBuilder()
                    .naming(NamingStrategy.underline_to_camel)
                    .enableChainModel()
                    .enableLombok()
                    //.enableActiveRecord()
                    .formatFileName(bo.getFileNamePatternEntity())
                    .idType(IdType.ASSIGN_ID)
                    .logicDeleteColumnName(bo.getFieldLogicDelete())
                    .superClass(bo.getBaseClassName())
                .mapperBuilder()
                    .formatMapperFileName(bo.getFileNamePatternMapper())
                    .formatXmlFileName(bo.getFileNamePatternMapperXml())
                .serviceBuilder()
                    .formatServiceFileName(bo.getFileNamePatternService())
                    .formatServiceImplFileName(bo.getFileNamePatternServiceImpl())
                .controllerBuilder()
                    .enableRestStyle()
                    .enableHyphenStyle();

        return builder;
    }
}
