package cn.it.zw.dao;

import cn.it.zw.bean.Time;
import cn.it.zw.bean.ZhangWu;

import java.util.List;

public interface ZhangWuDao {
    //添加记录
    String addZhangWu(ZhangWu zhangWu);
    //按照日期查看记录，用来获取页数
    List<ZhangWu> queryZhangWuBydata(Time time);
    //按照日期查看记录
    List<ZhangWu> queryZhangWuBydata(Time time,Integer index);
    //按照类型查看记录，用来获取页数
    List<ZhangWu> queryZhangWuBytype(ZhangWu zhangWu);
    //按照类型查看记录
    List<ZhangWu> queryZhangWuBytype(ZhangWu zhangWu,Integer index);
    //按照用户查看记录，用来获取页数
    List<ZhangWu> queryZhangWuByuser(ZhangWu zhangWu);
    //按照用户查看记录
    List<ZhangWu> queryZhangWuByuser(ZhangWu zhangWu,Integer index);
    //按照标题查看记录，用来获取页数
    List<ZhangWu> queryZhangWuBytitle(ZhangWu zhangWu);
    //按照标题查看记录
    List<ZhangWu> queryZhangWuBytitle(ZhangWu zhangWu,Integer index);
    //查询所有记录
    List<ZhangWu> queryZhangWuAll(ZhangWu zhangWu,Integer index);
    //查询所有记录，用来获取总页数
    List<ZhangWu> queryAll();
    //删除指定序号记录
    void deleteZhangWu(Integer xuhao);
    //修改制定序号记录
    void updateZhangWu(Integer xuhao);
    //按照标题排序
    List<ZhangWu> sortBytitle(ZhangWu zhangWu,Integer index);
    //按照时间排序
    List<ZhangWu> sortBydata(ZhangWu zhangWu,Integer index);
    //按照用户排序
    List<ZhangWu> sortByuser(ZhangWu zhangWu,Integer index);
    //按照金额排序
    List<ZhangWu> sortByprice(ZhangWu zhangWu,Integer index);
}
