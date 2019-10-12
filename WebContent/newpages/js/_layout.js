/// <reference path="jquery-1.7.2.min.js" />
var Config = {
    "setting":
    {
        "url":
        {
            "/Settings/UserSetting": [0, 0]
            , "/Settings/RoleSetting": [0, 1]
        }
    },
    "urlInit": function () {
        var href = window.location.toString();
        var myurl = window.location.protocol + "//" + window.location.host;
        myurl = href.replace(myurl, "");
        for (var i in Config.setting.url) {
            if (i.indexOf(myurl) == 0) {
                var j = this.setting.url[i][0];
                var k = this.setting.url[i][1];
                $(".limenuitem>li").css("color", "black");
                $(".limenuitem").eq(j).css("background-Color", "#F5F5F5");
                $(".limenuitem").eq(j).css("border-left", "3px solid #F5F5F5");
                $(".limenuitem").eq(j).css("background-Color", "white");
                $(".limenuitem").eq(j).css("border-left", "3px solid #2B7DBC");
                $(".limenuitem").eq(j).children(".ulleftsubitems").eq(0).stop().animate({ "height": "show" });
                $(".limenuitem").eq(j).children(".ulleftsubitems").eq(0).children("li").eq(k).css("color", "#2B7DBC");
                $(".limenuitem").eq(j).children(".ulleftsubitems").eq(0).children("li").eq(k).css("background-image", "url('/content/resources/images/menuarrow.jpg')");
                return
            }
        }
        $(".limenuitem>li").css("color", "black");
        $(".ulleftsubitems").stop().animate({ "height": "show" });
    },
    "tableInit": function () {
        $(".table>tbody>tr").hover(function () {
            $(this).css("background-color", "#F5F5F5");
        }, function () {
            $(this).css("background-color", "#ffffff");
        });
    },
    "init": function () {
        this.urlInit();
        this.tableInit();
    }
};

$(function () {
    Config.init();
    /*左侧菜单动画*/
//  $(".limenuitem").click(function () {
//      if ($(this).children(".ulleftsubitems").css("display") == "none") {
//          $(".ulleftsubitems").stop().animate({ "height": "hide" });
//          $(".limenuitem").css("background-Color", "#F5F5F5");
//          $(".limenuitem").css("border-left", "3px solid #F5F5F5");
//          $(this).css("background-Color", "white");
//          $(this).css("border-left", "3px solid #2B7DBC");
//          $(this).children(".ulleftsubitems").stop().animate({ "height": "show" });
//      }
//      else {
//          $(".ulleftsubitems").stop().animate({ "height": "hide" });
//          $(".limenuitem").css("background-Color", "#F5F5F5");
//          $(".limenuitem").css("border-left", "3px solid #F5F5F5");
//      }
//  });
    $(".ulleftsubitems").bind("click", function (event) {
        event.stopPropagation();
    });
});
