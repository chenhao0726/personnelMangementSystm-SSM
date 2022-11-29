<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/11/28
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script type="text/javascript" src="/js/jquery-1.11.2.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
${emp}
<div class="table-responsive" style="padding: 20px 40px 100px 10px;">
    <a href="/emp?type=input" class="btn btn-sm btn-info" role="button" aria-pressed="true" style="font-size: 7px;padding-bottom: 5px;">添加学生信息</a>
    <a href="/emp?type=classInput" class="btn btn-sm btn-info" role="button" aria-pressed="true" style="font-size: 7px;padding-bottom: 5px;">添加班级信息</a>
    <table class="table table-sm table-bordered table-hover" style="text-align: center">
        <thead>
        <tr>
            <th scope="col">编号</th>
            <th scope="col">名称</th>
            <th scope="col">密码</th>
            <th scope="col">年纪</th>
            <th scope="col">性别</th>
            <th scope="col">电话</th>
            <th scope="col">班级</th>
            <th scope="col">地址</th>
            <th scope="col" style="width: 110px;">操作</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">提示！</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    你确定要删除id=<span id="emid"></span>的信息吗？
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                    <a href="#" onclick="deleteId()" id="deleteSure" class="btn btn-primary" role="button">确认</a>
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    $(function (){
        // 发起请求
        $.get("/emp/empslist",function (datas) {
            var stra = "<a href='/stu?type=input&id=obj.id' class='btn btn-sm btn-info' role='button' aria-pressed='true' style='font-size: 7px;'>修改</a>"
            var strin = "<input type='button' class='btn btn-primary btn-sm btn-danger' data-toggle='modal' data-target='#exampleModal' style='font-size: 7px;' value='删除' onclick='values('obj.id')'>"
            // 循环数据
            $.each(datas,function (index,obj){
                var $td = $("table tbody").append("<tr></tr>");
                $td.append("<td>"+obj.id+"</td>");
                $td.append("<td>"+obj.name+"</td>")
                $td.append("<td>"+obj.password+"</td>")
                $td.append("<td>"+obj.age+"</td>")
                $td.append("<td>"+obj.gender+"</td>")
                $td.append("<td>"+obj.phone+"</td>")
                $td.append("<td>"+obj.salary+"</td>")
                $td.append("<td>"+obj.address+"</td>")
                $td.append("<td>"+"<a href='/stu?type=input&id=obj.id' class='btn btn-sm btn-info' role='button' aria-pressed='true' style='font-size: 7px;'>修改</a>"
                    +"<input type='button' class='btn btn-primary btn-sm btn-danger' data-toggle='modal' data-target='#exampleModal' style='font-size: 7px;' value='删除' onclick='values()'>"+"</td>")
                <%--<a href="/stu?type=input&id=${stu.id}" class="btn btn-sm btn-info" role="button" aria-pressed="true" style="font-size: 7px;">修改</a>--%>
                <%--<input type="button" class="btn btn-primary btn-sm btn-danger" data-toggle="modal" data-target="#exampleModal" style="font-size: 7px;" value="删除" onclick="values('${stu.id}')">--%>

                })
        })
    })

    $("#exampleModal").modal("hide");
    function values(ID){
        $("#id").val(ID);
        document.getElementById('use').innerText='id='+ID;
    }

    function deleteId(){
        var id = document.getElementById('id').value;
        document.getElementById('use').innerText='id='+id;
        document.getElementById('deleteSure').href='/stu?type=delete&id='+id;
    }
</script>
</body>
</html>
