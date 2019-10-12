/// <reference path="../jquery-1.7.2.min.js" />
$.extend({
    notifationTime: undefined,
    longpresstm: undefined,
    pageRecordEventArg: undefined,
    pageObject: undefined,
    /*获取顶层页面*/
    win: function () {
        var w = window;
        while (true) {
            if (w.top == w.self)
                break;
            else
                w = w.top;
        }
        return w;
    },
    /*遮罩阴影层*/
    jq_MaskDiv: function () {
        var str = "<div aria-hidden='false' class='theme-popover-mask' style=\"z-index:1;position:fixed;left:0;top:0;left:0;right:0;background:#000;opacity:0.1;filter:alpha(opacity=10);-moz-opacity:0.1;display:none;\"></div>";
        $("body").append(str);
        $('.theme-popover-mask').show();
        $('.theme-popover-mask').height($(document).height());
    },
    jq_MaskDiv_close: function () {
        $('.theme-popover-mask').hide();
    },
    /*确定取消对话框*/
    jq_Confirm: function (e) {
        if (!e) return;
        e.btnOktext = !e.btnOktext ? "确定" : e.btnOktext;
        e.btnCanceltext = !e.btnCanceltext ? "取消" : e.btnCanceltext;
        e.dialogModal = e.dialogModal == undefined ? true : e.dialogModal;


        if (!e.message) {
            e.message = "请输入对应的提示信息";
        }

        //set it's modal
        if (e.dialogModal) {
            $.jq_MaskDiv();
        }
        var str = "<div class='jq_dvconfirm' style='z-index:2;box-shadow: 0px 0px 5px #BCD4E5;border: 1px solid #BCD4E5 !important;position:absolute;background-Color:#fff;min-width:578px;width:578px;min-height:144px;border: 1px solid rgba(0, 0, 0, 0.2);font-size: 13px;opacity:0;filter:alpha(opacity=0);-moz-opacity:0;'>"
                        + "<div style='min-height:54px;line-height:54px;padding:20px;'>"
                                + "<button title='关闭' class='btncloseconfirm' style='outline:0px;float:right;margin-top:-20px;font-size:18px;font-weight: bold;color: rgb(0, 0, 0);text-shadow: 0px 1px 0px rgb(255, 255, 255);border:0px;background-color:transparent;cursor:pointer;opacity:0.2;filter:alpha(opacity=20);-moz-opacity:0.2;'>×</button>"
                                + "<div style='font-size:16px;color: rgb(57, 57, 57);'>" + e.message + "</div>"
                        + "</div>"
                        + "<div style='overflow:auto;padding:12px 14px;background-color: rgb(239, 243, 248);'>"
                                + "<input class='confirmbtncancel' type='button' value=' x " + e.btnCanceltext + "' style='float:right;margin:0px 10px;' />"
                                + "<input class='confirmbtnok' type='button' value=' ✓ " + e.btnOktext + "' style='float:right;' />"
                        + "</div>"
                    + "</div>";
        $("body").append(str);
        $(".btncloseconfirm").hover(function () {
            $(this).css("opacity", 1);
        }, function () {
            $(this).css("opacity", 0.2);
        });

        $('.jq_dvconfirm').css("left", ($(document).width() - $('.jq_dvconfirm').width()) / 2 + "px");
        $('.jq_dvconfirm').css("top", 0 - $('.jq_dvconfirm').height());
        $('.jq_dvconfirm').stop().animate({ "top": 20 + $(window).scrollTop(), "opacity": 1 }, 350);

        $('.confirmbtnok').bind("click", function () {
            if (e.btnOkClick) e.btnOkClick();
            $.jq_Confirm_close();
        });
        $('.confirmbtncancel').bind("click", function () {
            if (e.btnCancelClick) e.btnCancelClick();
            $.jq_Confirm_close();
        });
        $('.btncloseconfirm').bind("click", function () {
            $.jq_Confirm_close();
        });
    },
    /*确定取消对话框关闭*/
    jq_Confirm_close: function () {
        $('.jq_dvconfirm').stop().animate({ "top": 0 - $('.jq_dvconfirm').height(), "opacity": 0 }, 150, function () {
            $(".jq_dvconfirm").remove();
            $.jq_MaskDiv_close();
        });
    },
    /*确定对话框*/
    jq_Alert: function (e) {
        if (!e) return;
        e.btnOktext = !e.btnOktext ? "确定" : e.btnOktext;
        e.dialogModal = e.dialogModal == undefined ? true : e.dialogModal;

        if (!e.message) {
            e.message = "请输入对应的提示信息";
        }

        //set it's modal
        if (e.dialogModal) {
            $.jq_MaskDiv();
        }
        var str = "<div class='jq_dvalert' style='z-index:2;box-shadow: 0px 0px 5px #BCD4E5;border: 1px solid #BCD4E5 !important;position:absolute;background-Color:#fff;min-width:578px;width:578px;min-height:144px;border: 1px solid rgba(0, 0, 0, 0.2);font-size: 13px;opacity:0;filter:alpha(opacity=0);-moz-opacity:0;'>"
                        + "<div style='min-height:54px;line-height:54px;padding:20px;'>"
                                + "<button title='关闭' class='btnclosealert' style='outline:0px;float:right;margin-top:-10px;font-size:18px;font-weight: bold;color: rgb(0, 0, 0);text-shadow: 0px 1px 0px rgb(255, 255, 255);border:0px;background-color:transparent;cursor:pointer;opacity:0.2;filter:alpha(opacity=20);-moz-opacity:0.2;'>×</button>"
                                + "<div style='font-size:16px;color: rgb(57, 57, 57);'>" + e.message + "</div>"
                        + "</div>"
                        + "<div style='overflow:auto;padding:12px 14px;background-color:rgb(239, 243, 248);'>"
                                + "<input class='alertbtnok' type='button' value=' ✓ " + e.btnOktext + "' style='float:right;' />"
                        + "</div>"
                    + "</div>";
        $("body").append(str);
        $(".btnclosealert").hover(function () {
            $(this).css("opacity", 1);
        }, function () {
            $(this).css("opacity", 0.2);
        });

        $('.jq_dvalert').css("left", ($(document).width() - $('.jq_dvalert').width()) / 2 + "px");
        $('.jq_dvalert').css("top", 0 - $('.jq_dvalert').height());
        $('.jq_dvalert').stop().animate({ "top": 20 + $(window).scrollTop(), "opacity": 1 }, 350);


        $('.alertbtnok').bind("click", function () {
            if (e.btnOkClick) e.btnOkClick();
            $.jq_Alert_close();
        });
        $('.btnclosealert').bind("click", function () {
            $.jq_Alert_close();
        });
    },
    /*确定对话框关闭*/
    jq_Alert_close: function () {
        $('.jq_dvalert').stop().animate({ "top": 0 - $('.jq_dvalert').height(), "opacity": 0 }, 150, function () {
            $(".jq_dvalert").remove();
            $.jq_MaskDiv_close();
        });
    },
    /*加载对话框*/
    jq_Loading: function () {
        //set it's modal
        $.jq_MaskDiv();
        var str = "<div class='jq_dvloading' style='z-index:2;box-shadow: 0px 0px 5px #BCD4E5;border: 1px solid #BCD4E5 !important;position:absolute;background-Color:#fff;min-width:578px;width:578px;border: 1px solid rgba(0, 0, 0, 0.2);font-size: 13px;opacity:0;filter:alpha(opacity=0);-moz-opacity:0;'>"
                        + "<div style='height:100px;padding:30px 30px;'>"
                                + "<div style='font-weight:bold;height:100px;line-height:100px;text-indent:160px;font-size:16px;color: rgb(57, 57, 57);background-Image:url(/Content/resources/images/loading.gif);background-repeat:no-repeat;background-position:40px 0px;'>正在加载，请稍后……</div>"
                        + "</div>"
                    + "</div>";
        $("body").append(str);

        $('.jq_dvloading').css("left", ($(document).width() - $('.jq_dvloading').width()) / 2 + "px");
        $('.jq_dvloading').css("top", 0 - $('.jq_dvloading').height());
        $('.jq_dvloading').stop().animate({ "top": 20 + $(window).scrollTop(), "opacity": 1 }, 350);
    },
    /*加载对话框     关闭*/
    jq_Loading_close: function () {
        $('.jq_dvloading').stop().animate({ "top": 0 - $('.jq_dvloading').height(), "opacity": 0 }, 150, function () {
            $(".jq_dvloading").remove();
            $.jq_MaskDiv_close();
        });
    },
    /*消息提示  对话框*/
    jq_Notifation: function (e) {
        if (!e) return;
        e.message = !e.message ? "请填写消息内容" : e.message;
        var str = "<div class='jq_dvnotifation' style='z-index:2;box-shadow: 0px 0px 5px #BCD4E5;border: 1px solid #BCD4E5 !important;position:absolute;right:5px;bottom:3px;background-Color:#fff;min-width:328px;width:328px;border: 1px solid rgba(0, 0, 0, 0.2);font-size: 13px;opacity:0;filter:alpha(opacity=0);-moz-opacity:0;'>"
                        + "<div class='jq_dvnotifation_title' style='background-color:#ECF2F7 !important;border-bottom: 1px solid #BCD4E5 !important;font-weight:600;padding:10px 10px;'>"
                                + "提示消息"
                                + "<button title='关闭' class='btnclosenotifation' style='outline:0px;float:right;margin-top:-5px;font-size:18px;font-weight: bold;color: rgb(0, 0, 0);text-shadow: 0px 1px 0px rgb(255, 255, 255);border:0px;background-color:transparent;cursor:pointer;opacity:0.2;filter:alpha(opacity=20);-moz-opacity:0.2;'>×</button>"
                        + "</div>"
                        + "<div class='jq_dvnotifation_content' style='padding:20px 10px;min-height:100px;'>"
                                + e.message
                        + "</div>"
                    + "</div>";

        $("body").append(str);
        $(".btnclosenotifation").hover(function () {
            $(this).css("opacity", 1);
        }, function () {
            $(this).css("opacity", 0.2);
        });


        $('.jq_dvnotifation').stop().animate({ "opacity": 1 }, 350);

        $('.btnclosenotifation').bind("click", function () {
            $.jq_Notifation_close();
        });
        var tm = window.setTimeout(function () {
            $.jq_Notifation_close();
        }, 4000);

        $('.jq_dvnotifation_title,.jq_dvnotifation_content').hover(function (event) {
            window.clearTimeout(tm);
            $('.jq_dvnotifation').css("opacity", 1);
        }, function () {
            tm = window.setTimeout(function () {
                $.jq_Notifation_close();
            }, 4000);
        });
    },
    /*消息提示  对话框     关闭*/
    jq_Notifation_close: function () {
        $('.jq_dvnotifation').stop().animate({ "opacity": 0 }, 1050, function () {
            $('.jq_dvnotifation').remove();
            window.clearTimeout($.notifationTime);
        });
    }
});
$.fn.extend({
    /**************分页效果***************/
    /*
    dataUrl             请求的url           必要参数      必须返回格式 {"data":[对象数组],"pagecount":20}
    theadContent        列头的格式          必要参数      <th>姓名</th><th>年龄</th><th>电话</th><th>地址</th><th>编辑</th><th>删除</th>
    tbodyContent        内容的格式          必要参数      function(data){ return "xxxx"; }   data为数据集合  返回数据为<tr><td>xx<td/></tr>
    currentPage         当前页码            default       1 
    tableId             表格id              default       tbRecord
    pageSize            每页记录            default       10
    showProgressBar     进度条              default       false
    complated           加载完成时间        default       function(){   }

    */
    jq_pageRecord: function (e) {
        this.each(function () {
            $.pageRecordEventArg = e;
            $.pageObject = $(this);
            e.currentPage = e.currentPage || 1;
            e.tableId = e.tableId || "tbRecord";
            e.pageSize = e.pageSize || 10;
            e.showProgressBar = e.showProgressBar || false; //是否显示延迟进度条
            if (e.showProgressBar) { $.jq_Loading(); }
            var vdata = { psize: e.pageSize, cpage: e.currentPage };
            for (var i in e.data) {
                vdata[i] = e.data[i];
    
            }
   
            $.ajax({
                type: "post",
                url: e.dataUrl,
                data: vdata,
                success: function (d) {
                    var obj = null;
                    var pageCount = -1;
                    var o = d;
                    for (var i in o) {
                        if (i != "pagecount")
                            obj = o[i];
                        else
                            pageCount = parseInt(o[i]);
                    }
                    var str = "<table class='table' id='" + e.tableId + "'>" +
                                "<thead>" +
                                    "<tr>" +
                                        e.theadContent +
                                    "</tr>" +
                                "</thead>";
                    str += "<tbody>";
                    str += e.tbodyContent(obj);
                    str += "</tbody>";
                    str += "<tfoot>" +
                                "<tr>" +
                                    "<td colspan='0'>" +
                                    "<div class='dvpagerecord pagefirst' title='首页'>" +
                                    "<i class='fa fa-angle-double-left txt'></i>" +
                                    "</div>" +
                                    "<div class='dvpagerecord prvePage' title='上一页'>" +
                                    "<i class='fa fa-angle-left'></i>" +
                                    "</div>" +
                                    "<ul class='ulpageRecord'>";
                    var pp = "";
                    for (var p = 1; p <= pageCount; p++) {
                        if (p == e.currentPage) {
                            pp += "<li class='currentPage'>" + p + "</li>";
                        }
                        else {
                            pp += "<li>" + p + "</li>";
                        }
                    }
                    str += pp;
                    str += "</ul>" +
                                    "<div class='dvpagerecord nextPage' title='下一页'>" +
                                    "<i class='fa fa-angle-right'></i>" +
                                    "</div>" +
                                    "<div class='dvpagerecord pagelast' title='尾页'>" +
                                    "<i class='fa fa-angle-double-right'></i>" +
                                    "</div>" +
                                "</td>" +
                                "</tr>" +
                            "</tfoot>" +
                            "</table>";
                    $.pageObject.html(str);

                    var liwidth = $(".ulpageRecord li:eq(0)").outerWidth();
                    //            			/*设定选中的位置*/
                    var selectedIndex = e.currentPage - 1;
                    var allwidth = 0;
                    var rd = $(".ulpageRecord>li");
                    for (var i = 0; i < rd.length ; i++) {
                        if (i != selectedIndex)
                            allwidth += rd.eq(i).outerWidth();
                        else
                            break;
                    }
                    var lf = allwidth + (liwidth * 2);
                    lf = lf < 0 ? 0 : lf;
                    $(".ulpageRecord").stop().animate({ scrollLeft: lf }, 20);

                    /*  各个按钮效果   */
                    /*	首页      尾页   li  点击效果	*/
                    $(".pagefirst").click(function () {
                        $(".ulpageRecord").stop().animate({ scrollLeft: 0 }, 300, function () {
                            $(".ulpageRecord").stop();
                            $.pageRecordEventArg.currentPage = $(".ulpageRecord li").first().html();
                            $.pageObject.jq_pageRecord($.pageRecordEventArg);
                        });
                    });
                    $(".pagelast").click(function () {
                        var val = $(".pagelast")[0].scrollWidth;
                        $(".pagelast").stop().animate({ scrollLeft: val + "px" }, 300, function () {
                            $(".pagelast").stop();
                            $.pageRecordEventArg.currentPage = $(".ulpageRecord li").last().html();
                            $.pageObject.jq_pageRecord($.pageRecordEventArg);
                        });
                    });


                    /*  上一页   下一页  li 长按效果  */
                    $(".nextPage").click(function () {
                        var val = $(".ulpageRecord").scrollLeft();
                        val += liwidth * 2;
                        $(".ulpageRecord").stop().animate({ scrollLeft: val }, 300);
                    });
                    $(".prvePage").click(function () {
                        var val = $(".ulpageRecord").scrollLeft();
                        val -= liwidth * 2;
                        $(".ulpageRecord").stop().animate({ scrollLeft: val }, 300);
                    });

                    //点击页码 刷新页面数据
                    $(".ulpageRecord li").click(function () {
                        $.pageRecordEventArg.currentPage = $(this).html();
                        $.pageObject.jq_pageRecord($.pageRecordEventArg);
                    });
                },
                error: function () {
                    alert("error");
                },
                complete: function (request, settings) {
                    $.jq_Loading_close();
                    if (e.complated != undefined) { e.complated(); }
                }
            });
        });
    }
});
