package utils;
import com.aventstack.extentreports.ExtentTest;
import com.jcraft.jsch.*;
import common.DataFactory;
import globalConstants.FilePaths;
import globalConstants.NumberConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import propertyManagement.ProjectProperties;
import reportManagement.ExtentManager;

import java.io.*;
import java.util.Properties;

public class LogReader {

     ExtentTest pageInfo;

    public LogReader (){
        pageInfo = ExtentManager.getTest();
    }

    private final static String HOSTNAME = ProjectProperties.getProperty("wallet.server.ip");
    private final static String USERNAME = ProjectProperties.getProperty("wallet.server.username");
    private final static String PASSWORD = ProjectProperties.getProperty("wallet.server.password");
    private final static String MWALLETPATH = ProjectProperties.getProperty("wallet.server.mwallet");
  //  private final static String WEBBUSINESSFLOWPATH = ProjectProperties.getProperty("app.server.businessflow.path");
 //   private final static String TXNCHANNELGATEWAYAPATH = ProjectProperties.getProperty("txn.server.log.path");
    private final static String MWALLETLOGLIMIT = ProjectProperties.getProperty("wallet.server.log.limit");
    private final static String MESSAGE_SENT_LOG_PATH = ProjectProperties.getProperty("wallet.server.messageSent.path");

    private final static String MWALLETLOGSOUTPATH = FilePaths.dirMwalletLogs;
    private final static String MwalletGrepCommandString = "tail -n  " + MWALLETLOGLIMIT + " ";
    private static final int BYTE_CONSTANT = 1024;
    private static final int PORT = 22;
    private static final Logger logger = LoggerFactory.getLogger(LogReader.class);
    private static String MwalletFileName = "";
    private static String ServerRestartFileName = "";

     public static void main(String[] args) throws JSchException {
         LogReader logReader=new LogReader();
         logReader.connectToVpn();
         executeCmd("pwd");
     }
    public String getMwalletLog()  {
       // System.out.println(MWALLETPATH);
        executeCmd("cd ..");
        return getServerLog(MWALLETPATH);
    }

    private static void createLogsDirectory() {
        File directory = new File(FilePaths.dirMwalletLogs);
        if (!directory.exists()) {
            directory.mkdir();
        }}

        /**
         * To print server logs in a log file
         *
         *
         * @return LogFileName
         */

    public static void connectToVpn(){
        try {
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            com.jcraft.jsch.Session session = jsch.getSession("service.mobiquity", "192.168.230.109", 22);
            session.setPassword("n65eoE19ztlZci@#6");
            session.setConfig(config);
            session.connect();
            session.setPortForwardingL(22,"192.168.231.42",1525);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public  String getServerLog(String logFileName)  {

            String mwalletFileName = null;
            BufferedWriter out = null;
            try {
                createLogsDirectory();
                String fileName = new File(logFileName).getName().split("\\.")[0];
                mwalletFileName = MWALLETLOGSOUTPATH + fileName + DataFactory.getTimeStamp() + ".log";
                Properties config = new Properties();
                config.put("StrictHostKeyChecking", "no");
                JSch jsch = new JSch();
                Session session = jsch.getSession(USERNAME, HOSTNAME, PORT);
                session.setConfig(config);
                session.connect();

                Channel channel = session.openChannel("exec");
                InputStream in = channel.getInputStream();
                OutputStream outputStream = channel.getOutputStream();
                ((ChannelExec) channel).setCommand(MwalletGrepCommandString + logFileName);
                channel.setInputStream(null);
                ((ChannelExec) channel).setErrStream(outputStream);
                channel.connect();
                byte[] tmp = new byte[BYTE_CONSTANT];

                while (true) {
                    while (in.available() > 0) {
                        int i = in.read(tmp, 0, BYTE_CONSTANT);
                      //  System.out.println("i= " + i);
                        if (i < 0) break;
                     //   System.out.println("breaking");
                        String content;
                        try {
                            out = new BufferedWriter(new FileWriter(mwalletFileName, true));
                            content = (new String(tmp, 0, i));
                            out.write(content);
                         //   System.out.println(logFileName);
                         //   pageInfo.info(content);
                         //   System.out.println("CONTENT= " + content);
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (channel.isClosed()) {
                        break;
                    }
                   utils.Utils.putThreadSleep(NumberConstants.SLEEP_1000);
                }
                channel.disconnect();
                session.disconnect();
                out.close();

                logger.debug("Session Disconnected successfully");
            } catch (JSchException jsEx) {
                logger.error("Java Secure Channel Error Occured ", jsEx);
            } catch (IOException ioEx) {
                logger.error("IO Exception Occurred", ioEx);

            }
            return mwalletFileName;
        }

    /**
     * Method - getServerDate
     *
     * @return LinuxServerDate
     */
    public static String getServerDate() {

        String dateFromLinux = null;
        try {
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            com.jcraft.jsch.Session session = jsch.getSession(USERNAME, HOSTNAME, PORT);
            session.setPassword(PASSWORD);
            session.setConfig(config);
            session.connect();

            com.jcraft.jsch.Channel channel = session.openChannel("exec");
            OutputStream outputStream = channel.getOutputStream();
            ((ChannelExec) channel).setCommand("date  +%d/%m/%y");
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(outputStream);

            InputStream in = channel.getInputStream();

            channel.connect();
            byte[] tmp = new byte[BYTE_CONSTANT];

            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, BYTE_CONSTANT);
                    dateFromLinux = new String(tmp, 0, i);
                }
                if (dateFromLinux != null) {
                    break;
                }

            }


            channel.disconnect();
            session.disconnect();

            //Log.debug("Session Disconnected successfully");
        } catch (JSchException jsEx) {
            logger.error("Java Secure Channel Error Occured ", jsEx);
        } catch (IOException ioEx) {
            logger.error("IO Exception Occured", ioEx);
        }
        return dateFromLinux.trim();
    }

   public static void executeCmd(String cmdString) {
        String cmdOutput = null;
        try {
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            com.jcraft.jsch.Session session = jsch.getSession(USERNAME, HOSTNAME, 22);
            session.setPassword(PASSWORD);
            session.setConfig(config);
            session.connect(1000);

            com.jcraft.jsch.Channel channel = session.openChannel("exec");
            System.out.println("Command is " + cmdString);
            ((ChannelExec) channel).setCommand(cmdString);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);

            InputStream in = channel.getInputStream();
            channel.connect();
            channel.disconnect();
            session.disconnect();

            //Log.debug("Session Disconnected successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void executeShellCommandAndSaveLogs(String cmdString, File file) throws JSchException, IOException, InterruptedException {
        com.jcraft.jsch.Channel channel = null;
        com.jcraft.jsch.Session session = null;
        try {
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            session = jsch.getSession(USERNAME, HOSTNAME, 22);
            session.setPassword(PASSWORD);
            session.setConfig(config);
            session.connect();

            channel = session.openChannel("shell");
            OutputStream ops = channel.getOutputStream();
            PrintStream ps = new PrintStream(ops, true);

            channel.connect();
            ps.println(cmdString);
            InputStream in = channel.getInputStream();
            byte[] tmp = new byte[1024];
            BufferedWriter out = null;
            Thread.sleep(5000);
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    String content;
                    try {
                        out = new BufferedWriter(new FileWriter(file, true));
                        content = (new String(tmp, 0, i));
                        out.write(content);
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (channel != null)
                channel.disconnect();
            if (session != null)
                session.disconnect();
        }
    }


    public static String getLinuxServerDateTime() {

        String dateFromLinux = null;
        try {
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            com.jcraft.jsch.Session session = jsch.getSession(USERNAME, HOSTNAME, PORT);
            session.setPassword(PASSWORD);
            session.setConfig(config);
            session.connect();

            com.jcraft.jsch.Channel channel = session.openChannel("exec");
            OutputStream outputStream = channel.getOutputStream();
            ((ChannelExec) channel).setCommand("date  +%Y-%m-%d' '%H:%M:%S");
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(outputStream);

            InputStream in = channel.getInputStream();

            channel.connect();
            byte[] tmp = new byte[BYTE_CONSTANT];

            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, BYTE_CONSTANT);
                    dateFromLinux = new String(tmp, 0, i);
                }
                if (dateFromLinux != null) {
                    break;
                }

            }


            channel.disconnect();
            session.disconnect();

            //Log.debug("Session Disconnected successfully");
        } catch (JSchException jsEx) {
            logger.error("Java Secure Channel Error Occured ", jsEx);
        } catch (IOException ioEx) {
            logger.error("IO Exception Occured", ioEx);
        }
        return dateFromLinux.trim();
    }


    public static String getMessageFromMessageSentLog(String beforeDateTime, String afterDateTime, String msisdn, boolean... isPasswordRequired) {

        boolean isPassword = isPasswordRequired.length > 0 ? isPasswordRequired[0] : false;

        String message = null, commandToExecute = null;
        try {
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            com.jcraft.jsch.Session session = jsch.getSession(USERNAME, HOSTNAME, PORT);
            session.setPassword(PASSWORD);
            session.setConfig(config);
            session.connect();

            com.jcraft.jsch.Channel channel = session.openChannel("exec");
            OutputStream outputStream = channel.getOutputStream();
            if (isPassword) {
                commandToExecute = "awk '$0 ~ 'Message' && $0 > " + "\"" + beforeDateTime + "\" && $0 < " + "\"" + afterDateTime + "\"' " + MESSAGE_SENT_LOG_PATH + "| grep " + msisdn + " | tr -s '[' '|' |tr -s ']' '|' | cut -d '|' -f 10 | tr -s '\\n' '|'|cut -d '|' -f 2";
            } else {
                commandToExecute = "awk '$0 ~ 'Message' && $0 > " + "\"" + beforeDateTime + "\" && $0 < " + "\"" + afterDateTime + "\"' " + MESSAGE_SENT_LOG_PATH + "| grep " + msisdn + " | tr -s '[' '|' |tr -s ']' '|' | cut -d '|' -f 10 | tr -s '\\n' '|'|cut -d '|' -f 1";
            }
            logger.info("\n *********  Executing Linux Command : ************ \n" + commandToExecute);
            ((ChannelExec) channel).setCommand(commandToExecute);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(outputStream);

            InputStream in = channel.getInputStream();

            channel.connect();
            byte[] tmp = new byte[BYTE_CONSTANT];

            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, BYTE_CONSTANT);
                    message = new String(tmp, 0, i);
                }
                if (message != null) {
                    break;
                }

            }

            channel.disconnect();
            session.disconnect();

            //Log.debug("Session Disconnected successfully");
        } catch (JSchException jsEx) {
            logger.error("Java Secure Channel Error Occured ", jsEx);
        } catch (IOException ioEx) {
            logger.error("IO Exception Occured", ioEx);
        }
        return message.trim();
    }


}




