package com.app.room.bean;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task {

    @PrimaryKey(autoGenerate = true)
    private long id;

    /**
     * 任务id
     */
    private String taskId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 任务详情
     * common/queryById
     */
    private String taskDetail;

    /**
     * 流程图接口
     * initialize/queryLcById
     */
    private String flowChart;

    /**
     * 巡视监测表单
     *
     * @param taskId 任务id
     * @param jclx   1:局放监测;2:红外成像检测;3:接地电流检测
     * @return
     */
    private String jcbd1;
    private String jcbd2;
    private String jcbd3;

    /**
     * 地面
     * <p>
     * queryByDm id:周期巡视id;
     * sblx:设备类型{1010006:工井 4001100:通风亭 1030000:终端塔 1010004:终端站 0202:电缆终端头 };
     */

    private String dm_sblx_1010006;
    private String dm_sblx_4001100;
    private String dm_sblx_1030000;
    private String dm_sblx_1010004;
    private String dm_sblx_0202;

    /**
     * 地下
     * queryByXl
     * id:周期巡视id;
     * sblx:设备类型{0203:电缆中间接头 0202:电缆终端头 xl:线路本体};
     */
    private String xl_sblx_0203;
    private String xl_sblx_0202;
    private String xl_sblx_xl;

    /**
     * 巡视流程 数据核查
     * xsgl/queryCjsjALL
     */
    private String cjsjAllList;
    /**
     * 查询该任务下是否有新增的缺陷
     */
    private String sfczQxrw;
    /**
     * 生成准备及验收 参会人员
     */
    private String sczbjyschry;
    /**
     * 带电检测 检测记录、结论
     */
    private String ddjcjcjl;

    /**
     * 缺陷管理原因
     */
    private String qxglyy;

    /**
     * 有限空间许可原因
     */
    private String yxkjxkyy;
    /**
     * 有限空间验收原因
     */
    private String yxkjysyy;
    /**
     * 通用照片数据 保存 key 和 图片信息
     */
    private String picPathVoList;
    /**
     * 保存离线拍照的信息
     */
    private String offlinePhoto;
    /**
     * 保存离线操作  同步的时候 调用同步的接口
     */
    private String offlineSubmitList;

    public String getQxglyy() {
        return qxglyy;
    }

    public void setQxglyy(String qxglyy) {
        this.qxglyy = qxglyy;
    }

    public String getYxkjysyy() {
        return yxkjysyy;
    }

    public void setYxkjysyy(String yxkjysyy) {
        this.yxkjysyy = yxkjysyy;
    }

    public String getYxkjxkyy() {
        return yxkjxkyy;
    }

    public void setYxkjxkyy(String yxkjxkyy) {
        this.yxkjxkyy = yxkjxkyy;
    }

    public String getDdjcjcjl() {
        return ddjcjcjl;
    }

    public void setDdjcjcjl(String ddjcjcjl) {
        this.ddjcjcjl = ddjcjcjl;
    }

    public String getSczbjyschry() {
        return sczbjyschry;
    }

    public void setSczbjyschry(String sczbjyschry) {
        this.sczbjyschry = sczbjyschry;
    }

    public String getOfflineSubmitList() {
        return offlineSubmitList;
    }

    public void setOfflineSubmitList(String offlineSubmitList) {
        this.offlineSubmitList = offlineSubmitList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTaskDetail() {
        return taskDetail;
    }

    public void setTaskDetail(String taskDetail) {
        this.taskDetail = taskDetail;
    }

    public String getFlowChart() {
        return flowChart;
    }

    public void setFlowChart(String flowChart) {
        this.flowChart = flowChart;
    }

    public String getOfflinePhoto() {
        return offlinePhoto;
    }

    public void setOfflinePhoto(String offlinePhoto) {
        this.offlinePhoto = offlinePhoto;
    }

    public String getJcbd1() {
        return jcbd1;
    }

    public void setJcbd1(String jcbd1) {
        this.jcbd1 = jcbd1;
    }

    public String getJcbd2() {
        return jcbd2;
    }

    public void setJcbd2(String jcbd2) {
        this.jcbd2 = jcbd2;
    }

    public String getJcbd3() {
        return jcbd3;
    }

    public void setJcbd3(String jcbd3) {
        this.jcbd3 = jcbd3;
    }

    public String getDm_sblx_1010006() {
        return dm_sblx_1010006;
    }

    public void setDm_sblx_1010006(String dm_sblx_1010006) {
        this.dm_sblx_1010006 = dm_sblx_1010006;
    }

    public String getDm_sblx_4001100() {
        return dm_sblx_4001100;
    }

    public void setDm_sblx_4001100(String dm_sblx_4001100) {
        this.dm_sblx_4001100 = dm_sblx_4001100;
    }

    public String getDm_sblx_1030000() {
        return dm_sblx_1030000;
    }

    public void setDm_sblx_1030000(String dm_sblx_1030000) {
        this.dm_sblx_1030000 = dm_sblx_1030000;
    }

    public String getDm_sblx_1010004() {
        return dm_sblx_1010004;
    }

    public void setDm_sblx_1010004(String dm_sblx_1010004) {
        this.dm_sblx_1010004 = dm_sblx_1010004;
    }

    public String getDm_sblx_0202() {
        return dm_sblx_0202;
    }

    public void setDm_sblx_0202(String dm_sblx_0202) {
        this.dm_sblx_0202 = dm_sblx_0202;
    }

    public String getXl_sblx_0203() {
        return xl_sblx_0203;
    }

    public void setXl_sblx_0203(String xl_sblx_0203) {
        this.xl_sblx_0203 = xl_sblx_0203;
    }

    public String getXl_sblx_0202() {
        return xl_sblx_0202;
    }

    public void setXl_sblx_0202(String xl_sblx_0202) {
        this.xl_sblx_0202 = xl_sblx_0202;
    }

    public String getXl_sblx_xl() {
        return xl_sblx_xl;
    }

    public void setXl_sblx_xl(String xl_sblx_xl) {
        this.xl_sblx_xl = xl_sblx_xl;
    }

    public String getPicPathVoList() {
        return picPathVoList;
    }

    public void setPicPathVoList(String picPathVoList) {
        this.picPathVoList = picPathVoList;
    }

    public String getCjsjAllList() {
        return cjsjAllList;
    }

    public void setCjsjAllList(String cjsjAllList) {
        this.cjsjAllList = cjsjAllList;
    }

    public String getSfczQxrw() {
        return sfczQxrw;
    }

    public void setSfczQxrw(String sfczQxrw) {
        this.sfczQxrw = sfczQxrw;
    }

}
