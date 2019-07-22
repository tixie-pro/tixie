//CanvasjsChartController.java
package pro.tixie.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CanvasjsChartController {



    @GetMapping("canvasjschart")
    public String DashFregment(ModelMap modelMap) {

        return "user/manager/dashfregment";
    }

}         