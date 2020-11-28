package cn.it.zw.service;

import cn.it.zw.bean.Time;
import cn.it.zw.bean.ZhangWu;
import cn.it.zw.dao.ZhangWuDao;
import cn.it.zw.dao.ZhangWuDaoImpl;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public class  ZhangWuServiceImpl implements ZhangWuService {
    ZhangWuDao zhangWuDao = new ZhangWuDaoImpl();

    //添加用户
    @Override
    public String addZhangWu(ZhangWu zhangWu) {
        return zhangWuDao.addZhangWu(zhangWu);
    }

    @Override
    public List<ZhangWu> queryZhangWuBydata(Time time) {
        return zhangWuDao.queryZhangWuBydata(time);
    }

    //按照日期查看记录
    @Override
    public List<ZhangWu> queryZhangWuBydata(Time time,Integer index) {
        return zhangWuDao.queryZhangWuBydata(time,index);
    }

    @Override
    public List<ZhangWu> queryZhangWuBytype(ZhangWu zhangWu) {
        return zhangWuDao.queryZhangWuBytype(zhangWu);
    }

    //按照类型查看记录
    @Override
    public List<ZhangWu> queryZhangWuBytype(ZhangWu zhangWu, Integer index) {
        return zhangWuDao.queryZhangWuBytype(zhangWu,index);
    }

    @Override
    public List<ZhangWu> queryZhangWuByuser(ZhangWu zhangWu) {
        return zhangWuDao.queryZhangWuByuser(zhangWu);
    }

    //按照用户查看记录
    @Override
    public List<ZhangWu> queryZhangWuByuser(ZhangWu zhangWu,Integer index) {
        return zhangWuDao.queryZhangWuByuser(zhangWu,index);
    }

    @Override
    public List<ZhangWu> queryZhangWuBytitle(ZhangWu zhangWu) {
        return zhangWuDao.queryZhangWuBytitle(zhangWu);
    }

    //按照标题查看记录
    @Override
    public List<ZhangWu> queryZhangWuBytitle(ZhangWu zhangWu, Integer index) {
        return zhangWuDao.queryZhangWuBytitle(zhangWu,index);
    }


    @Override
    public List<ZhangWu> queryZhangWuAll(ZhangWu zhangWu,Integer index) {
        return zhangWuDao.queryZhangWuAll(zhangWu,index);
    }

    @Override
    public List<ZhangWu> queryAll() {
        return zhangWuDao.queryAll();
    }

    @Override
    public void deleteZhangWu(Integer xuhao) {
        zhangWuDao.deleteZhangWu(xuhao);
    }

    @Override
    public void updateZhangWu(Integer xuhao) {
        zhangWuDao.updateZhangWu(xuhao);
    }

    @Override
    public List<ZhangWu> sortBytitle(ZhangWu zhangWu,Integer index) {
        return zhangWuDao.sortBytitle(zhangWu,index);
    }

    @Override
    public List<ZhangWu> sortBydata(ZhangWu zhangWu,Integer index) {
        return zhangWuDao.sortBydata(zhangWu,index);
    }

    @Override
    public List<ZhangWu> sortByuser(ZhangWu zhangWu,Integer index) {
        return zhangWuDao.sortByuser(zhangWu,index);
    }

    @Override
    public List<ZhangWu> sortByprice(ZhangWu zhangWu,Integer index) {
        return zhangWuDao.sortByprice(zhangWu,index);
    }

}
