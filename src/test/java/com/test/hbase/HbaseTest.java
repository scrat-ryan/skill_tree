package com.test.hbase;

import com.jointstarc.ssm.first.entity.BackEndAcctBean;
import com.test.BaseTest;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with jointstarc.
 * Description:
 * User: lol.
 * Date: 2016/12/22.
 * Time: 11:25.
 */
public class HbaseTest extends BaseTest{

    @Resource
    private HbaseTemplate hbaseTemplate;

    @Test
    public void test(){
        String table = "SSA:Ht_INT_BACKEND_ACCT_LOGIN_HR_TEST";
        String row = "706102100boss4_yangztSMSAL_100_01HR_20160731_0202";
        final String cfamily = "c";
        final String qualifier = "login_name";

        // 通过表名和rowKey获取最近一行数据
        System.out.println("-------------------------");
//        String result = hbaseTemplate.get(table, row, new RowMapper<String>() {
//            public String mapRow(Result result, int rowNum) throws Exception {
//                return Bytes.toString(result.getValue(cfamily.getBytes(), qualifier.getBytes()));
//            }
//        });
        List<BackEndAcctBean> result = this.find();
        System.out.println("========******========");
        System.out.println(result.size());
    }


    private List<BackEndAcctBean> find(){
        String table = "SSA:Ht_INT_BACKEND_ACCT_LOGIN_HR";
        String beginRow = "706102230";
        Scan scan = new Scan();
        scan.setStartRow(Bytes.toBytes(beginRow));
        scan.setStopRow(Bytes.toBytes(beginRow.concat("~")));
        FilterList filterList = new FilterList();
        //列值过滤器
        Filter filterLoginName = new SingleColumnValueFilter(Bytes.toBytes("c"),  //过滤loginname
                Bytes.toBytes("login_name"),  //列名
                CompareFilter.CompareOp.EQUAL, Bytes.toBytes("luoxiaodong"));
        Filter filterdate = new SingleColumnValueFilter(Bytes.toBytes("c"),  //过滤loginname
                Bytes.toBytes("login_time"),  //列名
                CompareFilter.CompareOp.EQUAL,new BinaryPrefixComparator(Bytes.toBytes("2016/07/01")) );
        Filter pagefilter = new PageFilter(200);
        filterList.addFilter(filterLoginName);
        filterList.addFilter(filterdate);
//        filterList.addFilter(pagefilter);
        scan.setFilter(filterList);//加入所有的过滤器
        //通过表名和scan获取数据
        return hbaseTemplate.find(table, scan, new RowMapper<BackEndAcctBean>() {
            public BackEndAcctBean mapRow(Result result, int rowNum) throws Exception {
                final BackEndAcctBean backEndAcctBean = new BackEndAcctBean();
//                System.out.println("rowkey:" + new String(result.getRow()));
                List<Cell> ceList = result.listCells();
                if (ceList != null && ceList.size() > 0) {
                    for (Cell cell : ceList) {
                        String qfmily = new String(CellUtil.cloneQualifier(cell), "utf-8").trim();
                        String qvalue = new String(CellUtil.cloneValue(cell), "utf-8").trim();
                        switch (qfmily) {
                            case "province":
                                backEndAcctBean.setProvince(qvalue);
                                break;
                            case "login_name":
                                backEndAcctBean.setLoginName(qvalue);
                                break;
                            case "ip":
                                backEndAcctBean.setIp(qvalue);
                                break;
                            case "login_time":
                                System.out.println(qvalue);
                                backEndAcctBean.setAcctName(qvalue);
                                break;
                            case "res_address":
                                backEndAcctBean.setResAddress(qvalue);
                                break;
                            default:
                                break;
                        }
                    }
                }
                return backEndAcctBean;
            }
        });
    }

}
