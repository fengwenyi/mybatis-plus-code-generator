
layui.use(function() {
    var layer = layui.layer
        ,form = layui.form
        ,laypage = layui.laypage
        ,element = layui.element
        ,laydate = layui.laydate
        ,util = layui.util
        ,jQuery = layui.jquery;


    jQuery("#inputAuthor").val('<a href="https://fengwenyi.com">Erwin Feng</a>')


    //监听提交
    form.on('submit(formDemo)', function(data){
        //console.log(JSON.stringify(data.field));
        let layerIndex;
        jQuery.ajax({
            url: "/code-generator",
            type:'post',
            // 请求的媒体类型
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify(data.field),
            beforeSend:function () {
                layerIndex = layer.load(0, { shade: 0.1 });
            },
            success:function(response){
                if(response.success){
                    layer.alert(response.msg, { icon: 6 });
                }else{
                    layer.alert(response.msg,{ icon: 5 });//失败的表情
                }
            },
            complete: function () {
                layer.close(layerIndex);
            },
        });
        return false;
    });

});