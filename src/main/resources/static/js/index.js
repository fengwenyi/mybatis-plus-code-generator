layui.use(function(){
    var layer = layui.layer
        ,form = layui.form
        ,laypage = layui.laypage
        ,element = layui.element
        ,laydate = layui.laydate
        ,util = layui.util
        ,jQuery = layui.jquery;

    //欢迎信息
    // layer.msg('Hello World');

    //输出版本号
    // lay('#version').html(layui.v);

    //日期
    // laydate.render({
    //     elem: '#test2'
    //     ,value: new Date()
    //     ,isInitValue: true
    // });


    //监听提交
    form.on('submit(formDemo)', function(data){
        // layer.msg(JSON.stringify(data.field));
        console.log(JSON.stringify(data.field));

        jQuery.ajax({
            url: "/code-generator",
            type:'post',
            // 请求的媒体类型
            contentType: "application/json",
            data: JSON.stringify(data.field),
            beforeSend:function () {
                this.layerIndex = layer.alert(0, { shade: false });
            },
            success:function(response){
                if(response.success){
                    layer.msg(data.msg, {
                        icon: 6,//成功的表情
                        time: 5000 //1秒关闭（如果不配置，默认是3秒）
                    }, function(){
                        location.reload();
                    });
                }else{
                    layer.alert(response.msg,{icon: 5});//失败的表情
                }
            },
            complete: function () {
                layer.close(this.layerIndex);
            },
        });

        return false;
    });

});