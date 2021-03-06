
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-1.7.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
</head>
<body>

<%--区域滚动--%>
<marquee>
    <p style="font-size: 100px">Hello JSP!!</p>
    <img src="${pageContext.servletContext.contextPath}/doge.gif">
</marquee>
<br>
${msg}
${pageContext.servletContext.contextPath}
<br>
<select style="width:500px;" class="js-example-basic-single"  name="state">
    <option value="AL">Alabama</option>
    <option value="WY">Wyoming</option>
</select>

<br/>

<select style="width:500px;"  class="js-example-basic-single" multiple="multiple" name="state">
    <option value="AL">Alabama</option>
    <option value="WY">Wyoming</option>
</select>

<br>



单个文件上传：form表单 <br/>
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="提交上传"/>
</form>


单个文件上传：Ajax<br/>
<form class="form-horizontal" id="upload_form" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label class="col-sm-3 control-label">请选择License.lic文件：</label>
        <div class="col-sm-6">
            <input type="file" class="form-control" id="file" name="file"/>
        </div>

        <div class="col-sm-3">
            <input type="button" name="btnUpload" id="btnUpload" value="上传" class="btn btn-primary" onclick="importLicense()">
        </div>
    </div>
</form>
<br/>
多个文件上传：
<form action="/uploads" method="post" enctype="multipart/form-data">
    文件1：<input type="file" name="file"/><br/>
    文件2：<input type="file" name="file"/><br/>
    文件3：<input type="file" name="file"/><br/>
    <input type="submit" value="上传多个文件"/>
</form>


<hr/>
<p> 文件下载</p>

<a href="download">A标签 下载</a>
<button onclick="test()">window.location.href  下载 </button>
<button  onclick="test2()">表单 下载 </button>

<form id="queryCourseForm" action="/download"></form>


</body>
</html>

<script>

    function test() {
        window.location.href = "/download"
    }

    function test2() {
        // $("#queryCourseForm").attr("action",contextPath+"/downCourses.do");//改变表单的提交地址为下载的地址
        $("#queryCourseForm").submit();//提交表单
    }

    $(document).ready(function() {
        $('.js-example-basic-single').select2();
    });

    $(".js-example-basic-multiple-limit").select2({
        maximumSelectionLength: 2
    });

    function importLicense() {
        var str = $("#file").val();
        var fileName = getFileName(str); // 获取上传 文件名
        var fileExt = str.substring(str.lastIndexOf('.') + 1);  // 获取上传 文件后缀名
        console.log(fileName + "\r\n" + fileExt,123123123123);
        if (fileName != "license.lic") {
            alert("请上传 license.lic 证书文件！")
            return;
        }
        var formData = new FormData($("#upload_form")[0]);
        $.ajax({
            type: "POST",
            url: "/upload",
            data: formData,
            // dataType: "json",
            dataType: "text",
            async: false,
            enctype: "multipart/form-data",
            cache: false,
            contentType: false,
            processData: false,
            success: function (result) {
                console.log(result,22222222);
            },
            error:function(data){ // sos 走这里是因为 dataType: "text" 与 controller 中 返回的 格式不一致导致的
                console.log(data,111111111);
            }
        });
    }
    //获取文件名称
    function getFileName(path) {
        var pos1 = path.lastIndexOf('/');
        var pos2 = path.lastIndexOf('\\');
        var pos = Math.max(pos1, pos2);
        if (pos < 0) {
            return path;
        } else {
            return path.substring(pos + 1);
        }
    }
</script>
