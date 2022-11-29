<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="/styles/formui.css" />
    <link rel="stylesheet" type="text/css" href="/styles/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="/styles/base.css"/>
    <script type="text/javascript" src="/scripts/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="/scripts/jquery-ui-1.8.22.custom.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
    <script type="text/javascript">
        $(function () {
            $(".datepicker").datepicker();

            $('#find').click(function () {
                 $.dialog({
                    title: '查询结果',
                    content: 'url:Template/griddatalist.html',
                    lock: true,
					width:650,
					height:450
            			})
            })
        })

    </script>
</head>
<body>
    <div class="alert alert-info">当前位置<b class="tip"></b>学员管理<b class="tip"></b>添加</div>
    <form action="/emp/save" method="post">
    	<input type="hidden" name="id" value="${employee.id}">
	    <table class="tbform">
	        <thead>
	            <tr>
	                <td colspan="6" class="auto-style2">&nbsp;请填写添加数据 </td>
	            </tr>
	        </thead>
	        <tbody>
	            <tr>
	                <td class="tdl">姓名</td>
	                <td>
	                    <div class="input-append">
	                        <input class="ipt" name="name" value="${employee.name}" size="180" type="text" />
	                    </div>
	                </td>
	            </tr> 
	            <tr>
	                <td class="tdl">密码</td>
	                <td>
	                    <div class="input-append">
	                        <input class="ipt" name="password" value="${employee.password}" size="180" type="password" />
	                    </div>
	                </td>
	            </tr>   
	            <tr>
	                <td class="tdl">年龄</td>
	                <td>
	                    <div class="input-append">
	                        <input class="ipt" name="age" value="${employee.age}" size="180" type="number" />
	                    </div>
	                </td>
	             </tr>   
	            <tr>
	                <td class="tdl">性别</td>
	                <td>
	                    <div class="input-append">
	                        <input name="gender" type="radio" value="0" <c:if test="${employee.gender == 0}">checked</c:if> />女
	                        <input name="gender" type="radio" value="1" <c:if test="${employee.gender == 1}">checked</c:if> />男
	                    </div>
	                </td>
	             </tr>
				<tr>
					<td class="tdl">电话</td>
					<td>
						<div class="input-append">
							<input class="ipt" name="phone" value="${employee.phone}" size="180" type="text" />
						</div>
					</td>
				</tr>
				<tr>
					<td class="tdl">薪资</td>
					<td>
						<div class="input-append">
							<input class="ipt" name="salary" value="${employee.salary}" size="180" type="number" />
						</div>
					</td>
				</tr>
				<tr>
					<td class="tdl">部门</td>
					<td>
						<div class="input-append">
							<select name="dept.id">
								<option>--请选择--</option>
								<c:forEach items="${depts}" var="dep">
									<option name="class_id"
											<c:if test="${employee.dept.id==dep.id}">selected</c:if>
											value="${dep.id}">${dep.name}</option>
								</c:forEach>
							</select>
<%--							<input class="ipt" name="salary" value="${student.className}" size="180" type="text" />--%>
						</div>
					</td>
				</tr>
				<tr>
	                <td class="tdl">地址</td>
	                <td>
	                    <div class="input-append">
	                        <input class="ipt" name="address" value="${employee.address }" size="180" type="text" />
	                    </div>
	                </td>
	             </tr>
	             <tr>
	             	<td></td>
	             	<td>
	             		<button class="btn">提交</button>
	             	</td>
	             </tr>
	        </tbody>
	    </table>
	</form>
</body>
</html>
