//package com.huawei.web;
//
//import com.huawei.pojo.model.*;
//import com.huawei.service.TravelerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpSession;
//import java.util.List;
//
//@Controller
//@RequestMapping("/traveler")
//public class TravelerController {
//    @Autowired
//    private TravelerService travelerService;
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ResponseBody
//    public ModelAndView login(@RequestParam String mail, @RequestParam String password, HttpSession httpSession) {
//        TravelerInfo travelerInfo = travelerService.login(mail, password);
//        httpSession.setAttribute("travelerInfo", travelerInfo);
//
//        String viewName = "";
//
//        if (null != travelerInfo) {
//            viewName = "page/users/index.htm";
//        }
//        else {
//            viewName = "page/users/login.htm";
//        }
//
//        ModelAndView modelAndView = new ModelAndView(viewName);
//
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    @ResponseBody
//    public ModelAndView register(@RequestParam String name, @RequestParam String password, @RequestParam String mail, HttpSession httpSession) {
//        TravelerInfo travelerInfo = travelerService.register(name, password, mail);
//        httpSession.setAttribute("travelerInfo", travelerInfo);
//        ModelAndView modelAndView = new ModelAndView("page/users/index.htm");
//
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/getTop10Answers", method = RequestMethod.GET)
//    @ResponseBody
//    public List<TravelerInfo> getTop10Answers() {
//        List<TravelerInfo> travelerInfoList = travelerService.getTop10Answers();
//
//        return travelerInfoList;
//    }
//
//    @RequestMapping(value = "/followUsers", method = RequestMethod.GET)
//    @ResponseBody
//    public boolean followUsers(@RequestParam Integer followedId, HttpSession httpSession) {
//        TravelerInfo travelerInfo = (TravelerInfo)httpSession.getAttribute("travelerInfo");
//        Integer userId = travelerInfo.getUserId();
//
//        return travelerService.followUsers(userId, followedId);
//    }
//
//    @RequestMapping(value = "/unFollowUsers", method = RequestMethod.GET)
//    @ResponseBody
//    public boolean unFollowUsers(@RequestParam Integer followedId, HttpSession httpSession) {
//        TravelerInfo travelerInfo = (TravelerInfo)httpSession.getAttribute("travelerInfo");
//        Integer userId = travelerInfo.getUserId();
//
//        return travelerService.unFollowUsers(userId, followedId);
//    }
//
//    @RequestMapping(value = "/getTravelInfo", method = RequestMethod.GET)
//    @ResponseBody
//    public NoteBean getTravelInfo(@RequestParam Integer userId, @RequestParam Integer page, @RequestParam Integer maxItem, HttpSession httpSession) {
//
//        if (userId == 0) {
//            TravelerInfo travelerInfo = (TravelerInfo)httpSession.getAttribute("travelerInfo");
//            userId = travelerInfo.getUserId();
//        }
//
//        return travelerService.getTravelInfo(userId, page, maxItem);
//    }
//
//    @RequestMapping(value = "/getMyAnswer", method = RequestMethod.GET)
//    @ResponseBody
//    public MyAnswerBean getMyAnswer(@RequestParam Integer userId, HttpSession httpSession) {
//
//        if (userId == 0) {
//            TravelerInfo travelerInfo = (TravelerInfo)httpSession.getAttribute("travelerInfo");
//            userId = travelerInfo.getUserId();
//        }
//
//        return travelerService.getMyAnswer(userId);
//    }
//
//    @RequestMapping(value = "/getMyQuestionBean", method = RequestMethod.GET)
//    @ResponseBody
//    public MyQuestionBean getMyQuestionBean(@RequestParam Integer userId, HttpSession httpSession) {
//
//        if (userId == 0) {
//            TravelerInfo travelerInfo = (TravelerInfo)httpSession.getAttribute("travelerInfo");
//            userId = travelerInfo.getUserId();
//        }
//
//        return travelerService.getMyQuestionBean(userId);
//    }
//
//    @RequestMapping(value = "/getFollowQuestionBean", method = RequestMethod.GET)
//    @ResponseBody
//    public FollowQuestionBean getFollowQuestionBean(@RequestParam Integer userId, HttpSession httpSession) {
//
//        if (userId == 0) {
//            TravelerInfo travelerInfo = (TravelerInfo)httpSession.getAttribute("travelerInfo");
//            userId = travelerInfo.getUserId();
//        }
//
//        return travelerService.getFollowQuestionBean(userId);
//    }
//
//    @RequestMapping(value = "/getTravelInfoSetting", method = RequestMethod.GET)
//    @ResponseBody
//    public Traveler getTravelInfoSetting(HttpSession httpSession) {
//
//        TravelerInfo travelerInfo = (TravelerInfo)httpSession.getAttribute("travelerInfo");
//        Integer userId = travelerInfo.getUserId();
//
//        return travelerService.getTravelInfoSetting(userId);
//    }
//
//    @RequestMapping(value = "/setTravelInfoSetting", method = RequestMethod.POST)
//    @ResponseBody
//    public boolean setTravelInfoSetting(@RequestParam String nickname, @RequestParam boolean sex, @RequestParam String email,
//                                        @RequestParam String phone, @RequestParam String description, HttpSession httpSession) {
//
//        TravelerInfo travelerInfo = (TravelerInfo)httpSession.getAttribute("travelerInfo");
//        Integer userId = travelerInfo.getUserId();
//
//        return travelerService.setTravelInfoSetting(userId, nickname, sex, email, phone, description);
//    }
//
//    @RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
//    @ResponseBody
//    public boolean modifyPassword(@RequestParam String password, HttpSession httpSession) {
//
//        TravelerInfo travelerInfo = (TravelerInfo)httpSession.getAttribute("travelerInfo");
//        Integer userId = travelerInfo.getUserId();
//
//        return travelerService.modifyPassword(userId, password);
//    }
//
//    @RequestMapping(value = "/getTravelerInfo", method = RequestMethod.GET)
//    @ResponseBody
//    public TravelerInfo getTravelerInfo(HttpSession httpSession) {
//
//        TravelerInfo travelerInfo = (TravelerInfo)httpSession.getAttribute("travelerInfo");
//
//        return travelerInfo;
//    }
//}
