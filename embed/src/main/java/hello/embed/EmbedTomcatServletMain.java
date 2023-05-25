package hello.embed;

import hello.servlet.HelloServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class EmbedTomcatServletMain {
    public static void main(String[] args) throws LifecycleException {
        System.out.println("EmbedTomcatServletMain.main");

        //톰캣 설정
        Tomcat tomcat = new Tomcat();
        Connector connector = new Connector();
        connector.setPort(8090);
        tomcat.setConnector(connector);

        //서블릿 등록
        EmbedTomcatSpringMain.tomcatStart(tomcat);

        tomcat.addServlet("", "helloServlet", new HelloServlet());
        Context context = EmbedTomcatSpringMain.tomcatStart(tomcat);
        context.addServletMappingDecoded("/hello-servlet", "helloServlet");
        tomcat.start();

    }
}
