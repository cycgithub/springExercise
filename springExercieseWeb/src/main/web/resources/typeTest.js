/**
 *
 * Created by chenyuchao on 2016/7/18.
 */
var carname1 = "Bill Gates";
var carname2 = 'Bill Gates';
var answer1 = "Nice to meet you !";
var answer2 = "He is called 'Bill'";
var answer3 = 'He is called "Bill"';

document.write(carname1 + "<br>");
document.write(carname2 + "<br>");
document.write(answer1 + '<br>');
document.write(answer2 + '<br>');
document.write(answer3 + '<br>');
pathTest();
(function ($) {
    $.fn.jrPaginate = function (options) {
        $this = $(this);
        var opt = $.extend({}, $.fn.jrPaginate.default, options || {});
        if (opt.mode == 1) {
            $.fn.jrPaginate.ajax(opt, $this);
        }
        if (opt.mode == 2) {
            //普通分页
        }

    };
    $.fn.jrPaginate.defaults = {
        //js方法
        method: "pageSearch",
        //1:Ajax分页。2：普通分页（暂不支持）
        mode: 1,
        //当只有1页时是否显示分页
        hasBar: false,
        //分页bar
        pageBarNum: 5,
        //当前页
        pageIndex: 1,
        //总页数
        pageTotal: 0,
        //总记录数
        pageItem: 0,
        //每页大小
        pageSize: 10,
        //分页查询条件
        pageCondition: "",
        //pagePos
        pagePos: 2,
        //显示配置
        barConfigs: {
            pageHome: "首页",
            pageUp: "上一页",
            pageDown: "下一页",
            pageTrailer: "尾页"
        },
        //每页size选择
        selectBar: true,
        selectBarSize: [10, 20]
    };
    $.fn.jrPaginate.ajax=function(opt,obj){
        var barStr="";
        if(!opt||opt.pageTotal==0){
            obj.html(barStr);
            return;
        }
    }
})(jQuery);
