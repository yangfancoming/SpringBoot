
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- use EL-Expression-->
<%@ page isELIgnored="false" %>
<!-- use JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8" content="#">
    <title>学生信息管理页面</title>
    <!-- 引入CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/css/demo.css">
    <!-- 引入JS -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/themes/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/validateExtends.js"></script>

    <script type="text/javascript">
        //DOM加载完成后执行的回调函数
        $(function () {



            //信息修改按钮事件
            $("#edit").click(function () {
                table = $("#editTable");
                var selectRows = $("#dataList").datagrid("getSelections");
                if (selectRows.length !== 1) {
                    $.messager.alert("消息提醒", "请单条选择想要修改的数据哟!", "warning");
                } else {
                    $("#editDialog").dialog("open");
                }
            });



            //设置编辑学生信息窗口
            $("#editDialog").dialog({
                title: "修改学生信息窗口",
                width: 660,
                height: 500,
                iconCls: "icon-house",
                modal: true,
                collapsible: false,
                minimizable: false,
                maximizable: false,
                draggable: true,
                closed: true,
                buttons: [
                    {
                        text: '提交',
                        plain: true,
                        iconCls: 'icon-edit',
                        handler: function () {
                            var validate = $("#editForm").form("validate");
                            if (!validate) {
                                $.messager.alert("消息提醒", "请检查你输入的数据哟!", "warning");
                            } else {
                                var data = $("#editForm").serialize();//序列化表单信息
                                $.ajax({
                                    type: "post",
                                    url: "editStudent?t=" + new Date().getTime(),
                                    data: data,
                                    dataType: 'json',
                                    success: function (data) {
                                        if (data.success) {
                                            //关闭窗口
                                            $("#editDialog").dialog("close");
                                            //重新刷新页面数据
                                            $('#dataList').datagrid("reload");
                                            $('#dataList').datagrid("uncheckAll");
                                            //用户提示
                                            $.messager.alert("消息提醒", "修改成功啦!", "info");
                                        } else {
                                            $.messager.alert("消息提醒", data.msg, "warning");
                                        }
                                    }
                                });
                            }
                        }
                    },
                    {
                        text: '重置',
                        plain: true,
                        iconCls: 'icon-reload',
                        handler: function () {
                            $("#edit_name").textbox('setValue', "");
                            $("#edit_gender").textbox('setValue', "男");
                            $("#edit_password").textbox('setValue', "");
                            $("#edit_email").textbox('setValue', "");
                            $("#edit_telephone").textbox('setValue', "");
                            $("#edit_address").textbox('setValue', "");
                            $("#edit_introducation").textbox('setValue', "");
                        }
                    }
                ],
                //打开窗口前先初始化表单数据(表单回显)
                onBeforeOpen: function () {
                    var selectRow = $("#dataList").datagrid("getSelected");
                    $("#edit_id").val(selectRow.id);//初始化id值,需根据id更新学生信息
                    $("#edit_sno").textbox('setValue', selectRow.sno);
                    $("#edit_name").textbox('setValue', selectRow.name);
                    $("#edit_gender").textbox('setValue', selectRow.gender);
                    $("#edit_password").textbox('setValue', selectRow.password);
                    $("#edit_email").textbox('setValue', selectRow.email);
                    $("#edit_telephone").textbox('setValue', selectRow.telephone);
                    $("#edit_address").textbox('setValue', selectRow.address);
                    $("#edit_introducation").textbox('setValue', selectRow.introducation);
                    //通过获取头像路径来显示该学生的头像
                    $("#edit-portrait").attr('src', selectRow.portrait_path);
                    //初始化头像路径(已优化:在执行SQL语句时通过判断头像路径是否为空,为空则代表用户并未修改头像)
                    //$("#edit_portrait-path").val(selectRow.portrait_path);
                }
            });

            //学生与班级名搜索按钮的监听事件(将其值返回给Controller)
            $("#search-btn").click(function () {
                $('#dataList').datagrid('load', {
                    studentname: $('#search-studentname').val(),//获取学生名称
                    clazzname: $('#search-clazzname').combobox('getValue')//获取年级名称
                });
            });


            //修改信息窗口中上传头像的按钮事件
            $("#edit-upload-btn").click(function () {
                if ($("#edit-choose-portrait").filebox("getValue") === '') {
                    $.messager.alert("提示", "请选择图片!", "warning");
                    return;
                }
                $("#edit-uploadForm").submit();

            });

        });

        //上传头像按钮事件
        function uploaded() {
            var data = $(window.frames["photo_target"].document).find("body pre").text();
            data = JSON.parse(data);//将data装换为JSON对象
            if (data.success) {
                $.messager.alert("提示", "图片上传成功!", "info");
                //切换头像
                $("#add-portrait").attr("src", data.portrait_path);
                $("#edit-portrait").attr("src", data.portrait_path);
                //将头像路径存储到学生信息表单中(利用从用户信息中读取头像路径来显示头像)
                $("#add_portrait_path").val(data.portrait_path);
                $("#edit_portrait-path").val(data.portrait_path);
            } else {
                $.messager.alert("提示", data.msg, "warning");
            }
        }

    </script>
</head>
<body>



<!-- 修改信息窗口 -->
<div id="editDialog" style="padding: 20px 0 0 65px">
    <!-- 设置修改头像功能 -->
    <div style="float: right; margin: 15px 40px 0 0; width: 250px; border: 1px solid #EEF4FF" id="edit-photo">
        <img id="edit-portrait" alt="照片" style="max-width: 250px; max-height: 300px;" title="照片"
             src="${pageContext.request.contextPath}/image/portrait/default_student_portrait.png"/>
        <!-- 设置上传图片按钮 -->
        <form id="edit-uploadForm" method="post" enctype="multipart/form-data" action="uploadPhoto"
              target="photo_target">
            <input id="edit-choose-portrait" class="easyui-filebox" name="photo" data-options="prompt:'选择照片'"
                   style="width:200px;">
            <input id="edit-upload-btn" class="easyui-linkbutton" style="width: 50px; height: 24px;;float:right;"
                   type="button" value="上传"/>
        </form>
    </div>
    <!-- 学生信息表单 -->
    <form id="editForm" method="post" action="#">
        <!-- 获取被修改信息的学生id -->
        <input type="hidden" id="edit_id" name="id"/>
        <table id="editTable" style="border-collapse:separate; border-spacing:0 3px;" cellpadding="6">
            <!-- 存储所上传的头像路径 -->
            <input id="edit_portrait-path" type="hidden" name="portrait_path"/>
            <tr>
                <td>班级</td>
                <td colspan="1">
                    <select id="edit_clazz_name" style="width: 200px; height: 30px;" class="easyui-combobox"
                            name="clazz_name">
                        <c:forEach items="${clazzList}" var="clazz">
                            <option value="${clazz.name}">${clazz.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>姓名</td>
                <td colspan="1">
                    <input id="edit_name" style="width: 200px; height: 30px;" class="easyui-textbox"
                           type="text" name="name" data-options="required:true, missingMessage:'请填写姓名哟~'"/>
                </td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <select id="edit_gender" class="easyui-combobox"
                            data-options="editable: false, panelHeight: 50, width: 60, height: 30" name="gender">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>学号</td>
                <td colspan="1">
                    <!-- 设置为只读 -->
                    <input id="edit_sno" data-options="readonly: true" style="width: 200px; height: 30px;"
                           class="easyui-textbox" type="text"/>
                </td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td colspan="1"><input id="edit_email" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="email" validType="email"
                                       data-options="required:true, missingMessage:'请填写邮箱地址哟~'"/>
                </td>
            </tr>
            <tr>
                <td>电话</td>
                <td colspan="4"><input id="edit_telephone" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="telephone" validType="mobile"
                                       data-options="required:true, missingMessage:'请填写联系方式哟~'"/>
                </td>
            </tr>
            <tr>
                <td>住址</td>
                <td colspan="1"><input id="edit_address" style="width: 200px; height: 30px;" class="easyui-textbox"
                                       type="text" name="address"
                                       data-options="required:true, missingMessage:'请填写家庭住址哟~'"/>
                </td>
            </tr>
            <tr>
                <td>简介</td>
                <td colspan="4"><input id="edit_introducation" style="width: 200px; height: 60px;"
                                       class="easyui-textbox"
                                       type="text" name="introducation"
                                       data-options="multiline:true,required:true, missingMessage:'记得填写个人简介呦~'"/>
                </td>
            </tr>
        </table>
    </form>
</div>

<!-- 表单处理 -->
<iframe id="photo_target" name="photo_target" onload="uploaded(this)"></iframe>

</body>
</html>