package cn.it.zw.controller;

import cn.it.zw.bean.Time;
import cn.it.zw.bean.ZhangWu;
import cn.it.zw.service.ZhangWuService;
import cn.it.zw.service.ZhangWuServiceImpl;
import cn.it.zw.view.AddView;

import java.util.List;

public class ZhangWuController {

    private ZhangWuService zhangWuService = new ZhangWuServiceImpl();

    public void add(ZhangWu zhangWu){
        String result = zhangWuService.addZhangWu(zhangWu);
        switch (result){
            case "success":
                AddView.addResultView(result);
                break;
        }
    }

    public void  queryZhangWuBydata(Time time) {

    }

}
