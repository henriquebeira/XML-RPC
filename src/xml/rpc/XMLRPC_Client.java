/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.rpc;

import java.net.URL;
import java.util.*;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class XMLRPC_Client {

    public static void main(String[] args) {
        String serverURL = "http://localhost:1093";
        try {
            XmlRpcClientConfigImpl cliConfig = new XmlRpcClientConfigImpl();
            cliConfig.setServerURL(new URL(serverURL));
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(cliConfig);
            Vector params = new Vector();
            params.addElement(new Integer(17));
            params.addElement(new Integer(13));
            Object result = client.execute("Calculator.sum", params);
            int sum = ((Integer) result).intValue();
            System.out.println("The sum is: " + sum);
            
        } catch (Exception exception) {
            System.err.println("JavaClient: " + exception);
        }
    }
}
