package cc.openhome.web;

import java.util.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequestWrapper;

public class CharacterRequestWrapper extends HttpServletRequestWrapper {

    private Map<String, String> escapeMap;

    public CharacterRequestWrapper(HttpServletRequest request,
            Map<String, String> escapeMap) {
        super(request);
        this.escapeMap = escapeMap;
    }

    @Override
    public String getParameter(String name) {
        return doEscape(this.getRequest().getParameter(name));
    }

    private String doEscape(String parameter) {
        if(parameter == null) {
            return null;
        }
        String result = parameter;
        Iterator<String> iterator = escapeMap.keySet().iterator();
        while (iterator.hasNext()) {
            String origin = iterator.next();
            String escape = escapeMap.get(origin);
            result = result.replaceAll(origin, escape);
        }

        return result;
    }
}
