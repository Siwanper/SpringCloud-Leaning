<%--
  Created by IntelliJ IDEA.
  User: chenjie
  Date: 2020/10/21
  Time: 11:19 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/global.jsp" %>
<%@ include file="/common/include_index.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    <style>
        .s-profile > a{
            background: url("${pageContext.request.contextPath}/resource/images/background.png");
        }
    </style>
</head>
<body>
    <header id="header">
        <ul id="header-menu">
            <li id="guide" class="line-trigger">
                <div class="line-warp">
                    <div class="line top"></div>
                    <div class="line center"></div>
                    <div class="line bottom"></div>
                </div>
            </li>
            <li id="logo">
                <span id="logo-title">Siwanper</span>
            </li>
            <li class="pull-right">
                <ul class="pull-right-list">
                    <li class="dropdown">
                        <a class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" href="javascript:;">
                            <i class="menu-icon zmdi zmdi-search"></i>
                        </a>
                        <ul class="dropdown-menu pull-right">
                            <form class="search-form form-inline">
                                <div class="input-group">
                                    <input class="keywords form-control" type="text" name="keywords" placeholder="搜索">
                                    <div class="input-group-btn">
                                        <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                                    </div>
                                </div>
                            </form>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" href="javascript:;">
                            <i class="menu-icon zmdi zmdi-transform"></i>
                        </a>
                        <ul class="dropdown-menu dm-icon pull-right">
                            <li class="dropdown-header" style="text-align: center">角色切换
                            </li>
                            <li class="divider"></li>
                            <li style="text-align: center">
                                <a class="waves-effect" href="javascript:;">
                                    管理员
                                </a>
                            </li>
                            <li style="text-align: center">
                                <a class="waves-effect" href="javascript:;">
                                    技术部
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" href="javascript:;">
                            <i class="menu-icon zmdi zmdi-more-vert"></i>
                        </a>
                        <ul class="dropdown-menu pull-right">
                            <li>
                                <a class="waves-effect" href="javascript:;">
                                    <i class="zmdi zmdi-fullscreen"></i>全屏模式
                                </a>
                            </li>
                            <li>
                                <a class="waves-effect" href="javascript:;">
                                    <i class="zmdi zmdi-account"></i>个人资料
                                </a>
                            </li>
                            <li>
                                <a class="waves-effect" href="javascript:;">
                                    <i class="zmdi zmdi-settings"></i>系统设置
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a class="waves-effect" href="javascript:;">
                                    <i class="zmdi zmdi-run"></i>退出登录
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
    </header>

    <section id="main">
        <aside id="sidebar">
            <div class="s-profile">
                <a class="waves-light waves-effect" href="javascript:;">
                    <div class="sp-pic">
                        <img src="${pageContext.request.contextPath}/resource/images/avatar.png">
                    </div>
                    <div class="sp-info">
                        Siwanper ,你好
                        <i class="zmdi zmdi-caret-down"></i>
                    </div>
                </a>
                <ul class="main-menu">
                    <li>
                        <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-account"></i>个人信息</a>
                    </li>
                    <li>
                        <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-settings"></i>系统设置</a>
                    </li>
                    <li>
                        <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-run"></i>退出登录</a>
                    </li>
                </ul>
            </div>
            <ul id="main-menu" class="main-menu">
                <li>
                    <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-home"></i>首页</a>
                </li>
                <li class="sub-menu">
                    <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-account"></i>用户与权限管理</a>
                    <ul>
                        <li>
                            <a class="waves-effect" href="javascript:Tab.addTab('用户管理', '${pageContext.request.contextPath}/user/count');">用户管理</a>
                        </li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-run"></i>角色与资源管理</a>
                    <ul>
                        <li>
                            <a class="waves-effect" href="javascript:;">角色管理</a>
                        </li>
                        <li>
                            <a class="waves-effect" href="javascript:;">资源管理</a>
                        </li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-more"></i>其他数据管理</a>
                    <ul>
                        <li>
                            <a class="waves-effect" href="javascript:;">日志管理</a>
                        </li>
                        <li>
                            <a class="waves-effect" href="javascript:;">监控信息</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-text-format"></i>测试模块</a>
                </li>
                <li class="sub-menu">
                    <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-help"></i>帮助文档</a>
                    <ul>
                        <li>
                            <a class="waves-effect" href="javascript:;">界面UI模版</a>
                        </li>
                    </ul>
                </li>
            </ul>

            <div class="version-title">
                Siwanper V2.2.1
            </div>

        </aside>
        <section class="content">
            <div class="content_tab">
                <div class="tab_left">
                    <a class="waves-effect waves-light">
                        <i class="zmdi zmdi-chevron-left"></i>
                    </a>
                </div>
                <div class="tab_right">
                    <a class="waves-effect waves-light">
                        <i class="zmdi zmdi-chevron-right"></i>
                    </a>
                </div>
                <ul class="tabs">
                    <li id="tab_home" class="cur" data-index="home" data-closeable="false"><a class="waves-effect waves-light">首页</a></li>
                    <li id="tab_account" data-index="account" data-closeable="false"><a class="waves-effect waves-light">用户管理</a></li>
                    <li id="tab_role" data-index="role" data-closeable="false"><a class="waves-effect waves-light">角色管理</a></li>
                </ul>
            </div>
            <div class="content_main">
                <div id="iframe_home" class="iframe cur">
                    <p> 欢迎来到小麦公考！！！ </p>
                </div>
            </div>
        </section>
    </section>

    <footer id="footer">

    </footer>
</body>
</html>
