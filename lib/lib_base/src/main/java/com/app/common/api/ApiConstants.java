package com.app.common.api;


public interface ApiConstants {

    int CONNECT_TIMEOUT = 15;
    int READ_TIMEOUT = 60;
    int WRITE_TIMEOUT = 15;

    String prefix = "/gydl/a";
//    String prefix = "/gydl_war_exploded/a";// 张强
//    String prefix = "/a";// 任梦

    String JSESSIONID = ";JSESSIONID={JSESSIONID}";

    String On_Get_SM2_PubK = "/gydl/f/app/sm/init";//获取服务器公钥
//        String On_Get_SM2_PubK = "/gydl_war_exploded/f/app/sm/init";//获取服务器公钥 张强
    //    String On_Get_SM2_PubK = "/f/app/sm/init";//获取服务器公钥 任梦
    String ON_LOGIN = prefix + "/login"; //登录
    String On_UserInfo_Search = prefix + "/gydl/jctz/dlbt/ry/app/user" + JSESSIONID; //获取用户信息
    String ON_CABLE_SEARCH = prefix + "/gydl/jctz/dlbt/dlxl/app/list" + JSESSIONID; //线路列表查询
    String On_Company_Search = prefix + "/gydl/jctz/dlbt/ry/app/Company" + JSESSIONID; //线路列表查询


    String ON_CABLE_SEARCH_ROAD = prefix + "/gydl/jctz/dlbt/dld/app/find" + JSESSIONID; //根据线路查询路段
    String ON_CABLE_SEARCH_ROAD_PassWay = prefix + "/gydl/jctz/td/dltd/app/query" + JSESSIONID; //电缆通道查询
    String ON_TD_Search = prefix + "/gydl/jctz/td/dltd/app/query" + JSESSIONID; //电缆通道查询

    String ON_VO_SEARCH = prefix + "/gydl/jctz/dydj/app/query" + JSESSIONID;//电压等级查询

    String ON_PERSON_SEARCH = prefix + "/gydl/jctz/dlbt/ry/app/list" + JSESSIONID; //人员查询
    String ON_PERSON_LIST = prefix + "/gydl/app/gzgl/qxryList" + JSESSIONID; //人员列表
    String ON_BZ_SEARCH = prefix + "/gydl/jctz/bz/app/query" + JSESSIONID;//班组查询
    String ON_BM_SEARCH = prefix + "/gydl/jctz/dlbt/ry/app/officeList" + JSESSIONID;//部门查询
    String ON_QY_SEARCH = prefix + "/app/tool/findAppList" + JSESSIONID;//区域查询

    String ON_Qxczrw_Search = "gydl/a/qxdj/qxdj/app/getByQxbh" + JSESSIONID;//缺陷处置任务查询
    String ON_Qxrw_Search = prefix + "/qxdj/qxdj/app/Worklist" + JSESSIONID;//缺陷任务列表
    String ON_DEFECT_SEARCH = prefix + "/qxdj/qxdj/app/list" + JSESSIONID;//缺陷列表查询(缺陷登记)
    String ON_DEFECT_SEARCH2 = prefix + "/sx/app/qxDetailList" + JSESSIONID;//缺陷列表查询2 根据任务编号查询(缺陷消缺)
    String ON_DEFECT_SUBMITE = prefix + "/qxdj/qxdj/app/save" + JSESSIONID;//缺陷上传
    String ON_DEFECT_Mission_SUBMITE = prefix + "/sx/app/xqQx" + JSESSIONID;//缺陷任务上传

    String ON_Qxrw_Search2 = prefix + "/qxdj/qxdj/app/qxczrwQuery" + JSESSIONID;//缺陷任务列表查询2
    String ON_QxrwZt_Submit = prefix + "/qxdj/qxdj/app/jobStart" + JSESSIONID;//缺陷任务状态提交
    String ON_QxrwXq_Submit = prefix + "/qxdj/qxdj/app/qxrwxq" + JSESSIONID;//缺陷任务消缺上传
    String ON_QxrwXq_Search = prefix + "/qxdj/qxdj/app/getXqInfo" + JSESSIONID;//缺陷任务消缺下载
    String ON_QxrwXgqx_Search = prefix + "/qxdj/qxdj/app/queryQxglByqxbh" + JSESSIONID;//缺陷任务相关缺陷列表查询
    String ON_QxrwXgdw_Search = prefix + "" + JSESSIONID;//缺陷任务相关单位查询


    /*带电检测*/
    String ON_ElectestMission_Download = prefix + "/app/ddjc/list" + JSESSIONID;//检修任务下载
    String ON_ElectestMission_Submit = prefix + "/app/ddjc/jcrwSave" + JSESSIONID;//检修任务上传
    String ON_Jcjbxx_Download = prefix + "/app/ddjc/getRecord" + JSESSIONID;//检修任务下载
    String ON_Jcjbxx_Submit = prefix + "/app/ddjc/saveRecord" + JSESSIONID;//检修任务下载


    String ON_Yhczrw_Search = "gydl/a/yhdj/yhdj/app/getByYhbh" + JSESSIONID;//隐患处置任务
    String ON_Yhrw_Search = prefix + "/yhdj/yhdj/app/workList" + JSESSIONID;//隐患任务列表
    String ON_DANGER_SEARCH = prefix + "/yhdj/yhdj/app/list" + JSESSIONID;//隐患查询
    String ON_DANGER_SUBMITE = prefix + "/yhdj/yhdj/app/save" + JSESSIONID;//隐患上传
    String ON_DANGER_Template_SEARCH = prefix + "/yhdj/yhdj/app/yhTemplate" + JSESSIONID;//隐患表单模板下载
    String ON_DANGER_SBQD = prefix + "/app/tool/querysbqd" + JSESSIONID;//设备清单
    String ON_DANGER_SBQD2 = prefix + "/app/tool/querysbqd1" + JSESSIONID;//设备清单
    String ON_DICT_SEARCH = prefix + "/app/tool/dict" + JSESSIONID;//字典表
    String ON_DICT_Sblxmc = prefix + "/app/tool/dictLabels" + JSESSIONID;//设备类型名称查询
    String ON_Danger_Mission_SUBMITE = prefix + "/sx/app/yhQx" + JSESSIONID;//

    String ON_PATROL_PLAN_SEARCH = prefix + "/sx/app/list" + JSESSIONID;//巡视计划与历史查询
    String ON_XianluZb_SEARCH = prefix + "/gydl/ywgl/xsglxsrw/xsglXsrw/xsDt" + JSESSIONID;//线路坐标查询
    String ON_PATROL_Trail_Submite = prefix + "/app/position/save" + JSESSIONID;//巡视记录轨迹提交
    String ON_PATROL_Trail_Search = prefix + "/app/position/list" + JSESSIONID;//巡视记录轨迹下载
    String ON_User_Location_Submite = prefix + "/app/xtgyYhfb/save" + JSESSIONID;//用户坐标上传
    String ON_User_Location_Search = prefix + "/app/xtgyYhfb/findZb" + JSESSIONID;//用户坐标查询
    String ON_PATROL_PLAN_SUBMITE = prefix + "/sx/app/save" + JSESSIONID;//巡视计划提交
    String ON_THINKTANK_FINDALL = prefix + "/app/zk/findAll" + JSESSIONID;//智库列表下载
    String ON_THINKTANK_DOWNLOAD = prefix + "/app/zk/download" + JSESSIONID;//智库文件下载 参数wjlj ywjmc
    String ON_Sbqd_Dowload = prefix + "/app/ewm/save" + JSESSIONID;//设备清单下载
    String ON_Xsrwbc = prefix + "/sx/app/xsrwSave" + JSESSIONID;//
    /*巡视新需求接口*/
    String On_Xsrw_Search = prefix+"/sx/app/newApplist" + JSESSIONID;//巡视任务列表下载
    String On_Qxrws_Search = "/sx/app/AppFindGlqxPage" + JSESSIONID;//可添加的缺陷任务列表下载
    String On_Yhrws_Search = "/sx/app/AppFindGlyhPage" + JSESSIONID;//可添加的隐患任务列表下载
    String On_Ddjcrws_Search = "/sx/app/AppFindGlddjcPage" + JSESSIONID;//可添加的带电检测任务列表下载
    String On_Qxrws_Old_Search = "/sx/app/AppFindOldQxtbList" + JSESSIONID;//已添加的缺陷任务列表下载
    String On_Yhrws_Old_Search = "/sx/app/AppFindOldQxtbList" + JSESSIONID;//已添加的隐患任务列表下载
    String On_Ddjcrws_Old_Search = "/sx/app/AppFindOldQxtbList" + JSESSIONID;//已添加的隐患任务列表下载
    String On_Xsrw_Upload = "/sx/app/AppXsrwSave" + JSESSIONID;//巡视任务上传
    String On_XsrwZp_Submite = "/sx/app/AppXsrwTrans   " + JSESSIONID;//巡视任务上传
    String On_Xsrwxq = prefix + "/sx/app/AppXsrwDetail" + JSESSIONID;//巡视任务详情


    String ON_DANGER_CONTROL_SEARCH = prefix + "/yhdj/yhdj/app/listYhgk" + JSESSIONID;//隐患管控查询
    String ON_DANGER_ADD_CONTROL = prefix + "/gydl/app/gzgl/gzjlForm" + JSESSIONID;//管控新增

    String ON_DANGER_CONTROL_SUBMITE = prefix + "/yhdj/yhdj/app/saveYhgk" + JSESSIONID;//

    String ON_BDZS_LIST = prefix + "/app/bdgl/list" + JSESSIONID;//保电值守
    String ON_BDZSJL_SEARCH = prefix + "/app/bdgl/zsjlList" + JSESSIONID;//值守记录
    String ON_BDZSJL_SAVE = prefix + "/app/bdgl/zsSave" + JSESSIONID;//值守记录保存
    String ON_BDRW_SAVE = prefix + "/app/bdgl/updateZszt" + JSESSIONID;//值守任务状态更新
    String ON_GET_EMERGENCY_STATE = prefix + "/gydl/bdgl/bdzs/getBdzs" + JSESSIONID;  //获得告警状态
    String ON_EMERGENCY_RECORD = prefix + "/gydl/bdgl/bdzs/gjqkZsdd" + JSESSIONID;  //上传告警记录
    String ON_EMERGENCY_RECORD_LIST = prefix + "/app/bdgl/zsjlBjList" + JSESSIONID;  //值守记录list
    String ON_EMERGENCY_RECORD_SAVE = prefix + "/app/bdgl/updateZssjl" + JSESSIONID;  //值守记录保存

    String ON_FAULT_SOURCE_LIST_ = prefix + "/gydl/app/gzgl/qxzyList" + JSESSIONID;//抢修资源列表
    String ON_FAULT_LIST_ = prefix + "/gydl/app/gzgl/gzdjList" + JSESSIONID;//故障列表
    String ON_FAUL_SAVE_ = prefix + "/gydl/app/gzgl/gzdjNotUsed" + JSESSIONID;//故障登记
    String ON_FAUL_CONTROL_SAVE_ = prefix + "/gydl/app/gzgl/gzdjsave" + JSESSIONID;//故障管控新增
    String ON_FAUL_CONTROL_CORD_SAVE_ = prefix + "/gydl/app/gzgl/gzjlsave" + JSESSIONID;//故障管控记录  提交
    String ON_FAUL_CONTROL_CORD_LIST_ = prefix + "/gydl/app/gzgl/gzjlList" + JSESSIONID;//故障管控记录  下载
    String ON_FAUL_Download = prefix + "/gydl/app/gzgl/getGzByGzbh" + JSESSIONID;//故障下载（获取故障设备类型 设备名称）
    /**
     * String bh,
     * String lx,
     * MultipartFile[] files
     */
    String ON_FAUL_Pic_Upload = prefix + "/app/tool/uploadPic" + JSESSIONID;//图片上传
    String ON_FAUL_Pic_Upload1 = prefix + "/app/tool/uploadPic1" + JSESSIONID;//图片上传
    String ON_FAUL_Pic_Upload2 = prefix + "/app/tool/uploadPic" + JSESSIONID;//图片上传
    String ON_Picture_Download = prefix + "/app/tool/downloadPic" + JSESSIONID;//图片下载
    /**
     * String bh,
     * String lx,
     * MultipartFile[] files
     */
    String ON_FAUL_Pic_Download = prefix + "/gydl/a/app/tool/download" + JSESSIONID;//图片下载
    /*检修*/
    String ON_Ovehaul_Missions_Downlaod = prefix + "/app/ywjx/query" + JSESSIONID;//检修任务下载
    String ON_Ovehaul_Plan_Downlaod = prefix + "/app/jxjh/getJxjh" + JSESSIONID;//检修计划下载
    String ON_Ovehaul_Test_Report_Submit = prefix + "/app/jxsyjl/syjlSave" + JSESSIONID;//检修记录提交
    String ON_Ovehaul_Blq_Download = prefix + "/app/ywjx/getblq" + JSESSIONID;//避雷器下载
    String ON_Ovehaul_Jdhlx_Download = prefix + "/app/ywjx/getJdxJchl" + JSESSIONID;//查询接地箱&交叉互联箱
    String ON_Ovehaul_Dld_Download = prefix + "/app/ywjx/getdld" + JSESSIONID;//查询电缆段信息
    String ON_Ovehaul_cable_list_Download = prefix + "/app/ywjx/getListdld" + JSESSIONID;//查询多条电缆段的数据
    String ON_Ovehaul_Zdt_Download = prefix + "/app/ywjx/getZdt" + JSESSIONID;//查询终端头信息
    String ON_Ovehaul_Bzhzys_Download = prefix + "/app/bzk/findList" + JSESSIONID;//
    String ON_Ovehaul_Bzhzys_Submit = prefix + "/app/bzk/save" + JSESSIONID;//
    String ON_Ovehaul_Qxrw_Download = prefix + "/app/ywjx/getQxjh" + JSESSIONID;//检修相关缺陷任务下载
    /*String id, String rwzt, Date sj */
    String ON_Ovehaul_Mission_Submit = prefix + "/app/ywjx/save" + JSESSIONID;//检修任务状态提交
    String ON_Ovehaul_Report_Submit = prefix + "/app/jxbg/bgSave" + JSESSIONID;//检修报告提交
    String ON_Ovehaul_Zjjt_Download = prefix + "/app/ywjx/getzjjt" + JSESSIONID;//中间接头
    String ON_Ovehaul_TestList_Download = prefix + "/app/jxsyjl/findList" + JSESSIONID;//实验列表下载
    String ON_Ovehaul_TestReport_Download = prefix + "/app/jxsyjl/subClass" + JSESSIONID;//实验列表下载
    String ON_Ovehaul_OverHualReport_Download = prefix + "/app/jxbg/getBg" + JSESSIONID;//检修报告下载
    String ON_Ovehaul_BzhzyList_Download = prefix + "/gydl/app/bzhzy/list" + JSESSIONID;//标准化作业文件列表下载
    String ON_Ovehaul_BzhzyFile_Download = prefix + "/app/zk/bzhzyDownload" + JSESSIONID;//标准化作业文件列表下载
    String ON_Ovehaul_DELAY_LIST = prefix + "/app/ywjx/findRwyqQuery" + JSESSIONID;   //延期申请列表
    String ON_Ovehaul_DELAY_LIST_SUNMIT = prefix + "/app/ywjx/saveRwyq" + JSESSIONID;   //延期任务编辑/新增/提交
    String ON_Ovehaul_DELAY_LIST_DELETE = prefix + "/app/ywjx/rwyqDelete" + JSESSIONID;   //延期删除

    String ON_Bm_Search = prefix + "/app/tool/appTreeData" + JSESSIONID;//部门查询
    String ON_Ry_Search = prefix + "/app/tool/appTreeData" + JSESSIONID;//人员(部门)查询
    String ON_Bm_Search_Qx = prefix + "/sys/office/treeData" + JSESSIONID;//部门查询
    String ON_RY_Search = prefix + "/app/tool/appUserTreeData" + JSESSIONID;//人员查询

    String ON_MAP_OPT_INIT = "/gydl//a/ditu/dtLayer/app/list";
    String ON_MAP_LINE = prefix + "/ditu/dtLine/app/list";

    String ON_DOWNLOAD = prefix + "/apk/down" + JSESSIONID;
    String ON_CheckVersion = prefix + "/gydl/apk/appServiceDown" + JSESSIONID;
    String ON_DOWNLOAD_APK = "/gydl/f/gydl/apk/download" + JSESSIONID;
    String ON_DOWNLOAD_APK2 = "/gydl/f/gydl/apk/download;JSESSIONID=";
    //    String rtmpIP = "rtmp://tl.xyjy100.com/live/ryid=";
    String rtmpIP = "/no=";
    String ON_DEFECT_CLASSIFY_SEARCH = prefix + "/qxdj/qxdj/app/findQxfl" + JSESSIONID;
    String ON_CordCardTitem_SEARCH = prefix + "/sx/app/xsjlxfind" + JSESSIONID;
    String ON_CordCardTitrm_SEARCH3 = prefix + "/sx/app/queryJlknr" + JSESSIONID;
    String ON_CordCardTitem_SUBMITE = prefix + "/sx/app/xsjlxsave" + JSESSIONID;
    String ON_CordCardTitrm_SUBMITE2 = prefix + "/sx/app/xsjlxsave;JSESSIONID=";
}
