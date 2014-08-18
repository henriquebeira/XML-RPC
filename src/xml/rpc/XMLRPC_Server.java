/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.rpc;

/**
 *
 * @author Henrique
 */
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

public class XMLRPC_Server {

    public Integer sum(int x, int y) {
        return new Integer(x + y);
    }

    public static void main(String[] args) {
        try {
            System.out.println("Attempting to start XML - RPC Server...");
            WebServer webServer = new WebServer(1093); // HTTP server
            XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer(); // returns the XmlRpcServer;
            PropertyHandlerMapping pm = new PropertyHandlerMapping();
            // The property key is taken as the handler name. 
            // The property value is taken as the name of a class being instantiated.
            pm.addHandler("Calculator", (new XMLRPC_Server()).getClass());
            xmlRpcServer.setHandlerMapping(pm);
            webServer.start(); // Accept connections 
            System.out.println("Started successfully.");
            System.out.println("Accepting requests.(Halt program to stop.)");
            
        } catch (Exception exception) {
            System.err.println("JavaServer: " + exception);
        }
    }
}
