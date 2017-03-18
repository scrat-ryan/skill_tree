package com.jointstarc.ssm.first.utils;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created with jointstarc.
 * Description:
 * User: lol.
 * Date: 2016/12/15.
 * Time: 14:58.
 */
public class RemoteShellUtil {

    private Logger logger = Logger.getLogger(this.getClass());

    private Connection conn;
    private String ip;//远程机器IP
    private String osUsername;//用户名
    private String password;//密码
    private String port;//端口

    private String charset = Charset.defaultCharset().toString();
    private static final int TIME_OUT = 1000 * 5 * 60;

    /**
     * 构造函数
     *
     * @param ip
     * @param usr
     * @param pasword
     */
    public RemoteShellUtil(String ip, String usr, String pasword, String port) {
        this.ip = ip;
        this.osUsername = usr;
        this.password = pasword;
        this.port = port;
        logger.info("connecting to " + this.ip + " with user:" + this.osUsername + "and pwd:" + this.password + "and port:" + this.port);

    }

    /**
     * 登录
     *
     * @return
     * @throws IOException
     */
    private void login() throws Exception {
        conn = new Connection(ip);
        conn.connect();
        boolean isAuthenticated = conn.authenticateWithPassword(osUsername, password);
        if (!isAuthenticated){
            logger.info("登录远程机器失败!");
            throw new Exception("登录远程机器失败" + ip); // 自定义异常类 实现略
        }

        else
            logger.info("登录远程机器成功!");

    }

    /**
     * 执行脚本
     *
     * @param cmds
     * @return
     * @throws Exception
     */
    public int exec(String cmds) throws Exception {
        this.login();
        InputStream stdOut = null;
        InputStream stdErr = null;
        String outStr = "";
        String outErr = "";
        int ret = -1;
        try {

            if (null != conn) {

            }
            Session session = conn.openSession();
            session.execCommand(cmds);
            int i = session.getState();
            stdOut = new StreamGobbler(session.getStdout());
            outStr = processStream(stdOut, charset);
            stdErr = new StreamGobbler(session.getStderr());
            outErr = processStream(stdErr, charset);

            session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);

            logger.info("outStr=" + outStr);
            logger.info("outErr=" + outErr);

            ret = session.getExitStatus();

        } finally {
            if (conn != null) {
                conn.close();
            }
            IOUtils.closeQuietly(stdOut);
            IOUtils.closeQuietly(stdErr);
        }
        return ret;

    }


    /**
     * @param in
     * @param charset
     * @return
     * @throws IOException
     * @throws UnsupportedEncodingException
     */
    private String processStream(InputStream in, String charset) throws Exception {
        byte[] buf = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while (in.read(buf) != -1) {
            sb.append(new String(buf, charset));
        }
        return sb.toString();

    }


    public static void main(String args[]) throws Exception {
        String str = "/opt/ssa_web/apache-tomcat-7.0.73/bin/startup.sh";
        String str1 = "/opt/ssa_web/apache-tomcat-7.0.73/bin/shutdown.sh";
        String str2 = "/home/mcbadm/schedule_shell/bin/smhaf_start.sh";
        String str3 = "/home/mcbadm/schedule_shell/bin/smhaf_stop.sh";
        RemoteShellUtil executor = new RemoteShellUtil("192.168.117.194", "mcbadm", "Mcb__11", "22");
        // 执行myTest.sh 参数为java Know dummy

        System.out.println(executor.exec(str2));

    }
}
