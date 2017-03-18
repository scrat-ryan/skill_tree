package com.jointstarc.ssm.first.entity;


import java.util.Date;

/**
 * Created with SSA.
 * Description:
 * User: lium.
 * Date: 16/12/21.
 * Time: 上午11:11.
 */
public class BackEndAcctBean {
    private String province;

    private String rptMonth;

    private Date beginTime;

    private Date endTime;

    private Integer seq;

    private String loginName;

    private String acctName;

    private String resName;

    private String resAddress;

    private Date loginTime;

    private String ip;


    private String intFileName;

    private Date intUpdTime;

    private String rowKey;

    @Override
    public String toString() {
        return "\nBackEndAcctBean{" +
                "province='" + province + '\'' +
                ", rptMonth='" + rptMonth + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", seq=" + seq +
                ", loginName='" + loginName + '\'' +
                ", acctName='" + acctName + '\'' +
                ", resName='" + resName + '\'' +
                ", resAddress='" + resAddress + '\'' +
                ", loginTime=" + loginTime +
                ", ip='" + ip + '\'' +
                ", intFileName='" + intFileName + '\'' +
                ", intUpdTime=" + intUpdTime +
                ", rowKey='" + rowKey + '\'' +
                '}';
    }

    //获取中文省份名称
    public String getProvinceName() {
        return  this.province;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRptMonth() {
        return rptMonth;
    }

    public void setRptMonth(String rptMonth) {
        this.rptMonth = rptMonth;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResAddress() {
        return resAddress;
    }

    public void setResAddress(String resAddress) {
        this.resAddress = resAddress;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIntFileName() {
        return intFileName;
    }

    public void setIntFileName(String intFileName) {
        this.intFileName = intFileName;
    }

    public Date getIntUpdTime() {
        return intUpdTime;
    }

    public void setIntUpdTime(Date intUpdTime) {
        this.intUpdTime = intUpdTime;
    }

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }
}
