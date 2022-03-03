
layui.use(function() {
    var layer = layui.layer
        ,form = layui.form
        ,laypage = layui.laypage
        ,element = layui.element
        ,laydate = layui.laydate
        ,util = layui.util
        ,jQuery = layui.jquery;

    let $ = jQuery;


    let ERWIN_FENG = '<a href="https://www.fengwenyi.com?code">Erwin Feng</a>';

    let author = getAuthor();
    let dbAddress = getDbAddress();
    let dbUsername = getDbUsername();
    let dbPassword = getDbPassword();
    let outputDir = getOutputDir();

    if (isEmpty(author)) {
        author = ERWIN_FENG;
    }

    jQuery("#author").val(author);
    jQuery("#dbAddress").val(dbAddress);
    jQuery("#dbUsername").val(dbUsername);
    jQuery("#dbPassword").val(dbPassword);
    jQuery("#outputDir").val(outputDir);

    let layerIndex;

    showDbConfigSelect();

    function showDbConfigSelect() {
        let dbConfigList = queryList()
        $.each(dbConfigList, function(i, item) {
            showDbConfigSelectHtml(item)
        });
    }

    function showDbConfigSelectHtml(item) {
        let k = item.k;
        let name = item.v.name
        let html = '<option value="' + k + '">' + name + '</option>';
        $('#dbConfigSelect').append(html);
        $('#boxDbConfigSelect').append(html);
        form.render('select');
    }

    // 监听点击修改昵按钮
    jQuery('#btnEditDatabaseConfig').on('click', function () {
        layerIndex = layer.open({
            type: 1,
            title: '数据库配置',
            closeBtn: 1, //不显示关闭按钮
            anim: 5,
            shade: [0.5],
            area: ['', ''],
            shadeClose: true, //开启遮罩关闭
            content: jQuery('.box-database-config')
        });
    });

    form.on('submit(formDatabaseConfigAdd)', function (data) {
        console.log(JSON.stringify(data.field))
        let key = data.field.key;
        console.log(key)
        if (isEmpty(key)) {
            key = guid()
            add(key, data.field);
            data.field.key = key;
            let o = data.field;
            form.val('boxFormDbConfig', o);
            let obj = queryByKey(key);
            if (nonNull(obj)) {
                showDbConfigSelectHtml(obj);
            } // 有问题
        } else {
            update(key, data.field)
        }
        return false;
    });


    //监听提交
    form.on('submit(formCodeGenerator)', function(data){
        handleFormSubmit(data);
        return false;
    });

    // 处理form提交请求
    function handleFormSubmit(data) {
        let url = "/code-generator";
        let param = JSON.stringify(data.field);
        ajaxPost(jQuery, layer, url, param, function (response) {
            if (response.success) {
                handleCache(data.field);
                alertSuccess(layer, response.message);
            } else {
                layer.alert(response.msg,{ icon: 5 });//失败的表情
                alertFail(layer, response.message);
            }
        });
    }

    // 缓存
    function handleCache(formData) {
        setDbAddress(formData.host);
        setDbUsername(formData.username)
        setDbPassword(formData.password)
        setAuthor(formData.author)
        setOutputDir(formData.outDir)
    }

    form.on('select(boxFormDbConfigSelect)', function(data){
        let key = data.value;
        if (nonNull(key)) {
            let dbConfigObj = queryByKey(key)
            if (nonNull(dbConfigObj)) {
                let formVal = dbConfigObj.v
                form.val('boxFormDbConfig', formVal)
            }
        }
    });

});