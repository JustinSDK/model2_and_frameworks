/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.openhome.web;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

public class CharacterFilter implements Filter {
    private Map<String, String> escapeMap;

    public void init(FilterConfig filterConfig)
                  throws ServletException {
        BufferedReader reader = null;
        try {
            String escapeListFile = filterConfig
                        .getInitParameter("ESCAPE_LIST");
            reader = new BufferedReader(
                    new InputStreamReader(
                        filterConfig.getServletContext()
                            .getResourceAsStream(escapeListFile)));
            String input = null;
            escapeMap = new HashMap<String, String>();
            while ((input = reader.readLine()) != null) {
                String[] tokens = input.split("\t");
                escapeMap.put(tokens[0], tokens[1]);
            }
        } catch (IOException ex) {
            Logger.getLogger(CharacterFilter.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(CharacterFilter.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response,
              FilterChain chain) throws IOException, ServletException {
        HttpServletRequest requestWrapper =
                new CharacterRequestWrapper(
                       (HttpServletRequest) request, escapeMap);
        chain.doFilter(requestWrapper, response);
    }

    public void destroy() {
    }
}


