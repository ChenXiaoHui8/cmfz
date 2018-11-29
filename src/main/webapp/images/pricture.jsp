<%@page isELIgnored="false" pageEncoding="utf-8" contentType="text/html; UTF-8" %>
<body>
<table id="dg"></table>
<div id="dd">
    <form id="insertForm" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>title</td>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <td>imgPath</td>
                <td><input type="file" name="uploadFile"></td>
            </tr>
            <tr>
                <td>desc</td>
                <td><input type="text" name="desc"></td>
            </tr>
            <tr>
                <td>status</td>
                <td><input type="text" name="status"></td>
            </tr>
            <tr>
                <td>date</td>
                <td><input type="date" name="date"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="button" value="保存" onclick="toAdd()"/></td>
            </tr>
        </table>
    </form>


</div>

<script type="text/javascript">
    var toolbar = [{
        iconCls: 'icon-edit',
        text: "添加",
        handler: function () {
            $("#dd").dialog("open")
        }
    }, '-', {
        iconCls: 'icon-help',
        text: "删除",
        handler: function () {
            var row = $("#dg").edatagrid("getSelected")
            if (row == null) {
                $.messager.alert('提示', '请选', 'info');
            } else {
                $.ajax({
                    url: "${pageContext.request.contextPath}/delete",
                    data: "id=" + row.id,
                    success: function (data) {
                        if (data) {
                            $("dg").edatagrid("reload");
                        } else {
                            $.messager.alert('失败', '删除失败', 'error');
                        }
                    }
                })
            }
        }
    }, '-', {
        text: "修改",
        iconCls: 'icon-help',
        handler: function () {
            /*获取选中行*/
            var row = $("#dg").edatagrid("getSelected")
            if (row == null) {
                $.messager.show({
                    title: '警告',
                    msg: '请选中修改行。',
                    showType: 'show',
                    style: {
                        right: '',
                        top: document.body.scrollTop + document.documentElement.scrollTop,
                        bottom: ''
                    }
                });
            } else {
                /*将当前行变成可编辑模式*/
                var index = $("#dg").edatagrid("getRowIndex", row);
                $("#dg").edatagrid("editRow", index);
            }

        }
    }, '-', {
        text: "保存",
        iconCls: 'icon-help',
        handler: function () {
            $("#dg").edatagrid("saveRow");
        }
    }];

    /*构建数据表格*/
    $(function () {
        $('#dg').edatagrid({
            updateUrl: "${pageContext.request.contextPath}/update",
            toolbar: toolbar,
            url: '${pageContext.request.contextPath}/selectAll',
            method: "get",
            columns: [[
                {field: 'title', title: '图片名字', width: 100},
                {
                    field: 'status', title: '状态', width: 100,
                    // 定义该列为可编辑列
                    editor: {
                        // 定义编辑的形式为文本框text
                        type: "text",
                        options: {
                            // 编辑后必须有值（即不能为空）
                            required: true
                        }
                    }
                },
                {field: 'desc', title: '描述', width: 100, align: 'right'},
            ]],
            fit: true,
            fitColumns: true,
            pagination: true,
            pageSize: 3,
            pageList: [3, 6, 9],
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/img/' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>时间: ' + rowData.date + '</p>' +
                    '<p>:描述:' + rowData.desc + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }

        });
        $('#dd').dialog({
            title: 'My Dialog',

            closed: true,

            modal: true
        });


    })


    function toAdd() {
        alert(11)
        $("#insertForm").form("submit", {
            url: "${pageContext.request.contextPath}/insert",
            /*onSubmit: function(){
                return $(this).form("validate");
            },*/
            success: function (data) {
                if (data == "true") {
                    $('#dd').dialog("close");
                    $("#dg").edatagrid("reload");
                } else {
                    $.messager.alert('警告', '添加失败！', 'error');
                }
            }

        })
    }


</script>


</body>