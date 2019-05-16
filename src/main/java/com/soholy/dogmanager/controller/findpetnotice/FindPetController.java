package com.soholy.dogmanager.controller.findpetnotice;

import com.soholy.dogmanager.entity.TMissDog;
import com.soholy.dogmanager.entity.dogCard.ResponseEntity;
import com.soholy.dogmanager.entity.findpetnotice.MissDogVO;
import com.soholy.dogmanager.service.findpetnotice.FindPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**寻宠寻主
 * @author linchong
 * @create 2019-05-15 11:19
 */
@Controller
@RequestMapping("/biz/findPet")
public class FindPetController {
    @Autowired
    private FindPetService findPetService;

    @RequestMapping("/list")
    @ResponseBody
    public ResponseEntity list(@RequestParam Map<String,Object> map) {

        return new ResponseEntity();
    }


    @RequestMapping("/addNotice")
    @ResponseBody
    public ResponseEntity insertNotice(MissDogVO tMissDog) {
        tMissDog.setDogStatus(0);
        tMissDog.setCreateTime(new Date());
        //设置启事所属的区域
        setNoticeAreaCode(tMissDog);
        Integer rows = findPetService.addNotice(tMissDog);
        return new ResponseEntity(tMissDog.getId());
    }

    private void setNoticeAreaCode(MissDogVO tMissDog) {
        String [] code = tMissDog.getCode();
        String areaCode = "000000";     //默认000000表示中国
        if(code != null && code.length > 0) {
           areaCode = code[code.length -1];
        }
        tMissDog.setAreaCode(areaCode);
    }
}
