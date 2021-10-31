
layui.use(function() {
    var layer = layui.layer
        ,form = layui.form
        ,laypage = layui.laypage
        ,element = layui.element
        ,laydate = layui.laydate
        ,util = layui.util
        ,jQuery = layui.jquery;


    let ERWIN_FENG = '<a href="https://www.fengwenyi.com">Erwin Feng</a>';
    let ERWIN_FENG_OLD = '<a href="https://fengwenyi.com">Erwin Feng</a>';

    let author = getAuthor();
    let dbAddress = getDbAddress();
    let dbUsername = getDbUsername();
    let dbPassword = getDbPassword();
    let outputDir = getOutputDir();

    if (isEmpty(author)) {
        author = ERWIN_FENG;
    } else {
        // 修复链接地址不正确的问题
        if (author === ERWIN_FENG_OLD) {
            author = ERWIN_FENG;
            removeAuthor();
        }
    }

    jQuery("#author").val(author);
    jQuery("#dbAddress").val(dbAddress);
    jQuery("#dbUsername").val(dbUsername);
    jQuery("#dbPassword").val(dbPassword);
    jQuery("#outputDir").val(outputDir);


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

});