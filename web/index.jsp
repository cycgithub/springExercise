<%--
  Created by IntelliJ IDEA.
  User: chenyuchao
  Date: 2016/7/15
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="resources/jquery-3.1.0.js"></script>
    <!-- <script src="resources/pathTest.js"></script>-->
    <script src="resources/typeTest.js"></script>
    <title>$Title$</title>
    <script>
        $(document).ready(
                function () {
                    $("button").click(function () {
                        $("#div1").fadeIn();
                        $("#div2").fadeIn("slow");
                        $("#div3").fadeIn(3000);
                    });
                }
        );
    </script>
</head>


<body>
<button id="cyc" onclick="pathTest()">点击这里</button>
<br>
<a href="functionTest.html">函数测试</a>
<br>
<p>演示带有不同参数的fadeIn（）方法。</p>
<button>点击这里，使三个举行淡入</button>
<br><br>
<div id="div1" style="width:80px;height:80px;display:none;background-color:red;"></div>
<br>
<div id="div2" style="width:80px;height:80px;display:none;background-color:green"></div>
<div id="div3" style="width:80px;height:80px;display:none;background-color:blue"></div>
<form action="dataTrans/transDirect.htm" method="post" id="searchForm">
    <input id="data" name="data" type="text"/>
    <input type="submit"/>
</form>
</body>

</html>
