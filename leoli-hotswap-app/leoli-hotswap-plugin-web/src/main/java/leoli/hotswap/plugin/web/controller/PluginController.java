package leoli.hotswap.plugin.web.controller;

import leoli.hotswap.plugin.web.spi.DefaultPluginFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * @author leoli
 * @date 2021/06/05
 */
@Controller
@RequestMapping("plugin")
public class PluginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PluginController.class);

    @Autowired
    private DefaultPluginFactory pluginFactory;

    @RequestMapping(value = "list")
    public String getHavePlugins(HttpServletRequest request) {
        Collection list = null;
        try {
            list = pluginFactory.flushConfigs();
        } catch (IOException e) {
            e.printStackTrace();
        }
        request.setAttribute("havePlugins", list);
        return "/plugins";
    }

    @RequestMapping(value = "active")
    public void activePlugin(HttpServletRequest request, HttpServletResponse response) {
        pluginFactory.activePlugin(request.getParameter("id"));
        try {
            response.getWriter().append("active succeed!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("disable")
    public void disablePlugin(HttpServletRequest request, HttpServletResponse response) {
        pluginFactory.disablePlugin(request.getParameter("id"));
        try {
            response.getWriter().append("disable succeed!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
