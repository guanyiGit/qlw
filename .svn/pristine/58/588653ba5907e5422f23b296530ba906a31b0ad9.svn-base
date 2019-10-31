/**
 * 重写AJAX回调 by Eclipse
 * 此文件要放在所有JS引用末尾，否则可能会导致重写失效
 */

(function($) {
    //备份jquery的ajax方法
    var _ajax = $.ajax;

    //重写jquery的ajax方法
    $.ajax = function(opt) {
        //备份opt中方法
        var fn = {
            error: function(XMLHttpRequest, textStatus, errorThrown) {
            },
            success: function(data, textStatus) {
            },
            complete: function(XMLHttpRequest, data, textStatus) {
            }
        };
        
        if (opt.error)
            fn.error = opt.error;
        if (opt.success)
            fn.success = opt.success;
        if (opt.complete)
            fn.complete = opt.complete;

        //扩展增强处理

        var _opt = $.extend(opt, {
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                //错误方法增强处理
                fn.error(XMLHttpRequest, textStatus, errorThrown);
            },
            success: function(data, textStatus) {
                //成功回调方法增强处理
                if (null != data && undefined != data.code) {
                    location.reload();
                } else {
                    fn.success(data, textStatus);
                }
            },
            complete: function(XMLHttpRequest, data, textStatus) {
                //成功回调方法增强处理
                try {
                    var sessionstatus = XMLHttpRequest.getResponseHeader("SESSIONSTATUS");
                    //相同页面则不跳转
                    if (window.location.pathname == XMLHttpRequest.getResponseHeader("CONTEXTPATH"))
                        return;
                    //会话超时||用户资料完善
                    if ("TIMEOUT" == sessionstatus || "REDIRECT" == sessionstatus) {
                        var win = window;
                        while (win != win.top) {
                            win = win.top;
                        }
                        win.location.href = XMLHttpRequest.getResponseHeader("CONTEXTPATH");
                    }
                } catch (e) {
                }

                fn.complete(XMLHttpRequest, data, textStatus);
            }
        });
        _ajax(_opt);
    };
})(jQuery);