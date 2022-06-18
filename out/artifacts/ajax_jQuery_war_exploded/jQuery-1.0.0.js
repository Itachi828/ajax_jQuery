function jQuery(selector) {
    //ID选择器
    if(typeof selector == "string"){
        if(selector.charAt(0) == "#"){
            domObj = document.getElementById(selector.substring(1));
            return new jQuery();
        }
    }
    this.html = function(htmlStr){
        domObj.innerHTML = htmlStr
    }
    // 鼠标点击
    this.click = function(fun){
        domObj.onclick = fun
    }
    // 获得焦点
    this.focus = function (fun){
        domObj.onfocus = fun
    }
    // 失去焦点
    this.blur = function(fun) {
        domObj.onblur = fun
    }
    //事件发生改变
    this.change = function (fun){
        domObj.onchange = fun
    }
    this.val = function (v){
        if(v == undefined){
            return domObj.value
        }else {
            domObj.value = v
        }
    }

        // 页面全部加载完后调用方法
    if(typeof selector == "function"){
        window.onload = selector
    }

    // 静态的方法，发送ajax请求
    /**
     * 分析：使用ajax函数发送ajax请求的时候，需要程序员给我们传过来什么？
     *      请求的方式(type)：GET/POST
     *      请求的URL(url)：url
     *      请求时提交的数据(data)：data
     *      请求时发送异步请求还是同步请求(async)：true表示异步，false表示同步。
     */
    jQuery.ajax = function (jsonArgs) {
        //1创建XML对象
        var xhr = new XMLHttpRequest();
        // 2、创建回调函数
        xhr.onreadystatechange = function () {
            if (this.readyState == 4) {
                if (this.status == 200) {
                    // 假设服务器返回的都是json格式的字符串。
                    var jsonObj = JSON.parse(this.responseText);
                    // 调用函数
                    jsonArgs.success(jsonObj)
                }
            }
        }
        if (jsonArgs.type.toUpperCase() == "POST") {
            // 3.打开通道
            xhr.open("POST", jsonArgs.url, jsonArgs.async)
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
            // 4、发送数据
            xhr.send(jsonArgs.data)
        }
        if (jsonArgs.type.toUpperCase() == "GET") {
            // 3.打开通道
            xhr.open("GET", jsonArgs.url + "?" + jsonArgs.data, jsonArgs.async)
            // 4、发送数据
            xhr.send()
        }
    }
}
$ = jQuery
// 为了jQuer静态方法生效
new jQuery()




